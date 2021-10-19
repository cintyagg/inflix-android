package project.com.inflix_android.model

import project.com.inflix_android.home.view.MovieViewInterface

data class DataMovies(
    var image: Int,
    var title: String,
    var subtitle: String,
    var imageButton: Int ) : MovieViewInterface.MovieModelInterface {
    var list = ArrayList<DataMovies>()
    override fun addMovieValue() {
        list.add(DataMovies(image, title, subtitle, imageButton))
    }

    override fun getMovieValue(): ArrayList<DataMovies> {
        return list
    }
}