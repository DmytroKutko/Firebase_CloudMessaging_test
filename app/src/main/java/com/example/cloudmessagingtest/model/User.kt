package com.example.cloudmessagingtest.model

class User(val id: String, val username: String, val email: String) {
    constructor() : this("", "", "")
}