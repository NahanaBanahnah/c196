package com.nm.nmitchellc196.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes")
public class Note {
    @PrimaryKey (autoGenerate = true)
    private int noteID;
    private String note;
    private int termID;
    private int courseID;

    public Note(int noteID, String note, int termID, int courseID) {
        this.noteID = noteID;
        this.note = note;
        this.termID = termID;
        this.courseID = courseID;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
