package dev.mruss.mobaseng.language

interface IObject {
    val type: ITypeInfo
    fun isInstance(type: ITypeInfo): Boolean
    fun setAttr(name: String, value: IObject)
    fun getAttr(name: String): IObject
    operator fun get(index: Int): IObject
    operator fun set(index: Int, value: IObject)
}