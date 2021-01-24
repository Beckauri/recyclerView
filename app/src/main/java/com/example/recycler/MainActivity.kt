package com.example.recycler

import android.R
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    var recyclerView: RecyclerView? = null
    var gridLayoutManager: GridLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById<View>(R.id.imageView) as ImageView
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        gridLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView!!.layoutManager = gridLayoutManager
        val imageUrlList: ArrayList = prepareData()
        val dataAdapter = DataAdapter(applicationContext, imageUrlList)
        recyclerView!!.adapter = dataAdapter
    }

    private fun prepareData(): ArrayList {

        val imageUrls = arrayOf(
            "https://cars.usnews.com/images/article/202011/128724/P90289697_highRes.jpg",
            "https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_large/v1/editorial/story/hero_image/2021-Range-Rover-Evoque-SUV-1001x565%20%281%29.jpg",
            "https://www.mercedes-benz.co.nz/passengercars/mercedes-benz-cars/models/mercedes-maybach/mercedes-maybach-saloon/explore/vehicle-design/_jcr_content/hotspotimage/image.MQ6.12.20180801124147.jpeg",
            "https://media.autoexpress.co.uk/image/private/s--OCXoyCJr--/v1596704390/autoexpress/2020/08/BMW%20i5%20exclusive%20image.jpg"
            "https://upload.wikimedia.org/wikipedia/commons/1/1c/2019_Rolls-Royce_Phantom_V12_Automatic_6.75.jpg"
            "https://tesla-cdn.thron.com/delivery/public/image/tesla/c82315a6-ac99-464a-a753-c26bc0fb647d/bvlatuR/std/1200x628/lhd-model-3-social"
            "https://www.tesla.com/xNVh4yUEc3B9/04_Desktop.jpg"
            "https://carsalesbase.com/wp-content/uploads/2013/02/Lada-Europe-Sales-Figures.jpg"
        )
        val imageUrlList = ArrayList<Any>()
        for (i in imageUrls.indices) {
            val imageUrl = ImageUrl()
            imageUrl.imageUrl = imageUrls[i]
            imageUrlList.add(imageUrl)
        }
        Log.d("MainActivity", "List count: " + imageUrlList.size())
        return imageUrlList
    }
}