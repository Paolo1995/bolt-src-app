package com.sinch.android.rtc.internal.service.pubnub.http;

/* loaded from: classes3.dex */
public final class UriEncoder {
    private UriEncoder() {
    }

    public static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < str.length(); i8++) {
            char charAt = str.charAt(i8);
            if (isUnsafe(charAt)) {
                sb.append('%');
                sb.append(toHex(charAt / 16));
                charAt = toHex(charAt % 16);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static boolean isUnsafe(char c8) {
        return " ~`!@#$%^&*()+=[]\\{}|;':\",./<>?".indexOf(c8) >= 0;
    }

    private static char toHex(int i8) {
        return (char) (i8 < 10 ? i8 + 48 : (i8 + 65) - 10);
    }
}
