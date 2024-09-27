package dev.mruss.mobaseng.language.exception

import dev.mruss.mobaseng.language.ITypeInfo

class TypeMismatch(expected: ITypeInfo, actual: ITypeInfo) : Exception("Expected ${expected.name}, but got ${actual.name}")
