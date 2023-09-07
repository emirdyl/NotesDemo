package com.example.notesdemo.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesdemo.database.NoteDatabase
import com.example.notesdemo.database.NoteEntity
import com.example.notesdemo.ext.toLiveData
import com.example.notesdemo.ui.model.Note
import kotlinx.coroutines.launch

class DetailViewModel(val app: Application): AndroidViewModel(app) {

    private val _noteLiveData = MutableLiveData<Note>()
    val noteLiveData = _noteLiveData.toLiveData()


    fun getNote(note : Note){

        viewModelScope.launch {



        }

    }


}