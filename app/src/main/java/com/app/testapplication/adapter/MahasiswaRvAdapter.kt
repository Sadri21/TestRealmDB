package com.app.testapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.testapplication.R
import com.app.testapplication.databinding.ItemMahasiswaBinding
import com.app.testapplication.realmModel.Mahasiswa

class MahasiswaRvAdapter(var listMahasiswa: List<Mahasiswa>, var context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MahasiswaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listMahasiswa.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MahasiswaViewHolder -> {
                holder.bind(listMahasiswa[position])
            }
        }
    }

    inner class MahasiswaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemMahasiswaBinding.bind(itemView)

        fun bind(mahasiswa: Mahasiswa) {
            binding.tvKelas.text = mahasiswa.kelas?.namaKelas
            binding.tvName.text = mahasiswa.namaMahasiswa
            binding.rvMapel.layoutManager = LinearLayoutManager(context)
            binding.rvMapel.adapter = mahasiswa.kelas?.listMataPelajaran?.let { MapelAdapter(it) }
        }
    }
}