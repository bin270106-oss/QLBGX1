package com.example.quanlybaigiuxe1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quanlybaigiuxe1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain)


        binding.cardXeVao.setOnClickListener {
            openFeature("Quản lý xe vào")
        }

        binding.cardXeRa.setOnClickListener {
            openFeature("Quản lý xe ra")
        }

        binding.cardDanhSach.setOnClickListener {
            openFeature("Danh sách xe")
        }

        binding.cardThongKe.setOnClickListener {
            openFeature("Thống kê")
        }
        username = intent.getStringExtra("USERNAME") ?: "admin"

        if (username == "staff") {
            binding.cardThongKe.visibility = View.GONE
        }


    }
    private var username: String = ""

    private fun openFeature(title: String) {
        val intent = Intent(this, FeatureActivity::class.java)
        intent.putExtra("title", title)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val menuItem = menu.findItem(R.id.menu_user)
        val actionView = menuItem.actionView

        actionView?.let {
            val tvUsername = it.findViewById<TextView>(R.id.tvUsername)
            tvUsername.text = username
        }

        return super.onPrepareOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menu_logout -> {
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
                true
            }




            else -> super.onOptionsItemSelected(item)
        }
    }


}
