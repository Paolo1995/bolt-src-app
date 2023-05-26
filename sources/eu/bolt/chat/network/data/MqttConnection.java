package eu.bolt.chat.network.data;

import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MqttConnection.kt */
/* loaded from: classes5.dex */
public final class MqttConnection {

    /* renamed from: a  reason: collision with root package name */
    private final String f39217a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39218b;

    /* renamed from: c  reason: collision with root package name */
    private final short f39219c;

    /* renamed from: d  reason: collision with root package name */
    private final MqttWebSocketConfig f39220d;

    /* renamed from: e  reason: collision with root package name */
    private final short f39221e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f39222f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f39223g;

    private MqttConnection(String str, String str2, short s7, MqttWebSocketConfig mqttWebSocketConfig, short s8, boolean z7, boolean z8) {
        this.f39217a = str;
        this.f39218b = str2;
        this.f39219c = s7;
        this.f39220d = mqttWebSocketConfig;
        this.f39221e = s8;
        this.f39222f = z7;
        this.f39223g = z8;
    }

    public /* synthetic */ MqttConnection(String str, String str2, short s7, MqttWebSocketConfig mqttWebSocketConfig, short s8, boolean z7, boolean z8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, s7, mqttWebSocketConfig, s8, z7, z8);
    }

    public final boolean a() {
        return this.f39222f;
    }

    public final String b() {
        return this.f39217a;
    }

    public final boolean c() {
        return this.f39223g;
    }

    public final String d() {
        return this.f39218b;
    }

    public final short e() {
        return this.f39221e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MqttConnection) {
            MqttConnection mqttConnection = (MqttConnection) obj;
            return Intrinsics.a(this.f39217a, mqttConnection.f39217a) && Intrinsics.a(this.f39218b, mqttConnection.f39218b) && this.f39219c == mqttConnection.f39219c && Intrinsics.a(this.f39220d, mqttConnection.f39220d) && this.f39221e == mqttConnection.f39221e && this.f39222f == mqttConnection.f39222f && this.f39223g == mqttConnection.f39223g;
        }
        return false;
    }

    public final short f() {
        return this.f39219c;
    }

    public final MqttWebSocketConfig g() {
        return this.f39220d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f39217a.hashCode() * 31) + this.f39218b.hashCode()) * 31) + UShort.f(this.f39219c)) * 31;
        MqttWebSocketConfig mqttWebSocketConfig = this.f39220d;
        int hashCode2 = (((hashCode + (mqttWebSocketConfig == null ? 0 : mqttWebSocketConfig.hashCode())) * 31) + UShort.f(this.f39221e)) * 31;
        boolean z7 = this.f39222f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        boolean z8 = this.f39223g;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        return "MqttConnection(clientId=" + this.f39217a + ", host=" + this.f39218b + ", port=" + ((Object) UShort.h(this.f39219c)) + ", webSocketConfig=" + this.f39220d + ", keepAlive=" + ((Object) UShort.h(this.f39221e)) + ", cleanSession=" + this.f39222f + ", enableSsl=" + this.f39223g + ')';
    }
}
