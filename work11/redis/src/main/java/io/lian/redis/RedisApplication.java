package io.lian.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
//        SpringApplication.run(RedisApplication.class, args);

        boolean lock = RedisLock.getLock("lock", "1", 5000);
        if (lock) {
            // 减库存
        }

        RedisLock.releaseLock("lock", "1");

    }

}
