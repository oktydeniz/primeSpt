package com.facility.primeSport.configuration;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyLoader {

    private Environment configuration;

    public PropertyLoader(Environment configuration) {
        this.configuration = configuration;
    }

    public String getProperty(String name) {
        return getProperty(name, null);
    }

    public String getProperty(String name, String defaultValue) {
        String value = configuration.getProperty("fn_" + name.replace('.', '_'));

        if (value == null) {
            value = configuration.getProperty(name);
        }
        if (value == null) {
            return defaultValue;
        }
        return value;
    }
}
