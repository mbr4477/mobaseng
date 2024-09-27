package dev.mruss.mobaseng.language

class TypeRef(typeDefName: String, private val language: ILanguage) : IType {
    override val name: String = typeDefName

    override val base: ITypeInfo?
        get() = language.resolveType(name).base

    override fun getAttrs(): Map<String, IType> = language.resolveType(name).getAttrs()

    override fun new(): IObject = language.resolveType(name).new()

    override fun toString(): String {
        return name
    }
}