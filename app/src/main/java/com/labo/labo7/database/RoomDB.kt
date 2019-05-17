package com.labo.labo7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.labo.labo7.database.daos.GithubReoiDAO
import com.labo.labo7.database.entities.GithubRepo

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase(){

    abstract fun repoDAO() : GithubReoiDAO

    companion object {
        @Volatile
        private var INSTANCE : RoomDB?=null

        fun getInstance(context: Context) : RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Repo_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}