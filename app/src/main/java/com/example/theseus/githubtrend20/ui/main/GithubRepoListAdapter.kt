package com.example.theseus.githubtrend20.ui.main

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.theseus.githubtrend20.R
import com.example.theseus.githubtrend20.ui.detail.SELECTED_GITHUB_REPO
import kotlinx.android.synthetic.main.github_repo_item.view.*
import kotlin.properties.Delegates

class GithubRepoListAdapter: RecyclerView.Adapter<GithubRepoListAdapter.GithubRepoViewHolder>(),AutoUpdatableAdapter {
    var githubRepoList: List<GithubRepo> by Delegates.observable(emptyList()){
        _,oldList, newList -> autoNotify(oldList,newList){
            a,b-> a.id==b.id
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
        return GithubRepoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.github_repo_item,parent,false))
    }

    override fun getItemCount(): Int {
        return githubRepoList.size
    }

    override fun onBindViewHolder(viewHolder: GithubRepoViewHolder, position: Int) {
        viewHolder.bind(githubRepoList[viewHolder.adapterPosition])
    }

    inner class GithubRepoViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(githubRepo: GithubRepo) {
            view.name.text= githubRepo.name
            view.description.text = githubRepo.description
            view.star_count.text = githubRepo.stars.toString()
            view.watch_count.text = githubRepo.watchers.toString()
            view.setOnClickListener {
                it.findNavController()
                    .navigate(R.id.open_detail_view,
                        Bundle().apply {
                            putParcelable(SELECTED_GITHUB_REPO,githubRepo)
                        })
            }
        }
    }
}