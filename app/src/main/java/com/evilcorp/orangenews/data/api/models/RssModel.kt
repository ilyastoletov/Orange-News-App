package com.evilcorp.orangenews.data.api.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root


@Root(name = "rss", strict = false)
data class RssModel(

    @field:Element(name="title")
    @param:Element(name="title")
    @field:Path("channel")
    var channelTitle: String,

    @field:ElementList(name="item", inline=true)
    @param:ElementList(name="item", inline=true)
    @field:Path("channel")
    var articles: List<Article>

)