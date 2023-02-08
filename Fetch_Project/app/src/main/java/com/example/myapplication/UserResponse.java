package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("title")
    String firstname;
    @SerializedName("body")
    String lastname;
//    String last_name;
//    String email;
//    String date_joined = "2023-02-01T12:14:36.566Z";
//
//    public String getUsername() {
//        return username;
//    }
//

    public UserResponse(String username, String job){
        this.firstname=username;
        this.lastname = job;
    }

    public String getUsername() {
        return firstname;
    }

    public void setUsername(String username) {
        this.firstname = username;
    }

    public String getJob() {
        return lastname;
    }

    public void setJob(String job) {
        lastname = lastname;
    }

//    private int id;
//    private String username;
//    private String first_name;
//    private String last_name;
//    private String email;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
