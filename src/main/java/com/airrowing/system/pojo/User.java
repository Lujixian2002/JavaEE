package com.airrowing.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户昵称，唯一
     */
    private String userNickname;

    /**
     * 用户真实姓名
     */
    private String userRealName;

    /**
     * 用户所在国家
     */
    private String userCountry;

    /**
     * 用户头像图片的URL
     */
    private String userPortraitUrl;

    /**
     * 用户电子邮箱，唯一
     */
    private String userEmail;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户电话号码
     */
    private String userPhoneNumber;

    /**
     * 用户所属俱乐部
     */
    private String userClub;

    /**
     * 用户住址
     */
    private String userAddress;

    /**
     * 用户性别，1为男，0为女
     */
    private Integer userGender;

    /**
     * 用户生日
     */
    private Date userBirthday;

    /**
     * 用户身高（单位：厘米）
     */
    private Integer userHeight;

    /**
     * 用户体重（单位：千克）
     */
    private Integer userWeight;

    /**
     * 用户粉丝人数
     */
    private Integer userFollowerNumber;

    /**
     * 用户关注人数
     */
    private Integer userFollowingNumber;

    /**
     * 用户个性签名
     */
    private String userSignature;

    /**
     * 用户艇龄
     */
    private Integer userRowSince;

    /**
     * 用户两千米成绩
     */
    private Date userTwoKmRecord;

    /**
     * 用户最喜欢的艇种
     */
    private String userFavoriteBoat;

    /**
     * 用户的偶像
     */
    private String userIdol;

    /**
     * 用户现阶段目标
     */
    private String userCurrentTarget;

    /**
     * 用户一次难忘的经历
     */
    private String userUnforgettableExperience;

    /**
     * 用户喜欢赛艇的原因
     */
    private String userRowReason;

    /**
     * 标志用户是否被封禁
     */
    private Integer userIsBanned;

    /**
     * 标志用户是否在线
     */
    private Integer userIsOnline;

    /**
     * 用户最后登录时间
     */
    private Date userLastLoginTime;

    /**
     * 用户注册时间
     */
    private Date userRegistrationDate;

    /**
     * 
     */
    private Integer applyClubStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserNickname() == null ? other.getUserNickname() == null : this.getUserNickname().equals(other.getUserNickname()))
            && (this.getUserRealName() == null ? other.getUserRealName() == null : this.getUserRealName().equals(other.getUserRealName()))
            && (this.getUserCountry() == null ? other.getUserCountry() == null : this.getUserCountry().equals(other.getUserCountry()))
            && (this.getUserPortraitUrl() == null ? other.getUserPortraitUrl() == null : this.getUserPortraitUrl().equals(other.getUserPortraitUrl()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserPhoneNumber() == null ? other.getUserPhoneNumber() == null : this.getUserPhoneNumber().equals(other.getUserPhoneNumber()))
            && (this.getUserClub() == null ? other.getUserClub() == null : this.getUserClub().equals(other.getUserClub()))
            && (this.getUserAddress() == null ? other.getUserAddress() == null : this.getUserAddress().equals(other.getUserAddress()))
            && (this.getUserGender() == null ? other.getUserGender() == null : this.getUserGender().equals(other.getUserGender()))
            && (this.getUserBirthday() == null ? other.getUserBirthday() == null : this.getUserBirthday().equals(other.getUserBirthday()))
            && (this.getUserHeight() == null ? other.getUserHeight() == null : this.getUserHeight().equals(other.getUserHeight()))
            && (this.getUserWeight() == null ? other.getUserWeight() == null : this.getUserWeight().equals(other.getUserWeight()))
            && (this.getUserFollowerNumber() == null ? other.getUserFollowerNumber() == null : this.getUserFollowerNumber().equals(other.getUserFollowerNumber()))
            && (this.getUserFollowingNumber() == null ? other.getUserFollowingNumber() == null : this.getUserFollowingNumber().equals(other.getUserFollowingNumber()))
            && (this.getUserSignature() == null ? other.getUserSignature() == null : this.getUserSignature().equals(other.getUserSignature()))
            && (this.getUserRowSince() == null ? other.getUserRowSince() == null : this.getUserRowSince().equals(other.getUserRowSince()))
            && (this.getUserTwoKmRecord() == null ? other.getUserTwoKmRecord() == null : this.getUserTwoKmRecord().equals(other.getUserTwoKmRecord()))
            && (this.getUserFavoriteBoat() == null ? other.getUserFavoriteBoat() == null : this.getUserFavoriteBoat().equals(other.getUserFavoriteBoat()))
            && (this.getUserIdol() == null ? other.getUserIdol() == null : this.getUserIdol().equals(other.getUserIdol()))
            && (this.getUserCurrentTarget() == null ? other.getUserCurrentTarget() == null : this.getUserCurrentTarget().equals(other.getUserCurrentTarget()))
            && (this.getUserUnforgettableExperience() == null ? other.getUserUnforgettableExperience() == null : this.getUserUnforgettableExperience().equals(other.getUserUnforgettableExperience()))
            && (this.getUserRowReason() == null ? other.getUserRowReason() == null : this.getUserRowReason().equals(other.getUserRowReason()))
            && (this.getUserIsBanned() == null ? other.getUserIsBanned() == null : this.getUserIsBanned().equals(other.getUserIsBanned()))
            && (this.getUserIsOnline() == null ? other.getUserIsOnline() == null : this.getUserIsOnline().equals(other.getUserIsOnline()))
            && (this.getUserLastLoginTime() == null ? other.getUserLastLoginTime() == null : this.getUserLastLoginTime().equals(other.getUserLastLoginTime()))
            && (this.getUserRegistrationDate() == null ? other.getUserRegistrationDate() == null : this.getUserRegistrationDate().equals(other.getUserRegistrationDate()))
            && (this.getApplyClubStatus() == null ? other.getApplyClubStatus() == null : this.getApplyClubStatus().equals(other.getApplyClubStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserNickname() == null) ? 0 : getUserNickname().hashCode());
        result = prime * result + ((getUserRealName() == null) ? 0 : getUserRealName().hashCode());
        result = prime * result + ((getUserCountry() == null) ? 0 : getUserCountry().hashCode());
        result = prime * result + ((getUserPortraitUrl() == null) ? 0 : getUserPortraitUrl().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserPhoneNumber() == null) ? 0 : getUserPhoneNumber().hashCode());
        result = prime * result + ((getUserClub() == null) ? 0 : getUserClub().hashCode());
        result = prime * result + ((getUserAddress() == null) ? 0 : getUserAddress().hashCode());
        result = prime * result + ((getUserGender() == null) ? 0 : getUserGender().hashCode());
        result = prime * result + ((getUserBirthday() == null) ? 0 : getUserBirthday().hashCode());
        result = prime * result + ((getUserHeight() == null) ? 0 : getUserHeight().hashCode());
        result = prime * result + ((getUserWeight() == null) ? 0 : getUserWeight().hashCode());
        result = prime * result + ((getUserFollowerNumber() == null) ? 0 : getUserFollowerNumber().hashCode());
        result = prime * result + ((getUserFollowingNumber() == null) ? 0 : getUserFollowingNumber().hashCode());
        result = prime * result + ((getUserSignature() == null) ? 0 : getUserSignature().hashCode());
        result = prime * result + ((getUserRowSince() == null) ? 0 : getUserRowSince().hashCode());
        result = prime * result + ((getUserTwoKmRecord() == null) ? 0 : getUserTwoKmRecord().hashCode());
        result = prime * result + ((getUserFavoriteBoat() == null) ? 0 : getUserFavoriteBoat().hashCode());
        result = prime * result + ((getUserIdol() == null) ? 0 : getUserIdol().hashCode());
        result = prime * result + ((getUserCurrentTarget() == null) ? 0 : getUserCurrentTarget().hashCode());
        result = prime * result + ((getUserUnforgettableExperience() == null) ? 0 : getUserUnforgettableExperience().hashCode());
        result = prime * result + ((getUserRowReason() == null) ? 0 : getUserRowReason().hashCode());
        result = prime * result + ((getUserIsBanned() == null) ? 0 : getUserIsBanned().hashCode());
        result = prime * result + ((getUserIsOnline() == null) ? 0 : getUserIsOnline().hashCode());
        result = prime * result + ((getUserLastLoginTime() == null) ? 0 : getUserLastLoginTime().hashCode());
        result = prime * result + ((getUserRegistrationDate() == null) ? 0 : getUserRegistrationDate().hashCode());
        result = prime * result + ((getApplyClubStatus() == null) ? 0 : getApplyClubStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userNickname=").append(userNickname);
        sb.append(", userRealName=").append(userRealName);
        sb.append(", userCountry=").append(userCountry);
        sb.append(", userPortraitUrl=").append(userPortraitUrl);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userPhoneNumber=").append(userPhoneNumber);
        sb.append(", userClub=").append(userClub);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", userGender=").append(userGender);
        sb.append(", userBirthday=").append(userBirthday);
        sb.append(", userHeight=").append(userHeight);
        sb.append(", userWeight=").append(userWeight);
        sb.append(", userFollowerNumber=").append(userFollowerNumber);
        sb.append(", userFollowingNumber=").append(userFollowingNumber);
        sb.append(", userSignature=").append(userSignature);
        sb.append(", userRowSince=").append(userRowSince);
        sb.append(", userTwoKmRecord=").append(userTwoKmRecord);
        sb.append(", userFavoriteBoat=").append(userFavoriteBoat);
        sb.append(", userIdol=").append(userIdol);
        sb.append(", userCurrentTarget=").append(userCurrentTarget);
        sb.append(", userUnforgettableExperience=").append(userUnforgettableExperience);
        sb.append(", userRowReason=").append(userRowReason);
        sb.append(", userIsBanned=").append(userIsBanned);
        sb.append(", userIsOnline=").append(userIsOnline);
        sb.append(", userLastLoginTime=").append(userLastLoginTime);
        sb.append(", userRegistrationDate=").append(userRegistrationDate);
        sb.append(", applyClubStatus=").append(applyClubStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}