package ir.ahe.abbas.divar.Main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import ir.ahe.abbas.divar.AddAdver.AddAdverFragment
import ir.ahe.abbas.divar.Category.CategoryFragment
import ir.ahe.abbas.divar.Chat.ChatFragment
import ir.ahe.abbas.divar.Home.HomeFragment
import ir.ahe.abbas.divar.Profile.ProfileFragment
import ir.ahe.abbas.divar.R




class MainActivity : AppCompatActivity() {


    var manger=supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViews()
    }

    fun setUpViews() {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bnm_MainActivity_menu)
        creatFrag(HomeFragment())

        bottomNav.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.menuitem_home -> {
                    creatFrag(HomeFragment())

                    true
                }
                R.id.menuitem_dastebande -> {

                    creatFrag(CategoryFragment())
                    true
                }
                R.id.menuitem_addadver -> {

                    creatFrag(AddAdverFragment())
                    true
                }
                R.id.menuitem_direct -> {

                    creatFrag(ChatFragment())
                    true
                }
                R.id.menuitem_profile -> {

                    creatFrag(ProfileFragment())
                    true
                }
                else -> {
                    false
                }

            }
        }

    }



    fun creatFrag(fr:Fragment){
        var tra=manger.beginTransaction()
        tra.replace(R.id.fl_MainActivity_host,fr)
        tra.commit()
    }
}