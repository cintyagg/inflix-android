package project.com.inflix_android.home.view

import project.com.inflix_android.model.DataMovies

interface MovieViewInterface {
    interface MovieDataView {
        fun getDataMovieFromPresenter(value: ArrayList<DataMovies>)
    }

    interface MoviePresenter{
        fun getMovieData()
    }

    interface MovieModelInterface{
        fun addMovieValue()
        fun getMovieValue(): ArrayList<DataMovies>
    }
}