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
        var fragment: Fragment? = null

        fragment = LoginFragment()

        val fragmentTransiction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransiction.replace(R.id.loginFragment, fragment)
        fragmentTransiction.addToBackStack(null)
        fragmentTransiction.commit()
    }
}
