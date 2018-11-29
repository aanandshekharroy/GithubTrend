package com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class License(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("spdx_id")
	val spdxId: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null
) : Parcelable {
	constructor(source: Parcel) : this(
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(name)
		writeString(spdxId)
		writeString(key)
		writeString(url)
		writeString(nodeId)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<License> = object : Parcelable.Creator<License> {
			override fun createFromParcel(source: Parcel): License = License(source)
			override fun newArray(size: Int): Array<License?> = arrayOfNulls(size)
		}
	}
}