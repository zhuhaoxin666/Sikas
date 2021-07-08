package com.zhx.sikasoftware.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CompanyDo {
    private String name;
    private String introduce;
    private String sina;
    private String tencent;
    private String website;
    private String contact;
    private String contactNumber;
    private String email;
    private Byte[] picture;
    private Byte[] pride;
}
