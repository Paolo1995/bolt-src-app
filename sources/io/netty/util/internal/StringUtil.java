package io.netty.util.internal;

import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public final class StringUtil {
    private static final byte[] HEX2B;
    public static final String NEWLINE = SystemPropertyUtil.get("line.separator", "\n");
    private static final String[] BYTE2HEX_PAD = new String[Spliterator.NONNULL];
    private static final String[] BYTE2HEX_NOPAD = new String[Spliterator.NONNULL];

    static {
        String str;
        int i8 = 0;
        while (true) {
            String[] strArr = BYTE2HEX_PAD;
            if (i8 < strArr.length) {
                String hexString = Integer.toHexString(i8);
                if (i8 > 15) {
                    str = hexString;
                } else {
                    str = '0' + hexString;
                }
                strArr[i8] = str;
                BYTE2HEX_NOPAD[i8] = hexString;
                i8++;
            } else {
                byte[] bArr = new byte[65536];
                HEX2B = bArr;
                Arrays.fill(bArr, (byte) -1);
                bArr[48] = 0;
                bArr[49] = 1;
                bArr[50] = 2;
                bArr[51] = 3;
                bArr[52] = 4;
                bArr[53] = 5;
                bArr[54] = 6;
                bArr[55] = 7;
                bArr[56] = 8;
                bArr[57] = 9;
                bArr[65] = 10;
                bArr[66] = 11;
                bArr[67] = 12;
                bArr[68] = 13;
                bArr[69] = 14;
                bArr[70] = 15;
                bArr[97] = 10;
                bArr[98] = 11;
                bArr[99] = 12;
                bArr[100] = 13;
                bArr[101] = 14;
                bArr[102] = 15;
                return;
            }
        }
    }

    private StringUtil() {
    }

    public static String byteToHexStringPadded(int i8) {
        return BYTE2HEX_PAD[i8 & 255];
    }

    public static byte decodeHexByte(CharSequence charSequence, int i8) {
        int decodeHexNibble = decodeHexNibble(charSequence.charAt(i8));
        int decodeHexNibble2 = decodeHexNibble(charSequence.charAt(i8 + 1));
        if (decodeHexNibble != -1 && decodeHexNibble2 != -1) {
            return (byte) ((decodeHexNibble << 4) + decodeHexNibble2);
        }
        throw new IllegalArgumentException(String.format("invalid hex byte '%s' at index %d of '%s'", charSequence.subSequence(i8, i8 + 2), Integer.valueOf(i8), charSequence));
    }

    public static int decodeHexNibble(char c8) {
        return HEX2B[c8];
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.CharSequence escapeCsv(java.lang.CharSequence r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.StringUtil.escapeCsv(java.lang.CharSequence, boolean):java.lang.CharSequence");
    }

    private static int indexOfFirstNonOwsChar(CharSequence charSequence, int i8) {
        int i9 = 0;
        while (i9 < i8 && isOws(charSequence.charAt(i9))) {
            i9++;
        }
        return i9;
    }

    private static int indexOfLastNonOwsChar(CharSequence charSequence, int i8, int i9) {
        int i10 = i9 - 1;
        while (i10 > i8 && isOws(charSequence.charAt(i10))) {
            i10--;
        }
        return i10;
    }

    private static boolean isDoubleQuote(char c8) {
        return c8 == '\"';
    }

    private static boolean isOws(char c8) {
        return c8 == ' ' || c8 == '\t';
    }

    public static boolean isSurrogate(char c8) {
        return c8 >= 55296 && c8 <= 57343;
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence charSequence, int i8) {
        return new IllegalArgumentException("invalid escaped CSV field: " + ((Object) charSequence) + " index: " + i8);
    }

    public static String simpleClassName(Object obj) {
        return obj == null ? "null_object" : simpleClassName(obj.getClass());
    }

    public static CharSequence trimOws(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return charSequence;
        }
        int indexOfFirstNonOwsChar = indexOfFirstNonOwsChar(charSequence, length);
        int indexOfLastNonOwsChar = indexOfLastNonOwsChar(charSequence, indexOfFirstNonOwsChar, length);
        if (indexOfFirstNonOwsChar != 0 || indexOfLastNonOwsChar != length - 1) {
            return charSequence.subSequence(indexOfFirstNonOwsChar, indexOfLastNonOwsChar + 1);
        }
        return charSequence;
    }

    public static List<CharSequence> unescapeCsvFields(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList(2);
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int length = charSequence.length() - 1;
        int i8 = 0;
        boolean z7 = false;
        while (i8 <= length) {
            char charAt = charSequence.charAt(i8);
            if (z7) {
                if (charAt != '\"') {
                    stringBuilder.append(charAt);
                } else if (i8 == length) {
                    arrayList.add(stringBuilder.toString());
                    return arrayList;
                } else {
                    i8++;
                    char charAt2 = charSequence.charAt(i8);
                    if (charAt2 == '\"') {
                        stringBuilder.append('\"');
                    } else if (charAt2 == ',') {
                        arrayList.add(stringBuilder.toString());
                        stringBuilder.setLength(0);
                        z7 = false;
                    } else {
                        throw newInvalidEscapedCsvFieldException(charSequence, i8 - 1);
                    }
                }
            } else {
                if (charAt != '\n' && charAt != '\r') {
                    if (charAt != '\"') {
                        if (charAt != ',') {
                            stringBuilder.append(charAt);
                        } else {
                            arrayList.add(stringBuilder.toString());
                            stringBuilder.setLength(0);
                        }
                    } else if (stringBuilder.length() == 0) {
                        z7 = true;
                    }
                }
                throw newInvalidEscapedCsvFieldException(charSequence, i8);
            }
            i8++;
        }
        if (!z7) {
            arrayList.add(stringBuilder.toString());
            return arrayList;
        }
        throw newInvalidEscapedCsvFieldException(charSequence, length);
    }

    public static String simpleClassName(Class<?> cls) {
        String name = ((Class) ObjectUtil.checkNotNull(cls, "clazz")).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > -1 ? name.substring(lastIndexOf + 1) : name;
    }
}
