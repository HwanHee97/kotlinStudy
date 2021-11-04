package com.example.kotlinstudy05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    //lateinit 변수를 나중에 초기화 한다는 뜻
    lateinit var latevalue:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //자료 동일성 확인
        val a: Pair<Char, Int> = Pair('A', 65)
        val b = a
        val c: Pair<Char, Int> = Pair('A', 65)
        val d: String = "1000"
        val f: Number = 10
        //val aEqualc:Boolean= a==c
        println(a == b)//true
        println("----")
        println(a == c)//true
        println(a === b)//true
        println(a === c)//False a와c는 같은 객체가 아니기때문

        printTypeName(d)
        //자료형 변환 as
        val e: Int = f as Int
        printTypeName(e)
        // if-else 문 코틀린은 값 반환이 가능하여 다음과 같이 사용가능
        val age: Int = 25

        val ageRange: String = if (age >= 10 && age < 20) {
            "10대"
        } else if (age >= 20 && age < 30) {
            "20대"
        } else {
            "기타"
        }
        println(ageRange)
        //삼항연산자
        val num: Int = 10
        val str: String = if (num % 2 == 0) "짝수" else "홀수"
        println(str)

        //when문 = 자바의 switch문 대체
        val bags: Int = 2
        when (bags) {
            0 -> println("백 없음")
            1, 2 -> {
                println(" $bags 개의 백 소유")
            }
            else->println("더 많은 백 소유 불가")//else는 자바의 default와 같음
        }
        //when도 if와 같이 반환값을 가질수있다.
        val bagString:String=when(bags){
            //조건을 상수만이 아닌 표현식으로도 가능
            0 -> "백 없음"
            1, 2 -> {
               " $bags 개의 백 소유"
            }
            else->"더 많은 백 소유 불가"
        }
        println(bagString)

        //while 문  자바와 동일

        //for문
        val names:List<String> = listOf("A","B","C","D")
        for (name in names){
            Log.d("names","name= $name")
        }
        //인덱스로 접근하기
        for (i in names.indices){
            Log.d("names","names[$i]= ${names[i]}")
        }

        //범위 선언
        val myRange:IntRange=0..10//0부터 10까지 범위 선언
        val myRange2:IntRange=0 until 10//0부터 9까지 범위 선언 마지막 포함x
        for (i in myRange){
            //구현
        }
        for (i in 0..10){//위 코드와 같은 범위 바로 선언
            //구현
        }
        val foo:Boolean= 5 in myRange//true 5가 범위안에 포함
        val foo2:Boolean= 5 !in myRange//false 5가 범위안에 포함 하니까 거짓
        //인덱스 거꾸로
        for (i in 5 downTo 0 step 2){//5  3  1  출력 (543210중 2개씩)
            println(i)
        }
        //엘비스 연산자?: 널값을 허용하지 않는 변수에 널값을 반환할수 있는 함수의 결과를 대입할경우
        fun Ex(i:Int):String?{
            return if (i%2==0)"result is not null" else null
        }
        val notnull:String =  Ex(3)?: "result is null"//Ex함수의 반환값이 null일경우 isnull값을 변수에 저장
        println(notnull)//Ex 함수는 null을 반환 했지만 변수에 저장된 값은 "result is null"이다.
        //안전한 호출 ?.  사용예  val foo= bar?.baz -> bar이 널이 아닐경우만 foo에 baz를 대입
        //// foo?.bar() -> foo가 널이 아닐경우에만 bar함수를 호출

        //안전한 자료형 변환 as?
        val A:String="100"
        //val B:Int=A as Int// 오류 string는 int로 변환불가
        val B:Int?=A as? Int // A를 자료형 변환이 불가하면 null반환
        println(B)//null
        //엘비스 연산과 응용
        val C:Int=A as? Int ?: 0 // A를 자료형 변환 불가하면 0 으로 설정
        println(C)//0
        //널값이 아님을 보증하기 foo!!  foo는 널이 아님을 보증한다.



    }
}

//자료형 확인 is연산자  !is 가능
fun printTypeName(obj: Any) {
    if (obj is Int) {
        Log.d("Type", "Type=Integer")
    } else if (obj is String) {
        Log.d("Type", "Type=String")
    } else {
        Log.d("Type", "Type=Unknown type")
    }
}