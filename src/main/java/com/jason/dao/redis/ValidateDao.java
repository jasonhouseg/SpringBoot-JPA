package com.jason.dao.redis;

import org.springframework.stereotype.Repository;

@Repository
public class ValidateDao extends BaseRedisDao{

    @Override
    protected String getRedisKey() {
        return "validate";
    }
}
