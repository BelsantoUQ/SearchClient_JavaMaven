package org.server.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private DocumentType documentType;
    private String documentNumber;
}

