package ru.netology.nmedia

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false
        )

        fun countFormate(i : Int): String {
            var format = i
            if (i > 999 && i < 1100) {
                format = i / 1000
                return format.toString() + "K"
            }
            if (i >= 1100 && i < 10000) {
                format = i / 1000
                var add = (i - format * 1000) / 100
                return format.toString() + ",$add K"
            }
            if (i > 9999 && i < 1000000) {
                format = i / 1000
                return format.toString() + "K"
            }
            if (i > 999999) {
                format = i / 1000000
                var add = (i - format * 1000000) / 100000
                return format.toString() + ",$add M"
            } else {
                return format.toString()
            }
        }
        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            if (post.likedByMe) {
                like?.setImageResource(R.drawable.ic_liked_24)
            }


            likeCount?.text = countFormate(post.likes)

            root.setOnClickListener {
                Log.d("stuff", "stuff")
            }

                avatar.setOnClickListener {
                Log.d("stuff", "avatar")
            }

            like?.setOnClickListener {
                Log.d("stuff", "like")
                post.likedByMe = !post.likedByMe
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_liked_24
                )
                if (post.likedByMe) post.likes++ else post.likes--
                likeCount?.text = countFormate(post.likes)

            }

            shareCount?.text = countFormate(post.share)

            share?.setOnClickListener {
                Log.d("stuff", "share")
                post.share++
                shareCount?.text = countFormate(post.share)
            }

            viewsCount?.text = countFormate(post.views)
        }
    }
}


