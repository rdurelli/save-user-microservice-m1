package com.example.saveuser.model.DAO;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDAO implements Serializable {

    @NotBlank
    @NotNull
    private String name;
    @NotNull
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @Size(min = 5, max = 15)
    private String password;

}
