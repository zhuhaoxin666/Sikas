package com.zhx.sikasoftware.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@TableName("machinery")
public class Machinery {
    @TableId(type = IdType.AUTO)
    private Integer mId;

    private String mName;
    private String mType;
    private String mModel;
    private String purchaser;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchaserDate;
    private Integer purchaserPrice;
    private String contractNumber;
    private String provider;
    private String picture;
    private Integer officeId;
    private Integer delFlag;
    private String remark;
    private Integer creator;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createTime;
    private Integer modifier;
    private LocalDateTime modifyTime;

}
