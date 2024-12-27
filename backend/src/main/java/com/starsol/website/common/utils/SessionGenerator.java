package com.starsol.website.common.utils;

import java.util.UUID;

public class SessionGenerator {

    // Genera un nuevo ID de sesión
    public String nextSessionId() {
        // Por ejemplo, usar UUID para generar un identificador único
        return UUID.randomUUID().toString();
    }
}