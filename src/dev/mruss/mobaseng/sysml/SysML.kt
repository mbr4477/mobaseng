package dev.mruss.mobaseng.sysml

import dev.mruss.mobaseng.language.*

class SysML : Language() {
    val Integer: IObject
    val Boolean: IObject
    val Real: IObject
    val String: IObject

    init {
        val valueType = Type(
            "<<valueType>>", mapOf("name" to StringType)
        )

        Boolean = valueType.new().apply {
            setAttr("name", StringType.new("Boolean"))
        }
        Integer = valueType.new().apply {
            setAttr("name", StringType.new("Integer"))
        }
        Real = valueType.new().apply {
            setAttr("name", StringType.new("Real"))
        }
        String = valueType.new().apply {
            setAttr("name", StringType.new("String"))
        }
        declareBuiltIn(Boolean)
        declareBuiltIn(Integer)
        declareBuiltIn(Real)
        declareBuiltIn(String)

        val propertyType = Type("propertyType")

        val value = Type("value", mapOf("name" to StringType, "type" to valueType), base = propertyType)
        val part = Type(
            "part",
            mapOf(
                "name" to StringType,
                "type" to TypeRef("<<block>>", this),
                "multiplicity" to StringType
            ),
            mapOf("multiplicity" to StringType.new("1")),
            base = propertyType
        )
        declareType(StringType)
        declareType(valueType)
        declareType(value)
        declareType(part)
        declareType(
            Type(
                "<<block>>",
                mapOf(
                    "name" to StringType,
                    "properties" to ListType(propertyType),
                ),
            ),
        )
    }
}
