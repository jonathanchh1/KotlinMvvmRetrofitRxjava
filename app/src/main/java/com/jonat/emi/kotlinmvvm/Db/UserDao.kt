package com.jonat.emi.kotlinmvvm.Db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsers() : Single<List<User>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user : User)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users : List<User>)
}