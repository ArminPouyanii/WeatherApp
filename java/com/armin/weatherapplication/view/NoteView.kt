package com.armin.weatherapplication.view

import android.view.View

interface NoteView {

    //return the root view  // the inflate layout file
    fun onNoteView():View
    interface NoteSavedListener{
        //callback function with with be used by controller to do its things
        fun onNoteSaved(note:String)
    }
    fun setListener(listener:NoteSavedListener)
}

