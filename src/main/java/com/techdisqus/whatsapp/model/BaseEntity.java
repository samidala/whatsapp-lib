package com.techdisqus.whatsapp.model;



import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, property = "type"
)
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = WhatsappNotificationRequest.class, name = "WHATSAPP")
        }
)
public abstract class BaseEntity {
    @ApiModelProperty(value = "LogId of request", required = true, accessMode = ApiModelProperty.AccessMode.AUTO)
    private String logId;
    @ApiModelProperty(value = "ID of notification template configuration", required = true, accessMode = ApiModelProperty.AccessMode.AUTO)
    @JsonAlias({"emailTemplateId","smsTemplateId"})
    private String templateId;

    @JsonProperty("type")
    private NotificationType type;

    public abstract NotificationType notificationType();

}
