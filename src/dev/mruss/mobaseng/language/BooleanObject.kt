package dev.mruss.mobaseng.language

class BooleanObject(override val type: BooleanType, val data: Boolean) : Object(type, mapOf(), mutableMapOf()) {
    override fun toString(): String {
        return "$data"
    }
}
