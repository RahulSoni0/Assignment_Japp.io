package com.rahulsoni0.assignmentjappio.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.db.williamchart.Tooltip
import com.db.williamchart.data.Scale
import com.rahulsoni0.assignmentjappio.MyAdapter
import com.rahulsoni0.assignmentjappio.R
import com.rahulsoni0.assignmentjappio.model.DataModel
import kotlinx.android.synthetic.main.fragment_market.*
import kotlinx.android.synthetic.main.tooltip_layout.*
import kotlin.math.roundToInt


class MarketFragment : Fragment() {

    private val animationDuration = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_market, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvSpending.layoutManager = LinearLayoutManager(context)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<DataModel>()

        // This loop will create 20 Views containing
        // the image with the count of view

        data.add(DataModel(R.drawable.starbucks, "StarBucks ", "Jan 12 , 2022", "- $270.00"))
        data.add(DataModel(R.drawable.youtube, "Youtube ", "Jan 13 , 2022", "- $50.00"))
        data.add(DataModel(R.drawable.amazon_pay, "Amazon Pay ", "Feb 31 , 2022", "- $999.00"))
        data.add(DataModel(R.drawable.starbucks, "StarBucks ", "March 7 , 2022", "- $69.40"))
        data.add(DataModel(R.drawable.youtube, "Youtube ", "April 11 , 2022", "- $420.69"))


        // This will pass the ArrayList to our Adapter
        val adapter = MyAdapter(data)

        // Setting the Adapter with the recyclerview
        rvSpending.adapter = adapter

        val mySet = linkedMapOf(
            "Jan" to 0F, "Feb" to 6F,
            "Mar" to 0F, "April" to 7F, "May" to 2F, "June" to 8F, "July" to 5F, "Aug" to 0F,
            "Sept" to 4F, "Aug" to 3F, "Oct" to 12F, "Nov" to 10F, "Dec" to 0F

        )
        val mySet2 = linkedMapOf(
            "Jan" to 1F, "Feb" to 12F,
            "Mar" to 0F, "April" to 8F, "May" to 7F, "June" to 8F, "July" to 5F, "Aug" to 0F,
            "Sept" to 4F, "Aug" to 3F, "Oct" to 5F, "Nov" to 10F, "Dec" to 0F

        )
        val mySet3 = linkedMapOf(
            "Jan" to 5F, "Feb" to 12F,
            "Mar" to 7F, "April" to 7F, "May" to 6F, "June" to 8F, "July" to 5F, "Aug" to 0F,
            "Sept" to 4F, "Aug" to 3F, "Oct" to 11F, "Nov" to 10F, "Dec" to 0F

        )
        val mySet4 = linkedMapOf(
            "Jan" to 0F, "Feb" to 2F,
            "Mar" to 3F, "April" to 7F, "May" to 2F, "June" to 8F, "July" to 5F, "Aug" to 0F,
            "Sept" to 4F, "Aug" to 3F, "Oct" to 12F, "Nov" to 10F, "Dec" to 0F

        )
        val mySet5 = linkedMapOf(
            "Jan" to 0F, "Feb" to 5F,
            "Mar" to 0F, "April" to 12F, "May" to 2F, "June" to 8F, "July" to 5F, "Aug" to 0F,
            "Sept" to 5F, "Aug" to 3F, "Oct" to 12F, "Nov" to 10F, "Dec" to 0F

        )



        day.setOnClickListener {
            day.setBackgroundColor(Color.parseColor("#00E5FF"))
            week.setBackgroundColor(Color.WHITE)
            month.setBackgroundColor(Color.WHITE)
            year.setBackgroundColor(Color.WHITE)
            mychart.animate(mySet)
            mychart.onDataPointTouchListener = { index, _, _ ->
                PointValue.text = "$" +
                        mySet.toList()[index]
                            .second
                            .toString()
            }

        }
        week.setOnClickListener {
            week.setBackgroundColor(Color.parseColor("#00E5FF"))
            day.setBackgroundColor(Color.WHITE)
            month.setBackgroundColor(Color.WHITE)
            year.setBackgroundColor(Color.WHITE)
            mychart.onDataPointTouchListener = { index, _, _ ->
                PointValue.text = "$" +
                        mySet2.toList()[index]
                            .second
                            .toString()
            }
            mychart.animate(mySet2)
            mychart.show(mySet2)
        }
        month.setOnClickListener {
            month.setBackgroundColor(Color.parseColor("#00E5FF"))
            day.setBackgroundColor(Color.WHITE)
            week.setBackgroundColor(Color.WHITE)
            year.setBackgroundColor(Color.WHITE)
            mychart.onDataPointTouchListener = { index, _, _ ->
                PointValue.text = "$" +
                        mySet3.toList()[index]
                            .second
                            .toString()
            }
            mychart.animate(mySet3)
            mychart.show(mySet3)
        }
        year.setOnClickListener {
            year.setBackgroundColor(Color.parseColor("#00E5FF"))
            day.setBackgroundColor(Color.WHITE)
            week.setBackgroundColor(Color.WHITE)
            month.setBackgroundColor(Color.WHITE)
            mychart.onDataPointTouchListener = { index, _, _ ->
                PointValue.text = "$" +
                        mySet4.toList()[index]
                            .second
                            .toString()
            }
            mychart.animate(mySet4)
            mychart.show(mySet4)
        }


        mychart.gradientFillColors =
            intArrayOf(
                Color.parseColor("#00E5FF"),
                Color.TRANSPARENT
            )
        mychart.tooltip =
            SliderTooltip().also {
                it.color = Color.parseColor("#00E5FF")
            }
        mychart.onDataPointTouchListener = { index, _, _ ->
            PointValue.text = "$" +
                    mySet.toList()[index]
                        .second
                        .toString()
        }
        val maxY = 15f //should be greater than max value in the mySet
        mychart.scale = Scale(0f, 15f)

        mychart.animate(mySet)
        mychart.labelsFormatter = { "${it.roundToInt()}" }
        mychart.show(mySet)

    }

}

class SliderTooltip : Tooltip {

    lateinit var tooltipView: View

    var color = Color.BLACK

    override fun onCreateTooltip(parentView: ViewGroup) {
        tooltipView =
            LayoutInflater.from(parentView.context)
                .inflate(R.layout.tooltip_layout, parentView, false)
        tooltipView.setBackgroundColor(Color.TRANSPARENT)
        tooltipView.visibility = View.INVISIBLE
        parentView.addView(tooltipView)
    }

    override fun onDataPointTouch(x: Float, y: Float) {
        tooltipView.visibility = View.VISIBLE
        tooltipView.x = x - tooltipView.width / 2
        tooltipView.y = y - tooltipView.height / 5
    }

    override fun onDataPointClick(x: Float, y: Float) {


    }
}