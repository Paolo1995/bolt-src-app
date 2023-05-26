package eu.bolt.chat.network.data;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: MqttWebSocketConfig.kt */
/* loaded from: classes5.dex */
public final class MqttWebSocketConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f39228a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39229b;

    public MqttWebSocketConfig(String path, String query) {
        Intrinsics.f(path, "path");
        Intrinsics.f(query, "query");
        this.f39228a = path;
        this.f39229b = query;
    }

    public final String a() {
        return this.f39228a;
    }

    public final String b() {
        return this.f39229b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MqttWebSocketConfig) {
            MqttWebSocketConfig mqttWebSocketConfig = (MqttWebSocketConfig) obj;
            return Intrinsics.a(this.f39228a, mqttWebSocketConfig.f39228a) && Intrinsics.a(this.f39229b, mqttWebSocketConfig.f39229b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39228a.hashCode() * 31) + this.f39229b.hashCode();
    }

    public String toString() {
        return "MqttWebSocketConfig(path=" + this.f39228a + ", query=" + this.f39229b + ')';
    }
}
