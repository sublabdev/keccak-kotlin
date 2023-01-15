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