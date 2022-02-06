package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likes: Int = 1099999,
    var likedByMe: Boolean = false,
    var share: Int = 99999,
    var views: Int =1234577
)