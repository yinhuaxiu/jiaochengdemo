package cn.yykjc.jiaochengdemo.user.controller;

import cn.yykjc.jiaochengdemo.user.entity.UserEntity;


import cn.yykjc.jiaochengdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
*
* RestController =@ResponseBody+@Controller
* */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody    /*用于返回json数据*/
    @RequestMapping("/getAll")
    public List<UserEntity> getAll(Map map){

        return userService.getAll(map);
    }

    @RequestMapping("/delById")
    public String delById(Integer id) {

        userService.delById(id);
        return "redirect:/index.html";
    }

    // 保存用户
    @RequestMapping("/save")
    @ResponseBody       //如果没有此注解就会报错404 一定要将字符串转换成json返回给后台
    public String save(@RequestBody UserEntity userEntity) {

        System.out.println("用户注册 - " + userEntity.toString());
        userService.save(userEntity);
        return "success";
    }
}
