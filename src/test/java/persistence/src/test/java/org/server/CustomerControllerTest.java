package org.server;

import org.junit.jupiter.api.Test;
import org.server.controller.CustomerController;
import org.server.dto.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerControllerTest {

    @Test
    public void testGetCustomerInfo() {
        // Crear una instancia del controlador
        CustomerController customerController = new CustomerController();

        // Definir el tipo y el número de documento para la prueba
        String type = "C";
        String documentNumber = "23445322";

        // Ejecutar el método que se va a probar
        ResponseEntity<CustomerDto> response = customerController.getCustomerInfo(type, documentNumber);

        // Verificar que la respuesta sea la esperada
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("John", response.getBody().getFirstName());
        assertEquals("Doe", response.getBody().getLastName());
        assertEquals("1234567890", response.getBody().getPhoneNumber());
        assertEquals("123 Main St", response.getBody().getAddress());
        assertEquals("Anytown", response.getBody().getCity());
    }
}
