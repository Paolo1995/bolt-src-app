package io.netty.handler.codec.base64;

import com.google.android.gms.common.api.Api;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public final class Base64 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Decoder implements ByteProcessor {

        /* renamed from: b4  reason: collision with root package name */
        private final byte[] f47561b4;
        private int b4Posn;
        private byte[] decodabet;
        private ByteBuf dest;
        private int outBuffPosn;

        private Decoder() {
            this.f47561b4 = new byte[4];
        }

        private static int decode4to3(byte[] bArr, ByteBuf byteBuf, int i8, byte[] bArr2) {
            int i9;
            int i10;
            int i11;
            byte b8 = bArr[0];
            byte b9 = bArr[1];
            byte b10 = bArr[2];
            if (b10 == 61) {
                try {
                    byteBuf.setByte(i8, ((bArr2[b8] & 255) << 2) | ((bArr2[b9] & 255) >>> 4));
                    return 1;
                } catch (IndexOutOfBoundsException unused) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            }
            byte b11 = bArr[3];
            if (b11 == 61) {
                byte b12 = bArr2[b9];
                try {
                    if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                        i11 = ((b12 & 15) << 4) | ((((bArr2[b8] & 63) << 2) | ((b12 & 240) >> 4)) << 8) | ((bArr2[b10] & 252) >>> 2);
                    } else {
                        i11 = ((((b12 & 15) << 4) | ((bArr2[b10] & 252) >>> 2)) << 8) | ((bArr2[b8] & 63) << 2) | ((b12 & 240) >> 4);
                    }
                    byteBuf.setShort(i8, i11);
                    return 2;
                } catch (IndexOutOfBoundsException unused2) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            }
            try {
                if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                    i9 = ((bArr2[b8] & 63) << 18) | ((bArr2[b9] & 255) << 12) | ((bArr2[b10] & 255) << 6);
                    i10 = bArr2[b11] & 255;
                } else {
                    byte b13 = bArr2[b9];
                    byte b14 = bArr2[b10];
                    i9 = ((bArr2[b8] & 63) << 2) | ((b13 & 15) << 12) | ((b13 & 240) >>> 4) | ((b14 & 3) << 22) | ((b14 & 252) << 6);
                    i10 = (bArr2[b11] & 255) << 16;
                }
                byteBuf.setMedium(i8, i10 | i9);
                return 3;
            } catch (IndexOutOfBoundsException unused3) {
                throw new IllegalArgumentException("not encoded in Base64");
            }
        }

        ByteBuf decode(ByteBuf byteBuf, int i8, int i9, ByteBufAllocator byteBufAllocator, Base64Dialect base64Dialect) {
            this.dest = byteBufAllocator.buffer(Base64.decodedBufferSize(i9)).order(byteBuf.order());
            this.decodabet = Base64.decodabet(base64Dialect);
            try {
                byteBuf.forEachByte(i8, i9, this);
                return this.dest.slice(0, this.outBuffPosn);
            } catch (Throwable th) {
                this.dest.release();
                PlatformDependent.throwException(th);
                return null;
            }
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b8) throws Exception {
            byte[] bArr;
            byte b9;
            if (b8 > 0 && (b9 = (bArr = this.decodabet)[b8]) >= -5) {
                if (b9 < -1) {
                    return true;
                }
                byte[] bArr2 = this.f47561b4;
                int i8 = this.b4Posn;
                int i9 = i8 + 1;
                this.b4Posn = i9;
                bArr2[i8] = b8;
                if (i9 <= 3) {
                    return true;
                }
                int i10 = this.outBuffPosn;
                this.outBuffPosn = i10 + decode4to3(bArr2, this.dest, i10, bArr);
                this.b4Posn = 0;
                if (b8 != 61) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("invalid Base64 input character: " + ((int) ((short) (b8 & 255))) + " (decimal)");
        }
    }

    private Base64() {
    }

    private static byte[] alphabet(Base64Dialect base64Dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(base64Dialect, "dialect")).alphabet;
    }

    private static boolean breakLines(Base64Dialect base64Dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(base64Dialect, "dialect")).breakLinesByDefault;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] decodabet(Base64Dialect base64Dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(base64Dialect, "dialect")).decodabet;
    }

    public static ByteBuf decode(ByteBuf byteBuf) {
        return decode(byteBuf, Base64Dialect.STANDARD);
    }

    static int decodedBufferSize(int i8) {
        return i8 - (i8 >>> 2);
    }

    public static ByteBuf encode(ByteBuf byteBuf) {
        return encode(byteBuf, Base64Dialect.STANDARD);
    }

    private static void encode3to4(ByteBuf byteBuf, int i8, int i9, ByteBuf byteBuf2, int i10, byte[] bArr) {
        int i11 = 0;
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 > 0) {
                        i11 = toIntBE(byteBuf.getMedium(i8));
                    }
                } else {
                    i11 = toIntBE(byteBuf.getShort(i8));
                }
            } else {
                i11 = toInt(byteBuf.getByte(i8));
            }
            encode3to4BigEndian(i11, i9, byteBuf2, i10, bArr);
            return;
        }
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 > 0) {
                    i11 = toIntLE(byteBuf.getMedium(i8));
                }
            } else {
                i11 = toIntLE(byteBuf.getShort(i8));
            }
        } else {
            i11 = toInt(byteBuf.getByte(i8));
        }
        encode3to4LittleEndian(i11, i9, byteBuf2, i10, bArr);
    }

    private static void encode3to4BigEndian(int i8, int i9, ByteBuf byteBuf, int i10, byte[] bArr) {
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    byteBuf.setInt(i10, bArr[i8 & 63] | (bArr[i8 >>> 18] << 24) | (bArr[(i8 >>> 12) & 63] << 16) | (bArr[(i8 >>> 6) & 63] << 8));
                    return;
                }
                return;
            }
            byteBuf.setInt(i10, (bArr[(i8 >>> 6) & 63] << 8) | (bArr[i8 >>> 18] << 24) | (bArr[(i8 >>> 12) & 63] << 16) | 61);
            return;
        }
        byteBuf.setInt(i10, (bArr[(i8 >>> 12) & 63] << 16) | (bArr[i8 >>> 18] << 24) | 15616 | 61);
    }

    private static void encode3to4LittleEndian(int i8, int i9, ByteBuf byteBuf, int i10, byte[] bArr) {
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    byteBuf.setInt(i10, (bArr[i8 & 63] << 24) | bArr[i8 >>> 18] | (bArr[(i8 >>> 12) & 63] << 8) | (bArr[(i8 >>> 6) & 63] << 16));
                    return;
                }
                return;
            }
            byteBuf.setInt(i10, (bArr[(i8 >>> 6) & 63] << 16) | bArr[i8 >>> 18] | (bArr[(i8 >>> 12) & 63] << 8) | 1023410176);
            return;
        }
        byteBuf.setInt(i10, (bArr[(i8 >>> 12) & 63] << 8) | bArr[i8 >>> 18] | 3997696 | 1023410176);
    }

    static int encodedBufferSize(int i8, boolean z7) {
        long j8 = (i8 << 2) / 3;
        long j9 = (3 + j8) & (-4);
        if (z7) {
            j9 += j8 / 76;
        }
        if (j9 < 2147483647L) {
            return (int) j9;
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    private static int toInt(byte b8) {
        return (b8 & 255) << 16;
    }

    private static int toIntBE(int i8) {
        return (i8 & 255) | (16711680 & i8) | (65280 & i8);
    }

    private static int toIntBE(short s7) {
        return ((s7 & 255) << 8) | ((65280 & s7) << 8);
    }

    private static int toIntLE(int i8) {
        return ((i8 & 16711680) >>> 16) | ((i8 & 255) << 16) | (65280 & i8);
    }

    private static int toIntLE(short s7) {
        return (s7 & 65280) | ((s7 & 255) << 16);
    }

    public static ByteBuf decode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        ObjectUtil.checkNotNull(byteBuf, "src");
        ByteBuf decode = decode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), base64Dialect);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return decode;
    }

    public static ByteBuf encode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        return encode(byteBuf, breakLines(base64Dialect), base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z7, Base64Dialect base64Dialect) {
        ObjectUtil.checkNotNull(byteBuf, "src");
        ByteBuf encode = encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), z7, base64Dialect);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return encode;
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i8, int i9, Base64Dialect base64Dialect) {
        return decode(byteBuf, i8, i9, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i8, int i9, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        ObjectUtil.checkNotNull(byteBuf, "src");
        ObjectUtil.checkNotNull(base64Dialect, "dialect");
        return new Decoder().decode(byteBuf, i8, i9, byteBufAllocator, base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i8, int i9, boolean z7, Base64Dialect base64Dialect) {
        return encode(byteBuf, i8, i9, z7, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i8, int i9, boolean z7, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        ObjectUtil.checkNotNull(byteBuf, "src");
        ObjectUtil.checkNotNull(base64Dialect, "dialect");
        ByteBuf order = byteBufAllocator.buffer(encodedBufferSize(i9, z7)).order(byteBuf.order());
        byte[] alphabet = alphabet(base64Dialect);
        int i10 = i9 - 2;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < i10) {
            encode3to4(byteBuf, i11 + i8, 3, order, i12, alphabet);
            i13 += 4;
            if (z7 && i13 == 76) {
                order.setByte(i12 + 4, 10);
                i12++;
                i13 = 0;
            }
            i11 += 3;
            i12 += 4;
        }
        if (i11 < i9) {
            encode3to4(byteBuf, i11 + i8, i9 - i11, order, i12, alphabet);
            i12 += 4;
        }
        if (i12 > 1 && order.getByte(i12 - 1) == 10) {
            i12--;
        }
        return order.slice(0, i12);
    }
}
