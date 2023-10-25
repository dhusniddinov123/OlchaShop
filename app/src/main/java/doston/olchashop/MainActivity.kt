package doston.olchashop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import doston.olchashop.databinding.ActivityMainBinding
import doston.olchashop.ui.CartFragment
import doston.olchashop.ui.HomeFragment
import doston.olchashop.ui.ProfileFragment
import doston.olchashop.ui.SplashFragment

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(HomeFragment())
                R.id.bag -> replaceFragment(CartFragment())
                R.id.account -> replaceFragment(ProfileFragment())

                else ->{



                }

            }

            true

        }

    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}

//        supportFragmentManager.beginTransaction().add(R.id.main, SplashFragment()).commit()