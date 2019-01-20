package com.cberry.springsite

import com.cberry.springsite.controller.TacoController
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@WebMvcTest(TacoController::class)
class TacoControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `test title exists as h1`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/taco"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("<h1>Taco Cloud</h1>")))
    }

    @Test
    fun `test main image exists`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/taco"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("<img class=\"home-img\" src=\"/tacos.webp\">")))
    }

    @Test
    fun `test styles added to head`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/taco"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("<link rel=\"stylesheet\" href=\"/css/taco.css\">")))
    }
}