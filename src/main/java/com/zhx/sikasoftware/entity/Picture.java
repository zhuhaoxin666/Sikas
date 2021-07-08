package com.zhx.sikasoftware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@TableName("picturetest")
@Repository
public class Picture {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private byte[] picture;
}
