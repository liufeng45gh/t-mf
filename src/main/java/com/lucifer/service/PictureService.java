package com.lucifer.service;

import com.lucifer.mapper.shop.PictureMapper;
import com.lucifer.model.Picture;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PictureService {

    @Resource
    private PictureMapper pictureMapper;

    @Resource
    private MemberLoginService memberLoginService;

    public List<Picture> memberPictureList(String token){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        return pictureMapper.memberPictureList(tokenMemberId);
    }

    public void insertMorePicture(String token, String picture){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        pictureMapper.insertMorePicture(tokenMemberId,picture);
    }

    public void deletePicture(String token, Long id){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        pictureMapper.deletePicture(tokenMemberId,id);
    }
}
