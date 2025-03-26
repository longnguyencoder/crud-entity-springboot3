package com.example.Ecommerce.dto.request;

import com.example.Ecommerce.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 2, message = "USERNAME_INVALID")
     String  username;
    @Size(min = 8, message = "PASSWORD_INVALID")
     String  password;
     String  firstname;
     String  lastname;

     @DobConstraint(min=18,message = "INVALID_DOB")
     LocalDate dob;



}
