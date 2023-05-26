package com.google.crypto.tink;

import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class CryptoFormat {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f14795a = new byte[0];

    /* renamed from: com.google.crypto.tink.CryptoFormat$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14796a;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            f14796a = iArr;
            try {
                iArr[OutputPrefixType.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14796a[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14796a[OutputPrefixType.TINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14796a[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static byte[] a(Keyset.Key key) throws GeneralSecurityException {
        int i8 = AnonymousClass1.f14796a[key.M().ordinal()];
        if (i8 != 1 && i8 != 2) {
            if (i8 != 3) {
                if (i8 == 4) {
                    return f14795a;
                }
                throw new GeneralSecurityException("unknown output prefix type");
            }
            return ByteBuffer.allocate(5).put((byte) 1).putInt(key.L()).array();
        }
        return ByteBuffer.allocate(5).put((byte) 0).putInt(key.L()).array();
    }
}
