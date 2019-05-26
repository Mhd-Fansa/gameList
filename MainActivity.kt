package com.raywenderlich.android.alltherecipes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

      listView = findViewById(R.id.game_list_view)
// 1
      val gameList = Game.getGamesFromFile("games.json", this)
      val adapter = GameAdapter(this, gameList)
      listView.adapter = adapter



  }
}
