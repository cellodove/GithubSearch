package com.peter.data.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.peter.data.model.LocalGithubRepoRes

@Database(entities = [LocalGithubRepoRes::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun localDao() : LocalDao

    companion object{
        @Volatile
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
}