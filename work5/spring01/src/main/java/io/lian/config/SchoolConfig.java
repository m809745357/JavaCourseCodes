package io.lian.config;

import io.lian.entity.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author m809745357
 */
@Configuration
public class SchoolConfig {

    @Bean
    public School school() {
        School school = new School();
        school.setSchName("浙江工贸职业技术学院");
        school.setSchAge(100);
        school.setSchNo(1);

        return school;
    }
}
