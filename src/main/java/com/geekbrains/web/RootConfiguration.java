package com.geekbrains.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, value = RootConfiguration.class))
public class RootConfiguration {

}