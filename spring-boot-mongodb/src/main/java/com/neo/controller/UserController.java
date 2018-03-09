package com.neo.controller;

import com.neo.dao.UserDao;
import com.neo.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** java 中 mongodb的各种操作 模糊查询 精确查询 等等
 * Created by Administrator on 2018/3/9.
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 添加
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public String save(){
        long i=1;
        UserEntity userEntity = new UserEntity();
        userEntity.setPassWord("123456");
        userEntity.setId(++i);
        userEntity.setUserName("gongjiang"+(++i));
        userDao.saveUser(userEntity);
        return "添加";
    }

    /**
     * 查询
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectUser")
    public String selectUser(){
       UserEntity user= userDao.findUserByUserName("gongjiang");
       return user.getPassWord();
    }

    /**
     * 修改
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUser")
    public  UserEntity updateUser(){
        UserEntity user= userDao.findUserById(1);
        user.setPassWord("987654321");
        userDao.updateUser(user);
        return user;
    };

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public void deleteUser(){
        userDao.deleteUserById(1l);
    }

    /**
     * 查询数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/listUser")
    public List<UserEntity> listUser(){
        List<UserEntity> li = userDao.getListUserByUserName();
        return li;
    }

    /**
     * id查询
     * @return
     */
    @ResponseBody
    @RequestMapping("/findUserOne")
    public UserEntity findUserOne(){
        UserEntity userEntity = userDao.findUserById(1);
        return userEntity;
    }
}
