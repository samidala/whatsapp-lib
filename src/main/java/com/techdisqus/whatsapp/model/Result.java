package com.techdisqus.whatsapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private T response;
    private HttpStatus httpStatus;
    private boolean isSuccess;

}
