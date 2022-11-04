package com.orgzly.android.ui.views.style

import android.text.style.URLSpan
import android.view.View

class MidLinkSpan(val type: Int, val url: String, val name: String?) : LinkSpan(), Offsetting {
    // rewrite the link to gmail
    val gmailUrl = "https://mail.google.com/mail/mu/mp/268/#tl/search/rfc822msgid:${url.substring(PREFIX.length)}"

    override val characterOffset = when (type) {
        TYPE_NO_BRACKETS -> 0
        TYPE_BRACKETS -> 4
        TYPE_BRACKETS_WITH_NAME -> 6 + url.length
        else -> 0
    }

    override fun onClick(widget: View) {
        URLSpan(gmailUrl).onClick(widget)
    }

    companion object {
        const val PREFIX = "mid:"
    }
}
