package com.github.evlissa.ok.workout.app.mappers.v1.exceptions

import com.github.evlissa.ok.workout.app.common.models.WrkApCommand

class UnknownWrkApCommand(command: WrkApCommand) : Throwable("Wrong command $command at mapping toTransport stage")
