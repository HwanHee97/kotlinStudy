package com.example.databindingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.example.databindingex.databinding.ActivityMainBinding

//dataBinding 실습
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var msg = ObservableField<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.activity=this@MainActivity

    }
    fun btnClick(view : View){
        Toast.makeText(this,"Button Click",Toast.LENGTH_SHORT).show()
        //이 안에 토스트 메세지가 아니더라도 원하는 함수를 써도 된다.
        msg.set("버튼 클릭됨")
    }
}