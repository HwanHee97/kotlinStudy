package com.example.kotlinstudy03_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

//클래스, 인터페이스 선언
class Baz(i: Int) {
    //클래스 인자는 기본 생성자 , 안자를 바로 사용하려면 변수 앞에 val, var 붙여야함
//접근제란자를 지정하지 않으면 public 으로 간주
    val i = i
}

class Foo //클래스 본체 없이 선언 가능

interface Baz1 {
    fun fbaz1()
}

interface Foo1

//추상 클래스
abstract class absFoo {
    abstract fun fabsfoo()
}

//extend, implement
//:뒤에 상속한 클래스나 인터페이스를 표현
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnHello: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//클래스 상속하는경우에는 부모 생성자 호출해야함!
        setContentView(R.layout.activity_main)

        //생성자
        //자바처럼 new카워드 사용x
        val foo: Foo = Foo()
        val baz: Baz = Baz(1)

        //추상클래스 인스턴스 생성
        val absfoo = object : absFoo() {
            override fun fabsfoo() {
                //함수구현
                println("추상클래스 함수 구현")
            }
        }
        absfoo.fabsfoo()
        //인터페이스 생성과 구현은 추상클래스와 비슷하다.
        val baz1 = object : Baz1 {
            //차이점!!!! 추상클래스에서는 object:생성자() 이지만 생성자가 없는 인터페이스는 object:인터페이스 이름이다.
            override fun fbaz1() {
                println("인터페이스 함수 구현")
            }
        }
        baz1.fbaz1()

        val person: Person = Person(5)

        val final: Final = Final()
        final.openFun()
        println(final.openval)

        btnHello = findViewById(R.id.btn_hello) as Button
        btnHello.setOnClickListener {
           Toast.makeText(this@MainActivity, "HELLO", Toast.LENGTH_SHORT).show()
        }//자바에서 MainActivity.this를 코틀린에서는 this@MainActivity로 표기한다

    }

    override fun onClick(p0: View?) {//코틀린에서는 어노케이션이 아닌  override키워드 붙임
        //implement한 온클릭 이벤트 구현부
    }
}

// 클래스의 프로퍼티티(속성)
//person클래스에서 이름과 주소를 선언 한다.
class Person(val a: Int) {
    //생성자 인자를 통해 프로퍼티 선언 가능
    var name: String? = null
    val address: String? = null

    // 자바처럼 getter setter을 사용가능 , ?는 널값 가능함을 말함, var 로 선언한 이유는 값이 변경될수 있음을 말함,
    // val로 선언하면 getter만있고 setter은 없는것것읽기만 가능)
    lateinit var number: String //초기화를 나중에 해도됨 널값은 허용하지 않음으로 ? 생략
    // lateinit는 무조건 var 을 사용해야 하며, Primitive Type (Int, Float, Double, Long 등) 에는 사용할 수 없다
    //접근제한자
    //public은 생략하면 동일하게 사용, private,protected는 자바와 동일
    //internal 은 같은 모듈내에서만 접근 가능능

    init {//주 생성자 블록
        Log.d("Person", "주 생성자.$a")
    }
}

open class Number(var a: Int, var b: Int) {
    // 자바에서는 final로 상속이나 재정의를 막았지만 코들인은 open 키워드가 없으면 모두 상속이나 재정의 불가!
    open val openval = "string"//상속받은 클래스에서 재정의 가능
    open fun openFun() {
        Log.d("Number", "Numbers openFun")
    }

    constructor(a: Int) : this(a, 0)

    //a의 값만 인자로 받는 추가 생성자 ,b는 0으로 , 기본생성자 반드시 호출해야함
    constructor() : this(0, 0)
    //a,b모두 0 으로지정하는 생성자.
    //자바와 달리 추가 생성자를 호출하면 반드시 주 생성자를 호출해야 한다.!!!!
}

class Final : Number() {
    override val openval = "STRING"
    override fun openFun() {
        Log.d("Final", "Finals openFun")

    }
}
