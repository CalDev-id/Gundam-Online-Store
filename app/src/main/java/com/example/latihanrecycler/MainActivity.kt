package com.example.latihanrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AdapterCard
    lateinit var adapterBuatAtas: AdapterCardAtas
    lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inisialisasi()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView2.adapter = adapterBuatAtas
    }

    private fun inisialisasi() {
        recyclerView = findViewById(R.id.recycleview_di_main)

        val data = arrayListOf<DataCardView>()
        data.add(DataCardView(R.drawable.gundam1, "Barbatos Gundam", "$ 50"))
        data.add(DataCardView(R.drawable.gundam2, "RX-78-02 Gundam", "$ 45"))
        data.add(DataCardView(R.drawable.gundam3, "Full Armor Unicorn", "$ 208"))

        //Array Detail_Aplikasi



        val efgh = arrayListOf<DataDetailActivity>()

        efgh.add(DataDetailActivity("(GUNDAM THE ORIGIN Ver.)"))
        efgh.add(DataDetailActivity("(GUNDAM THE ORIGIN Ver.)"))
        efgh.add(DataDetailActivity("(GUNDAM THE ORIGIN Ver.)"))
        efgh.add(DataDetailActivity("Test3"))
        efgh.add(DataDetailActivity("Test4"))
        efgh.add(DataDetailActivity("Test5"))
        efgh.add(DataDetailActivity("Test6"))
        efgh.add(DataDetailActivity("Test7"))
        efgh.add(DataDetailActivity("Test8"))
        efgh.add(DataDetailActivity("Test9"))

        adapter = AdapterCard(data)
        adapter.setItemClickListenerBuatKamu(object : AdapterCard.OnItemClickListenerBuatKamu{

            override fun onItemclickKamu(position: Int) {
                //Toast.makeText(this@MainActivity, "You Clicked On Item $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra("judulA",data[position].titleAppData)
                intent.putExtra("gambarA", data[position].imgViewData)
                intent.putExtra("detailA",efgh[position].deskripsi_detailData)

                startActivity(intent)

            }

        })

        recyclerView2 = findViewById(R.id.recycleview_kanan)

        val dataAtas = arrayListOf<DataCardAtas>()
        dataAtas.add(DataCardAtas(R.drawable.gundam_banner1, "Barbatos Gundam", "$ 50", "MG-11O"))
        dataAtas.add(DataCardAtas(R.drawable.gundam_banner3, "RX-78 Gundam", "$ 45", "Gundam"))
        dataAtas.add(DataCardAtas(R.drawable.gundam_banner2, "Unicorn Gundam", "$ 208", "Gundam"))

        adapterBuatAtas = AdapterCardAtas(dataAtas)
        adapterBuatAtas.setItemClickListenerBuatKamu(object : AdapterCardAtas.OnItemClickListener2{

            override fun onItemclickKamu(position: Int) {
                //Toast.makeText(this@MainActivity, "You Clicked On Item $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra("judulA",data[position].titleAppData)
                intent.putExtra("gambarA", data[position].imgViewData)
                intent.putExtra("detailA",efgh[position].deskripsi_detailData)

                startActivity(intent)

            }

        })
    }
//    //fun search
//
//    search.addTextChangedListener(object: TextWatcher {
//        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//        }
//
//        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//        }
//
//        override fun afterTextChanged(p0: Editable?) {
//            search(p0.toString())
//        }
//    })
//
//    private fun search(text: String) {
//        val filteredList = ArrayList<DataClass>()
//
//        for(item in array_rv){
//            if (item.titleAppData.lowercase().contains(text.lowercase())) {
//                filteredList.add(item)
//            }
//        }
//        adapter.filteredData(filteredList)
//    }
}

