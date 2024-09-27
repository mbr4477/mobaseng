package dev.mruss.mobaseng.language.exception

class UninitializedAttribute(attr: String) : Exception("$attr was not initialized")
