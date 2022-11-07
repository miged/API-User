package com.dizon.models;

import javax.persistence.Column;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

//About lombok
//https://www.baeldung.com/intro-to-project-lombok

@Data
@Table(name = "UserUpdates")
public class UserUpdate {

    // @Id
    @Column(name = "Id")
    private long id;

    @Column(name = "Username")
    private String userName;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Approved_by")
    private String approved_by;

    @Column(name = "Approved_date")
    private String approved_date;

    @Column(name = "Submitted_by")
    private String submitted_by;

    public long getId() {
        return id;
    }

    public void setId(long _Id) {
        id = _Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String _UserName) {
        userName = _UserName;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstName(String _Firstname) {
        firstName = _Firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String _LastName) {
        lastName = _LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _Email) {
        email = _Email;
    }
}
