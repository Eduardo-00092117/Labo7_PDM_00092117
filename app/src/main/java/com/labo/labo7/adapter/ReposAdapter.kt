package com.labo.labo7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.labo.labo7.R
import com.labo.labo7.database.entities.GithubRepo
import kotlinx.android.synthetic.main.repo_cardview.view.*

class ReposAdapter(var repos : List<GithubRepo>) : RecyclerView.Adapter<ReposAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: ReposAdapter.ViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    fun updateList(newRepos : List<GithubRepo>){
        this.repos = newRepos
        notifyDataSetChanged()
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item){
        fun bind(repo : GithubRepo) = with(itemView){
            this.tv_repo_name.text = repo.name
        }
    }

}