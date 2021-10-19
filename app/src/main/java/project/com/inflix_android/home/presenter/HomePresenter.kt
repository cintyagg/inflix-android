package project.com.inflix_android.home.presenter

import project.com.inflix_android.R
import project.com.inflix_android.home.view.MovieViewInterface
import project.com.inflix_android.home.view.SeriesViewInterface
import project.com.inflix_android.model.DataMovies
import project.com.inflix_android.model.DataSeries

class MoviePresenter(
    private var movieView: MovieViewInterface.MovieDataView) :
    MovieViewInterface.MoviePresenter {
    private var movies : DataMovies = DataMovies(
        R.mipmap.ic_launcher,
        R.string.movieName.toString(),
        R.string.movieSubtitle.toString(),
        R.drawable.ic_baseline_favorite)

    init{
        movies.addMovieValue()
    }

    override fun getMovieData() {
        movieView.getDataMovieFromPresenter(movies.getMovieValue())
    }
}

class SeriesPresenter(
    private var seriesView: SeriesViewInterface.SeriesDataView) : SeriesViewInterface,
    SeriesViewInterface.SeriesPresenter {
    private var series : DataSeries = DataSeries(
        R.mipmap.ic_launcher,
        R.string.movieName.toString(),
        R.string.movieSubtitle.toString(),
        R.drawable.ic_baseline_favorite)

    init{
        series.addSeriesValue()
    }

    override fun getSeriesData() {
        seriesView.getDataSeriesFromPresenter(series.getSeriesValue())
    }
}