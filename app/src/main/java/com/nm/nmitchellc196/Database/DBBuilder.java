package com.nm.nmitchellc196.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nm.nmitchellc196.DAO.AssessmentDAO;
import com.nm.nmitchellc196.DAO.CourseDAO;
import com.nm.nmitchellc196.DAO.InstructorDAO;
import com.nm.nmitchellc196.DAO.NoteDAO;
import com.nm.nmitchellc196.DAO.TermDAO;
import com.nm.nmitchellc196.Entity.Assessment;
import com.nm.nmitchellc196.Entity.Course;
import com.nm.nmitchellc196.Entity.Instructor;
import com.nm.nmitchellc196.Entity.Note;
import com.nm.nmitchellc196.Entity.Term;

@Database(entities = {Term.class, Course.class, Assessment.class, Instructor.class, Note.class}, version = 5, exportSchema = false)

public abstract class DBBuilder extends RoomDatabase {
    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    public abstract AssessmentDAO assessmentDAO();
    public abstract InstructorDAO instructorDAO();
    public abstract NoteDAO noteDAO();

    private static volatile DBBuilder INSTANCE;

    static DBBuilder getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (DBBuilder.class) {
                if(INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DBBuilder.class, "TermDB.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
