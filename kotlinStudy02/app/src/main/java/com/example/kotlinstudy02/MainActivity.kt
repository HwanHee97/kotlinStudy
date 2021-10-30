package com.example.kotlinstudy02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var a = 1
    lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv1)
        tv.text = a.toString()

        //가변/불변 구분 var,val
        val list: List<String> = listOf("foo", "bar", "baz")//변경 불가능한 리스트
        //list.add("ass")//오류!!!!
        var list2: MutableList<String> = mutableListOf("foo", "bar", "baz")//변경 가능한 리스트
        list2.add("asd")//가능
        //List는 변경불가리스트 MutableList은 변경가능 리스트
        list2.toList()//
        list.toMutableList()//이렇게 서로 형태 변경 가능

        //람다식 brn2에 토스트 메시지 이벤트 연결
        val btn: Button = findViewById(R.id.btn2)
        btn.setOnClickListener {
            Toast.makeText(it.context, "Click Btn2", Toast.LENGTH_SHORT).show()
        }
        //변수 선언, 문자 표현
        val c: String
        c = "asd"
        val b = "asd"  // 타입추론 가능함으로 타입 선언 생략
        val char: Char = 'A'// 자바처럼 문자를 아스키코드 번호(65) 로 선언할수 없다! (아스키 코드값의 숫자를 toChar()을 통해 변환 가능)
        printhello("코틀린")
        countItems(10)


        val items = listOf("foo", "bar", "baz")
        //반복문 for
        for (item in items) {
            println("item: $item")
        }
        //반복문 while
        var i = 0
        println("while문")
        while (i < items.size) {
            println("item: ${items[i]}")
            i++
        }
        //리터럴 표기법
        val dec: Int = 100//10잔슈
        val hex: Int = 0x100//16진수
        val binary: Int = 0b100//이진수
        val longValue: Long = 100L
        val doubleValue: Double = 100.0// 또는 1.001e2
        val floatValue: Float = 100.0f//또는 100f
        //비트 연산자, 논리연산자는 자바와 같다.
        val foo: Int = (2 or 4) shl 1 //(2|4)<<1 과 같은 말
        println("foo=$foo")

        //문자열 접근
        val string:String="hellokotlin"
        val ch1:Char= string.get(4)//=o
        val ch2:Char= string[5]//=k
        println("문자열 접근=$ch1//$ch2")//자바에서는 charAt()으로 접근함

        val text:String="Lorem ipsum"
        val lengText:String="TextLength : ${text.length}"
        println("문자열 길이=$lengText")
        val price:Int=1000
        val priceText:String="price : ${'$'}$price"//문자열 내에 $포함할 경우
        println("문자열 가격=$priceText")




    }

    //함수 선언
    fun printhello(name: String): Unit {//반환형 Unit은 자바의 void와 유사하고 생략이 가능하다.!!
        println("Hello, $name !")
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    //조건문, switch
    fun max(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun countItems(count: Int) {
        when (count) {//when은 자바의 switch문과 동일한 역할
            1 -> println("There is $count item.")
            else -> println("There are $count item.")
        }
    }


    fun count(v: View): Unit {
        a++
        tv.text = a.toString()
    }

    //클래스,인터페이스 선언
    interface Bar {
        fun bar()
    }

    class Foo : Bar {
        val foo: String = "foo"
        fun foo() {}

        override fun bar() {//Foo클래스가 Bar인터페이스 살속후 사용용
        }
    }

}