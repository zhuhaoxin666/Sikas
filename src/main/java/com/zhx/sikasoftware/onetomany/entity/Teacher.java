package com.zhx.sikasoftware.onetomany.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("teacher")
@NoArgsConstructor
public class Teacher {
    private Integer tId;
    private String tName;
    private String tTile;
}
