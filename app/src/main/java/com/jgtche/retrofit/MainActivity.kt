package com.jgtche.retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val postService = RetrofitClient.createService(PostService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val call = postService.list()
        call.enqueue(object : Callback<List<PostEntity>> {
            override fun onResponse(
                call: Call<List<PostEntity>>, response: Response<List<PostEntity>>
            ) {
                val a = ""
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                val a = ""
            }

        })

        lifecycleScope.launch {
            val result = postService.listCoroutine()
            if (result.isSuccessful) {
                val abc =  result.body()
            }
        }
    }
}