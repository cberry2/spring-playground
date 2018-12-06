package com.cberry.SpringSite.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView

@Controller
@RequestMapping("/")
class RedirectController {

    @GetMapping("/redirect")
    fun redirect(attributes: RedirectAttributes): RedirectView {
//        attributes.addFlashAttribute("flashAttribute", "ThisIsAFlashAttribute")
//        attributes.addAttribute("attribute", "redirect")
        return RedirectView("redirected")
    }
}