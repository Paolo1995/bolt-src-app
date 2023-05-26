package okhttp3.internal.ws;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* compiled from: WebSocketProtocol.kt */
/* loaded from: classes5.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String key) {
        Intrinsics.f(key, "key");
        return ByteString.f52591i.d(Intrinsics.n(key, ACCEPT_MAGIC)).x().a();
    }

    public final String closeCodeExceptionMessage(int i8) {
        boolean z7;
        if (i8 >= 1000 && i8 < 5000) {
            boolean z8 = true;
            if (1004 <= i8 && i8 < 1007) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                if (!((1015 > i8 || i8 >= 3000) ? false : false)) {
                    return null;
                }
            }
            return "Code " + i8 + " is reserved and may not be used.";
        }
        return Intrinsics.n("Code must be in range [1000,5000): ", Integer.valueOf(i8));
    }

    public final void toggleMask(Buffer.UnsafeCursor cursor, byte[] key) {
        Intrinsics.f(cursor, "cursor");
        Intrinsics.f(key, "key");
        int length = key.length;
        int i8 = 0;
        do {
            byte[] bArr = cursor.f52586j;
            int i9 = cursor.f52587k;
            int i10 = cursor.f52588l;
            if (bArr != null) {
                while (i9 < i10) {
                    int i11 = i8 % length;
                    bArr[i9] = (byte) (bArr[i9] ^ key[i11]);
                    i9++;
                    i8 = i11 + 1;
                }
            }
        } while (cursor.c() != -1);
    }

    public final void validateCloseCode(int i8) {
        boolean z7;
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i8);
        if (closeCodeExceptionMessage == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        Intrinsics.c(closeCodeExceptionMessage);
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}
