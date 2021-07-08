package com.zhx.sikasoftware.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class AccountDo {
    private String nickname;
    private String password;
}
