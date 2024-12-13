package org.haobin.mybatis.service;

import org.haobin.mybatis.mapper.UserInfoMapper;
import org.haobin.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/2/27
 */
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public List<UserInfo> queryAllUser() {
        return userInfoMapper.queryUserList();
    }

    public UserInfo queryUserByNameAndPassword(String name, String password) {
        List<UserInfo> userInfos = userInfoMapper.queryUserByNameAndPassword(name,password);
        if (userInfos.size()>0){
            return userInfos.get(0);
        }
        return null;
    }
}
