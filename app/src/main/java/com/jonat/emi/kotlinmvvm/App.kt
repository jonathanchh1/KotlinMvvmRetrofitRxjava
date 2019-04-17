package com.jonat.emi.kotlinmvvm

import android.app.Application
import android.arch.persistence.room.Room
import com.jonat.emi.kotlinmvvm.Db.AppDatabase
import com.jonat.emi.kotlinmvvm.Db.UserRepo
import com.jonat.emi.kotlinmvvm.Services.UserApi
import com.jonat.emi.kotlinmvvm.ViewModel.UserListViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class App : Application(){



    companion object {
        private lateinit var retrofit: Retrofit
        private lateinit var userApi : UserApi
        private lateinit var userRepo : UserRepo
        private lateinit var userListViewModel: UserListViewModel
        private lateinit var appDatabase : AppDatabase

        fun injectUserApi() = userApi
        fun injectUserListViewModel() = userListViewModel
        fun injectUserDao() = appDatabase.userDao()

    }

    override fun onCreate() {
        super.onCreate()
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())

        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://randomapi.com/api/")
            .build()

        userApi = retrofit.create(UserApi::class.java)
        appDatabase = Room.databaseBuilder(applicationContext,
            AppDatabase::class.java, "mmvvm-databse").build()

        userRepo = UserRepo(userApi, appDatabase.userDao())
        userListViewModel = UserListViewModel(userRepo)
    }


}