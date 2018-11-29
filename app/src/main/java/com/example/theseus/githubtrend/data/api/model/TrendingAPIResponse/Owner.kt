package com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Owner(

	@field:SerializedName("gists_url")
	val gistsUrl: String? = null,

	@field:SerializedName("repos_url")
	val reposUrl: String? = null,

	@field:SerializedName("following_url")
	val followingUrl: String? = null,

	@field:SerializedName("starred_url")
	val starredUrl: String? = null,

	@field:SerializedName("login")
	val login: String? = null,

	@field:SerializedName("followers_url")
	val followersUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:SerializedName("received_events_url")
	val receivedEventsUrl: String? = null,

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("events_url")
	val eventsUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("site_admin")
	val siteAdmin: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("gravatar_id")
	val gravatarId: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String? = null
) : Parcelable {
	constructor(source: Parcel) : this(
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readValue(Boolean::class.java.classLoader) as Boolean?,
		source.readValue(Int::class.java.classLoader) as Int?,
		source.readString(),
		source.readString(),
		source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(gistsUrl)
		writeString(reposUrl)
		writeString(followingUrl)
		writeString(starredUrl)
		writeString(login)
		writeString(followersUrl)
		writeString(type)
		writeString(url)
		writeString(subscriptionsUrl)
		writeString(receivedEventsUrl)
		writeString(avatarUrl)
		writeString(eventsUrl)
		writeString(htmlUrl)
		writeValue(siteAdmin)
		writeValue(id)
		writeString(gravatarId)
		writeString(nodeId)
		writeString(organizationsUrl)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<Owner> = object : Parcelable.Creator<Owner> {
			override fun createFromParcel(source: Parcel): Owner = Owner(source)
			override fun newArray(size: Int): Array<Owner?> = arrayOfNulls(size)
		}
	}
}