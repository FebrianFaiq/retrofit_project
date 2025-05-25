package com.example.retrofit

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvTitle = findViewById(R.id.tvDetailTitle)
        tvBody = findViewById(R.id.tvDetailBody)

        val postId = intent.getIntExtra("postId", 0)

        ApiClient.instance.getPost(postId).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    tvTitle.text = post?.title
                    tvBody.text = post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(this@DetailActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
