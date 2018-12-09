package com.cberry.springsite.view.core

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

fun homeWrapper(title: String, block: BODY.() -> Unit) =
    StringWriter().appendHTML().html {
        renderHead(title)
        renderBody(block)
    }.toString()

fun HTML.renderHead(title: String) {
    head {
        meta {
            charset = "utf-8"
        }
        meta {
            name = "viewport"
            content = "width=device=width, initial-scale=1, shrink-to-fit=no"
        }
        bootstrapCssLink()
        title { +title }
    }
}

fun HEAD.bootstrapCssLink() =
        link {
            rel = "stylesheet"
            href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
            integrity = "sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
            crossorigin = "anonymous"
        }

fun HTML.renderBody(block: BODY.() -> Unit) {
    body {
        renderNavBar()
        block()
        bootstrapScripts()
    }
}

private fun BODY.renderNavBar() {
    nav(classes = "navbar navbar-expand-lg navbar-dark bg-dark") {
        a(classes = "navbar-brand") {
            href = "#"
            +"Spring Site"
        }
        button(classes = "navbar-toggler") {
            type = ButtonType.button
            attributes["data-toggle"] = "collapse"
            attributes["data-toggle"] ="collapse"
            attributes["data-target"]="#navbarSupportedContent"
            attributes["aria-controls"] = "navbarSupportedContent"
            attributes["aria-expanded"]= false.toString()
            attributes["aria-label"] = "Toggle navigation"
            span(classes = "navbar-toggler-icon")
        }

        div(classes = "collapse navbar-collapse") {
            id = "navbarSupportedContent"
            ul(classes = "navbar-nav mr-auto") {
                li(classes = "nav-item dropdown") {
                    a(classes = "nav-link dropdown-toggle") {
                        href = "#"
                        id = "navbarDropdown"
                        role = "button"
                        attributes["data-toggle"] = "dropdown"
                        attributes["aria-haspopup"] = true.toString()
                        attributes["aria-expanded"] = false.toString()
                        +"Pages"
                    }
                    div(classes = "dropdown-menu") {
                        attributes["aria-labelledby"] = "navbarDropdown"
                        dropdownItem("Stupid", "/stupid")
                        dropdownItem("Redirect", "/redirect")
                        dropdownItem("Test HTML Wrapper", "/wrapper")
                    }
                }
            }
        }
    }
}

fun DIV.dropdownItem(name: String, url: String = "#") {
    a(classes = "dropdown-item") {
        href=url
        +name
    }
}

fun BODY.bootstrapScripts() {
    script {
        src = "https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity = "sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin = "anonymous"
    }
    script {
        src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity ="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin = "anonymous"
    }
    script {
        src = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity ="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin = "anonymous"
    }
}