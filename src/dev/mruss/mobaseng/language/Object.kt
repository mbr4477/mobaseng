package dev.mruss.mobaseng.language

import dev.mruss.mobaseng.language.exception.*

open class Object(
    override val type: IType,
    private val attrs: Map<String, IType> = mapOf(),
    initializers: Map<String, IObject> = mapOf()
) : IObject {
    private val attrValues: MutableMap<String, IObject> = mutableMapOf()

    init {
        for (attrName in attrs.keys) {
            setAttr(
                attrName, initializers[attrName] ?: throw UninitializedAttribute(
                    attrName
                )
            )
        }
    }

    override fun isInstance(type: ITypeInfo): Boolean {
        var objType: ITypeInfo? = this.type
        var result = false
        while (objType != null && !result) {
            result = objType.name == type.name
            objType = objType.base
        }
        return result
    }

    override fun setAttr(name: String, value: IObject) {
        val typeDef = attrs[name] ?: throw AttributeNotFound(name, type)
        if (!value.isInstance(typeDef)) {
            throw TypeMismatch(typeDef, value.type)
        }
        attrValues[name] = value
    }

    override fun getAttr(name: String): IObject {
        return attrValues[name] ?: throw AttributeNotFound(name, type)
    }

    override fun get(index: Int): IObject {
        throw NotIndexable(type.name)
    }

    override fun set(index: Int, value: IObject) {
        throw NotIndexable(type.name)
    }

    override fun toString(): String {
        val attributes = attrValues.entries.joinToString(",") { "${it.key}=${it.value}" }
        return "${type.name}($attributes)"
    }
}