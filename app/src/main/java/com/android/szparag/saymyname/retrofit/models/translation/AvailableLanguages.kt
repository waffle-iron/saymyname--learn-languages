package com.android.szparag.saymyname.retrofit.models.translation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/2/2017.
 */
data class AvailableLanguages(
    @SerializedName("dirs") @Expose val dirs: List<String>?
  //?
)