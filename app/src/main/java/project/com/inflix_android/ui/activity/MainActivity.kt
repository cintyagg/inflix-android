package project.com.inflix_android.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import project.com.inflix_android.R
import project.com.inflix_android.api.InfoWebClient


class MainActivity : AppCompatActivity() {

    lateinit var nav: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment()
        InfoWebClient().infoCall()
    }

    fun showHome() {
        nav.navigate(R.id.action_loginFragment_to_homeFragment)
    }

    fun showRegister() {
        nav.navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun showFragment(){
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as? NavHostFragment
        if (navHostFragment != null) {
            nav = navHostFragment.navController
        }
    }
}
