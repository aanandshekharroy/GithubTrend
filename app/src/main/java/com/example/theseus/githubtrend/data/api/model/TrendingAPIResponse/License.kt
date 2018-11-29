package com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse

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
)