package dev.mruss.mobaseng.language

object IntegerType : Type("Integer", mapOf()) {
    override fun new(): IntegerObject {
        return IntegerObject(this, 0)
    }

    fun new(literal: Int): IntegerObject {
        return IntegerObject(this, literal)
    }
}