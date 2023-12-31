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
 * @TableName training_record
 */
@TableName(value ="training_record")
@Data
public class TrainingRecord implements Serializable {
    /**
     *
     */
    @TableId
    private Integer clubTrainingId;

    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private Date registrationTime;

    /**
     *
     */
    private Integer isPresent;

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
        TrainingRecord other = (TrainingRecord) that;
        return (this.getClubTrainingId() == null ? other.getClubTrainingId() == null : this.getClubTrainingId().equals(other.getClubTrainingId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getRegistrationTime() == null ? other.getRegistrationTime() == null : this.getRegistrationTime().equals(other.getRegistrationTime()))
                && (this.getIsPresent() == null ? other.getIsPresent() == null : this.getIsPresent().equals(other.getIsPresent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClubTrainingId() == null) ? 0 : getClubTrainingId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRegistrationTime() == null) ? 0 : getRegistrationTime().hashCode());
        result = prime * result + ((getIsPresent() == null) ? 0 : getIsPresent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clubTrainingId=").append(clubTrainingId);
        sb.append(", userId=").append(userId);
        sb.append(", registrationTime=").append(registrationTime);
        sb.append(", isPresent=").append(isPresent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}