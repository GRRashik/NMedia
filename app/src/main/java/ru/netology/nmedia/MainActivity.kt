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

        fun likesCountFormate(int: Int): String {
            var format = post.likes
            if (post.likes > 999 && post.likes < 1100) {
                format = post.likes / 1000
                return format.toString() + "K"
            }
            if (post.likes >= 1100 && post.likes < 10000) {
                format = post.likes / 1000
                var add = (post.likes - format * 1000) / 100
                return format.toString() + ",$add K"
            }
            if (post.likes > 9999 && post.likes < 1000000) {
                format = post.likes / 1000
                return format.toString() + "K"
            }
            if (post.likes > 999999) {
                format = post.likes / 1000000
                var add = (post.likes - format * 1000000) / 100000
                return format.toString() + ",$add M"
            } else {
                return format.toString()
            }
        }

        fun shareCountFormate(int: Int): String {
            var format = post.share
            if (post.share > 999 && post.share < 1100) {
                format = post.share / 1000
                return format.toString() + "K"
            }
            if (post.share >= 1100 && post.share < 10000) {
                format = post.share / 1000
                var add = (post.share - format * 1000) / 100
                return format.toString() + ",$add K"
            }
            if (post.share > 9999 && post.share < 1000000) {
                format = post.share / 1000
                return format.toString() + "K"
            }
            if (post.share > 999999) {
                format = post.share / 1000000
                var add = (post.share - format * 1000000) / 100000
                return format.toString() + ",$add M"
            } else {
                return format.toString()
            }
        }

        fun viewsCountFormate(int: Int): String {
            var format = post.views
            if (post.views > 999 && post.views < 1100) {
                format = post.views / 1000
                return format.toString() + "K"
            }
            if (post.views >= 1100 && post.views < 10000) {
                format = post.views / 1000
                var add = (post.views - format * 1000) / 100
                return format.toString() + ",$add K"
            }
            if (post.views > 9999 && post.views < 1000000) {
                format = post.views / 1000
                return format.toString() + "K"
            }
            if (post.views > 999999) {
                format = post.views / 1000000
                var add = (post.views - format * 1000000) / 100000
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


            likeCount?.text = likesCountFormate(post.likes)

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
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
                if (post.likedByMe) post.likes++ else post.likes--
                likeCount?.text = likesCountFormate(post.likes)

            }

            shareCount?.text = shareCountFormate(post.share)

            share?.setOnClickListener {
                Log.d("stuff", "share")
                post.share++
                shareCount?.text = shareCountFormate(post.share)
            }

            viewsCount?.text = viewsCountFormate(post.views)
        }
    }
}

