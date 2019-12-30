package com.luxin.base.mapper;

import com.luxin.base.domain.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    List<Account> findList();
}
