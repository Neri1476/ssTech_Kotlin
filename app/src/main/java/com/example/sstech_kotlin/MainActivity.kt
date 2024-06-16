package com.example.sstech_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.sstech_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var isAdmin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userType = intent.getStringExtra("user_type")
        isAdmin = userType == "admin"

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        if (isAdmin) {
            binding.appBarMain.fab.hide()
        } else {
            binding.appBarMain.fab.setOnClickListener { view ->
                val navController = findNavController(R.id.nav_host_fragment_content_main)
                navController.navigate(R.id.nav_registrar_cita)
            }
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        navView.menu.clear()

        if (isAdmin) {
            navView.inflateMenu(R.menu.activity_main_drawer_admin)
            appBarConfiguration = AppBarConfiguration(
                setOf(R.id.nav_home, R.id.nav_empleados, R.id.nav_reparaciones, R.id.nav_componentes ,R.id.nav_acerca),
                drawerLayout
            )
        } else {
            navView.inflateMenu(R.menu.activity_main_drawer)
            appBarConfiguration = AppBarConfiguration(
                setOf(R.id.nav_home, R.id.nav_registrar_cita, R.id.nav_historial, R.id.nav_tecnicos, R.id.nav_acerca),
                drawerLayout
            )
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}