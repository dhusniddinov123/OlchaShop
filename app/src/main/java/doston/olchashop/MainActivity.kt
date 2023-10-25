package doston.olchashop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import doston.olchashop.database.AppDataBase
import doston.olchashop.databinding.ActivityMainBinding
import doston.olchashop.ui.CartFragment
import doston.olchashop.ui.HomeFragment
import doston.olchashop.ui.LoginFragment
import doston.olchashop.ui.ProfileFragment

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        var user = appDatabase.getUserDao().getUser()

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(HomeFragment())
                R.id.bag -> if (user.get(user.size-1).name == ""){
                    replaceFragment(LoginFragment())

                }

                else replaceFragment( CartFragment())


                R.id.account -> replaceFragment(ProfileFragment())

                else ->{



                }

            }

            true

        }

    }

    val appDatabase: AppDataBase by lazy {
        AppDataBase.getInstance(this)
    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}

//        supportFragmentManager.beginTransaction().add(R.id.main, SplashFragment()).commit()