package project.com.inflix_android.home.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movies_galery.view.*
import project.com.inflix_android.R
import project.com.inflix_android.model.DataMovies

class MoviesAdapter(var value: ArrayList<DataMovies>) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(movieItem : View) : RecyclerView.ViewHolder(movieItem){
        fun bindMovieItens(movies: DataMovies){
            itemView.movieImage.setImageResource(movies.image)
            itemView.movieName.text = movies.title
            itemView.movieSubtitle.text = movies.subtitle
            itemView.heartMovieImage.setImageResource(movies.imageButton)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_galery, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovieItens(value[position])
    }

    override fun getItemCount(): Int {
        return value.size
    }

}