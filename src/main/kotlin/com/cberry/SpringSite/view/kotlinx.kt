package templates

import com.cberry.SpringSite.controller.KotlinxMessage
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

fun render(title: String, messages: List<KotlinxMessage>) =
        StringWriter().appendHTML().html {
            head {
                title { +"Test" }
                meta {
                    charset = "utf-8"
                }
                meta {
                    name="viewport"
                    content="width=device=width, initial-scale=1, shrink-to-fit=no"
                }
                link {
                    rel = "stylesheet"
                    href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                    integrity = "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                    crossorigin = "anonymous"
                }
            }
            body {
                div {
                    classes = setOf("container")
                    p { +"This is using kotlinx" }
                    span {
                        classes = setOf("badge badge-success")
                        +"Nailed It"
                    }
                }
                script {
                    src = "https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min/js"
                }
                script {
                    src = "js/bootstrap.min.js"
                }
            }
        }.toString()

var LINK.integrity: String
    get()  = attributes["integrity"] ?: ""
    set(newValue) { attributes["integrity"] = newValue}

var LINK.crossorigin: String
    get()  = attributes["crossorigin"] ?: ""
    set(newValue) { attributes["crossorigin"] = newValue}
