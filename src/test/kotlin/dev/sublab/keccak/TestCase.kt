package dev.sublab.keccak

internal data class TestCase<T>(
    val value: T,
    val expectedHash: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestCase<*>

        if (value != other.value) return false
        if (!expectedHash.contentEquals(other.expectedHash)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value?.hashCode() ?: 0
        result = 31 * result + expectedHash.contentHashCode()
        return result
    }
}