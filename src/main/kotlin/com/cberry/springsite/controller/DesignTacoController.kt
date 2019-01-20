package com.cberry.springsite.controller

import com.cberry.springsite.model.Ingredient
import com.cberry.springsite.model.Type
import com.cberry.springsite.view.core.homeWrapper
import kotlinx.html.*
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
@RequestMapping("/taco/design")
class DesignTacoController {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(DesignTacoController::class.java)

        val ingredients = listOf(
                Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                Ingredient("CARN", "Carnitas", Type.PROTEIN),
                Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                Ingredient("LETC", "Lettuce", Type.VEGGIES),
                Ingredient("CHED", "Cheddar", Type.CHEESE),
                Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                Ingredient("SLSA", "Salsa", Type.SAUCE),
                Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        )

        val typeDescriptions = mapOf(
                Type.WRAP to "Designate your wrap",
                Type.CHEESE to "Choose your cheese",
                Type.PROTEIN to "Pick your protein",
                Type.SAUCE to "Select your sauce",
                Type.VEGGIES to "Determine your veggies"
            )
    }

    @ResponseBody
    @GetMapping
    fun showDesignForm(): String {
        val ingredientByTypeMap = Type.values().map { type ->
            type to ingredients.filter { ingredient -> type == ingredient.type }
        }.toMap()

        return renderDesignForm(ingredientByTypeMap)
    }

    private fun renderDesignForm(ingredientByTypeMap: Map<Type, List<Ingredient>>) : String =
        homeWrapper("Taco Cloud", "taco") {
            div(classes = "container") {
                h1 { +"Design your taco!" }
                img(classes = "home-img") {
                    src = "/tacos.webp"
                }

                form {
                    method = FormMethod.post

                    div(classes = "grid") {
                        ingredientByTypeMap.forEach { entry ->
                            renderIngredientGroup(
                                    typeDescriptions[entry.key].orEmpty(),
                                    entry.key.toString().toLowerCase(),
                                    entry.value
                            )
                        }
                    }
                }
            }
        }

    private fun DIV.renderIngredientGroup(headerText: String, ingredientType: String, ingredients: List<Ingredient>) {
        div(classes = "ingredient-group") {
            id = "${ingredientType}s"
        }
        h3 { +"$headerText:" }
        ingredients.forEach { ingredient ->
            div {
                input {
                    id = ingredient.id
                    name = "ingredients"
                    type = InputType.checkBox
                }
                span { +ingredient.name }
            }
        }
    }

}