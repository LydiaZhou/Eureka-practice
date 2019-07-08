package com.lydia.server.service.implement;

import com.lydia.server.Model.UnknownDO;
import com.lydia.server.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private RedisTemplate redisTemplate;

    public String add(UnknownDO unknown) {
        try {
            Long result = redisTemplate.opsForSet().add("unknown", unknown.getName());
            if (result > 0) {
                return "Success";
            } else {
                return "Failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}