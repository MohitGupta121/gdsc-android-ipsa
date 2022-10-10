package com.mohit.gdsc.ipsacademy.data.models

data class User(
    val name: String,
    val description: String,
    val imageUrl: String,
    val links: List<Link>
)

data class Link(
    val imageUrl: String,
    val link: String
)

data class Users(
    val lead: User,
    val seniors: List<User>,
    val juniors: List<User>
)
