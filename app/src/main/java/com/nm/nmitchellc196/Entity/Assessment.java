package com.nm.nmitchellc196.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Assessments")
public class Assessment {
    @PrimaryKey(autoGenerate = true)
    private int assessmentID;
    private String assessmentName;
    private String assessmentType;
    private String termID;
    private String courseID;

    public Assessment(int assessmentID, String assessmentName, String assessmentType, String termID, String courseID) {
        this.assessmentID = assessmentID;
        this.assessmentName = assessmentName;
        this.assessmentType = assessmentType;
        this.termID = termID;
        this.courseID = courseID;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getTermID() {
        return termID;
    }

    public void setTermID(String termID) {
        this.termID = termID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}
