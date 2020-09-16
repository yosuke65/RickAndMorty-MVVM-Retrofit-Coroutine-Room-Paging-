package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models

data class EpisodeResponse(
    val info: Info,
    val results: ArrayList<Episode>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)

data class Episode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)