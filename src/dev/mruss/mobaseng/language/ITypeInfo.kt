package dev.mruss.mobaseng.language

interface ITypeInfo {
    val name: String
    val base: ITypeInfo?
}
