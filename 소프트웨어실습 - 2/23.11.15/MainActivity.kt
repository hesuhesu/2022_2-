package com.example.a231115

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import com.example.a231115.databinding.ActivityMainBinding

            class MainActivity : AppCompatActivity() {

                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    var binding = ActivityMainBinding.inflate(layoutInflater)
                    setContentView(binding.root) // setContentView(R.layout.activity_main)

                    var counter = 0
                    // var button = findViewById<Button>(R.id.button)
                    // var textView = findViewById<TextView>(R.id.textView)
                    binding.button.setOnClickListener{
                        Log.d("kkang", "클릭 이벤트")
                        println("hello")
                        counter++
                        binding.textView.text = counter.toString()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action){
            MotionEvent.ACTION_DOWN ->{
                Log.d("kkang", "x : ${event.x}, y : ${event.rawX}")
            }
            MotionEvent.ACTION_UP ->{
                Log.d("kkang", "touch up event")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode){
            KeyEvent.KEYCODE_0 -> Log.d("kkang", "keydown 0")
            KeyEvent.KEYCODE_A -> Log.d("kkang", "keydown A")
            KeyEvent.KEYCODE_BACK -> Log.d("kkang", "keydown BACK")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("kkang", "keydown Volume up")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("kkang", "keydown Volume down")
        }
        return super.onKeyDown(keyCode, event)
    }
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("kkang", "onKeyUp")
        return super.onKeyUp(keyCode, event)
    }

}
