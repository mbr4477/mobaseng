package dev.mruss.mobaseng.language

interface IType : ITypeInfo {
    fun getAttrs(): Map<String, IType>
    fun new(): IObject
}