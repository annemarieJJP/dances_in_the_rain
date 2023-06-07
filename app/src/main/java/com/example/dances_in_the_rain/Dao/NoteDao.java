package com.example.dances_in_the_rain.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Dao;

import com.example.dances_in_the_rain.entities.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("Select * From notes Order By id DESC")
    List<Note> getAllNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);
}
