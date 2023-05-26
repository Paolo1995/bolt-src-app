package com.hivemq.client.internal.util;

/* loaded from: classes3.dex */
public final class ClassUtil {
    private ClassUtil() {
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
