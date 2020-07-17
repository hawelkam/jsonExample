package com.michalhawelka.restexample.client

import com.google.gson.GsonBuilder
import com.michalhawelka.restexample.dto.PostDTO
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.io.File
import java.net.URI

@Service
class JSONPlaceholderClient {
    private inline fun <reified T: Any> typeRef(): ParameterizedTypeReference<T> = object: ParameterizedTypeReference<T>(){}


    fun getPosts() {
        val url = "https://jsonplaceholder.typicode.com/posts"
        val endpoint = URI.create(url)
        val request = RequestEntity<Any>(HttpMethod.GET, endpoint)
        val response = RestTemplate().exchange(request, typeRef<List<PostDTO>>())
        val items: List<PostDTO> = response.body!!

        val directory = File("posts")
        if (!directory.exists()) {
            directory.mkdir()
        }
        for(post in items) {
            val gsonPretty = GsonBuilder().setPrettyPrinting().create()

            val postJson: String = gsonPretty.toJson(post)
            File("posts/" + post.id + ".json").writeText(postJson)
        }
    }
}