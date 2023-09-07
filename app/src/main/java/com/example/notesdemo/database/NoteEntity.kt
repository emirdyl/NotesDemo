package com.example.notesdemo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTE")
data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noteId")
    var noteId: Int = 0,

    @ColumnInfo(name = "noteTitle")
    var noteTitle: String,

    @ColumnInfo(name = "noteDesc")
    var noteDesc : String
)