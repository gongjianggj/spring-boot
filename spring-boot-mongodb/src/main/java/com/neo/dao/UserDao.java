package com.neo.dao;

import com.neo.entity.UserEntity;

import java.util.List;

/**
 * Created by summer on 2017/5/5.
 */
public interface UserDao  {

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public int updateUser(UserEntity user);

    public void deleteUserById(Long id);

    public UserEntity findUserById(long id);

    /**
     * 查询多条数据:linkUrl.id 属于分级查询
     * @return
     */
    public List<UserEntity> getListUserByUserName();
}
