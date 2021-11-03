package com.example.kotlinStudy04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val value = 123
fun funEx() {}//위 변수와 함수는 클래스가 아닌 패키지에 종속됨으로 import {패키지명}.{변수,함수명} 을 사용

// 자바에서는 클래스안에 선언하고 public static을 사용했음//정적 필드 및 메서드
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        User.create("LHH")
        User.printEx2()//동반객체(인스턴스 생성없이 사용할수있는 오브젝트) 호출

        //싱글톤인 오브젝트 참조
        val foo = Foo.foo
        println(foo)
        Foo.funFoo()

        //enum클래스 사용
        getDrection(Direction.EAST)
        val south:Direction=Direction.SOUTH
        getDrection(south)

        println(Direction2.NORTH2)
        println(Direction2.NORTH2.label)

        println(Color.RED)
        println(Color.BLUE.rgb())

        //정적 중첩 클래스 인스턴스 생성
        val staticInstance=Outer.StaticNested()
        //비 정적 중첩 클래스 인스턴스 생성
        val nonstaticInstance=Outer().NonStaticNested()
        //차이점: 비정적 중첩 클래스의 인스턴스생성할때는 Outer클래스의 인스턴스가 필요하지만  정적 중첩클래스는 바로 생성 가능



    }
}

class User private constructor(val name: String, val time: Long) {
    companion object {
        //동반 객체 생성!
        fun create(name: String): User {
            println("Users create()")
            return User(name, System.currentTimeMillis())//User 생성자 리턴
        }

        fun printEx2() {
            println("Users printEx2()")
        }
    }

    fun printEx() {
        println("Users printEx()")
    }
}

//싱글톤(단 하나의 인스턴스만 생성가능) 선언
object Foo {
    val foo = "foo"
    fun funFoo() {
        println("Foo funFoo()")
    }
}

//enum클래스!!
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}
enum class Direction2(val label:String) {
    NORTH2("N"), SOUTH2("S"), WEST2("W"), EAST2("E")
}
fun getDrection(d:Direction){
    when(d){
        Direction.EAST-> println("동쪽")
        Direction.NORTH-> println("북쪽")
        Direction.SOUTH-> println("남쪽")
        Direction.WEST-> println("서쪽")
    }
}
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238); // 코틀린에서 ;는 사용하지 않지만 enum클래스에서  상수와 함수를 구별하기 위해서는 꼭사용!

    fun rgb() = (r * 256 + g) * 256 + b
}
//중첨클래스 선언
class Outer{
    //정적 중첩 클래스
    class StaticNested{

    }
    //비 정적 중첩클래스(내부클래스)
    inner class NonStaticNested{

    }
}