package com.evilcorp.orangenews.data.api.models.politics

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element


data class Enclosure(

    @field:Attribute(name = "url")
    @param:Attribute(name="url")
    val imageUrl: String,

    /*@field:Attribute(name = "length")
    @param:Attribute(name = "length")
    val imageLength: Int,*/

    @field:Attribute(name = "type")
    @param:Attribute(name = "type")
    val imageType: String

)
