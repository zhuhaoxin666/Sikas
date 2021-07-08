package com.zhx.sikasoftware.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("table_dept")
@Data
@NoArgsConstructor
public class TableDept {
    @TableId
    private Integer deptId;
    private String deptName;
    private String deptDescription;

    public TableDept(Integer deptId,String deptName,String deptDescription){
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptDescription = deptDescription;
    }

}
