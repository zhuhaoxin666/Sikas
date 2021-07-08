package com.zhx.sikasoftware.onetomany.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("student")
@NoArgsConstructor
public class Student {
    @TableId(type = IdType.AUTO)
    private Integer stuId;
    private String stuName;
    private String stuAge;

    public Student(String stuName, String stuAge) {
        this.stuName = stuName;
        this.stuAge = stuAge;
    }
}
