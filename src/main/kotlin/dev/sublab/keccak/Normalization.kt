/**
 *
 * Copyright 2023 SUBSTRATE LABORATORY LLC <info@sublab.dev>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

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