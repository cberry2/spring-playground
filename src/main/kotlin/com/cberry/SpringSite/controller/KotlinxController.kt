package com.cberry.SpringSite.controller;

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import templates.render

data class KotlinxMessage(val id: Int, var message: String)

@Controller
class KotlinxController {
    var nextId: Int = 0
    val messages: MutableList<KotlinxMessage> = mutableListOf()

    init {
        messages.add(KotlinxMessage(1, "First muthafuggin message"))
        messages.add(KotlinxMessage(2, "Second message"))
        messages.add(KotlinxMessage(3, "The end"))

        nextId = messages.size + 1
    }

    @ResponseBody
    @GetMapping("/kotlinx")
    fun get(): String = render("Test", messages)

    @PostMapping("/kotlinx")
    fun post(@RequestParam message: String): String {
        if (!message.isBlank()) {
            nextId += 1
            messages.add(KotlinxMessage(nextId, message))
        }
        return "redirect:/#item-$nextId"
    }

    @PostMapping("/delete")
    fun delete(@RequestParam id: Int, @RequestParam jumpTo: Int): String {
        messages.removeAll { it.id == id }
        return "redirect:/#item-$jumpTo"
    }
}