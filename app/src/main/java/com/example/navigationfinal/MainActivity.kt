package com.example.navigationfinal

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar:Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var navhost: NavHostFragment
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title =" App bar"
        instantiondrawer()
        navhost = supportFragmentManager.findFragmentById(R.id.navhostcontainer_id) as NavHostFragment
        navController= navhost.navController
    }

    private fun instantiondrawer() {
        drawerLayout=findViewById(R.id.drawer)
        navigationView= findViewById(R.id.navigationview)
        val toggle= ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_settings_item -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            R.id.id_start_intent->Toast.makeText(this, "Start Intent", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_gallery -> {
                navController.navigate(R.id.galleryFragment)
                drawerLayout.close()
            return true
            }
            R.id.id_home->{
                navController.navigate(R.id.homeFragment)
                drawerLayout.close()
                return true
            }
            R.id.id_slideshow ->{
                navController.navigate(R.id.slideshowFragment)
                drawerLayout.close()
                return true
            }

        }
        return false

    }
}