package Fave.mainactivity

import Fave.mainactivity.API.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_text_view.*
import kotlinx.android.synthetic.main.list_view_data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TextViewActivity : AppCompatActivity() {
    private val mockDataList = mutableListOf(
        Data(albumId = 1, id = 1, title = "Loading", url = "...", thumbnail = "...")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

        val message = intent.getStringExtra(MainActivity.Extras)
        viewData.text =message

        ButtonText.setOnClickListener(){
            onBackPressed()
        }

        val dataAdapter = DataAdapter(mockDataList)
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = dataAdapter

        GlobalScope.launch(Dispatchers.IO){
            try {
                val listData = DataRepository.createDataRepository(DataServices::class.java).getDatas()
                val filterData = listData.filter { it.title.startsWith("n") }
                Log.e("Activity","${listData}")
                withContext(Dispatchers.Main){
                    dataAdapter.updateData(filterData)
                }

            }catch(e:Exception){
                withContext(Dispatchers.Main){
                    Log.e("Activity","testrun")
                    Toast.makeText(this@TextViewActivity,e.message,Toast.LENGTH_LONG).show()
                    dataAdapter.updateData(listOf())
                }
            }
        }

    }
}

