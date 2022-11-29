package com.example.test.config;

import static org.springframework.core.annotation.AnnotationFilter.packages;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyAppConfig extends ResourceConfig {

  public JerseyAppConfig() {
    packages("com.example.test.resources");
  }

}
