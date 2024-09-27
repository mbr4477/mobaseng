package examples

import dev.mruss.mobaseng.language.StringType
import dev.mruss.mobaseng.sysml.SysML

fun main() {
    val sysml = SysML()
    println("TYPES ----------------------------------------")
    sysml.getTypes().forEach {
        println(it.name)
        it.getAttrs().entries.forEach { typeDef ->
            println("    ${typeDef.key} : ${typeDef.value}")
        }
    }
    println("BUILT-INS ------------------------------------")
    sysml.getBuiltIns().forEach {
        println(it)
    }
    println("----------------------------------------------")

    val block = sysml.resolveType("<<block>>")
    val value = sysml.resolveType("value")
    val part = sysml.resolveType("part")

    val spacecraft = block.new().apply {
        setAttr("name", StringType.new("Spacecraft"))
        getAttr("properties").setAttr("__append__", value.new().apply {
            setAttr("name", StringType.new("hasGroundComms"))
            setAttr("type", sysml.Boolean)
        })
    }

    val pdu = block.new().apply {
        setAttr("name", StringType.new("PDU"))
    }

    spacecraft.getAttr("properties").setAttr("__append__", part.new().apply {
        setAttr("name", StringType.new("pdu"))
        setAttr("type", pdu)
    })

    println(spacecraft)
}