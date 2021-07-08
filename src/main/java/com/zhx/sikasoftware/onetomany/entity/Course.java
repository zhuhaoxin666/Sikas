package com.zhx.sikasoftware.onetomany.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("course")
public class Course {
    private Integer cId;
    private String cName;
    private Integer cTeacherId;
    private Integer cStuId;
    private String cDescription;
}
