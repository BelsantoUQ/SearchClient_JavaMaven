package org.server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
}

