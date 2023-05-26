package okhttp3.internal.http2;

import j$.util.Spliterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okio.ByteString;

/* compiled from: Http2.kt */
/* loaded from: classes5.dex */
public final class Http2 {
    private static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;
    public static final Http2 INSTANCE = new Http2();
    public static final ByteString CONNECTION_PREFACE = ByteString.f52591i.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] FLAGS = new String[64];

    static {
        String E;
        String[] strArr = new String[Spliterator.NONNULL];
        int i8 = 0;
        for (int i9 = 0; i9 < 256; i9++) {
            String binaryString = Integer.toBinaryString(i9);
            Intrinsics.e(binaryString, "toBinaryString(it)");
            E = StringsKt__StringsJVMKt.E(Util.format("%8s", binaryString), ' ', '0', false, 4, null);
            strArr[i9] = E;
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i10 = 0;
        while (i10 < 1) {
            int i11 = iArr[i10];
            i10++;
            String[] strArr3 = FLAGS;
            strArr3[i11 | 8] = Intrinsics.n(strArr3[i11], "|PADDED");
        }
        String[] strArr4 = FLAGS;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i12 = 0;
        while (i12 < 3) {
            int i13 = iArr2[i12];
            i12++;
            int i14 = 0;
            while (i14 < 1) {
                int i15 = iArr[i14];
                i14++;
                String[] strArr5 = FLAGS;
                int i16 = i15 | i13;
                StringBuilder sb = new StringBuilder();
                sb.append((Object) strArr5[i15]);
                sb.append('|');
                sb.append((Object) strArr5[i13]);
                strArr5[i16] = sb.toString();
                strArr5[i16 | 8] = ((Object) strArr5[i15]) + '|' + ((Object) strArr5[i13]) + "|PADDED";
            }
        }
        int length = FLAGS.length;
        while (i8 < length) {
            int i17 = i8 + 1;
            String[] strArr6 = FLAGS;
            if (strArr6[i8] == null) {
                strArr6[i8] = BINARY[i8];
            }
            i8 = i17;
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i8, int i9) {
        String str;
        String F;
        String F2;
        if (i9 == 0) {
            return "";
        }
        if (i8 != 2 && i8 != 3) {
            if (i8 != 4 && i8 != 6) {
                if (i8 != 7 && i8 != 8) {
                    String[] strArr = FLAGS;
                    if (i9 < strArr.length) {
                        str = strArr[i9];
                        Intrinsics.c(str);
                    } else {
                        str = BINARY[i9];
                    }
                    String str2 = str;
                    if (i8 == 5 && (i9 & 4) != 0) {
                        F2 = StringsKt__StringsJVMKt.F(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
                        return F2;
                    } else if (i8 == 0 && (i9 & 32) != 0) {
                        F = StringsKt__StringsJVMKt.F(str2, "PRIORITY", "COMPRESSED", false, 4, null);
                        return F;
                    } else {
                        return str2;
                    }
                }
            } else if (i9 == 1) {
                return "ACK";
            } else {
                return BINARY[i9];
            }
        }
        return BINARY[i9];
    }

    public final String formattedType$okhttp(int i8) {
        String[] strArr = FRAME_NAMES;
        if (i8 < strArr.length) {
            return strArr[i8];
        }
        return Util.format("0x%02x", Integer.valueOf(i8));
    }

    public final String frameLog(boolean z7, int i8, int i9, int i10, int i11) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(i10);
        String formatFlags = formatFlags(i10, i11);
        if (z7) {
            str = "<<";
        } else {
            str = ">>";
        }
        return Util.format("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(i8), Integer.valueOf(i9), formattedType$okhttp, formatFlags);
    }
}
