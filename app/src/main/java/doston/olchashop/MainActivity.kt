package doston.olchashop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import doston.olchashop.databinding.ActivityMainBinding
import doston.olchashop.ui.HomeFragment
import doston.olchashop.ui.SplashFragment

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.main, SplashFragment()).commit()
    }
}