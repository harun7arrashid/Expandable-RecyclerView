package com.example.expandablekotin.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(val name: String? = ""): Parcelable
