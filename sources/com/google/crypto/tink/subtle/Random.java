package com.google.crypto.tink.subtle;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public final class Random {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<SecureRandom> f15370a = new ThreadLocal<SecureRandom>() { // from class: com.google.crypto.tink.subtle.Random.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SecureRandom initialValue() {
            return Random.a();
        }
    };

    static /* synthetic */ SecureRandom a() {
        return b();
    }

    private static SecureRandom b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] c(int i8) {
        byte[] bArr = new byte[i8];
        f15370a.get().nextBytes(bArr);
        return bArr;
    }
}
