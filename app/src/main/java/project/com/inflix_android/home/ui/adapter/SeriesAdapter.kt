package project.com.inflix_android.home.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.series_galery.view.*
import project.com.inflix_android.R
import project.com.inflix_android.model.DataSeries

class SeriesAdapter(var value: ArrayList<DataSeries>) :
    RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>() {

    class SeriesViewHolder(seriesItens: View) : RecyclerView.ViewHolder(seriesItens) {
        fun bindSeriesItens(series: DataSeries) {
            itemView.seriesImage.setImageResource(series.image)
            itemView.seriesName.text = series.title
            itemView.seriesSubtitle.text = series.subtitle
            itemView.heartSeriesImage.setImageResource(series.imageButton)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.series_galery, parent, false)
        return SeriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.bindSeriesItens(value[position])
    }

    override fun getItemCount(): Int {
        return value.size
    }
}