package com.github.evlissa.ok.workout.app.common.models

import kotlin.jvm.JvmInline

@JvmInline
value class WrkApPlanId(private val id: String) {
    fun asString() = id

    companion object {
        val NONE = WrkApPlanId("")
    }
}
