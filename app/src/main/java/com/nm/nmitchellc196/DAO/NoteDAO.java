package com.nm.nmitchellc196.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nm.nmitchellc196.Entity.Note;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("SELECT * FROM Notes order by noteID ASC")
    List<Note> getAllNotes();
}
