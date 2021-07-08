package com.zhx.sikasoftware.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;

@TableName("company")
@Data
@NoArgsConstructor
@ToString
@Repository
public class Company {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String introduce;
    private String sina;
    private String tencent;
    private String website;
    private String contact;
    private String contactNumber;
    private String email;
    private Byte[] picture;
    private Byte[] pride;
    private String remark;
    private Integer creator;

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createTime;

    private Integer updater;
    private LocalDateTime updateTime;
}
