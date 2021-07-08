package com.zhx.sikasoftware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("table_vendor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableVendor {
    @TableId
    private Integer vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhone;
    private String vendorFax;
    private String vendorContactPerson;
}
