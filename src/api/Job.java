package api;

import constants.Priority;
import constants.UserType;

import java.util.Objects;

public class Job {

    private volatile static int uniqueID = 0;
    private int id;
    private String name;
    private int duration;
    private Priority priority;
    private UserType usertype;
    private int deadline;

    public Job(String name, int duration, Priority priority, UserType usertype, int deadline) {
        this.id = uniqueId();
        this.name = name;
        this.duration = duration;
        this.priority = priority;
        this.usertype = usertype;
        this.deadline = deadline;
    }

    private int uniqueId() {
        uniqueID++;
        return uniqueID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", priority=" + priority +
                ", usertype=" + usertype +
                ", deadline=" + deadline +
                '}';
    }
}
