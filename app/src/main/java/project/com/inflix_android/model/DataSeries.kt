package project.com.inflix_android.model

import project.com.inflix_android.home.view.SeriesViewInterface

data class DataSeries(
    var image: Int,
    var title: String,
    var subtitle: String,
    var imageButton: Int ) : SeriesViewInterface.SeriesModelInterface {
    var list = ArrayList<DataSeries>()
    override fun addSeriesValue() {
        list.add(DataSeries(image, title, subtitle, imageButton))
    }

    override fun getSeriesValue(): ArrayList<DataSeries> {
        return list
    }
}
