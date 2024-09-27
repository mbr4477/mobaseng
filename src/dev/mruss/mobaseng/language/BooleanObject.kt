package dev.mruss.mobaseng.language

class BooleanObject(override val type: BooleanType, val data: Boolean) : Object(type) {
    override fun toString(): String {
        return "$data"
    }
}
