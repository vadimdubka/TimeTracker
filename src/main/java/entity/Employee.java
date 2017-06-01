package entity;// Created by sky-vd on 24.03.2017.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Comparable {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private int empl_id;

    private String surName;
    private String firstName;
    private String patronymic;

    private Date dateOfBirth;
    private String sex;

    private String email;
    private String phone;

    private String post;
    private float wageRate;

    private String login;
    private String password;

    // может добавить кучу для хранения всех квантов работника?

    public Employee() {
    }

    public Employee(ResultSet rs) throws SQLException {
        empl_id = rs.getInt(1);
        surName = rs.getString(2);
        firstName = rs.getString(3);
        patronymic = rs.getString(4);
        dateOfBirth = rs.getDate(5);
        sex = rs.getString(6);
        email = rs.getString(7);
        phone = rs.getString(8);
        post = rs.getString(9);
        wageRate = rs.getFloat(10);
        login = rs.getString(11);
        password = rs.getString(12);
    }

    public int getEmpl_id() {
        return empl_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public float getWageRate() {
        return wageRate;
    }

    public void setWageRate(float wageRate) {
        this.wageRate = wageRate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int compareTo(Object obj) {
        return this.surName.compareTo(((Employee) obj).getSurName());
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    // + реализация стандартных методов
    @Override
    public String toString() {
        String dateOfBirthString = dateFormat.format(dateOfBirth);
        return String.format("%-3d %-10s %-10s %-14s %s %s email:%-15s phone:%-7s должность:%-10s час.ставка:%.2f login:%-7s passw:%s", empl_id, surName, firstName, patronymic, dateOfBirthString, sex, email, phone, post, wageRate, login, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (this.empl_id == employee.empl_id) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return empl_id % 10;
    }
}
