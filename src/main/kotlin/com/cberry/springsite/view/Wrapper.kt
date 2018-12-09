package com.cberry.springsite.view

import com.cberry.springsite.view.core.homeWrapper
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.p

fun renderWrapper() =
    homeWrapper("Wrapper Test") {
        div(classes = "container") {
            h1 { +"Test" }
            p {
                +"This is a test of the default navbar home page with bootstrap dependencies"
            }
        }
    }
