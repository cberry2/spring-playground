package com.cberry.springsite.controller

import com.cberry.springsite.view.core.homeWrapper
import kotlinx.html.h1
import kotlinx.html.h2
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class StupidPageController {

    @ResponseBody
    @GetMapping("/stupid")
    fun showStupidPage() =
            homeWrapper("Stupid Page") {
                h1 { +"This Page is Stupid" }
                h2 { + "Or is it?"}
            }
}