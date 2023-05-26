package com.hivemq.client.internal.util;

/* loaded from: classes3.dex */
public final class StringUtil {
    private StringUtil() {
    }

    public static String a(String str, String str2) {
        if (str2.isEmpty()) {
            return "";
        }
        return str + str2;
    }
}
