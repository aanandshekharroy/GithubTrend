package com.example.theseus.githubtrend20.ui.main

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView

interface AutoUpdatableAdapter {
    fun <T> RecyclerView.Adapter<*>.autoNotify(oldList: List<T>,newList:List<T>,compare:(T,T)->Boolean){
        val calculateDiff = DiffUtil.calculateDiff(object : DiffUtil.Callback(){
            override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
                return compare(oldList[oldPos],newList[newPos])
            }

            override fun getOldListSize(): Int {
                return oldList.size
            }

            override fun getNewListSize(): Int {
                return newList.size
            }

            override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
                return oldList[oldPosition]==newList[newPosition]
            }

        })
        calculateDiff.dispatchUpdatesTo(this)
    }
}