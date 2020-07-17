package com.michalhawelka.restexample.dto

data class PostDTO(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
) {}