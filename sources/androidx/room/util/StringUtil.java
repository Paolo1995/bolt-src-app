package androidx.room.util;

/* loaded from: classes.dex */
public class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f7667a = new String[0];

    private StringUtil() {
    }

    public static void a(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            sb.append("?");
            if (i9 < i8 - 1) {
                sb.append(",");
            }
        }
    }

    public static StringBuilder b() {
        return new StringBuilder();
    }
}
