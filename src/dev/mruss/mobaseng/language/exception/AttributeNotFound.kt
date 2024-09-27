package dev.mruss.mobaseng.language.exception

import dev.mruss.mobaseng.language.ITypeInfo

class AttributeNotFound(attr: String, type: ITypeInfo) : Exception("attribute '$attr' not found on type '${type.name}'")