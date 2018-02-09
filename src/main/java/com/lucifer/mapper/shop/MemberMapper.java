package com.lucifer.mapper.shop;

import com.lucifer.annotation.ShopDb;
import com.lucifer.model.Member;
import org.apache.ibatis.annotations.Param;

@ShopDb
public interface MemberMapper {

    Integer insertMember(Member member);

    Member getMemberByPhone(@Param(value = "phone") String phone);

    Integer updateMemberPassword(Member member);
}
