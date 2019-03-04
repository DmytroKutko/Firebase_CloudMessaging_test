package com.example.cloudmessagingtest.view.AuthFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudmessagingtest.R
import com.example.cloudmessagingtest.adapter.MessageRow
import com.example.cloudmessagingtest.model.MessageItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var adapter: GroupAdapter<ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setInitialData()
    }

    private fun setInitialData() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = GroupAdapter()
        rvMessages.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvMessages.adapter = adapter

        setDummyRows()
    }

    private fun setDummyRows() {
        adapter.add(MessageRow())
        adapter.add(MessageRow())
        adapter.add(MessageRow())
        adapter.add(MessageRow())
    }
}
