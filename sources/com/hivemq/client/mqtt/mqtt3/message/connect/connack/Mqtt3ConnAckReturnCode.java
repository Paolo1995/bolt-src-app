package com.hivemq.client.mqtt.mqtt3.message.connect.connack;

/* loaded from: classes3.dex */
public enum Mqtt3ConnAckReturnCode {
    SUCCESS,
    UNSUPPORTED_PROTOCOL_VERSION,
    IDENTIFIER_REJECTED,
    SERVER_UNAVAILABLE,
    BAD_USER_NAME_OR_PASSWORD,
    NOT_AUTHORIZED;
    

    /* renamed from: l  reason: collision with root package name */
    private static final Mqtt3ConnAckReturnCode[] f18784l = values();

    public static Mqtt3ConnAckReturnCode a(int i8) {
        if (i8 >= 0) {
            Mqtt3ConnAckReturnCode[] mqtt3ConnAckReturnCodeArr = f18784l;
            if (i8 < mqtt3ConnAckReturnCodeArr.length) {
                return mqtt3ConnAckReturnCodeArr[i8];
            }
            return null;
        }
        return null;
    }
}
