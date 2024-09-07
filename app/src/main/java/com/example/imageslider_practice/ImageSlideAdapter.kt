package com.example.imageslider_practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ImageSlideAdapter(private val list: ArrayList<Int>, private val viewPager2: ViewPager2) :
    RecyclerView.Adapter<ImageSlideAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val image = v.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.image_container, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.image.setImageResource(list[position])

        if (position == list.size - 1) {
            viewPager2.post(runnable)
        }
    }

    private val runnable = Runnable {
        list.addAll(list)
        notifyDataSetChanged()
    }
}