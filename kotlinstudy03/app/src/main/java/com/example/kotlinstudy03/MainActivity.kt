package com.example.kotlinstudy03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //배열 선언
        val words: Array<String> = arrayOf("apple", "banana", "grape")
        //원시타입을 위한 배열
        val intArr: IntArray = intArrayOf(1, 2, 3, 4, 5, 6)
        //원시타입이 아닌 래퍼타입배열
        val intArr2: Array<Int> = arrayOf(1, 2, 3, 4, 5)

        println("words:$words")
        println("intArr:$intArr")
        println("intArr2:$intArr2")

        printArr(*words)//가변인자 전달시에 스프레드연산자(*)를 붙인다
        printArr("가", "변", "인자", "테스트")
        printIntArr(intArr)
        printIntArr2(intArr2)
        printString("vararg1", "vararg2", "vararg3", title = "Title")


        //맵 생성
        val map : MutableMap<String, Int> = mutableMapOf("A" to 12, Pair("B",13))//초기화시에 to 나 Pair()을 통해 선언
        map["C"]=14 //immutablemap 은 값쌍 추가 삭제 불가
        for (m in map){
            println("$m--${map[m.key]}") //키로 값을 접근
        }

    }

    fun printString(vararg strings: String, title: String): Unit {
        // 가변인자와 일반인자를 같이 사용가능 가변인자는 가장 마지막에 위치해야함 but 가변인자를 먼저 사용하고싶다면
        //호출시에 일반인자 title을 지정해줘야함
        println(title)
        for (string in strings) {
            println(string)
        }
    }
    //가변인자 받기
    fun printArr(vararg args: Any) {//vararg는 가변인자 라는 뜻,

        for (item in args) {
            println("배열::$item")
        }
    }
    //배열을 인자로 받기
    fun printIntArr(arr: IntArray) {
        for (item in arr) {
            println("배열::$item")
        }
    }

    fun printIntArr2(arr: Array<Int>) {
        for (item in arr) {
            println("배열::$item")
        }
    }


}