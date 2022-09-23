package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(){

    lateinit var tts:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSpeak=findViewById<Button>(R.id.speakButton)
        var editTextField=findViewById<EditText>(R.id.inputText)

        tts= TextToSpeech(applicationContext,TextToSpeech.OnInitListener {
            if (it == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.US)
                tts.setSpeechRate(1.0f)
            }
            else{
                Log.e("TTS", "Initialization Failed")
            }
        })

        btnSpeak.setOnClickListener {
            var text=editTextField.text.toString()

            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
            tts.speak(text, TextToSpeech.QUEUE_ADD, null,null)
        }

    }
}

