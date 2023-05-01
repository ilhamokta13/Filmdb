package com.example.filmdb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmdb.databinding.ItemMovieBinding
import com.example.filmdb.model.Result

class MovieAdapter(var listmovie:List<Result>):RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {

        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.binding.tvNamafilm.text = listmovie[position].originalTitle
        holder.binding.tvRatingfilm.text = listmovie[position].voteAverage.toString()
        holder.binding.tvReleasefilm.text=listmovie[position].releaseDate
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${listmovie[position].posterPath}").into(holder.binding.ivFilmimage)


    }

    override fun getItemCount(): Int {
        return listmovie.size


    }


}