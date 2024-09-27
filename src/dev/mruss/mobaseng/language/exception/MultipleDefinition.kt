package dev.mruss.mobaseng.language.exception

class MultipleDefinition(symbol: String) : Exception("Multiple definitions of $symbol")