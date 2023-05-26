package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class MessageFormatter {
    public static final FormattingTuple a(String str, Object[] objArr) {
        Throwable k8 = k(objArr);
        if (k8 != null) {
            objArr = s(objArr);
        }
        return b(str, objArr, k8);
    }

    public static final FormattingTuple b(String str, Object[] objArr, Throwable th) {
        int i8;
        if (str == null) {
            return new FormattingTuple(null, objArr, th);
        }
        if (objArr == null) {
            return new FormattingTuple(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i9 = 0;
        int i10 = 0;
        while (i9 < objArr.length) {
            int indexOf = str.indexOf("{}", i10);
            if (indexOf == -1) {
                if (i10 == 0) {
                    return new FormattingTuple(str, objArr, th);
                }
                sb.append((CharSequence) str, i10, str.length());
                return new FormattingTuple(sb.toString(), objArr, th);
            }
            if (n(str, indexOf)) {
                if (!m(str, indexOf)) {
                    i9--;
                    sb.append((CharSequence) str, i10, indexOf - 1);
                    sb.append('{');
                    i8 = indexOf + 1;
                    i10 = i8;
                    i9++;
                } else {
                    sb.append((CharSequence) str, i10, indexOf - 1);
                    f(sb, objArr[i9], new HashMap());
                }
            } else {
                sb.append((CharSequence) str, i10, indexOf);
                f(sb, objArr[i9], new HashMap());
            }
            i8 = indexOf + 2;
            i10 = i8;
            i9++;
        }
        sb.append((CharSequence) str, i10, str.length());
        return new FormattingTuple(sb.toString(), objArr, th);
    }

    private static void c(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append(zArr[i8]);
            if (i8 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void d(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append((int) bArr[i8]);
            if (i8 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void e(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append(cArr[i8]);
            if (i8 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void f(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
        } else if (!obj.getClass().isArray()) {
            q(sb, obj);
        } else if (obj instanceof boolean[]) {
            c(sb, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            d(sb, (byte[]) obj);
        } else if (obj instanceof char[]) {
            e(sb, (char[]) obj);
        } else if (obj instanceof short[]) {
            r(sb, (short[]) obj);
        } else if (obj instanceof int[]) {
            l(sb, (int[]) obj);
        } else if (obj instanceof long[]) {
            o(sb, (long[]) obj);
        } else if (obj instanceof float[]) {
            h(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb, (double[]) obj);
        } else {
            p(sb, (Object[]) obj, map);
        }
    }

    private static void g(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append(dArr[i8]);
            if (i8 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void h(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append(fArr[i8]);
            if (i8 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static final FormattingTuple i(String str, Object obj) {
        return a(str, new Object[]{obj});
    }

    public static final FormattingTuple j(String str, Object obj, Object obj2) {
        return a(str, new Object[]{obj, obj2});
    }

    public static Throwable k(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    private static void l(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append(iArr[i8]);
            if (i8 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    static final boolean m(String str, int i8) {
        if (i8 >= 2 && str.charAt(i8 - 2) == '\\') {
            return true;
        }
        return false;
    }

    static final boolean n(String str, int i8) {
        if (i8 == 0 || str.charAt(i8 - 1) != '\\') {
            return false;
        }
        return true;
    }

    private static void o(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append(jArr[i8]);
            if (i8 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void p(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i8 = 0; i8 < length; i8++) {
                f(sb, objArr[i8], map);
                if (i8 != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb.append("...");
        }
        sb.append(']');
    }

    private static void q(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            Util.d("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    private static void r(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append((int) sArr[i8]);
            if (i8 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static Object[] s(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            if (length > 0) {
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return objArr2;
        }
        throw new IllegalStateException("non-sensical empty or null argument array");
    }
}
