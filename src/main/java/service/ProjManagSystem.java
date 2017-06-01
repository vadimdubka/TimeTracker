package service;

import entity.Project;
import entity.Task;
import entity.TimeQuant;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class ProjManagSystem {
    private static ProjManagSystem projManagSystemInst;
    private Connection connection;
    private HashSet<Project> projectsSet;


    public ProjManagSystem() {
        this.connection = DBConnection.getConnection();
        loadProjectsFromDB();
    }

    private static ProjManagSystem getInstance() {
        if (projManagSystemInst == null) {
            projManagSystemInst = new ProjManagSystem();
        }
        return projManagSystemInst;
    }

    public HashSet<Project> getProjectsSet() {
        return projectsSet;
    }

    // загрузка списка всех проектов из БД
    public void loadProjectsFromDB() {
        if (projectsSet != null) {
            projectsSet.clear();
        } else projectsSet = new HashSet<Project>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM projects ORDER BY project_id");
            while (rs.next()) {
                Project project = new Project(rs);
                projectsSet.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // загрузка из БД списка всех задач определенного проекта
    public void loadTasksFromDB(Project project) {
        HashSet<Task> tasks = project.getTasksSet();
        if (tasks != null) {
            tasks.clear();
        } else tasks = new HashSet<Task>();

        int project_id = project.getProject_Id();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM task WHERE project_id=project_id ORDER BY task_id");
            while (rs.next()) {
                Task task = new Task(rs);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // загрузка из БД списка всех квантов определенной задачи
    public void loadTimeQsFormDB(Task task) {
        HashSet<TimeQuant> timeQuants = task.getTimeQuantumsSet();
        if (timeQuants != null) {
            timeQuants.clear();
        } else timeQuants = new HashSet<TimeQuant>();

        int task_id = task.getTask_id();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM timeQuantums WHERE task_id=task_id ORDER BY timeQuantum_id");
            while (rs.next()) {
                TimeQuant quantum = new TimeQuant(rs);
                timeQuants.add(quantum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Добавить, удалить, обновить проект в БД
    // Добавить, удалить, обновить подпроект в БД
    // Добавить, удалить, обновить квант в БД

    /* Получение списка квантов по фильтру:
    по работнику
    по проекту
    по подпроекту
    по дате создания
    по продолжительности кванта
     */


}
