package com.example.myapplication

fun main() {
//    //immutable
//    //val age = 10
//    //mutable
//   // var name = "pradip"
//   // name = "ram"
//    var name : String ="pradip"
//    var age : Int =16
//    println("Hello i am ${name.lowercase()} and i am $age years old")
//    println("hello world")
//    var age = arrayOf(10,20,30)
//    age[3]=50
//    println(age[3])
    var male = arrayListOf<String>("ram","shyam")
    var female = ArrayList<Any>()
    female.add("sita")
    female.add("gita")
    male.add("hari")
    male.removeAt(0)

    var meaning = mapOf(
        "apple" to "this is fruits",
    )
}