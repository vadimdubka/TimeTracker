package entity;// Created by sky-vd on 24.03.2017.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class Task {
    private int task_id;
    private int project_id; // возможно лучше хранить ссылку на объект
    private String taskName;
    private HashSet<TimeQuant> timeQuantumsSet;

    public Task(ResultSet resultSet) throws SQLException {
        this.task_id = resultSet.getInt(1);
        this.project_id = resultSet.getInt(2);
        this.taskName = resultSet.getString(3);
    }


    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String  getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public HashSet<TimeQuant> getTimeQuantumsSet() {
        return timeQuantumsSet;
    }

    public void setTimeQuantumsSet(HashSet<TimeQuant> timeQuantumsSet) {
        this.timeQuantumsSet = timeQuantumsSet;
    }
}
