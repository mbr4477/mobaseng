package dev.mruss.mobaseng.language

class ListType(override val itemType: IType) : IListType {
    override val name: String = "ListType<${itemType.name}>"
    override val base: IType? = null
    override fun getAttrs(): Map<String, IType> = mapOf()

    override fun new(): ListObject {
        return ListObject(this)
    }

    override fun toString(): String {
        return "${itemType.name}[]"
    }
}