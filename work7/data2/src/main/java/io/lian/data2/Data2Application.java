package io.lian.data2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

/**
 * @author m809745357
 */
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class Data2Application {

    public static void main(String[] args) {
        SpringApplication.run(Data2Application.class, args);
    }

}
