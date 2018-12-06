package com.cberry.SpringSite.view

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

fun render() =
        StringWriter().appendHTML().html {
            renderHead()
            renderBody()
        }.toString()

fun HTML.renderBody() {
    body {
        div(classes = "container") {
            div (classes = "row") {
                div (classes = "col-sm") {
                    p { +"This is using kotlinx" }
                }
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

fun HTML.renderHead() {
    head {
        meta {
            charset = "utf-8"
        }
        meta {
            name = "viewport"
            content = "width=device=width, initial-scale=1, shrink-to-fit=no"
        }
        bootstrapLink()
        title { +"Test" }
    }
}

fun HEAD.bootstrapLink() =
    link {
        rel = "stylesheet"
        href = "https://maxcdn.bootstrapcdn.com/bootstrapLink/4.0.0/css/bootstrapLink.min.css"
        integrity = "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin = "anonymous"
    }

fun BODY.bootstrapScripts() {
    script {
        src = "https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min/js"
    }
    script {
        src = "js/bootstrapLink.min.js"
    }
}

var LINK.integrity: String
    get()  = attributes["integrity"] ?: ""
    set(newValue) { attributes["integrity"] = newValue}

var LINK.crossorigin: String
    get()  = attributes["crossorigin"] ?: ""
    set(newValue) { attributes["crossorigin"] = newValue}
