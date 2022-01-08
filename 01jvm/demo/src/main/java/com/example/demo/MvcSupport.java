package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.Filter;

/**
 * @author m809745357
 */
@Component
@Configuration
public class MvcSupport extends WebMvcConfigurationSupport {
    @Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> filterFilterRegistrationBean() {
        ShallowEtagHeaderFilter shallowEtagHeaderFilter = new ShallowEtagHeaderFilter();
        FilterRegistrationBean<ShallowEtagHeaderFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(shallowEtagHeaderFilter);

        return filterFilterRegistrationBean;
    }
}
