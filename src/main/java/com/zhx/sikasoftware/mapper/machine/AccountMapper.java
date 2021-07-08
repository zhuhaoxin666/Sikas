package com.zhx.sikasoftware.mapper.machine;

import com.zhx.sikasoftware.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    void insertAccount(Account account);
    Account selectOne(Account account);


}
