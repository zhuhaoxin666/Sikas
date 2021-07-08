package com.zhx.sikasoftware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@TableName("table_bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableBill {
    @TableId
    private Long billId;
    private Long vendorId;
    private Date billDate;
    private Date billDueDate;
    private Boolean billPaidFlag;
    private Integer billAmount;
}
