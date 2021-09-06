package com.example.saveuser.exceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ApiErrors {
    private BindingResult bindingResult;
    @Getter
    private List<String> errors;

    public ApiErrors(BindingResult bindingResult) {
        this.errors = new ArrayList<>();
        this.bindingResult = bindingResult;
        this.bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            this.errors.add(fieldName+" : " +  error.getDefaultMessage());
        });
    }
    public ApiErrors(String errorMessage) {
        this.errors = new ArrayList<>();
        this.errors.add(errorMessage);
    }

}
