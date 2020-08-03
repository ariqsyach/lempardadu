package com.example.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_top_score.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

class TopScoreActivity : AppCompatActivity() {
    private lateinit var rollAdapter: RollAdapter
    private lateinit var myList: MutableList<Dadu>
    private lateinit var database: RollDatabase
    private lateinit var repository: ItemRepository

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_score)
        database = RollDatabase.getDatabase(this)
        repository = ItemRepository(database.itemDao())
        myList = mutableListOf()
        rollAdapter = RollAdapter(myList)
        rv_topskor.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_topskor.adapter = rollAdapter
        rv_topskor.setHasFixedSize(true)
        loadSkor()
    }
    private fun loadSkor() {
        GlobalScope.launch(Dispatchers.Main) {
            val skor = repository.getSkor()
            myList.clear()
            myList.addAll(skor)
            rollAdapter.notifyDataSetChanged()
        }
    }
}