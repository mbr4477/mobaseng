package examples

import dev.mruss.mobaseng.language.BooleanType
import dev.mruss.mobaseng.language.ListObject
import dev.mruss.mobaseng.language.StringType
import dev.mruss.mobaseng.language.Type
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
        (getAttr("properties") as ListObject).append(value.new().apply {
            setAttr("name", StringType.new("hasGroundComms"))
            setAttr("type", sysml.Boolean)
        })
    }

    val pdu = block.new().apply {
        setAttr("name", StringType.new("PDU"))
    }

    (spacecraft.getAttr("properties") as ListObject).append(part.new().apply {
        setAttr("name", StringType.new("pdu"))
        setAttr("type", pdu)
    })

    // Extend the SysML language
    val softwareElement = Type("<<software>>", mapOf("isRealTime" to BooleanType), base = block)
    val missionSoftware = softwareElement.new().apply {
        setAttr("name", StringType.new("MissionSoftware"))
        setAttr("isRealTime", BooleanType.new(true))
    }

    (spacecraft.getAttr("properties") as ListObject).append(part.new().apply {
        setAttr("name", StringType.new("missionSoftware"))
        setAttr("type", missionSoftware)
    })

    println(spacecraft)
}