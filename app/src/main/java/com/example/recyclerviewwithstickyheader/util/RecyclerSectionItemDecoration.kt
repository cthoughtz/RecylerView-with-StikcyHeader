package com.example.recyclerviewwithstickyheader.util

import android.graphics.Canvas
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithstickyheader.R
import kotlinx.android.synthetic.main.list_items.view.*
import kotlinx.android.synthetic.main.view_header.view.*

class RecyclerSectionItemDecoration(val headerOffSet: Int,
                                    val sticky: Boolean,
                                    val sectionCallback: SectionCallback?):
    RecyclerView.ItemDecoration() {

    var headerView: View? = null
    var header: TextView? = null

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        var pos: Int = parent.getChildAdapterPosition(view)

        if (sectionCallback != null) {
            if (sectionCallback.isSection(pos)) {
                outRect.top = headerOffSet
            }
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        if (headerView == null) {
            headerView = inflateHeaderView(parent).tv_header
            header = headerView as TextView
            fixLayoutSize(headerView!!,parent)
        }

        var prevoiusHeader: CharSequence? = ""

        parent.children.forEach { child ->
            var position = parent.getChildAdapterPosition(child)

            var title: CharSequence = sectionCallback!!.gettSectionHeader(position)
            header?.setText(title)

            if (!prevoiusHeader!!.equals(title) || sectionCallback.isSection(position)) {
                drawHeader(c,child,headerView as View)
                prevoiusHeader = title
            }
        }
    }

    fun drawHeader(c: Canvas, child: View, headerView: View) {

        c.save()

        if (sticky) {
            c.translate(0f, Math.max(0,child.top - headerView.height).toFloat())
        } else{
            c.translate(0f,child.top.toFloat() - headerView.height.toFloat())
        }

        headerView.draw(c)
        c.restore()
    }

    fun inflateHeaderView( parent: RecyclerView):View {
        return LayoutInflater.from(parent.context).inflate(R.layout.view_header,parent,false)
    }

    fun fixLayoutSize(view: View, parent: ViewGroup) {

        val widthSpec = View.MeasureSpec.makeMeasureSpec(parent.width, View.MeasureSpec.EXACTLY)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(parent.height, View.MeasureSpec.UNSPECIFIED)

        val childWidth = ViewGroup.getChildMeasureSpec(widthSpec, parent.paddingLeft + parent.paddingRight, view.layoutParams.width)
        val childHeight = ViewGroup.getChildMeasureSpec(heightSpec, parent.paddingTop + parent.paddingBottom, view.layoutParams.height)

        view.measure(childWidth,childHeight)
        view.layout(0,0,view.measuredWidth,view.measuredHeight)
    }

    interface SectionCallback{

        fun isSection(position: Int):Boolean

        fun gettSectionHeader(position: Int): CharSequence
    }
}