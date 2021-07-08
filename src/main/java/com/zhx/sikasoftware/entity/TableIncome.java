package com.zhx.sikasoftware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@TableName("table_income")
@Data
@NoArgsConstructor
public class TableIncome {
    @TableId
    private Long incomeId;
    private Integer deptId;
    private Double dailyIncome;
    private Date businessDate;
    private Timestamp lstModTimestamp;

    public TableIncome(Long incomeId, Integer deptId, Double dailyIncome, Date businessDate) {
        this.incomeId = incomeId;
        this.deptId = deptId;
        this.dailyIncome = dailyIncome;
        this.businessDate = businessDate;
    }
}
