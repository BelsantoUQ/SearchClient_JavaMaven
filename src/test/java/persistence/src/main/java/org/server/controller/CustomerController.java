package org.server.controller;

import org.server.dto.CustomerDto;
import org.server.model.Customer;
import org.server.model.DocumentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {

    private Map<String, Customer> customerMap = new HashMap<>();

    public CustomerController() {
        // Agregar un cliente a la lista
        Customer customer = mockCustomer();
        customerMap.put(customer.getDocumentNumber(), customer);
    }
    @GetMapping("/customer-info")
    public ResponseEntity<CustomerDto> getCustomerInfo(@RequestParam String type, @RequestParam String documentNumber) {

        if (!type.equals("C") && !type.equals("P")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Verificar si el número de documento existe en la lista de clientes
        if (!customerMap.containsKey(documentNumber)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Customer customer = customerMap.get(documentNumber);

        // Validar si el tipo de documento coincide
        if (type.equals("C") && customer.getDocumentType() != DocumentType.CEDULA) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (type.equals("P") && customer.getDocumentType() != DocumentType.PASAPORTE) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CustomerDto customerDTO = convertToDTO(customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    private Customer mockCustomer() {
        // Datos quemados para cédula de ciudadanía 23445322
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setPhoneNumber("1234567890");
        customer.setAddress("123 Main St");
        customer.setCity("Anytown");
        customer.setDocumentType(DocumentType.CEDULA);
        customer.setDocumentNumber("23445322");

        return customer;
    }

    private CustomerDto convertToDTO(Customer customer) {
        CustomerDto customerDTO = new CustomerDto();
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setCity(customer.getCity());
        return customerDTO;
    }
}