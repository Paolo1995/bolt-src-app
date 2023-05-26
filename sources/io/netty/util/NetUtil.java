package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;

/* loaded from: classes5.dex */
public final class NetUtil {
    private static final boolean IPV4_PREFERRED;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d9, code lost:
        r10 = r8.nextElement();
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0130, code lost:
        if (r10 != null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010e  */
    static {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.<clinit>():void");
    }

    private NetUtil() {
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            return validIpV4ToBytes(str);
        }
        if (isValidIpV6Address(str)) {
            if (str.charAt(0) == '[') {
                str = str.substring(1, str.length() - 1);
            }
            int indexOf = str.indexOf(37);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            return getIPv6ByName(str, true);
        }
        return null;
    }

    private static int decimalDigit(String str, int i8) {
        return str.charAt(i8) - '0';
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0168, code lost:
        if ((r6 - r9) <= 3) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0186, code lost:
        if (r19.charAt(0) == ':') goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0199, code lost:
        if (r7 <= 2) goto L166;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] getIPv6ByName(java.lang.CharSequence r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 649
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getIPv6ByName(java.lang.CharSequence, boolean):byte[]");
    }

    private static byte ipv4WordToByte(String str, int i8, int i9) {
        int decimalDigit = decimalDigit(str, i8);
        int i10 = i8 + 1;
        if (i10 == i9) {
            return (byte) decimalDigit;
        }
        int decimalDigit2 = (decimalDigit * 10) + decimalDigit(str, i10);
        int i11 = i10 + 1;
        if (i11 == i9) {
            return (byte) decimalDigit2;
        }
        return (byte) ((decimalDigit2 * 10) + decimalDigit(str, i11));
    }

    private static boolean isValidHexChar(char c8) {
        return (c8 >= '0' && c8 <= '9') || (c8 >= 'A' && c8 <= 'F') || (c8 >= 'a' && c8 <= 'f');
    }

    private static boolean isValidIPv4Mapped(byte[] bArr, int i8, int i9, int i10) {
        boolean z7;
        if (i10 + i9 >= 14) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (i8 <= 12 && i8 >= 2 && ((!z7 || i9 < 12) && isValidIPv4MappedSeparators(bArr[i8 - 1], bArr[i8 - 2], z7) && PlatformDependent.isZero(bArr, 0, i8 - 3))) {
            return true;
        }
        return false;
    }

    private static boolean isValidIPv4MappedChar(char c8) {
        return c8 == 'f' || c8 == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b8, byte b9, boolean z7) {
        return b8 == b9 && (b8 == 0 || (!z7 && b9 == -1));
    }

    public static boolean isValidIpV4Address(String str) {
        return isValidIpV4Address(str, 0, str.length());
    }

    private static boolean isValidIpV4Address0(CharSequence charSequence, int i8, int i9) {
        int indexOf;
        int i10;
        int indexOf2;
        int i11;
        int indexOf3;
        int i12 = i9 - i8;
        if (i12 <= 15 && i12 >= 7 && (indexOf = AsciiString.indexOf(charSequence, '.', i8 + 1)) > 0 && isValidIpV4Word(charSequence, i8, indexOf) && (indexOf2 = AsciiString.indexOf(charSequence, '.', (i10 = indexOf + 2))) > 0 && isValidIpV4Word(charSequence, i10 - 1, indexOf2) && (indexOf3 = AsciiString.indexOf(charSequence, '.', (i11 = indexOf2 + 2))) > 0 && isValidIpV4Word(charSequence, i11 - 1, indexOf3) && isValidIpV4Word(charSequence, indexOf3 + 1, i9)) {
            return true;
        }
        return false;
    }

    private static boolean isValidIpV4Word(CharSequence charSequence, int i8, int i9) {
        char charAt;
        char charAt2;
        int i10 = i9 - i8;
        if (i10 < 1 || i10 > 3 || (charAt = charSequence.charAt(i8)) < '0') {
            return false;
        }
        if (i10 == 3) {
            char charAt3 = charSequence.charAt(i8 + 1);
            if (charAt3 < '0' || (charAt2 = charSequence.charAt(i8 + 2)) < '0') {
                return false;
            }
            if (charAt > '1' || charAt3 > '9' || charAt2 > '9') {
                if (charAt != '2' || charAt3 > '5') {
                    return false;
                }
                if (charAt2 > '5' && (charAt3 >= '5' || charAt2 > '9')) {
                    return false;
                }
            }
            return true;
        } else if (charAt > '9') {
            return false;
        } else {
            if (i10 != 1 && !isValidNumericChar(charSequence.charAt(i8 + 1))) {
                return false;
            }
            return true;
        }
    }

    public static boolean isValidIpV6Address(String str) {
        return isValidIpV6Address((CharSequence) str);
    }

    private static boolean isValidNumericChar(char c8) {
        return c8 >= '0' && c8 <= '9';
    }

    private static StringBuilder newSocketAddressStringBuilder(String str, String str2, boolean z7) {
        int length = str.length();
        if (z7) {
            StringBuilder sb = new StringBuilder(length + 1 + str2.length());
            sb.append(str);
            return sb;
        }
        StringBuilder sb2 = new StringBuilder(length + 3 + str2.length());
        if (length > 1 && str.charAt(0) == '[' && str.charAt(length - 1) == ']') {
            sb2.append(str);
            return sb2;
        }
        sb2.append('[');
        sb2.append(str);
        sb2.append(']');
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        Process start = new ProcessBuilder("sysctl", str).start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.startsWith(str)) {
                for (int length = readLine.length() - 1; length > str.length(); length--) {
                    if (!Character.isDigit(readLine.charAt(length))) {
                        Integer valueOf = Integer.valueOf(readLine.substring(length + 1));
                        bufferedReader.close();
                        start.destroy();
                        return valueOf;
                    }
                }
            }
            bufferedReader.close();
            start.destroy();
            return null;
        } catch (Throwable th) {
            if (start != null) {
                start.destroy();
            }
            throw th;
        }
    }

    public static String toSocketAddressString(String str, int i8) {
        String valueOf = String.valueOf(i8);
        StringBuilder newSocketAddressStringBuilder = newSocketAddressStringBuilder(str, valueOf, !isValidIpV6Address(str));
        newSocketAddressStringBuilder.append(':');
        newSocketAddressStringBuilder.append(valueOf);
        return newSocketAddressStringBuilder.toString();
    }

    static byte[] validIpV4ToBytes(String str) {
        int indexOf = str.indexOf(46, 1);
        int i8 = indexOf + 1;
        int indexOf2 = str.indexOf(46, indexOf + 2);
        int indexOf3 = str.indexOf(46, indexOf2 + 2);
        return new byte[]{ipv4WordToByte(str, 0, indexOf), ipv4WordToByte(str, i8, indexOf2), ipv4WordToByte(str, indexOf2 + 1, indexOf3), ipv4WordToByte(str, indexOf3 + 1, str.length())};
    }

    private static boolean isValidIpV4Address(CharSequence charSequence, int i8, int i9) {
        if (charSequence instanceof String) {
            return isValidIpV4Address((String) charSequence, i8, i9);
        }
        if (charSequence instanceof AsciiString) {
            return isValidIpV4Address((AsciiString) charSequence, i8, i9);
        }
        return isValidIpV4Address0(charSequence, i8, i9);
    }

    public static boolean isValidIpV6Address(CharSequence charSequence) {
        int i8;
        int i9;
        int length = charSequence.length();
        int i10 = 2;
        if (length < 2) {
            return false;
        }
        char charAt = charSequence.charAt(0);
        if (charAt == '[') {
            length--;
            if (charSequence.charAt(length) != ']') {
                return false;
            }
            charAt = charSequence.charAt(1);
            i8 = 1;
        } else {
            i8 = 0;
        }
        if (charAt != ':') {
            i10 = 0;
            i9 = -1;
        } else if (charSequence.charAt(i8 + 1) != ':') {
            return false;
        } else {
            int i11 = i8;
            i8 += 2;
            i9 = i11;
        }
        int i12 = i8;
        int i13 = 0;
        while (true) {
            if (i12 >= length) {
                break;
            }
            char charAt2 = charSequence.charAt(i12);
            if (!isValidHexChar(charAt2)) {
                if (charAt2 == '%') {
                    length = i12;
                    break;
                } else if (charAt2 == '.') {
                    if ((i9 >= 0 || i10 == 6) && ((i10 != 7 || i9 < i8) && i10 <= 7)) {
                        int i14 = i12 - i13;
                        int i15 = i14 - 2;
                        if (isValidIPv4MappedChar(charSequence.charAt(i15))) {
                            if (!isValidIPv4MappedChar(charSequence.charAt(i15 - 1)) || !isValidIPv4MappedChar(charSequence.charAt(i15 - 2)) || !isValidIPv4MappedChar(charSequence.charAt(i15 - 3))) {
                                return false;
                            }
                            i15 -= 5;
                        }
                        while (i15 >= i8) {
                            char charAt3 = charSequence.charAt(i15);
                            if (charAt3 != '0' && charAt3 != ':') {
                                return false;
                            }
                            i15--;
                        }
                        int indexOf = AsciiString.indexOf(charSequence, '%', i14 + 7);
                        if (indexOf >= 0) {
                            length = indexOf;
                        }
                        return isValidIpV4Address(charSequence, i14, length);
                    }
                    return false;
                } else if (charAt2 != ':' || i10 > 7) {
                    return false;
                } else {
                    int i16 = i12 - 1;
                    if (charSequence.charAt(i16) != ':') {
                        i13 = 0;
                    } else if (i9 >= 0) {
                        return false;
                    } else {
                        i9 = i16;
                    }
                    i10++;
                }
            } else if (i13 >= 4) {
                return false;
            } else {
                i13++;
            }
            i12++;
        }
        if (i9 < 0) {
            return i10 == 7 && i13 > 0;
        }
        if (i9 + 2 != length) {
            if (i13 <= 0) {
                return false;
            }
            if (i10 >= 8 && i9 > i8) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIpV4Address(String str, int i8, int i9) {
        int indexOf;
        int i10;
        int indexOf2;
        int i11;
        int indexOf3;
        int i12 = i9 - i8;
        return i12 <= 15 && i12 >= 7 && (indexOf = str.indexOf(46, i8 + 1)) > 0 && isValidIpV4Word(str, i8, indexOf) && (indexOf2 = str.indexOf(46, (i10 = indexOf + 2))) > 0 && isValidIpV4Word(str, i10 - 1, indexOf2) && (indexOf3 = str.indexOf(46, (i11 = indexOf2 + 2))) > 0 && isValidIpV4Word(str, i11 - 1, indexOf3) && isValidIpV4Word(str, indexOf3 + 1, i9);
    }

    private static boolean isValidIpV4Address(AsciiString asciiString, int i8, int i9) {
        int indexOf;
        int i10;
        int indexOf2;
        int i11;
        int indexOf3;
        int i12 = i9 - i8;
        return i12 <= 15 && i12 >= 7 && (indexOf = asciiString.indexOf('.', i8 + 1)) > 0 && isValidIpV4Word(asciiString, i8, indexOf) && (indexOf2 = asciiString.indexOf('.', (i10 = indexOf + 2))) > 0 && isValidIpV4Word(asciiString, i10 - 1, indexOf2) && (indexOf3 = asciiString.indexOf('.', (i11 = indexOf2 + 2))) > 0 && isValidIpV4Word(asciiString, i11 - 1, indexOf3) && isValidIpV4Word(asciiString, indexOf3 + 1, i9);
    }
}
