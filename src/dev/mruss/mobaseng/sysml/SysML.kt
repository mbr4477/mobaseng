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

        val value = Type("value", mapOf("name" to StringType, "type" to valueType))
        val part = Type("part", mapOf("name" to StringType, "type" to TypeRef("<<block>>", this)))
        declareType(StringType)
        declareType(valueType)
        declareType(value)
        declareType(part)
        declareType(
            Type(
                "<<block>>",
                mapOf(
                    "name" to StringType,
                    "parts" to ListType(part),
                    "values" to ListType(value)
                )
            ),
        )
    }
}
