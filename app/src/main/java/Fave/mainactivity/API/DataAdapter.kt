package Fave.mainactivity.API

import Fave.mainactivity.R
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val dataList:MutableList<Data>):RecyclerView.Adapter<DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_view_data, parent,false))
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
//    Update new List Data
    fun updateData(newList: List<Data>){
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }

}


