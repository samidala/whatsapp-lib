package com.techdisqus.whatsapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

@ApiModel(description = "Represents a template configuration per tenant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@JsonInclude(Include.NON_NULL)
@JsonTypeName("whatsappNotificationRequest")
public class WhatsappNotificationRequest extends BaseEntity implements NotificationMessage {

    /*@ApiModelProperty(value = "UUID of whatsapp template configuration", required = true, accessMode = AccessMode.AUTO)
    private String templateId;
    */
    @ApiModelProperty(value = "phone no of the recipient", required = true, accessMode = AccessMode.AUTO)
    @NotEmpty
    private String whatsappTo;

    @ApiModelProperty(value = "Values of the whatsapp template", required = false, accessMode = AccessMode.AUTO)
    private Map<String, String> values;

    @ApiModelProperty(value = "Message to be sent", required = true, accessMode = AccessMode.AUTO)
    private String message;

    @Override
    public String getConfigId() {
        return null;
    }
    @Override
    public NotificationType notificationType() {
        return NotificationType.WHATSAPP;
    }
}