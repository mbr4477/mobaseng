package dev.mruss.mobaseng.language

import dev.mruss.mobaseng.language.exception.MultipleDefinition

open class Language : ILanguage {
    private val types: MutableList<IType> = mutableListOf()
    private val builtIns: MutableList<IObject> = mutableListOf()

    override fun getTypes() = types

    override fun declareType(type: IType) {
        if (type.name !in types.map { it.name }) {
            types.add(type)
        } else {
            throw MultipleDefinition(type.name)
        }
    }

    override fun resolveType(name: String): IType {
        return types.find { it.name == name } ?: throw Exception("No definition found for '$name'")
    }

    override fun declareBuiltIn(obj: IObject) {
        builtIns.add(obj)
    }

    override fun getBuiltIns(): List<IObject> = builtIns
}