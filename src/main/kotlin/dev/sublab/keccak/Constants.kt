package dev.sublab.keccak

internal const val KECCAK_SIZE_BYTES = 200
internal const val KECCAK_SIZE_LONGS = 25

internal val RHO = intArrayOf(
    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 2, 14, 27, 41, 56, 8, 25, 43, 62, 18, 39, 61, 20, 44
)

internal val PI = intArrayOf(
    10, 7, 11, 17, 18, 3, 5, 16, 8, 21, 24, 4, 15, 23, 19, 13, 12, 2, 20, 14, 22, 9, 6, 1
)

internal val RC = longArrayOf(
    0x0000000000000001L, 0x0000000000008082L, -0x7fffffffffff7f76L, -0x7fffffff7fff8000L,
    0x000000000000808BL, 0x0000000080000001L, -0x7fffffff7fff7f7fL, -0x7fffffffffff7ff7L,
    0x000000000000008AL, 0x0000000000000088L, 0x0000000080008009L, 0x000000008000000AL,
    0x000000008000808BL, -0x7fffffffffffff75L, -0x7fffffffffff7f77L, -0x7fffffffffff7ffdL,
    -0x7fffffffffff7ffeL, -0x7fffffffffffff80L, 0x000000000000800AL, -0x7fffffff7ffffff6L,
    -0x7fffffff7fff7f7fL, -0x7fffffffffff7f80L, 0x0000000080000001L, -0x7fffffff7fff7ff8L
)