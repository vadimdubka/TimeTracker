package entity;// Created by sky-vd on 24.03.2017.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TimeQuant {
    private int timeQuantum_id;
    private int task_id;
    private int empl_id;
    private int length;
    private Date date;

    public TimeQuant(ResultSet resultSet) throws SQLException {
        this.timeQuantum_id = resultSet.getInt(1);
        this.task_id = resultSet.getInt(2);
        this.empl_id = resultSet.getInt(3);
        this.length = resultSet.getInt(4);
        this.date = resultSet.getDate(5);
    }

    public int getTimeQuantum_id() {
        return timeQuantum_id;
    }

    public void setTimeQuantum_id(int timeQuantum_id) {
        this.timeQuantum_id = timeQuantum_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getEmpl_id() {
        return empl_id;
    }

    public void setEmpl_id(int empl_id) {
        this.empl_id = empl_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
