package com.example.kerjaku.views.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kerjaku.R
import com.example.kerjaku.views.home.HomeFragment
import com.example.kerjaku.views.taskcomplate.TaskCompleteFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        btmNavMain.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.action_home -> {
                    openFragment(HomeFragment())
                    return@setOnNavigationItemReselectedListener true
                }
                R.id.action_task_complete -> {
                    openFragment(TaskCompleteFragment())
                    return@setOnNavigationItemReselectedListener true
                }
            }
            return@setOnNavigationItemReselectedListener false
        }
        btmNavMain.selectedItemId = R.id.action_home
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameMain, fragment)
            .addToBackStack(null)
            .commit()
    }
}
