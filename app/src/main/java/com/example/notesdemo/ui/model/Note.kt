package com.example.notesdemo.ui.model

import java.io.Serializable

data class Note(

    var id: Int,
    var title: String,
    var description: String
):Serializable
