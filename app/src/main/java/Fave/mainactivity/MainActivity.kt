package Fave.mainactivity

import Fave.mainactivity.API.Data
import Fave.mainactivity.API.DataAdapter
import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_text_view.*

class MainActivity : AppCompatActivity() {
    companion object{
        val Extras = "Tag"
        val tag = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(){
            val message = editText.text.toString()
            passTextView(message)
        }
        callButton.setOnClickListener(){
            callDial()
        }
        threadButton.setOnClickListener(){
            val intent = Intent(this, ThreadActivity::class.java)
            startActivity(intent)
        }
    }
    
//Implisit Intent
    fun passTextView(message : String){

        val intent = Intent(this, TextViewActivity::class.java)
            intent.putExtra(Extras,message)
        startActivity(intent)
    }

//    Explisit Intent
    fun callDial(){
        val phone = "0821565996596"
        val intent = Intent().apply {
            action = ACTION_DIAL
            data = Uri.parse("tel:$phone")
        }
        startActivity(intent)
    }
}