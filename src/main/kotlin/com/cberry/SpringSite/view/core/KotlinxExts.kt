package com.cberry.SpringSite.view.core

import kotlinx.html.LINK

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
