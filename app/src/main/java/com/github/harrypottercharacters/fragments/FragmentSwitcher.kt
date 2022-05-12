package com.github.harrypottercharacters.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface FragmentSwitcher{
    fun replaceFragment(supportFM: FragmentManager, id: Int, fragment: Fragment)

    class Base : FragmentSwitcher {

        override fun replaceFragment(supportFM: FragmentManager, id: Int, fragment: Fragment) {
            if (!supportFM.fragments.contains(fragment)){
                supportFM.beginTransaction().replace(id, fragment).commit()
            }
        }
    }
}
