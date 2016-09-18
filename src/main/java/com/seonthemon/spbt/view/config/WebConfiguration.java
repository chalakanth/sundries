package com.seonthemon.spbt.view.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.seonthemon.spbt.view.data.converters.USLocalDateConverter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		registry.addFormatterForFieldType(LocalDate.class, new USLocalDateConverter());
		
	}

}
