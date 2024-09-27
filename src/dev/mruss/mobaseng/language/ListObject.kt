package dev.mruss.mobaseng.language

import dev.mruss.mobaseng.language.exception.TypeMismatch

class ListObject(override val type: IListType) :
    Object(type, mapOf("size" to IntegerType), mutableMapOf("size" to IntegerType.new(0))) {
    private val items: MutableList<IObject> = mutableListOf()

    override fun getAttr(name: String): IObject {
        return when (name) {
            "size" -> IntegerType.new(items.size)
            else -> super.getAttr(name)
        }
    }

    override fun setAttr(name: String, value: IObject) {
        if (name == "__append__") {
            if (!value.isInstance(type.itemType)) {
                throw TypeMismatch(type.itemType, value.type)
            }
            items.add(value)
        } else {
            super.setAttr(name, value)
        }
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