package com.jason.dao.redis;

import org.springframework.stereotype.Repository;

@Repository
public class RedisListDao extends BaseRedisDao {

    @Override
    protected String getRedisKey() {
        return "list";
    }
}
