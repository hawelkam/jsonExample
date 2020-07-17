package com.michalhawelka.restexample.component

import com.michalhawelka.restexample.client.JSONPlaceholderClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class RestExampleComponent @Autowired constructor(jsonPlaceholderClient: JSONPlaceholderClient) {
    init {
        jsonPlaceholderClient.getPosts()
    }
}