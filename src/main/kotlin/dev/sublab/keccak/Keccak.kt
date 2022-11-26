package dev.sublab.keccak

interface Keccak {
    fun f1600(): ByteArray
}

private class KeccakImpl(
    private val byteArray: ByteArray
): Keccak {
    override fun f1600() = byteArray.normalize().toLongArray().f1600().toByteArray()
}

val ByteArray.keccak: Keccak
    get() = KeccakImpl(this)