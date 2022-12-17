package com.example.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.a7minutesworkout.databinding.ActivityExcerciseBinding

class excercise_activity : AppCompatActivity() {


    private var countDownTimer:CountDownTimer?=null
    private var timeDuration:Long=60000
    private var pauseOffset:Long=0


    private var binding:ActivityExcerciseBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityExcerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarExcercise)

        if(supportActionBar!=null)
        {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }
        binding?.toolbarExcercise?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.tvTimer?.text="${(timeDuration?.div(1000)).toString()}"

        object : CountDownTimer(timeDuration - pauseOffset, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                binding?.tvTimer?.setText("${(millisUntilFinished) / 1000}")
            }

            override fun onFinish() {
                Toast.makeText(this@excercise_activity,"timer is finished",Toast.LENGTH_SHORT).show()
            }
        }.start()



    }
}