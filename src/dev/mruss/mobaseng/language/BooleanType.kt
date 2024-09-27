package dev.mruss.mobaseng.language

object BooleanType : Type("Boolean", mapOf()) {
    override fun new(): BooleanObject {
        return BooleanObject(this, false)
    }

    fun new(literal: Boolean): BooleanObject {
        return BooleanObject(this, literal)
    }
}