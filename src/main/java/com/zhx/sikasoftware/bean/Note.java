package com.zhx.sikasoftware.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@TableName("message")
@Data
public class Note {
    @TableId(type = IdType.AUTO)
    private Integer mId;
    private String author;
    private String title;
    private String email;
    private String content;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime addDate;
}
