package io.netty.util.internal.logging;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
final class MessageFormatter {
    private MessageFormatter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple arrayFormat(String str, Object[] objArr) {
        Throwable th;
        boolean z7;
        Throwable th2 = null;
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object obj = objArr[length];
            if (obj instanceof Throwable) {
                th = (Throwable) obj;
            } else {
                th = null;
            }
            if (str == null) {
                return new FormattingTuple(null, th);
            }
            int indexOf = str.indexOf("{}");
            if (indexOf == -1) {
                return new FormattingTuple(str, th);
            }
            StringBuilder sb = new StringBuilder(str.length() + 50);
            int i8 = 0;
            int i9 = 0;
            do {
                if (indexOf != 0 && str.charAt(indexOf - 1) == '\\') {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (z7) {
                    sb.append((CharSequence) str, i8, indexOf);
                } else {
                    sb.append((CharSequence) str, i8, indexOf - 1);
                    if (indexOf >= 2 && str.charAt(indexOf - 2) == '\\') {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                i8 = indexOf + 2;
                if (z7) {
                    deeplyAppendParameter(sb, objArr[i9], null);
                    i9++;
                    if (i9 > length) {
                        break;
                    }
                } else {
                    sb.append("{}");
                }
                indexOf = str.indexOf("{}", i8);
            } while (indexOf != -1);
            sb.append((CharSequence) str, i8, str.length());
            String sb2 = sb.toString();
            if (i9 <= length) {
                th2 = th;
            }
            return new FormattingTuple(sb2, th2);
        }
        return new FormattingTuple(str, null);
    }

    private static void booleanArrayAppend(StringBuilder sb, boolean[] zArr) {
        if (zArr.length == 0) {
            return;
        }
        sb.append(zArr[0]);
        for (int i8 = 1; i8 < zArr.length; i8++) {
            sb.append(", ");
            sb.append(zArr[i8]);
        }
    }

    private static void byteArrayAppend(StringBuilder sb, byte[] bArr) {
        if (bArr.length == 0) {
            return;
        }
        sb.append((int) bArr[0]);
        for (int i8 = 1; i8 < bArr.length; i8++) {
            sb.append(", ");
            sb.append((int) bArr[i8]);
        }
    }

    private static void charArrayAppend(StringBuilder sb, char[] cArr) {
        if (cArr.length == 0) {
            return;
        }
        sb.append(cArr[0]);
        for (int i8 = 1; i8 < cArr.length; i8++) {
            sb.append(", ");
            sb.append(cArr[i8]);
        }
    }

    private static void deeplyAppendParameter(StringBuilder sb, Object obj, Set<Object[]> set) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            if (Number.class.isAssignableFrom(cls)) {
                if (cls == Long.class) {
                    sb.append(((Long) obj).longValue());
                    return;
                } else if (cls != Integer.class && cls != Short.class && cls != Byte.class) {
                    if (cls == Double.class) {
                        sb.append(((Double) obj).doubleValue());
                        return;
                    } else if (cls == Float.class) {
                        sb.append(((Float) obj).floatValue());
                        return;
                    } else {
                        safeObjectAppend(sb, obj);
                        return;
                    }
                } else {
                    sb.append(((Number) obj).intValue());
                    return;
                }
            }
            safeObjectAppend(sb, obj);
            return;
        }
        sb.append('[');
        if (cls == boolean[].class) {
            booleanArrayAppend(sb, (boolean[]) obj);
        } else if (cls == byte[].class) {
            byteArrayAppend(sb, (byte[]) obj);
        } else if (cls == char[].class) {
            charArrayAppend(sb, (char[]) obj);
        } else if (cls == short[].class) {
            shortArrayAppend(sb, (short[]) obj);
        } else if (cls == int[].class) {
            intArrayAppend(sb, (int[]) obj);
        } else if (cls == long[].class) {
            longArrayAppend(sb, (long[]) obj);
        } else if (cls == float[].class) {
            floatArrayAppend(sb, (float[]) obj);
        } else if (cls == double[].class) {
            doubleArrayAppend(sb, (double[]) obj);
        } else {
            objectArrayAppend(sb, (Object[]) obj, set);
        }
        sb.append(']');
    }

    private static void doubleArrayAppend(StringBuilder sb, double[] dArr) {
        if (dArr.length == 0) {
            return;
        }
        sb.append(dArr[0]);
        for (int i8 = 1; i8 < dArr.length; i8++) {
            sb.append(", ");
            sb.append(dArr[i8]);
        }
    }

    private static void floatArrayAppend(StringBuilder sb, float[] fArr) {
        if (fArr.length == 0) {
            return;
        }
        sb.append(fArr[0]);
        for (int i8 = 1; i8 < fArr.length; i8++) {
            sb.append(", ");
            sb.append(fArr[i8]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple format(String str, Object obj) {
        return arrayFormat(str, new Object[]{obj});
    }

    private static void intArrayAppend(StringBuilder sb, int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        sb.append(iArr[0]);
        for (int i8 = 1; i8 < iArr.length; i8++) {
            sb.append(", ");
            sb.append(iArr[i8]);
        }
    }

    private static void longArrayAppend(StringBuilder sb, long[] jArr) {
        if (jArr.length == 0) {
            return;
        }
        sb.append(jArr[0]);
        for (int i8 = 1; i8 < jArr.length; i8++) {
            sb.append(", ");
            sb.append(jArr[i8]);
        }
    }

    private static void objectArrayAppend(StringBuilder sb, Object[] objArr, Set<Object[]> set) {
        if (objArr.length == 0) {
            return;
        }
        if (set == null) {
            set = new HashSet<>(objArr.length);
        }
        if (set.add(objArr)) {
            deeplyAppendParameter(sb, objArr[0], set);
            for (int i8 = 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                deeplyAppendParameter(sb, objArr[i8], set);
            }
            set.remove(objArr);
            return;
        }
        sb.append("...");
    }

    private static void safeObjectAppend(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            printStream.println("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + ']');
            th.printStackTrace();
            sb.append("[FAILED toString()]");
        }
    }

    private static void shortArrayAppend(StringBuilder sb, short[] sArr) {
        if (sArr.length == 0) {
            return;
        }
        sb.append((int) sArr[0]);
        for (int i8 = 1; i8 < sArr.length; i8++) {
            sb.append(", ");
            sb.append((int) sArr[i8]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple format(String str, Object obj, Object obj2) {
        return arrayFormat(str, new Object[]{obj, obj2});
    }
}
