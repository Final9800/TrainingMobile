package Fave.mainactivity.API

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_view_data.view.*

class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(data: Data){
        if(data.thumbnail.isNotBlank()){
            Picasso.get().load(data.thumbnail).into((itemView.image))
        }
        itemView.album.text = "${data.albumId}"
        itemView.idPhoto.text = "${data.id}"
        itemView.title.text = data.title
        itemView.website.text =data.url
    }

}