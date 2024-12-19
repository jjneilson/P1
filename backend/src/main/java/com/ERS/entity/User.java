package com.ERS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {
    
    /*
     * The userid field is the primary key for the User table.
     */
    @Column(name = "userid")
    @Id
    @SequenceGenerator(name = "user_seq",sequenceName = "user_seq",allocationSize = 1)
    @GeneratedValue(generator ="user_seq",strategy = GenerationType.SEQUENCE)
    private int userid;    

    /*
     * The firstname field is the first name of the user.
     */
    @Column
    private String firstname;

    /* 
     * The lastname field is the last name of the user.
     */
    @Column
    private String lastname;

    /*
     * The username field is the username of the user.
     */
    @Column
    private String username;

    /*
     * The password field is the password of the user.
     */
    @Column
    private String password;

    /* 
     * The role field is the role of the user.
     */
    @Column
    private String role;

    /*
     * Default constructor for the User class.
     * Initializes a new instance of the User class.
     */
    public User() {
    }

    /*
     * Constructs a new User object with the specified userid, firstname, lastname, username, password, and role.
     *
     * @param userid The unique identifier for the user.
     * @param firstname The first name of the user.
     * @param lastname The last name of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param role The role of the user.
     */
    public User(int userid, String firstname, String lastname, String username, String password, String role) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getuserid() {
        return userid;
    }

    public void setuserid(int userid) {
        this.userid = userid;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /*
     * Returns a string representation of the User object.
     * The string includes the userid, firstname, lastname, username, password, and role fields.
     *
     * @return a string representation of the User object
     */
    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid + '\'' +
                "firstname=" + firstname + '\'' +
                "lastname=" + lastname + '\'' +
                "username=" + username + '\'' +
                "password=" + password + '\'' +
                "role=" + role + '\'' +
                '}';
    }
}
