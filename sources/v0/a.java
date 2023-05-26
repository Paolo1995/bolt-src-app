package v0;

import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;

/* compiled from: Mqtt5ReasonCode.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static boolean a(Mqtt5ReasonCode mqtt5ReasonCode) {
        if (mqtt5ReasonCode.getCode() >= 128) {
            return true;
        }
        return false;
    }
}
