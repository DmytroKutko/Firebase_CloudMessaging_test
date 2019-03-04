package com.example.cloudmessagingtest.model

class MessageItem(val fromId: String, val message: String, val timeStamp: Long) {
    constructor() : this("", "", -1)
}