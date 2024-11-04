package ru.sberp.javaseniortask.utils;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JacksonUtils {

  public Module getTimeModule(String pattern) {
    JavaTimeModule module = new JavaTimeModule();

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(pattern);

    LocalDateDeserializer deserializer = new LocalDateDeserializer(dateFormat);
    LocalDateSerializer serializer = new LocalDateSerializer(dateFormat);

    module.addDeserializer(LocalDate.class, deserializer);
    module.addSerializer(LocalDate.class, serializer);

    return module;
  }
}
