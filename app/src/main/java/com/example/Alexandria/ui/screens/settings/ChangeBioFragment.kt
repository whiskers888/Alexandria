package com.example.Alexandria.ui.screens.settings

import com.example.Alexandria.R
import com.example.Alexandria.database.*
import com.example.Alexandria.ui.screens.base.BaseChangeFragment
import kotlinx.android.synthetic.main.fragment_change_bio.*

//Фрагмент для изменения биографии пользователя
class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_change_bio) {

    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER1.bio)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        setBioToDatabase(newBio)

    }


}