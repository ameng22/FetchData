package com.example.myapplication;

public class GetDataModal {

    String username;
    String Job;


    public GetDataModal(String username, String job){
        this.username=username;
        this.Job = job;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

}
