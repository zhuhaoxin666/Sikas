package com.zhx.sikasoftware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@TableName("user")
@AllArgsConstructor
public class User {
//    @TableId
//    private Integer userId;
//    private String username;
//    private String password;
//    private Integer flag;
    private Integer id;
    private String name;
    private Integer age;

}
