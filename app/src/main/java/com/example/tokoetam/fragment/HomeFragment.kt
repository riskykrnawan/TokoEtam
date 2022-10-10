package com.example.tokoetam.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoetam.adapter.GridItemAdapter
import com.example.tokoetam.model.ItemModel
import com.example.tokoetam.repository.ItemRepository
import com.example.tokoetam.R

class HomeFragment : Fragment() {
    private lateinit var rvItem: RecyclerView
    private lateinit var itemList: ArrayList<ItemModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        rvItem = view.findViewById(R.id.home_fragment)
        rvItem.setHasFixedSize(true)
        itemList = ArrayList()
        itemList.addAll(ItemRepository.getListItem()!!)
        showRecyclerItem()
        return view
    }

    fun showRecyclerItem() {
        rvItem.layoutManager = GridLayoutManager(this.context, 2)
        val itemAdapter = GridItemAdapter(this.requireContext())
        itemAdapter.setItemList(itemList)
        rvItem.adapter = itemAdapter
    }
}