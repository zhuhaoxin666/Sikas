package com.zhx.sikasoftware.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("table_bill_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableBillItem {
    @TableField
    private Long billId;
    private Integer deptId;
    private Long billItemId;
    private Double billItemExpense;
}
