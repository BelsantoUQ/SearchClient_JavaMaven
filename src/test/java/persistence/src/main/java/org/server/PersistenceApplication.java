package org.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PersistenceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PersistenceApplication.class, args);
        Environment env = context.getEnvironment();
        String port = env.getProperty("local.server.port");
        System.out.println("La aplicación se está ejecutando en el puerto: " + port);
    }
}
