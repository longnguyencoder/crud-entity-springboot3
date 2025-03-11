package com.example.Ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)  // thông báo l trường nào null thì không hiển thị
public class ApiResponse  <T>{
    private int code = 1000;
    private String message;
    private T result;


}
