package io.ktor.utils.io.core.internal;

import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import okhttp3.internal.http2.Settings;

/* compiled from: UTF8.kt */
/* loaded from: classes5.dex */
public final class UTF8Kt {
    public static final int a(char c8, char c9) {
        return ((c8 - 55232) << 10) | (c9 - 56320);
    }

    public static final int b(ByteBuffer encodeUTF8, CharSequence text, int i8, int i9, int i10, int i11) {
        int g8;
        Intrinsics.f(encodeUTF8, "$this$encodeUTF8");
        Intrinsics.f(text, "text");
        int min = Math.min(i9, i8 + Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        g8 = RangesKt___RangesKt.g(i11, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        int i12 = i8;
        int i13 = i10;
        while (i13 < g8 && i12 < min) {
            int i14 = i12 + 1;
            int charAt = text.charAt(i12) & 65535;
            if ((65408 & charAt) == 0) {
                encodeUTF8.put(i13, (byte) charAt);
                i12 = i14;
                i13++;
            } else {
                return c(encodeUTF8, text, i14 - 1, min, i8, i13, g8, i10);
            }
        }
        return EncodeResult.d(UShort.c((short) (i12 - i8)), UShort.c((short) (i13 - i10)));
    }

    private static final int c(ByteBuffer byteBuffer, CharSequence charSequence, int i8, int i9, int i10, int i11, int i12, int i13) {
        boolean z7;
        boolean z8;
        boolean z9;
        int i14 = i12 - 3;
        int i15 = i8;
        int i16 = i11;
        while (i14 - i16 > 0 && i15 < i9) {
            int i17 = i15 + 1;
            char charAt = charSequence.charAt(i15);
            boolean isHighSurrogate = Character.isHighSurrogate(charAt);
            int i18 = charAt;
            if (isHighSurrogate) {
                if (i17 != i9 && Character.isLowSurrogate(charSequence.charAt(i17))) {
                    int a8 = a(charAt, charSequence.charAt(i17));
                    i17++;
                    i18 = a8;
                } else {
                    i18 = 63;
                }
            }
            boolean z10 = false;
            int i19 = 1;
            if (i18 >= 0 && i18 < 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                byteBuffer.put(i16, (byte) i18);
            } else {
                if (128 <= i18 && i18 < 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    byteBuffer.put(i16, (byte) (((i18 >> 6) & 31) | 192));
                    byteBuffer.put(i16 + 1, (byte) ((i18 & 63) | 128));
                    i19 = 2;
                } else {
                    if (2048 <= i18 && i18 < 65536) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        byteBuffer.put(i16, (byte) (((i18 >> 12) & 15) | 224));
                        byteBuffer.put(i16 + 1, (byte) ((63 & (i18 >> 6)) | 128));
                        byteBuffer.put(i16 + 2, (byte) ((i18 & 63) | 128));
                        i19 = 3;
                    } else {
                        if (65536 <= i18 && i18 < 1114112) {
                            z10 = true;
                        }
                        if (z10) {
                            byteBuffer.put(i16, (byte) (((i18 >> 18) & 7) | 240));
                            byteBuffer.put(i16 + 1, (byte) (((i18 >> 12) & 63) | 128));
                            byteBuffer.put(i16 + 2, (byte) ((63 & (i18 >> 6)) | 128));
                            byteBuffer.put(i16 + 3, (byte) ((i18 & 63) | 128));
                            i19 = 4;
                        } else {
                            j(i18);
                            throw new KotlinNothingValueException();
                        }
                    }
                }
            }
            i16 += i19;
            i15 = i17;
        }
        if (i16 == i14) {
            return d(byteBuffer, charSequence, i15, i9, i10, i16, i12, i13);
        }
        return EncodeResult.d(UShort.c((short) (i15 - i10)), UShort.c((short) (i16 - i13)));
    }

    private static final int d(ByteBuffer byteBuffer, CharSequence charSequence, int i8, int i9, int i10, int i11, int i12, int i13) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i14;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i15 = i8;
        int i16 = i11;
        while (true) {
            int i17 = i12 - i16;
            if (i17 <= 0 || i15 >= i9) {
                break;
            }
            int i18 = i15 + 1;
            char charAt = charSequence.charAt(i15);
            boolean isHighSurrogate = Character.isHighSurrogate(charAt);
            int i19 = charAt;
            if (isHighSurrogate) {
                if (i18 != i9 && Character.isLowSurrogate(charSequence.charAt(i18))) {
                    int a8 = a(charAt, charSequence.charAt(i18));
                    i18++;
                    i19 = a8;
                } else {
                    i19 = 63;
                }
            }
            int i20 = 1;
            if (1 <= i19 && i19 < 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                i14 = 1;
            } else {
                if (128 <= i19 && i19 < 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    i14 = 2;
                } else {
                    if (2048 <= i19 && i19 < 65536) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        i14 = 3;
                    } else {
                        if (65536 <= i19 && i19 < 1114112) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            i14 = 4;
                        } else {
                            j(i19);
                            throw new KotlinNothingValueException();
                        }
                    }
                }
            }
            if (i14 > i17) {
                i15 = i18 - 1;
                break;
            }
            if (i19 >= 0 && i19 < 128) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                byteBuffer.put(i16, (byte) i19);
            } else {
                if (128 <= i19 && i19 < 2048) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    byteBuffer.put(i16, (byte) (((i19 >> 6) & 31) | 192));
                    byteBuffer.put(i16 + 1, (byte) ((i19 & 63) | 128));
                    i20 = 2;
                } else {
                    if (2048 <= i19 && i19 < 65536) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        byteBuffer.put(i16, (byte) (((i19 >> 12) & 15) | 224));
                        byteBuffer.put(i16 + 1, (byte) ((63 & (i19 >> 6)) | 128));
                        byteBuffer.put(i16 + 2, (byte) ((i19 & 63) | 128));
                        i20 = 3;
                    } else {
                        if (65536 <= i19 && i19 < 1114112) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z14) {
                            byteBuffer.put(i16, (byte) (((i19 >> 18) & 7) | 240));
                            byteBuffer.put(i16 + 1, (byte) (((i19 >> 12) & 63) | 128));
                            byteBuffer.put(i16 + 2, (byte) ((63 & (i19 >> 6)) | 128));
                            byteBuffer.put(i16 + 3, (byte) ((i19 & 63) | 128));
                            i20 = 4;
                        } else {
                            j(i19);
                            throw new KotlinNothingValueException();
                        }
                    }
                }
            }
            i16 += i20;
            i15 = i18;
        }
        return EncodeResult.d(UShort.c((short) (i15 - i10)), UShort.c((short) (i16 - i13)));
    }

    public static final int e(int i8) {
        return (i8 >>> 10) + 55232;
    }

    public static final boolean f(int i8) {
        return (i8 >>> 16) == 0;
    }

    public static final boolean g(int i8) {
        return i8 <= 1114111;
    }

    public static final int h(int i8) {
        return (i8 & 1023) + 56320;
    }

    public static final Void i(int i8) {
        throw new MalformedUTF8InputException("Expected " + i8 + " more character bytes");
    }

    public static final Void j(int i8) {
        throw new IllegalArgumentException("Malformed code-point " + i8 + " found");
    }
}
