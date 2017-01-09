package com.example.logviewer.user;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ResetForm {
    @Pattern(regexp = "^.*$")
    private String password1;
    @Pattern(regexp = "^.*$")
    private String password2;
}
