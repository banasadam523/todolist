package pl.sda.todolist.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date finishDate;

    //true if finished
    private boolean finished;

    public ToDo() {
        startDate = new Date();
    }

    public ToDo(String name, boolean finished) {
        this();
        this.name = name;
        this.finished = finished;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desription) {
        this.description = desription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void isFinished(boolean finished) {
        this.finished = finished;
    }

    public void setFinished(boolean finished){
        if(finished!=true) {
            return;
        }

        if(finished) {
            finishDate = new Date();

        }
        this.finished = finished;
    }

}
