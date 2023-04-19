package com.app.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.testapplication.R
import com.app.testapplication.databinding.ItemMapelBinding
import com.app.testapplication.realmModel.MataPelajaran

class MapelAdapter(var listMapel : List<MataPelajaran>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MapelHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_mapel, parent, false)
        )
    }

    override fun getItemCount(): Int {
       return listMapel.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MapelHolder -> {
                holder.bind(listMapel[position])
            }
        }
    }

    inner class MapelHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemMapelBinding.bind(itemView)

        fun bind(mataPelajaran: MataPelajaran) {
            binding.tvMapel.text = mataPelajaran.namaMataPelajaran
        }
    }
}