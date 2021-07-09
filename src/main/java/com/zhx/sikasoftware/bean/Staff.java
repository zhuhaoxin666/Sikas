package com.zhx.sikasoftware.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.Principal;
import java.security.PrivateKey;
import java.time.LocalDate;
@TableName("staff")
@Data
public class Staff {
    private Integer sId;
    private String sName;
    private String sJobType;
    private String sActor;
    private String sUserPicture;
    @DateTimeFormat(pattern =  "yyyy-MM-dd")
    private LocalDate sBirthday;
    private int sJobTime;
    private String sNotes;
    private int sDelFlag;
}
