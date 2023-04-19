package com.app.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.testapplication.RealmConfiguration.collectDataMahasiswa
import com.app.testapplication.adapter.MahasiswaRvAdapter
import com.app.testapplication.databinding.ActivityMainBinding
import com.app.testapplication.viewModel.MahasiswaViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val mahasiswaViewModel = MahasiswaViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listMahasiswa = collectDataMahasiswa()
        binding.rvMahasiswaList.layoutManager = LinearLayoutManager(this)
        mahasiswaViewModel.addAllMahasiswa(listMahasiswa)

        //read mahasiswa list
        mahasiswaViewModel.getMahasiswa()
        mahasiswaViewModel.mahasiswa.observe(this) {
            val adapter = MahasiswaRvAdapter(it, this)
            binding.rvMahasiswaList.adapter = adapter
        }




    }
}