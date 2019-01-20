package com.cberry.springsite.controller

import com.cberry.springsite.view.core.homeWrapper
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.img
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class TacoController {

    @ResponseBody
    @GetMapping("/taco")
    fun getTacoHome(): String = renderTacoHome()

    fun renderTacoHome(): String =
        homeWrapper("Taco Cloud", "taco") {
            div(classes = "container") {
                h1 { +"Taco Cloud" }
                img(classes = "home-img") {
                    src = "/tacos.webp"
                }
                a {
                    href="/taco/design"
                    +"Design a taco"
                }
            }
        }

}