package com.example.theseus.githubtrend20.ui.main

import android.os.Parcel
import android.os.Parcelable

data class GithubRepo(
    val id: Int, val name: String, val description: String, val stars: Int
    , val watchers: Int, val ownerName: String, val githubUrl: String, val avatarUrl: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(description)
        writeInt(stars)
        writeInt(watchers)
        writeString(ownerName)
        writeString(githubUrl)
        writeString(avatarUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<GithubRepo> = object : Parcelable.Creator<GithubRepo> {
            override fun createFromParcel(source: Parcel): GithubRepo = GithubRepo(source)
            override fun newArray(size: Int): Array<GithubRepo?> = arrayOfNulls(size)
        }
    }
}