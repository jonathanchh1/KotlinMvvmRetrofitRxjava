package com.jonat.emi.kotlinmvvm.ViewModel

import com.jonat.emi.kotlinmvvm.Db.User

data class UsersList (val users : List<User>, val message : String, val error : Throwable? = null){
}