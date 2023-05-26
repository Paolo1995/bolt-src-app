package eu.bolt.chat.network.data;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: MqttMessage.kt */
/* loaded from: classes5.dex */
public final class MqttMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f39224a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f39225b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f39226c;

    public MqttMessage(String topic, byte[] payload) {
        Intrinsics.f(topic, "topic");
        Intrinsics.f(payload, "payload");
        this.f39224a = topic;
        this.f39225b = payload;
        this.f39226c = LazyKt.b(new Function0<String>() { // from class: eu.bolt.chat.network.data.MqttMessage$payloadAsString$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final String invoke() {
                String s7;
                s7 = StringsKt__StringsJVMKt.s(MqttMessage.this.a());
                return s7;
            }
        });
    }

    public final byte[] a() {
        return this.f39225b;
    }

    public final String b() {
        return (String) this.f39226c.getValue();
    }

    public final String c() {
        return this.f39224a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.a(Reflection.b(MqttMessage.class), Reflection.b(obj.getClass()))) {
            return false;
        }
        MqttMessage mqttMessage = (MqttMessage) obj;
        if (Intrinsics.a(this.f39224a, mqttMessage.f39224a) && Intrinsics.a(b(), mqttMessage.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f39224a.hashCode() * 31) + b().hashCode();
    }

    public String toString() {
        return "MqttMessage(topic='" + this.f39224a + "', payload=" + b() + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MqttMessage(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "topic"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "payloadString"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            byte[] r3 = kotlin.text.StringsKt.t(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.data.MqttMessage.<init>(java.lang.String, java.lang.String):void");
    }
}
