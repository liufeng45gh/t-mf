package com.lucifer.mapper.shop;

import com.lucifer.annotation.ShopDb;
import com.lucifer.model.Member;
import org.apache.ibatis.annotations.Param;

@ShopDb
public interface MemberMapper {

    Integer insertMember(Member member);

    Member getMemberByPhone(@Param(value = "phone") String phone);

    Member getMemberById(@Param(value = "id") Long id);

    Member getMemberByNickName(@Param(value = "nickName") String nickName);

    Integer updateMemberPassword(Member member);

    Integer updateMemberNick(@Param(value = "id") Long id,@Param(value = "nickName") String nickName);

    Integer updateMemberInfo(Member member);

    Integer updateMemberDescription(Member member);

    Integer updateMemberSelfShow(@Param(value = "id") Long id,@Param(value = "selfShow") Integer selfShow);

    Integer updateMemberPrice(Member member);

    Integer updateMemberMainPicture(@Param(value = "id") Long id,@Param(value = "picture") String picture);


}
