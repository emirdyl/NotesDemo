package com.example.notesdemo.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NoteDao {
    @Query(" SELECT * FROM Note ")
    suspend fun getAllNotes(): List<NoteEntity>

    @Insert
    suspend fun insert(note: NoteEntity)
    @Update
    suspend fun update(note : NoteEntity)

    @Delete
    suspend fun delete(note:NoteEntity)
}