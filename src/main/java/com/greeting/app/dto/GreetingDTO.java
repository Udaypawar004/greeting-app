package com.greeting.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingDTO {
    //Used to Tranfer Date through Object in Each Step.
    private String id;
    private String fname;
    private String lname;
    private String message;
}
