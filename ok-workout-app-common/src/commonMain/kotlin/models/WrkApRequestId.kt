package com.github.evlissa.ok.workout.app.common.models

import kotlin.jvm.JvmInline

@JvmInline
value class WrkApRequestId(private val id: String) {
    fun asString() = id

    companion object {
        val NONE = WrkApRequestId("")
    }
}
