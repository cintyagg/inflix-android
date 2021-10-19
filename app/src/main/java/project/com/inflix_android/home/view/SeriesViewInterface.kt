package project.com.inflix_android.home.view

import project.com.inflix_android.model.DataSeries

interface SeriesViewInterface {
    interface SeriesDataView {
        fun getDataSeriesFromPresenter(value: ArrayList<DataSeries>)
    }

    interface SeriesPresenter{
        fun getSeriesData()
    }

    interface SeriesModelInterface{
        fun addSeriesValue()
        fun getSeriesValue(): ArrayList<DataSeries>
    }
}