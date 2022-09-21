package com.greedygame.aksingh.newsbreeze.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greedygame.aksingh.newsbreeze.R
import com.greedygame.aksingh.newsbreeze.model.News
import com.greedygame.aksingh.newsbreeze.util.DateFormatter
import com.greedygame.aksingh.newsbreeze.view.ArticleActivity
import com.squareup.picasso.Picasso

class SavedNewsAdapter(val context: Context, private val savedNews: List<News>):
    RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder>()
{
    inner class SavedNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private lateinit var news: News
        private val imageView: ImageView

        private val tvTitle: TextView
        private val tvDescription: TextView
        private val tvTime: TextView

        private val btnRead: Button

        init {
            imageView = itemView.findViewById(R.id.image)

            tvTitle = itemView.findViewById(R.id.title)
            tvDescription = itemView.findViewById(R.id.desc)
            tvTime = itemView.findViewById(R.id.time)

            btnRead = itemView.findViewById(R.id.read)
            btnRead.setOnClickListener {
                val intent = ArticleActivity.newIntent(context, news.urlToImage,
                    news.publishedAt, news.title, news.description, news.content,
                    news.author)

                context.startActivity(intent)
            }
        }

        fun bind(news: News)
        {
            this.news = news

            Picasso.get().load(news.urlToImage).into(imageView)

            tvTitle.text = news.title
            tvDescription.text = news.description
            tvTime.text = DateFormatter(context).format(news.publishedAt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedNewsViewHolder
    {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false)
        return SavedNewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedNewsViewHolder, position: Int)
    {
        holder.bind(savedNews[position])
    }

    override fun getItemCount(): Int
    {
        return savedNews.size
    }
}