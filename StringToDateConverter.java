package com.example.Restaurante.Entitys;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {

    private final SimpleDateFormat dateFormat;

    public StringToDateConverter() {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        this.dateFormat.setLenient(false);
    }
    @Override
    public Date convert(String source) {
        try {
            return this.dateFormat.parse(source);
        } catch (ParseException e) {
            return null;
        }
    }
}
