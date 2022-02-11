package com.nm.nmitchellc196.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.nm.nmitchellc196.Entity.Instructor;


import java.util.List;

@Dao
public interface InstructorDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Instructor instructor);

    @Update
    void update(Instructor instructor);

    @Query("SELECT * FROM Instructors order by instructorID ASC")
    List<Instructor> getAllInstructors();
}
