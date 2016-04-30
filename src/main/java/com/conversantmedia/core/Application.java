package com.conversantmedia.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .main(Application.class)
                .run(args);
	}
}
