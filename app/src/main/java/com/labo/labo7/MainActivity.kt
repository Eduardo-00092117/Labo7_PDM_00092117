package com.labo.labo7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.labo.labo7.adapter.ReposAdapter
import com.labo.labo7.database.entities.GithubRepo
import com.labo.labo7.database.viewmodels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ReposAdapter
    lateinit var viewModel : GithubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()

    }

    fun bind(){
        adapter = ReposAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        recycler.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })
        btn_add.setOnClickListener {
            viewModel.insert(GithubRepo(et_repo_name.text.toString()))
        }
    }
}
