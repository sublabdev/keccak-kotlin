package dev.sublab.keccak

import dev.sublab.common.numerics.Int64
import dev.sublab.common.numerics.toByteArray
import dev.sublab.common.numerics.toInt64
import kotlin.math.min

internal fun ByteArray.normalize() = ByteArray(KECCAK_SIZE_BYTES).let { result ->
    val blockSize = min(size, KECCAK_SIZE_BYTES)
    copyInto(result, 0, 0, blockSize)
}

internal fun ByteArray.toLongArray() = LongArray(KECCAK_SIZE_LONGS).apply {
    for ((pos, i) in (0 until KECCAK_SIZE_LONGS).withIndex()) {
        val offset = i * Int64.SIZE_BYTES
        val int64Bytes = this@toLongArray.copyOfRange(offset, offset+8)
        val int64 = int64Bytes.toInt64()

        this[pos] = this[pos] xor int64
    }
}

internal fun LongArray.toByteArray() = ByteArray(KECCAK_SIZE_BYTES).apply {
    for ((i, int64) in this@toByteArray.withIndex()) {
        int64.toByteArray().copyInto(this, i * Int64.SIZE_BYTES)
    }
}