package com.example.memeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMeme()
    }

    private fun loadMeme() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        val networkRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                val url = response.getString("url")
                Glide.with(this).load(url).into(memeImage)
            },
            { err -> Log.d("Error","Error: $err") })

        queue.add(networkRequest)
    }

    fun NextButtonHandler(view: View) {
        loadMeme()
    }
    fun ShareButtonHandler(view: View) {

    }
}