package com.jason.dao.redis;

import org.springframework.stereotype.Repository;

@Repository
public class RedisSessionDao extends BaseRedisDao {

    @Override
    protected String getRedisKey() {
        return "session";
    }
}
