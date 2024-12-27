package com.starsol.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import java.time.Duration;

@Service
@Slf4j
public class RedisServices {
    //interaccion con redisConfig
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    protected final String KEYSPACE_SEPARATOR = "://";
    protected final String DEFAULT_KEYSPACE = "ROOT";

    public String getKeyString(String pKeyspace, String key)
    {

        String ksp = this.DEFAULT_KEYSPACE;

        if (pKeyspace != null)
        {
            if (pKeyspace.length() > 0)
            {
                ksp = pKeyspace;
            }
        }
        return getValue(ksp + this.KEYSPACE_SEPARATOR + key);
    }

        /**
     * Sets a new value in Redis.
     *
     * @param pKeyspace The keyspace to store the data.
     * @param pKey The key for identifying the data.
     * @param pValue Value of the Redis key
     * @param pExpires Expiration time
     * @return
     */
    public boolean set(String pKeyspace, String pKey, String pValue, int pExpires) {

        if (pKey == null) {
            return false;
        }
        if (pKey.isEmpty()) {
            return false;
        }

        String ksp = this.DEFAULT_KEYSPACE;

        if (pKeyspace != null) {
            if (pKeyspace.length() > 0) {
                ksp = pKeyspace;
            }
        }

        String valToPut = "";
        if (pValue != null) {
            valToPut = pValue;
        }

        try {
            if (pExpires > 0) {
                setValueWithExpiration(ksp + this.KEYSPACE_SEPARATOR + pKey, valToPut , pExpires);
            } else {
                setValue(ksp + this.KEYSPACE_SEPARATOR + pKey, valToPut);
            }
            return true;
        } catch (Exception ex) {
           // StarsolLog.logPanic(Level.SEVERE, "Cannot set value in redis transaction for key:" + pKey + " " + ex.getMessage() + " stack trace: " + Arrays.toString(ex.getStackTrace()));
        }

        return false;
    }

    // Método para asignar un valor
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // Método para obtener un valor
    public String getValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    // Asignar un valor con tiempo de expiración
    public void setValueWithExpiration(String key, String value, long timeoutInSeconds) {
        redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(timeoutInSeconds));
    }

    // Establecer tiempo de expiración en una clave existente
    public boolean setExpiration(String key, long timeoutInSeconds) {
        return redisTemplate.expire(key, Duration.ofSeconds(timeoutInSeconds));
    }
    
}
