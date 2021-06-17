package com.example.Alexandria.ui.screens.tab_mail.about_mail

import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.MessagesInboxMail
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.mail_message.*

class AboutInMailFragment(messages: MessagesInboxMail) : BaseFragment(
    R.layout.mail_message
) {

    val fullname = messages.userIdFromMessage
    val theme = messages.message.theme
    val msg = messages.message.markdownMessage
    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.title = "Сообщение"
        toolbar_chat_fullname.text = fullname
        if (msg == null){
            message_mail.text = theme
            toolbar_chat_status.text = "Системное сообщение"
        }else {
            message_mail.text = msg
            toolbar_chat_status.text = theme
        }
    }
}