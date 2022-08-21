package com.example.apiwithpaging3.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.apiwithpaging3.R

class Glide {
    fun glide(url: String, image: ImageView) {
        Glide
            .with(image.context)
            .load(url)
            .placeholder(R.mipmap.avatar_man)
            .centerCrop()
            .into(image)
    }

}