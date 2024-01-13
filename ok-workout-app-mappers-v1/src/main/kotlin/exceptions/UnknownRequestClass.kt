package com.github.evlissa.ok.workout.app.mappers.v1.exceptions

class UnknownRequestClass(clazz: Class<*>) : RuntimeException("Class $clazz cannot be mapped to WrkApContext")
