package com.evilcorp.orangenews.data.api.models.politics

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name="item", strict=false)
data class Article(

    @field:Element(name = "title")
    @param:Element(name = "title")
    var articleTitle: String,

    @field:Element(name = "link")
    @param:Element(name = "link")
    var articleLink: String,

    @field:Element(name = "description")
    @param:Element(name = "description")
    var articleText: String,

    @field:Element(name = "enclosure")
    @param:Element(name = "enclosure")
    var image: Enclosure,

    @field:Element(name = "category")
    @param:Element(name = "category")
    var articleCategory: String

)

