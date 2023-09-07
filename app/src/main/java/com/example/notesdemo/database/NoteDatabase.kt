package com.example.notesdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class],version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun notedao(): NoteDao

    companion object {

        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context) : NoteDatabase {
            return INSTANCE ?: Room.databaseBuilder(
                context,
                NoteDatabase::class.java, "note_db"
            ).build().also {
                INSTANCE = it
            }
        }
    }
}