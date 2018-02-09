package com.lucifer.mapper.shop;

import com.lucifer.annotation.ShopDb;
import com.lucifer.model.SmsCode;
import org.apache.ibatis.annotations.Param;

@ShopDb
public interface SmsCodeMapper {

    Integer insertSmsCode(SmsCode smsCode);

    String getLastSmsCode(@Param(value = "phone") String phone, @Param(value = "type") String type);
}
