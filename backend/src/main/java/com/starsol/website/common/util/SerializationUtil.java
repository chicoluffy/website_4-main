package com.starsol.website.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SerializationUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Convierte un Objeto a Texto JSON
     *
     * @param o
     * @return
     */
    public static String obj2json(Object o) {
        if (o == null) {
            return null;
        }
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            log.error("", ex);
        }
        return null;
    }

    /**
     * Convierte un texto de JSON a un objeto
     *
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static Object json2Object(String json, @SuppressWarnings("rawtypes") Class clazz) throws IOException {

        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            mapper.setDateFormat(df);
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException ex) {
            log.error("", ex);
        } catch (@SuppressWarnings("hiding") IOException ex) {
            log.error("", ex);
        }
        return null;
    }
}

