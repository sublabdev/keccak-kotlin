package dev.sublab.keccak

/**
 * An interface for Keccak
 */
interface Keccak {
    /**
     * Returns `ByteArray` encrypted as Keccak f1600
     */
    fun f1600(): ByteArray
}


private class KeccakImpl(
    private val byteArray: ByteArray
): Keccak {
    override fun f1600() = byteArray.normalize().toLongArray().f1600().toByteArray()
}

/**
 * ByteArray to Keccak converter
 */
val ByteArray.keccak: Keccak
    get() = KeccakImpl(this)