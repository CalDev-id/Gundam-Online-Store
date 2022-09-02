package com.example.latihanrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterCardAtas (private val dataApp: ArrayList<DataCardAtas>):
    RecyclerView.Adapter<AdapterCardAtas.HolderArrayList>() {

    private lateinit var mListener:OnItemClickListener2

    //1

    interface OnItemClickListener2 {
        fun onItemclickKamu(position: Int)

    }

    fun setItemClickListenerBuatKamu(listener:OnItemClickListener2){
        mListener = listener

    }

    class HolderArrayList (inflater: LayoutInflater, parent: ViewGroup, listener:OnItemClickListener2) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.template_recycle_atas, parent, false)) {
        val imageHolder : ImageView? = itemView.findViewById(R.id.banner_gundam)
        val textAppHolder : TextView? = itemView.findViewById(R.id.nama_gundam)
        val textHargaHolder : TextView? = itemView.findViewById(R.id.harga)

        init {
            itemView.setOnClickListener {
                listener.onItemclickKamu(bindingAdapterPosition)
            }
        }
        }

    override fun onBindViewHolder(holder:HolderArrayList, position: Int) {
        val datalistApp = dataApp[position]
        holder.imageHolder?.setImageResource(datalistApp.imgData)
        holder.textAppHolder?.text = datalistApp.txtJudulData
        holder.textHargaHolder?.text = datalistApp.txtHargaData
    }

    override fun onCreateViewHolder(groupAdapter: ViewGroup, viewType: Int):HolderArrayList {
        val inflater : LayoutInflater = LayoutInflater.from(groupAdapter.context)
        return HolderArrayList(inflater, groupAdapter, mListener)
    }

    override fun getItemCount(): Int {
        return dataApp.size
    }
}