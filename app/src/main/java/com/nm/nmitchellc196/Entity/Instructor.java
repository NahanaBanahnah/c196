package com.nm.nmitchellc196.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Instructors")
public class Instructor {
    @PrimaryKey(autoGenerate = true)
    private int instructorID;
    private String name;
    private String email;
    private String phoneNumber;

    public Instructor(int instructorID, String name, String email, String phoneNumber) {
        this.instructorID = instructorID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
