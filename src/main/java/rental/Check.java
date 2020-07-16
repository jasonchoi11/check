package rental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Check_table")
public class Check {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String checkDate;
    private String status;
    private Integer score;

    @PostPersist
    public void onPostPersist(){
//        ScheduleFixed scheduleFixed = new ScheduleFixed();
//        BeanUtils.copyProperties(this, scheduleFixed);
//        scheduleFixed.publishAfterCommit();

        Checked checked = new Checked();
        BeanUtils.copyProperties(this, checked);
        checked.publishAfterCommit();

    }

    @PostUpdate
    public void onPostUpdate(){
        Checked checked = new Checked();
       BeanUtils.copyProperties(this, checked);
        checked.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


}
