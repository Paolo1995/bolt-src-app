package com.sinch.gson.internal;

/* renamed from: com.sinch.gson.internal.$Gson$Preconditions  reason: invalid class name */
/* loaded from: classes3.dex */
public final class C$Gson$Preconditions {
    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t7) {
        t7.getClass();
        return t7;
    }
}
