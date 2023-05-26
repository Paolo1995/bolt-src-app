package com.hivemq.client.internal.util;

import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes3.dex */
public final class UnsignedDataTypes {
    private UnsignedDataTypes() {
    }

    public static boolean a(long j8) {
        return j8 >= 0 && j8 <= 4294967295L;
    }

    public static boolean b(long j8) {
        return j8 >= 0 && j8 <= WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }
}
