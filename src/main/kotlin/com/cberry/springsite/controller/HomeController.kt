package com.cberry.springsite.controller

import com.cberry.springsite.model.PersonForm
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.validation.Valid


//@RestController
@Controller
class HomeController : WebMvcConfigurer {

//    @GetMapping("/")
////    fun home(@PathVariable params: Map<String, String>): String = "SuperTEst
//    fun home(): String = "SuperTEst"

    @GetMapping("/")
    fun home() = "forward:/kotlinx"

    @GetMapping("/form")
    fun showForm(personForm: PersonForm): String = "form"

//    @GetMapping("/stupid")
//    fun showStupid(): String = "stupid"

    @GetMapping("/redirected")
    fun showRedirected(model: MutableMap<String, Any>): String {
        model["message"] = "redirect"
        return "redirected"
    }

    @PostMapping("/")
    fun checkPersonInfo(@Valid personForm: PersonForm, bindingResult: BindingResult): String =
            if (bindingResult.hasErrors()) "form" else "redirect:/results"

    @GetMapping("/error")
    fun showError() = "error"

    override fun addViewControllers(registry: ViewControllerRegistry) =
            registry.addViewController("/results").setViewName("results")
}

