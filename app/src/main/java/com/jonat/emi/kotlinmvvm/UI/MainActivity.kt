package com.jonat.emi.kotlinmvvm.UI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jonat.emi.kotlinmvvm.Fragments.UsersListFragment
import com.jonat.emi.kotlinmvvm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.frag_container, UsersListFragment()).commit()
        }
    }


}
