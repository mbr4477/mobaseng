package dev.mruss.mobaseng.language

class StringObject(override val type: StringType, val data: String) : Object(type) {
    override fun toString(): String {
        return "\"$data\""
    }
}
