package com.example.kotlinstudy06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Range
import android.view.View
import android.widget.Button
import android.widget.TextView

//코틀린에서 클래스
class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv=findViewById(R.id.tv)

        val tiger:Zoo.Tiger= Zoo.Tiger("Tiger","two")
        tiger.whatAnimal(tiger)//Tiger two
        //getter setter 사용
        val person:Person= Person(20,"홍길동")
        person.address="가나다라마바사"
        println("${person.age}/${person.name}/${person.adult}/${person.address}")

        //확장 함수 사용!!
        val foo="Foo"
        val foobar=foo.withBar()
        println(foobar)//FooBar
        println(foobar.withPostfix("123456"))//FooBar123456

        //연산자 오버로딩 사용
        val v1:Volume=Volume(10,20)+Volume(30,40)
        //+를 오버로딩해서 a.plus(b) 형태로 호출된다 따라서 아래 함수 구현시 this와 other사용가능
        println("${v1.left}//${v1.right}")

        //중위 표기법 = 함수나 클래스 매개변수 호출시 . 생략할수있다.
        val volume:Volume= Volume(20,20)
        volume increseBy 10
        println("${volume.left}//${volume.right}")//30 30
        volume decreseBy 15
        println("${volume.left}//${volume.right}")//15 15

        // 참조 ::(더블 콜론)
        val numList= listOf<Int>(1,2,3,4,5,6,7,8,9)
        println("홀수값들: ${numList.filter (::isOdd) }")
        numList.filter (::isOdd).forEach{ println("홀수$it")}
        //람다 표현, 참조 사용예
        println("짝수값들: ${numList.filter  { x:Int -> x%2==0} }")
        numList.filter { x:Int -> x%2==0}.forEach{ println("짝수$it")}
        //람다식으로 버튼이벤트 선언
        val btn:Button = findViewById(R.id.btn)
        btn.setOnClickListener({v -> btn_click() })

        //인라인 함수 = 함수를 호출한 부분에 함수내용을 그래로 복사해줌

    }
    fun btn_click(){
        if(tv.text =="btnClicked!!") tv.setText("hello") else tv.setText("btnClicked!!")
    }


}

//타입별칭
typealias peopleList=List<Person>//
fun Ex(personList:peopleList){//위에서 지정한 리스트의 타입 별칭을 사용할수있다.

}

// 참조 ::(더블 콜론)
fun isOdd(x:Int):Boolean{
    return  x%2!=0
}
//확장 함수!!!
fun String.withPostfix(postfix:String):String="$this$postfix"//함수의 단일 표현식 표기, return타입 생략가가능
fun String.withBar()=this.withPostfix("Bar")

//한정 클래스= enum클래스를 확장한 개념을 가진 클래스, 인스턴스 여러개 생성가능
sealed class Zoo(val name: String) {
    class Elephant(name: String, val nose: String) : Zoo("Elephant")

    class Tiger(name: String, val eye: String) : Zoo("Tiger")

    class Lion(name: String, val mouth: String) : Zoo("Lion")

    fun whatAnimal(zoo: Zoo) = when (zoo) {
        is Elephant -> {
            println("${zoo.name} ${zoo.nose}")
        }
        is Tiger -> {
            println("${zoo.name} ${zoo.eye}")
        }
        else -> { // 꼭 처리 Lion클래스에 대한 처리가 없으니까 else 로 처리 해줘야함 안하면 오류
            println("${zoo.name}")
        }
    }
}
//getter setter
class Person(val age:Int,val name:String){
    val adult:Boolean get()=age>=19//19세 이상이면 성인

    var address:String= ""
        set(value){
        field=value.substring(0..3)//문자열 앞4자리만 저장
    }
}
//연산자 오버로딩 가능 !
class Volume(var left:Int, var right:Int){
    operator fun plus(other: Volume): Volume {
       return Volume(this.left+other.left,this.right+other.right)
    }
    operator fun minus(other: Volume):Volume=Volume(this.left-other.left,this.right-other.right)
    //중위 표기법
    infix fun increseBy(amount:Int){
        this.left+=amount
        this.right+=amount
    }
}
infix fun Volume.decreseBy(amount:Int){//확장 함수의 중위 표기법
    this.left-=amount
    this.right-=amount
}
