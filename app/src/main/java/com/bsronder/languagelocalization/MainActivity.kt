package com.bsronder.languagelocalization

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bsronder.languagelocalization.Utils.LocaleChanger
import com.bsronder.languagelocalization.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        
        binding.ButtonEn.setOnClickListener { 
            LocaleChanger(it.context).overrideLocale(Locale("en"))
            recreate()
        }
        
        binding.buttonTr.setOnClickListener { 
            LocaleChanger(it.context).overrideLocale(Locale("tr"))
            recreate()
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleChanger(base).wrapContext())
    }
}