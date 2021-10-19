package project.com.inflix_android.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import project.com.inflix_android.R
import project.com.inflix_android.home.presenter.MoviePresenter
import project.com.inflix_android.home.presenter.SeriesPresenter
import project.com.inflix_android.home.ui.adapter.MoviesAdapter
import project.com.inflix_android.home.ui.adapter.SeriesAdapter
import project.com.inflix_android.home.view.MovieViewInterface
import project.com.inflix_android.home.view.SeriesViewInterface
import project.com.inflix_android.model.DataMovies
import project.com.inflix_android.model.DataSeries

class HomeFragment : NavHostFragment(),
    MovieViewInterface.MovieDataView,
    SeriesViewInterface.SeriesDataView{

    private lateinit var movieMoviePresenter: MovieViewInterface.MoviePresenter
    private lateinit var seriesSeriesPresenter: SeriesViewInterface.SeriesPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        movieMoviePresenter = MoviePresenter(this)
        seriesSeriesPresenter = SeriesPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun getDataMovieFromPresenter(value: ArrayList<DataMovies>) {
        val movieAdapter = MoviesAdapter(value)
        recyclerMovies.adapter = movieAdapter
    }

    override fun getDataSeriesFromPresenter(value: ArrayList<DataSeries>) {
        val seriesAdapter = SeriesAdapter(value)
        recyclerSeries.adapter = seriesAdapter
    }

    private fun initView(){
        recyclerMovies.layoutManager = LinearLayoutManager(activity)
        movieMoviePresenter.getMovieData()
        seriesSeriesPresenter.getSeriesData()
    }
}