package com.example.demo.mapper;

import com.example.demo.entity.UserName;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


public interface UserMapper {
    /**
     * 插入数据
     */
   // public  void insert(UserName user) ;
 //  @Insert(" INSERT INTO users(id,name) VALUES(#{id},#{name})")
    public void insert(@Param("name") String name,@Param("id") Integer id);

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    //@Select("SELECT id,name FROM users WHERE id=#{id}")
    public UserName getByUserID(@Param("id") Integer id);
}
