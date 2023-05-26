package eu.bolt.chat.network.data;

import kotlin.UByte;

/* compiled from: ConnAckReturnCode.kt */
/* loaded from: classes5.dex */
public enum ConnAckReturnCode {
    SUCCESS(UByte.c((byte) 0)),
    UNACCEPTABLE_PROTOCOL_VERSION(UByte.c((byte) 1)),
    IDENTIFIER_REJECTED(UByte.c((byte) 2)),
    SERVER_UNAVAILABLE(UByte.c((byte) 3)),
    BAD_USERNAME_OR_PASSWORD(UByte.c((byte) 4)),
    NOT_AUTHORIZED(UByte.c((byte) 5));
    

    /* renamed from: f  reason: collision with root package name */
    private final byte f39193f;

    ConnAckReturnCode(byte b8) {
        this.f39193f = b8;
    }

    public final boolean c() {
        if (this != UNACCEPTABLE_PROTOCOL_VERSION && this != IDENTIFIER_REJECTED && this != BAD_USERNAME_OR_PASSWORD && this != NOT_AUTHORIZED) {
            return false;
        }
        return true;
    }
}
