package com.noname.task.presentation.main

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.noname.basesample.R
import com.noname.task.model.usecases.changecolor
import com.noname.task.presentation.main.login.LoginFragment

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changecolor(this)
        this.supportFragmentManager.beginTransaction().add(R.id.main_fram,
            LoginFragment(), "Main").commit()

    }
}
