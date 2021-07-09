package com.zhx.sikasoftware.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class MachineryDo {
    private Integer mId;
    private String mName;
    private String mType;
    private String mModel;
    private String purchaser;
    private Date purchaserDate;
    private String picture;
}
