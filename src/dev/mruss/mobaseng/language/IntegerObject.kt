package dev.mruss.mobaseng.language

class IntegerObject(override val type: IntegerType, val data: Int) : Object(type) {
    override fun toString(): String {
        return "$data"
    }
}
