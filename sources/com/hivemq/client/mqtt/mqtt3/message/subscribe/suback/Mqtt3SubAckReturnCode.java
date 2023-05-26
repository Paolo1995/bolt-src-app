package com.hivemq.client.mqtt.mqtt3.message.subscribe.suback;

/* loaded from: classes3.dex */
public enum Mqtt3SubAckReturnCode {
    SUCCESS_MAXIMUM_QOS_0(0),
    SUCCESS_MAXIMUM_QOS_1(1),
    SUCCESS_MAXIMUM_QOS_2(2),
    FAILURE(128);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f18793f;

    Mqtt3SubAckReturnCode(int i8) {
        this.f18793f = i8;
    }

    public static Mqtt3SubAckReturnCode a(int i8) {
        Mqtt3SubAckReturnCode mqtt3SubAckReturnCode = SUCCESS_MAXIMUM_QOS_0;
        if (i8 == mqtt3SubAckReturnCode.f18793f) {
            return mqtt3SubAckReturnCode;
        }
        Mqtt3SubAckReturnCode mqtt3SubAckReturnCode2 = SUCCESS_MAXIMUM_QOS_1;
        if (i8 == mqtt3SubAckReturnCode2.f18793f) {
            return mqtt3SubAckReturnCode2;
        }
        Mqtt3SubAckReturnCode mqtt3SubAckReturnCode3 = SUCCESS_MAXIMUM_QOS_2;
        if (i8 == mqtt3SubAckReturnCode3.f18793f) {
            return mqtt3SubAckReturnCode3;
        }
        Mqtt3SubAckReturnCode mqtt3SubAckReturnCode4 = FAILURE;
        if (i8 == mqtt3SubAckReturnCode4.f18793f) {
            return mqtt3SubAckReturnCode4;
        }
        return null;
    }

    public boolean c() {
        if (this == FAILURE) {
            return true;
        }
        return false;
    }
}
