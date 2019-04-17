package com.jonat.emi.kotlinmvvm.ViewModel

import com.jonat.emi.kotlinmvvm.Db.UserRepo
import io.reactivex.Observable
import timber.log.Timber

class UserListViewModel(private val userRepo : UserRepo) {

    fun getUsers(): Observable<UsersList> {
        //creating the data for UI
        return userRepo.getUsers()
            .map{
                Timber.d("mapping users to UI Data")
                UsersList(it.take(10), "Top 10 users")
            }
            .onErrorReturn{
                Timber.d("an error occurred $it")
                UsersList(emptyList(), "An error occurred,", it);
            }
    }

}