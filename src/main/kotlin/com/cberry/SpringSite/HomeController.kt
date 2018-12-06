package com.cberry.SpringSite

import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.validation.Valid



@RestController
//@Controller
class HomeController : WebMvcConfigurer {

//    @GetMapping("/")
////    fun home(@PathVariable params: Map<String, String>): String = "SuperTEst
//    fun home(): String = "SuperTEst"

    @GetMapping("/")
    fun showForm(personForm: PersonForm): String = "form"

    @PostMapping("/")
    fun checkPersonInfo(@Valid personForm: PersonForm, bindingResult: BindingResult): String =
            if (bindingResult.hasErrors()) "form" else "redirect:/results"

    override fun addViewControllers(registry: ViewControllerRegistry) =
            registry.addViewController("/results").setViewName("results")
}

data class PersonForm(
        var name: String = "",
        var age: Int = 0
)