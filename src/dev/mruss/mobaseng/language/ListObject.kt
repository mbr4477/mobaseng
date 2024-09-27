package dev.mruss.mobaseng.language

import dev.mruss.mobaseng.language.exception.TypeMismatch

class ListObject(override val type: IListType) : Object(type) {
    private val items: MutableList<IObject> = mutableListOf()

    fun append(value: IObject) {
        if (!value.isInstance(type.itemType)) {
            throw TypeMismatch(type.itemType, value.type)
        }
        items.add(value)
    }

    override fun get(index: Int): IObject {
        return items[index]
    }

    override fun set(index: Int, value: IObject) {
        items[index] = value
    }

    override fun toString(): String {
        return "[" + items.joinToString(",") + "]"
    }
}