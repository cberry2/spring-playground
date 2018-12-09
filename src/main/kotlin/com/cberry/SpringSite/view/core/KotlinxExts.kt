package com.cberry.SpringSite.view.core

import kotlinx.html.LINK
import kotlinx.html.SCRIPT

var LINK.integrity: String
    get() = attributes["integrity"] ?: ""
    set(newValue) {
        attributes["integrity"] = newValue
    }

var LINK.crossorigin: String
    get() = attributes["crossorigin"] ?: ""
    set(newValue) {
        attributes["crossorigin"] = newValue
    }

var SCRIPT.integrity: String
    get() = attributes["integrity"] ?: ""
    set(newValue) {
        attributes["integrity"] = newValue
    }

var SCRIPT.crossorigin: String
    get() = attributes["crossorigin"] ?: ""
    set(newValue) {
        attributes["crossorigin"] = newValue
    }