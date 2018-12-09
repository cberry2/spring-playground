package com.cberry.springsite.view

import com.cberry.springsite.controller.KotlinxMessage
import com.cberry.springsite.view.core.homeWrapper
import kotlinx.html.*

fun render(messages: List<KotlinxMessage>) =
        homeWrapper("Kotlinx Messages") {
            renderBody(messages)
        }

fun BODY.renderBody(messages: List<KotlinxMessage>) {
    div(classes = "container") {
        div (classes = "row") {
            div (classes = "col-sm") {
                h1 { +"Using kotlinx.html" }
            }
            renderMessages(messages)
            div (classes = "col-sm") {
                span(classes = "badge badge-success") { +"Nailed It" }
            }
        }
    }
}

private fun DIV.renderMessages(messages: List<KotlinxMessage>) {
    table(classes = "table") {
        thead {
            tr {
                th(ThScope.col) { +"#" }
                th(ThScope.col) { +"Message" }
            }
        }
        tbody {
            messages.forEachIndexed { index, kotlinxMessage ->
                tr {
                    td { +index.plus(1).toString()}
                    td { +kotlinxMessage.message}
                }
            }
        }
    }
}
