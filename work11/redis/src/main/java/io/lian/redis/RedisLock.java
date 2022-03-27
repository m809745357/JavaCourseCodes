package io.lian.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author m809745357
 */
@Slf4j
public class RedisLock {
    private static StringRedisTemplate stringRedisTemplate;

    public RedisLock(StringRedisTemplate stringRedisTemplate) {
        RedisLock.stringRedisTemplate = stringRedisTemplate;
    }

    public static boolean getLock(String lockKey, String value, int expireTimout) {
        try {
            String script = "if redis.call('setNx', KEYS[1], ARGV[1]) then if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('expire', KEYS[1], ARGV[2]) else return 0 end end";
            RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
            List<String> keys = new ArrayList<>();
            keys.add(lockKey);
            Long execute = stringRedisTemplate.execute(redisScript, keys, value, expireTimout + "");

            return execute != null && 1L == execute;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean releaseLock(String lockKey, String value) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        List<String> keys = new ArrayList<>();
        keys.add(lockKey);
        Long execute = stringRedisTemplate.execute(redisScript, keys, value);

        return execute != null && 1L == execute;
    }
}
