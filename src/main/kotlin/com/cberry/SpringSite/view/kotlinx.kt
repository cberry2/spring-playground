package templates

import com.cberry.SpringSite.controller.KotlinxMessage
import com.cberry.SpringSite.view.core.crossorigin
import com.cberry.SpringSite.view.core.integrity
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

fun render(title: String, messages: List<KotlinxMessage>) =
        StringWriter().appendHTML().html {
            renderHead(title)
            renderBody(messages)
        }.toString()

fun HTML.renderBody(messages: List<KotlinxMessage>) {
    body {
        div(classes = "container") {
            div (classes = "row") {
                div (classes = "col-sm") {
                    p { +"This is using kotlinx" }
                }
                renderMessages(messages)
                div (classes = "col-sm") {
                    span(classes = "badge badge-success") {
                        +"Nailed It"
                    }
                }
            }
        }
        bootstrapScripts()
    }
}

fun HTML.renderHead(title: String) {
    head {
        meta {
            charset = "utf-8"
        }
        meta {
            name = "viewport"
            content = "width=device=width, initial-scale=1, shrink-to-fit=no"
        }
        bootstrapLink()
        title { +title }
    }
}

fun HEAD.bootstrapLink() =
        link {
            rel = "stylesheet"
            href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
            integrity = "sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
            crossorigin = "anonymous"
        }

fun BODY.bootstrapScripts() {
    script {
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"
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
