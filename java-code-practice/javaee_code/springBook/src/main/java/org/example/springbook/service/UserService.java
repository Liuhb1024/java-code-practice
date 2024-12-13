package org.example.springbook.service;

import org.example.springbook.mapper.UserInfoMapper;
import org.example.springbook.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘浩彬
 * @date 2024/3/1
 */
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 从数据库中查询用户信息
     * @return
     */
    public UserInfo queryByName(String userName){
        return userInfoMapper.queryByName(userName);
    }
}
