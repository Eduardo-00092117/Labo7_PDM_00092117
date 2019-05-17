package com.labo.labo7.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.labo.labo7.database.daos.GithubReoiDAO
import com.labo.labo7.database.entities.GithubRepo

class GithubRepoRepository(private val repoDAO : GithubReoiDAO) {

    fun getAll() : LiveData<List<GithubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo : GithubRepo){
        repoDAO.insert(repo)
    }
}