package dev.mruss.mobaseng.language

interface ILanguage {
    fun getTypes(): List<IType>
    fun declareType(type: IType)
    fun resolveType(name: String): IType
    fun declareBuiltIn(obj: IObject)
    fun getBuiltIns(): List<IObject>
    fun typeRef(name: String): TypeRef
}
