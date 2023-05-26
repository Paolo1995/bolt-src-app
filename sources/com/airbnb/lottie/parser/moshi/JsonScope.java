package com.airbnb.lottie.parser.moshi;

/* loaded from: classes.dex */
final class JsonScope {
    private JsonScope() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i8, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = iArr[i9];
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3 || i10 == 4 || i10 == 5) {
                    sb.append('.');
                    String str = strArr[i9];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append('[');
                sb.append(iArr2[i9]);
                sb.append(']');
            }
        }
        return sb.toString();
    }
}
