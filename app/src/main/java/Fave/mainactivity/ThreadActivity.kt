package Fave.mainactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thread.*
import kotlinx.coroutines.*

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        nonMultiThreadButton.setOnClickListener { heavyTaskNonMultiThread() }
        multiThreadButton.setOnClickListener { heavyTaskMultiThread() }
        coroutineButton.setOnClickListener {
            GlobalScope.launch {
                heavyTaskCoroutine()
            }
        }
    }

    private fun heavyTaskNonMultiThread() {
        Thread.sleep(5000)
        Toast.makeText(this, "Heavy task complete!", Toast.LENGTH_SHORT).show()
    }

    private fun heavyTaskMultiThread() {
        Thread {
            Thread.sleep(5000)
            this.runOnUiThread {
                Toast.makeText(this, "Heavy task complete!", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private suspend fun heavyTaskCoroutine() {
        delay(5000)
        withContext(Dispatchers.Main ) {
            Toast.makeText(this@ThreadActivity, "Heavy task is complete!", Toast.LENGTH_SHORT).show()
        }
    }
}