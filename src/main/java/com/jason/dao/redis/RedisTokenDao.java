package com.jason.dao.redis;

import org.springframework.stereotype.Repository;

@Repository
public class RedisTokenDao extends BaseRedisDao {

    private static final String REDIS_KEY = "token";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }

}
