package com.example.groupieexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.groupieexample.databinding.ItemHeaderBinding
import com.example.groupieexample.databinding.ItemTextBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.BindableItem
import com.xwray.groupie.kotlinandroidextensions.ViewHolder

class MainActivity : AppCompatActivity() {
    private val items
        get() = listOf(
            HeaderItem("Header1"),
            TextItem("test1"),
            TextItem("test2"),
            TextItem("test3"),
            HeaderItem("Header2"),
            TextItem("test4"),
            TextItem("test5")
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val groupAdapter = GroupAdapter<ViewHolder>()
        findViewById<RecyclerView>(R.id.recycler_view).adapter = groupAdapter
        groupAdapter.update(items)

        findViewById<Button>(R.id.button).setOnClickListener {
            groupAdapter.update(items)
        }
    }
}

class HeaderItem(val text: String) : BindableItem<ItemHeaderBinding>() {
    override fun getLayout() = R.layout.item_header

    override fun bind(viewBinding: ItemHeaderBinding, position: Int) {
        viewBinding.textView.text = text
    }
}

class TextItem(val text: String) : BindableItem<ItemTextBinding>() {
    override fun getLayout() = R.layout.item_text

    override fun bind(viewBinding: ItemTextBinding, position: Int) {
        viewBinding.textView.text = text
    }
}