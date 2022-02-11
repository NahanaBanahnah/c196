package com.nm.nmitchellc196.Database;

import android.app.Application;

import com.nm.nmitchellc196.DAO.AssessmentDAO;
import com.nm.nmitchellc196.DAO.CourseDAO;
import com.nm.nmitchellc196.DAO.InstructorDAO;
import com.nm.nmitchellc196.DAO.NoteDAO;
import com.nm.nmitchellc196.DAO.TermDAO;
import com.nm.nmitchellc196.Entity.Course;
import com.nm.nmitchellc196.Entity.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private TermDAO mTermDAO;
    private CourseDAO mCourseDAO;
    private AssessmentDAO mAssessmentDAO;
    private InstructorDAO mInstructorDAO;
    private NoteDAO mNoteDAO;
    private List<Term> mAllTerms;
    private List<Course> mAllCourses;

    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public Repository(Application application) {
        DBBuilder db = DBBuilder.getDatabase(application);
        mTermDAO = db.termDAO();
        mCourseDAO = db.courseDAO();
    }

    public void insert(Term term) {
        databaseExecutor.execute(() -> {
            mTermDAO.insert(term);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Term> getAllTerms() {
        databaseExecutor.execute(() -> {
            mAllTerms = mTermDAO.getAllTerms();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllTerms;
    }
}
