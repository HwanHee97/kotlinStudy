package com.example.kotlinstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinstudy.databinding.ActivityMainBinding
//viewBinding 실습
//1.gradle 추가
//2. 객체화된 xml의 id에 접근하여 사용한다.
private lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //inflate가 xml의 뷰를 객체화 시킨다.
        //객체화 된 뷰를 setContentView로 넘긴다.
        setContentView(binding.root)

    }

    fun viewbind(view: android.view.View) {
        //2.
        binding.tvName.text="홍길동"
        binding.tvPhone.text="010-1111-2222"
        binding.tvAddress.text="서울특별시"
        
       with(binding) {
           name.text ="홍길동"  // 변수명도 tv 빼는게 좋을듯 
           phone.text = "010-111-2222"
           address.text ="서울"
       }
       
    }
}
