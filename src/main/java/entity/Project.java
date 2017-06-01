package entity;// Created by sky-vd on 24.03.2017.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class Project {
    private int project_Id;
    private String projectName;
    private HashSet<Task> tasksSet;

    public Project(ResultSet resultSet) throws SQLException {
        this.project_Id = resultSet.getInt(1);
        this.projectName = resultSet.getString(2);
    }

    public int getProject_Id() {
        return project_Id;
    }

    public void setProject_Id(int project_Id) {
        this.project_Id = project_Id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public HashSet<Task> getTasksSet() {
        return tasksSet;
    }

    public void setTasksSet(HashSet<Task> tasksSet) {
        this.tasksSet = tasksSet;
    }


}
