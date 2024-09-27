package dev.mruss.mobaseng.language

open class Type(
    override val name: String,
    private val attrs: Map<String, IType> = mapOf(),
    private val defaultInitializers: Map<String, IObject> = mapOf(),
    override val base: IType? = null
) : IType {
    override fun getAttrs(): Map<String, IType> {
        val allAttrs = base?.getAttrs()?.toMutableMap() ?: mutableMapOf()
        allAttrs.putAll(attrs)
        return allAttrs
    }

    override fun new(): Object {
        val objAttrs = getAttrs()
        val initializers = objAttrs.entries.associate { it.key to it.value.new() }
        val obj = Object(this, objAttrs, initializers + defaultInitializers)
        return obj
    }

    override fun toString(): String {
        return name
    }
}