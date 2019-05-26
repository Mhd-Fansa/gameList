package com.raywenderlich.android.alltherecipes

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import kotlin.collections.ArrayList


class Game(
    val name: String,
    val price: String,
    val imageUrl: String,
    val discountPrice: String,
    val release: String,
    val developer: String,
    val Platforms: JSONArray) {

  companion object {

    fun getGamesFromFile(filename: String, context: Context): ArrayList<Game> {
      val gameList = ArrayList<Game>()

      try {
        // Load data
        val jsonString = loadJsonFromAsset("games.json", context)
        val json = JSONObject(jsonString)
        val games = json.getJSONArray("games")

        // Get Recipe objects from data
        (0 until games.length()).mapTo(gameList) {
          Game(games.getJSONObject(it).getString("name"),
              games.getJSONObject(it).getString("imageUrl"),
              games.getJSONObject(it).getString("price"),
              games.getJSONObject(it).getString("discountPrice"),
                  games.getJSONObject(it).getString("release"),
                  games.getJSONObject(it).getString("developer"),
                  games.getJSONObject(it).getJSONArray("Platforms"))
        }
      } catch (e: JSONException) {
        e.printStackTrace()
      }

      return gameList
    }

    private fun loadJsonFromAsset(filename: String, context: Context): String? {
      var json: String?

      try {
        val inputStream = context.assets.open(filename)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, Charsets.UTF_8)
      } catch (ex: java.io.IOException) {
        ex.printStackTrace()
        return null
      }

      return json
    }
  }
}