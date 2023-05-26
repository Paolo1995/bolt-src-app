package j$.time.format;

import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final w f50051a = new w();

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private w() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(char c8) {
        int i8 = c8 - '0';
        if (i8 < 0 || i8 > 9) {
            return -1;
        }
        return i8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            ((w) obj).getClass();
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 182;
    }

    public final String toString() {
        return "DecimalStyle[0+-.]";
    }
}
