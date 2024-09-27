package dev.mruss.mobaseng.language

object StringType : Type("String", mapOf()) {
    override fun new(): StringObject {
        return StringObject(this, "")
    }

    fun new(literal: String): StringObject {
        return StringObject(this, literal)
    }
}