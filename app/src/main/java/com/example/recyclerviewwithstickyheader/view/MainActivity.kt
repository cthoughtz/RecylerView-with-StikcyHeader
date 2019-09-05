package com.example.recyclerviewwithstickyheader.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithstickyheader.R
import com.example.recyclerviewwithstickyheader.model.AnimalNames
import com.example.recyclerviewwithstickyheader.util.RecyclerSectionItemDecoration
import com.example.recyclerviewwithstickyheader.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*


//http://www.androidtechweb.com/2017/09/sticky-header-smooth-recycler-view-in.html
class MainActivity : AppCompatActivity() {

     var viewModel = ListViewModel()
     var myAdapter = MyAdapter(viewModel.plainInfo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        val recSection = RecyclerSectionItemDecoration(20,true, getSectionCallback(viewModel.plainInfo))



        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter =  myAdapter
            addItemDecoration(recSection)
        }


        //TODO RecyclerSectionItemDecoration

      //  observeMethod()
    }


    fun getSectionCallback(people: ArrayList<AnimalNames>): RecyclerSectionItemDecoration.SectionCallback{

        return object: RecyclerSectionItemDecoration.SectionCallback{
            override fun isSection(position: Int): Boolean {
                return position == 0 || people.get(position).name?.get(0) != people.get(position!!.minus(1)).name?.get(0)
            }

            override fun gettSectionHeader(position: Int): CharSequence {
                return people.get(position).name!!.subSequence(0,1)
            }

        }
    }

    private fun observeMethod() {
        viewModel.animalInfo.observe(this, Observer {
            myAdapter.updateList(it)
        })
    }
}
