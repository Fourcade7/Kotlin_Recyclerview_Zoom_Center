package com.pr7.kotlin_recyclerview_zoom_center

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.pr7.kotlin_recyclerview_zoom_center.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val array= arrayOf(
            R.drawable.adobe,
            R.drawable.firebase,
            R.drawable.google,
            R.drawable.swift,
            R.drawable.yandex,
            R.drawable.youtube,
        )


        binding.recyclerview1.apply {
            val linearlayoutManager=LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL, false)
            layoutManager=linearlayoutManager
            val myAdapter=MyAdapter(this@MainActivity,array)
            adapter=myAdapter
            val snapHelper=LinearSnapHelper()
            snapHelper.attachToRecyclerView(this)
            setPadding(150,0,100,0)

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    var pastvidibleitem=linearlayoutManager.findLastCompletelyVisibleItemPosition()
                    var totalitemcount=linearlayoutManager.itemCount
                    title="$totalitemcount $pastvidibleitem"
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    val view=snapHelper.findSnapView(recyclerView.layoutManager)
                    var position=recyclerView.layoutManager!!.getPosition(view!!)

                    val viewholder=recyclerView.findViewHolderForAdapterPosition(position)
                    val linearLayout:LinearLayout=viewholder!!.itemView.findViewById(R.id.linearlayout1)

                    if (newState === RecyclerView.SCROLL_STATE_IDLE) {
                        linearLayout.animate().setDuration(150).scaleX(1F).scaleY(1F)
                            .setInterpolator(AccelerateInterpolator()).start()
                    } else {
                        linearLayout.animate().setDuration(150).scaleX(0.8f).scaleY(0.8f)
                            .setInterpolator(AccelerateInterpolator()).start()
                    }


                }
            })



        }


    }
}