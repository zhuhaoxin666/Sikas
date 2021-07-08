package com.zhx.sikasoftware.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@TableName("account")
@Data
@NoArgsConstructor
@ToString
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String nickname;
    private String password;
    private String realname;
    private String phone;
    private String jobNumber;
    private String email;
    private String telephone;
    private Integer userType;
    private Byte[] picture;
    private String lastIp;
    private Date lastTime;
    private Integer loginFlag;
    private Integer loginCount;
    private Integer creator;
    private Date createTime;
    private Integer updater;
    private Date updateTime;
    private String department;
    private String company;
    private String remark;
    private Integer delFlag;
}
