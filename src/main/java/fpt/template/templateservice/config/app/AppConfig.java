package fpt.template.templateservice.config.app;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;

public class AppConfig {
    @Value("${app.application-short-name}")
    String applicationShortName;


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .setAnnotationIntrospector(new JacksonAnnotationIntrospector())
                .registerModule(new JavaTimeModule())
                .setDateFormat(new StdDateFormat())
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setTimeZone(Calendar.getInstance().getTimeZone())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
