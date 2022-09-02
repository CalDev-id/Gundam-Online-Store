package com.example.latihanrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class AdapterCard (private val dataApp: ArrayList<DataCardView>):

    RecyclerView.Adapter<AdapterCard.HolderArrayList>(){


    //ini set on click
    //2
    private lateinit var mListener: OnItemClickListenerBuatKamu

    //1

    interface OnItemClickListenerBuatKamu {
        fun onItemclickKamu(position: Int)

    }

    //3

    fun setItemClickListenerBuatKamu(listener: OnItemClickListenerBuatKamu){
        mListener = listener

    }

    class HolderArrayList (inflater: LayoutInflater, parent: ViewGroup, listener: OnItemClickListenerBuatKamu) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.template_item_recycle, parent, false)) {
            val imageHolder : ImageView? = itemView.findViewById(R.id.template_gambar)
            val textAppHolder : TextView? = itemView.findViewById(R.id.template_title)
            val textHargaHolder : TextView? = itemView.findViewById(R.id.template_harga)

            //make var on-click
            val cardView:MaterialCardView = itemView.findViewById(R.id.data)

            init {
                itemView.setOnClickListener {
                    listener.onItemclickKamu(bindingAdapterPosition)
                }
            }

        }

    override fun onBindViewHolder(holder: HolderArrayList, position: Int) {
        val datalistApp = dataApp[position]
        holder.imageHolder?.setImageResource(datalistApp.imgViewData)
        holder.textAppHolder?.text = datalistApp.titleAppData
        holder.textHargaHolder?.text = datalistApp.HargaAppData
    }
    //inisiasi viewholder
    override fun onCreateViewHolder(groupAdapter: ViewGroup, viewType: Int): HolderArrayList {
        val  inflater : LayoutInflater = LayoutInflater.from(groupAdapter.context)
        return HolderArrayList(inflater, groupAdapter, mListener)
    }

    override fun getItemCount(): Int {
        return dataApp.size
    }
}