package com.example.testapp

class MyData : ArrayList<MyDataItem>()

data class MyDataItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)