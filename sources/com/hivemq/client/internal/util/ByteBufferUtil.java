package com.hivemq.client.internal.util;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class ByteBufferUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f18668a = new byte[0];

    private ByteBufferUtil() {
    }

    public static ByteBuffer a(int i8, boolean z7) {
        if (z7) {
            return ByteBuffer.allocateDirect(i8);
        }
        return ByteBuffer.allocate(i8);
    }

    public static byte[] b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return f18668a;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bArr);
        return bArr;
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            byte[] array = byteBuffer.array();
            if (byteBuffer.arrayOffset() == 0 && array.length == byteBuffer.remaining()) {
                return array;
            }
        }
        return b(byteBuffer);
    }

    public static ByteBuffer d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return ByteBuffer.wrap(bArr);
    }
}
