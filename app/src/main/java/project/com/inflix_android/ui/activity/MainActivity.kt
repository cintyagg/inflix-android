package project.com.inflix_android.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import project.com.inflix_android.R
import project.com.inflix_android.ui.fragment.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment()
    }

    private fun showFragment(){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.loginFragment, LoginFragment())
            addToBackStack(null)
            commit()
        }
    }
}
