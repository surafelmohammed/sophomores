package com.aait.zekaryastadele.sophomores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.constraintlayout.widget.Guideline
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.aait.zekaryastadele.sophomores.homeMenu.MainContentFragment
import com.aait.zekaryastadele.sophomores.uploadMenu.UploadFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {


    lateinit var drawerLayout: DrawerLayout

    lateinit var navigationView: NavigationView

    lateinit var mainContentFragment: MainContentFragment




    lateinit var guideline: Guideline

    var inPortraitMode : Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        plugDefaultFragments()



        setUpToolBar()




        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)


    }

    fun plugDefaultFragments(){
        val transaction = supportFragmentManager.beginTransaction()
        mainContentFragment = MainContentFragment()
        transaction.add(R.id.bottomFrame,mainContentFragment)



        transaction.commit()
    }




    fun setUpToolBar(){
        navigationView = findViewById(R.id.navigationView)
        drawerLayout = findViewById(R.id.drawer)
    }







    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId){
            R.id.home -> {
                Toast.makeText(this,"home",Toast.LENGTH_LONG).show()
                homeHandler()
            }
            R.id.upload -> {
                Toast.makeText(this,"upload",Toast.LENGTH_LONG).show()
                uploadHandler()
            }
            R.id.profile -> {Toast.makeText(this,"profile",Toast.LENGTH_LONG).show()}
            R.id.setting -> {Toast.makeText(this,"setting",Toast.LENGTH_LONG).show()}
            R.id.myuploads -> {Toast.makeText(this,"my upload",Toast.LENGTH_LONG).show()}
        }



        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    fun homeHandler(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.bottomFrame,mainContentFragment)
        transaction.addToBackStack(null)
        transaction.commit()



    }

    fun uploadHandler(){
        val transaction = supportFragmentManager.beginTransaction()
        val uploadFragment = UploadFragment()

        transaction.replace(R.id.bottomFrame,uploadFragment)

        transaction.addToBackStack(null)

        transaction.commit()



    }

    fun profileHandler(){

    }







}
