package com.example.myapplication

fun main(){
    var num1: Double = 10.6
    var num2: Double = 5.0
    var resul: Double = 0.0

    resul = num1 + num2
    println("num1 + num2 is $resul")
    resul = num1 - num2
    println("num1 - num2 is $resul")
    resul = num1 * num2
    println("num1 * num2 is $resul")
    resul = num1 / num2
    println("num1 / num2 is $resul")
    resul = num1 % num2
    println("num1 % num2 is $resul")

    var number:Double = 7.6
    var isCheck:Boolean = true;
    println("+number = ${+number}");
    println("-number = ${-number}");
    println("++number = ${++number}");
    println("--number = ${--number}");
    println("!isCheck = ${!isCheck}");
    println("------------------------------")
    var res:Double = 4.7
    println("result :$resul")
//when the result++ is executed, the original value is evaluated first
//and value of result is increased only after that
    println("result++ :" + resul++)

    var a:Int = 5
    var b:Int = 5

    println("a == b : " + (a == b))
    println("a != b : " + (a != b))
    println("a < b : " + (a < b))
    println("a > b : " + (a > b))
    println("a >= b : " + (a >= b))
    println("a <= b : " + (a <= b))


    var number1:Int = 5
    var number2:Int = 8
    var number3:Int = 12
    var result:Boolean = false;
//conditional operator (&&)
    result = (number1 > number2) && (number3 > number2)
    println(result)
//conditional operator (||)
    result = (number1 > number2) || (number3 > number2)
    println(result)
    //BODMAS
    var resu:Int = 5+2*4
    println("Result = "+result)
    resu= (5+2) * 4
    println("Result = "+result)
    var x:Int = 8;
    var y:Int = 4;
    var z:Int = 2;
    var sum:Int = 0;
    sum = x + --y + --z
    print("x+ --y + --z ::: $sum")
}