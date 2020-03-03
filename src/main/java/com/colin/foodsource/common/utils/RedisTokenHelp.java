package com.colin.foodsource.common.utils;

import com.colin.foodsource.common.FoodConstants;
import com.colin.foodsource.common.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Description: Token管理类
 * Created by Colin on 2020/2/28 0028 上午 11:27.
 */
@Component
public class RedisTokenHelp{

    @Autowired
    private RedisUtils redisUtils;

    public TokenModel create(String id) {
        String token = RandomUtils.getUUID();
        TokenModel mode = new TokenModel(id, token);
        redisUtils.set(id == null ? null : id, token, FoodConstants.REDIS_EXPIRATION_SECONDS, TimeUnit.SECONDS);
        return mode;
    }

    public boolean check(TokenModel model) {
        boolean result = false;
        if(model != null) {
            String userId = model.getId();
            String token = model.getToken();
            String authenticatedToken = (String) redisUtils.get(userId);
            if(authenticatedToken != null && authenticatedToken.equals(token)) {
                redisUtils.expire(userId, FoodConstants.REDIS_EXPIRATION_SECONDS,TimeUnit.SECONDS);
                result = true;
            }
        }
        return result;
    }

    public TokenModel get(String authStr) {
        TokenModel model = null;
        if(!StringUtils.isEmpty(authStr)) {
            String[] modelArr = authStr.split("_");
            if(modelArr.length == 2) {
                String userId = modelArr[0];
                String token = modelArr[1];
                model = new TokenModel(userId, token);
            }
        }
        return model;
    }

    /**
    * 获取用户的token值
    * @param userId
    * @return  java.lang.String
    * @author  Colin
    * @date  2020/3/3 0003 下午 1:38
    */
    public String getToken(String userId){
        String token = (String) redisUtils.get(userId);
        return token;
    }

    public boolean delete(String id) {
        return redisUtils.remove(id);
    }

}
