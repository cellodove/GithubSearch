package com.peter.data.service

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [LocalDao::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        private lateinit var instance : AppDatabase

        fun getInstance(context: Context) : AppDatabase{
            synchronized(this){
                if (!::instance.isInitialized){
                    instance =
                        Room.databaseBuilder(
                            context,
                            AppDatabase::class.java,
                            "github-db"
                        ).build()
                }
            }
            return instance
        }
    }
    abstract fun localDao() : LocalDao
}