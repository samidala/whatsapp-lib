package com.techdisqus.whatsapp;


import com.techdisqus.persistence.entities.Whatsapp;
import com.techdisqus.persistence.entities.WhatsappGateway;
import com.techdisqus.whatsapp.model.Result;
import com.techdisqus.whatsapp.model.WhatsappApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

@Component
@Slf4j
public class WhatsappMessageSender {

    @Value("notification.whatsapp.token")
    private String token;

    @Value("notification.whatsapp.uri")
    private String uri;

    @Autowired
    RestTemplate restTemplate;

    public Result<WhatsappApiResponse> sendMessage(com.techdisqus.vo.WhatsappMessage whatsappMessage, WhatsappGateway whatsappGateway,
                                                   Whatsapp whatsapp, Map<String, String> values){
        boolean notificationStatus = true;
        Result<WhatsappApiResponse> result = new Result();
        HttpStatus httpStatus = null;
        WhatsappApiResponse whatsappApiResponse = null;
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer " + whatsappGateway.getToken());
            WhatsappMessage.WhatsappMessagePayload whatsappMessagePayload = new WhatsappMessage.WhatsappMessagePayload();
            whatsappMessagePayload.setTo(whatsappMessage.getWhatsappTo());
            whatsappMessagePayload.setType(whatsapp.getType());
            WhatsappMessage.WhatsappTemplate template = WhatsappMessage.getTemplate(whatsappMessage.getValues(),whatsapp.getWhatsappTemplateName());
            whatsappMessagePayload.setTemplate(template);
			/*String body = replacePlaceholders(whatsapp, values);
			WhatsappMessage.TextMessage textMesg = getTextMessage(body, false);
			whatsappMessagePayload.setTemplate();*/
            HttpEntity<WhatsappMessage.WhatsappMessagePayload> httpEntity = new HttpEntity<>(whatsappMessagePayload, httpHeaders);
            ResponseEntity<WhatsappApiResponse> apiResponse =
                    restTemplate.postForEntity(whatsappGateway.getUri(),
                            httpEntity, WhatsappApiResponse.class);
            log.info("status code {} and body {}", apiResponse.getStatusCode(), apiResponse.getBody());
            httpStatus = apiResponse.getStatusCode();
            whatsappApiResponse = apiResponse.getBody();
            if (httpStatus != HttpStatus.OK) {
                notificationStatus = false;
            }
        }catch (Exception e){
            log.error("Error while sending whatsapp notification ",e);
            notificationStatus = false;
        }
        result  =  Result.<WhatsappApiResponse>builder()
                .httpStatus(httpStatus)
                .response(whatsappApiResponse).isSuccess(notificationStatus).build();
        return result;

    }

    private String replacePlaceholders(Whatsapp whatsapp, Map<String, String> values) {
        String body = whatsapp.getWhatsappbody();
        for(String key : values.keySet() ) {
            body = body.replace("${"+key+"}", values.get(key));
        }
        return body;
    }


}
