package com.example.sharedpreferenceex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.sharedpreferenceex.databinding.ActivityMainBinding
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)



        initView()
    }

    private fun initView() {
        binding.btSave.setOnClickListener({
            var insertName=binding.etName.text.toString()
            var insertAge=binding.etAge.text.toString()

            var sharePref=getSharedPreferences("shared_PreFile", MODE_PRIVATE)
            var editor=sharePref.edit()

            editor.putString("NAME",insertName)
            editor.putString("AGE",insertAge)
            editor.apply()

            binding.txtName.text="Name: $insertName \nAge: $insertAge"


        })
        var sharePrefer=getSharedPreferences("shared_PreFile", MODE_PRIVATE)
        var uName=sharePrefer.getString("NAME","")
        var uAge=sharePrefer.getString("AGE","")
        binding.txtName.text="Name: $uName \nAge: $uAge"

    }




    }
