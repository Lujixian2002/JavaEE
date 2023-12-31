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
 * @TableName club_training
 */
@TableName(value ="club_training")
@Data
public class ClubTraining implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer clubTrainingId;

    /**
     * 
     */
    private String clubTrainingName;

    /**
     * 
     */
    private String clubTrainingTime;

    /**
     * 
     */
    private String clubTrainingLocation;

    /**
     * 
     */
    private String clubTrainingNote;

    /**
     * 
     */
    private Integer clubTrainingNumber;

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
        ClubTraining other = (ClubTraining) that;
        return (this.getClubTrainingId() == null ? other.getClubTrainingId() == null : this.getClubTrainingId().equals(other.getClubTrainingId()))
            && (this.getClubTrainingName() == null ? other.getClubTrainingName() == null : this.getClubTrainingName().equals(other.getClubTrainingName()))
            && (this.getClubTrainingTime() == null ? other.getClubTrainingTime() == null : this.getClubTrainingTime().equals(other.getClubTrainingTime()))
            && (this.getClubTrainingLocation() == null ? other.getClubTrainingLocation() == null : this.getClubTrainingLocation().equals(other.getClubTrainingLocation()))
            && (this.getClubTrainingNote() == null ? other.getClubTrainingNote() == null : this.getClubTrainingNote().equals(other.getClubTrainingNote()))
            && (this.getClubTrainingNumber() == null ? other.getClubTrainingNumber() == null : this.getClubTrainingNumber().equals(other.getClubTrainingNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClubTrainingId() == null) ? 0 : getClubTrainingId().hashCode());
        result = prime * result + ((getClubTrainingName() == null) ? 0 : getClubTrainingName().hashCode());
        result = prime * result + ((getClubTrainingTime() == null) ? 0 : getClubTrainingTime().hashCode());
        result = prime * result + ((getClubTrainingLocation() == null) ? 0 : getClubTrainingLocation().hashCode());
        result = prime * result + ((getClubTrainingNote() == null) ? 0 : getClubTrainingNote().hashCode());
        result = prime * result + ((getClubTrainingNumber() == null) ? 0 : getClubTrainingNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clubTrainingId=").append(clubTrainingId);
        sb.append(", clubTrainingName=").append(clubTrainingName);
        sb.append(", clubTrainingTime=").append(clubTrainingTime);
        sb.append(", clubTrainingLocation=").append(clubTrainingLocation);
        sb.append(", clubTrainingNote=").append(clubTrainingNote);
        sb.append(", clubTrainingNumber=").append(clubTrainingNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}