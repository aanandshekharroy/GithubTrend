package com.example.theseus.githubtrend.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theseus.githubtrend.R
import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.RepoItem
import kotlinx.android.synthetic.main.repo_item.view.*
import kotlin.properties.Delegates

class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.RepoItemViewHolder>(),
    AutoUpdatableAdapter {
    var mRepoList: List<RepoItem> by Delegates.observable(emptyList()) {
        _, oldList, newList ->
        //Using DiffUtils to enhance the performance of RecyclerView
        autoNotify(oldList, newList) { o, n -> o.id == n.id}
    }
    lateinit var mListener: (repo: RepoItem) -> Unit
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        return RepoItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repo_item, parent,false))
    }

    override fun getItemCount() = mRepoList.size

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(holder.adapterPosition)
    }

    inner class RepoItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(adapterPosition: Int) {
            view.name.text = mRepoList[adapterPosition].name
            view.description.text = mRepoList[adapterPosition].description
            view.star_count.text = mRepoList[adapterPosition].stargazersCount.toString()
            view.watch_count.text = mRepoList[adapterPosition].watchersCount.toString()
            view.setOnClickListener {
                mListener(mRepoList[adapterPosition])
            }
        }

    }

    fun updateRepoList(repoList: List<RepoItem>){
        mRepoList = repoList
    }
}