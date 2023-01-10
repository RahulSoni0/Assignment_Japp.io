package com.rahulsoni0.assignmentjappio.graphutils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.db.williamchart.Tooltip
import com.rahulsoni0.assignmentjappio.R

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