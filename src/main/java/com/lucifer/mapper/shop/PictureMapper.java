package com.lucifer.mapper.shop;

import com.lucifer.annotation.ShopDb;
import com.lucifer.model.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@ShopDb
public interface PictureMapper {
    Integer insertMorePicture(@Param(value = "memberId") Long memberId, @Param(value = "pictureUrl") String pictureUrl);

    List<Picture> memberPictureList(@Param(value = "memberId") Long memberId);
}
