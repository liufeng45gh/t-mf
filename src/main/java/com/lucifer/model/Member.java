package com.lucifer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lucifer.utils.Constant;
import com.lucifer.utils.DateTimeSerializer;
import com.lucifer.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1l;


	// id        自增长(长整,以下所有id字段皆为该规则)
	private Long id;


	// phone     绑定手机,允许为空
	private String phone;
	

	
	// password  密码,(加密后的密码,非明文),允许为空
	private String password;
	

	// salt      加密盐,6位随机数字字母组合,允许为空
	private String salt;

	// weixin_id 微信绑定ID,允许为空
	private String weixin;

	// qq_id     QQ绑定ID,允许为空
	private String qq;

	//验证码
	private String code;

	private String status;
	
	//第三方token
	private String accessToken;
	
	// nick_name 昵称
	private String nickName;
	
	// avatar    头像图片路径
	private String avatar;

	// gender       性别 male:男 female:女  secrecy:保密
	private String gender;
	

	// birth     出生年月日

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String feature;

	private String description;

	private String nationality;

	private Float height;
	
	private Float weight;

	private Float bust;

	private String city;

	private String language;

	private String line;

	private String facebook;

	// mail      绑定邮箱,允许为空
	private String email;

	private Float timePrice;

	private Float nightPrice;

	private Float dayPrice;

	private String picture;

	private Integer selfShow;

	// 创建时间（记录）
	protected  Date createdAt;
	
	// 更新时间（记录）
	protected Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}





	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}




	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(using=DateTimeSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(using=DateTimeSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getBust() {
		return bust;
	}

	public void setBust(Float bust) {
		this.bust = bust;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getTimePrice() {
		return timePrice;
	}

	public void setTimePrice(Float timePrice) {
		this.timePrice = timePrice;
	}

	public Float getNightPrice() {
		return nightPrice;
	}

	public void setNightPrice(Float nightPrice) {
		this.nightPrice = nightPrice;
	}

	public Float getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Float dayPrice) {
		this.dayPrice = dayPrice;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getSelfShow() {
		return selfShow;
	}

	public void setSelfShow(Integer selfShow) {
		this.selfShow = selfShow;
	}


}
