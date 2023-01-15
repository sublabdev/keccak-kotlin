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

// TODO: Implement other sizes with RC manipulation
@Throws(IllegalStateException::class)
internal fun LongArray.f1600(): LongArray {
    check(size == KECCAK_SIZE_LONGS) { "Invalid input provided" }
    val state = copyOf()

    for (rc in RC) {
        val array = LongArray(5)

        // Theta
        for (x in 0 until 5) {
            for (y in 0 until 5) {
                array[x] = array[x] xor state[5 * y + x]
            }
        }

        for (x in 0 until 5) {
            for (y in 0 until 5) {
                val t1 = array[(x + 4) % 5]
                val t2 = array[(x + 1) % 5].rotateLeft(1)
                state[5 * y + x] = state[5 * y + x] xor (t1 xor t2)
            }
        }

        // Rho and pi
        var last = state[1]
        for (x in 0 until 24) {
            array[0] = state[PI[x]]
            state[PI[x]] = last.rotateLeft(RHO[x])
            last = array[0]
        }

        // Chi
        for (yStep in 0 until 5) {
            val y = 5 * yStep

            for (x in 0 until 5) {
                array[x] = state[y + x]
            }

            for (x in 0 until 5) {
                val t1 = array[(x + 1) % 5].inv()
                val t2 = array[(x + 2) % 5]
                state[y + x] = array[x] xor (t1 and t2)
            }
        }

        // Iota
        state[0] = state[0] xor rc
    }

    return state
}