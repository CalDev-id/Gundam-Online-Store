package com.example.latihanrecycler

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(){
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.detail_aplikasi)

    val judulAplikasi : TextView = findViewById(R.id.namaAplikasi_detail)
    val fotoAplikasi : ImageView = findViewById(R.id.gambar_detail)
    val deskripsiAplikasi : TextView = findViewById(R.id.deskripsi_aplikasi_detail)

    val extra : Bundle? = intent.extras
    val judul = extra!!.getString("judulA")
    val foto = extra.getInt("gambarA")
    val deskripsi = extra.getString("detailA")

    judulAplikasi.text = judul
    fotoAplikasi.setImageResource(foto)
    deskripsiAplikasi.text = deskripsi

} }
