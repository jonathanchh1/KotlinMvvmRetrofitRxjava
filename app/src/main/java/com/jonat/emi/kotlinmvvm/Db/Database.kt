package com.jonat.emi.kotlinmvvm.Db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = arrayOf(User::class), version = 1)
abstract class  AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}