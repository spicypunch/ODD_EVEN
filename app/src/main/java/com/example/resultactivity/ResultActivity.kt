package com.example.resultactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity :AppCompatActivity() {

    lateinit var btn : Button
    lateinit var strResult : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        btn = findViewById(R.id.btn)
        strResult = findViewById(R.id.result)

        //랜덤 함수로 숫자 1 혹은 2를 생성 후
        val range = (1..2)
        val resultRandom = range.random()

        //1일 경우 홀로, 2일 경우 짝수로 결과값 표시
        strResult.text =  if (resultRandom == 1) {
            "결과는 \'홀\'입니다."
        } else {
            "결과는 \'짝\'입니다."
        }

        //매인 액티비티에서 가져온 값을 숫자로 바꿔줌
        val input = when(intent.getStringExtra("input")) {
            "홀" -> 1
            "짝" -> 2
            else -> "오류"
        }

        btn.setOnClickListener {
            //내가 선택한 홀/짝과 결과가 같은지 비교
            if (input == resultRandom) {
                setResult(Activity.RESULT_OK, Intent().apply { putExtra("result", "맞췄습니다!") })
            } else {
                setResult(Activity.RESULT_OK, Intent().apply { putExtra("result", "틀렸습니다!") })
            }

            finish()
        }
    }
}