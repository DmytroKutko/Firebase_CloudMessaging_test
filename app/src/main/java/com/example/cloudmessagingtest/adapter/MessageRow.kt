package com.example.cloudmessagingtest.adapter

import com.example.cloudmessagingtest.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.message_row.view.*

class MessageRow : Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.message_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textView.text = "user1"
    }
}