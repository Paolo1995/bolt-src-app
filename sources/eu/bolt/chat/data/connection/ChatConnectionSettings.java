package eu.bolt.chat.data.connection;

import eu.bolt.chat.network.CredentialsProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatConnectionSettings.kt */
/* loaded from: classes5.dex */
public final class ChatConnectionSettings {

    /* renamed from: a  reason: collision with root package name */
    private final String f38959a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38960b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38961c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38962d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38963e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38964f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38965g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38966h;

    /* renamed from: i  reason: collision with root package name */
    private final String f38967i;

    /* renamed from: j  reason: collision with root package name */
    private final String f38968j;

    /* renamed from: k  reason: collision with root package name */
    private final String f38969k;

    /* renamed from: l  reason: collision with root package name */
    private final String f38970l;

    /* renamed from: m  reason: collision with root package name */
    private final String f38971m;

    /* renamed from: n  reason: collision with root package name */
    private final CredentialsProvider f38972n;

    public ChatConnectionSettings(String mqttServerHost, String httpServerHost, String userType, String userId, String userName, String deviceId, String deviceName, String deviceType, String deviceOsVersion, String sessionId, String appVersion, String str, String language, CredentialsProvider credentialsProvider) {
        Intrinsics.f(mqttServerHost, "mqttServerHost");
        Intrinsics.f(httpServerHost, "httpServerHost");
        Intrinsics.f(userType, "userType");
        Intrinsics.f(userId, "userId");
        Intrinsics.f(userName, "userName");
        Intrinsics.f(deviceId, "deviceId");
        Intrinsics.f(deviceName, "deviceName");
        Intrinsics.f(deviceType, "deviceType");
        Intrinsics.f(deviceOsVersion, "deviceOsVersion");
        Intrinsics.f(sessionId, "sessionId");
        Intrinsics.f(appVersion, "appVersion");
        Intrinsics.f(language, "language");
        Intrinsics.f(credentialsProvider, "credentialsProvider");
        this.f38959a = mqttServerHost;
        this.f38960b = httpServerHost;
        this.f38961c = userType;
        this.f38962d = userId;
        this.f38963e = userName;
        this.f38964f = deviceId;
        this.f38965g = deviceName;
        this.f38966h = deviceType;
        this.f38967i = deviceOsVersion;
        this.f38968j = sessionId;
        this.f38969k = appVersion;
        this.f38970l = str;
        this.f38971m = language;
        this.f38972n = credentialsProvider;
    }

    public final String a() {
        return this.f38969k;
    }

    public final String b() {
        return this.f38962d + ':' + this.f38964f;
    }

    public final String c() {
        return this.f38970l;
    }

    public final CredentialsProvider d() {
        return this.f38972n;
    }

    public final String e() {
        return this.f38964f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatConnectionSettings) {
            ChatConnectionSettings chatConnectionSettings = (ChatConnectionSettings) obj;
            return Intrinsics.a(this.f38959a, chatConnectionSettings.f38959a) && Intrinsics.a(this.f38960b, chatConnectionSettings.f38960b) && Intrinsics.a(this.f38961c, chatConnectionSettings.f38961c) && Intrinsics.a(this.f38962d, chatConnectionSettings.f38962d) && Intrinsics.a(this.f38963e, chatConnectionSettings.f38963e) && Intrinsics.a(this.f38964f, chatConnectionSettings.f38964f) && Intrinsics.a(this.f38965g, chatConnectionSettings.f38965g) && Intrinsics.a(this.f38966h, chatConnectionSettings.f38966h) && Intrinsics.a(this.f38967i, chatConnectionSettings.f38967i) && Intrinsics.a(this.f38968j, chatConnectionSettings.f38968j) && Intrinsics.a(this.f38969k, chatConnectionSettings.f38969k) && Intrinsics.a(this.f38970l, chatConnectionSettings.f38970l) && Intrinsics.a(this.f38971m, chatConnectionSettings.f38971m) && Intrinsics.a(this.f38972n, chatConnectionSettings.f38972n);
        }
        return false;
    }

    public final String f() {
        return this.f38965g;
    }

    public final String g() {
        return this.f38967i;
    }

    public final String h() {
        return this.f38966h;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.f38959a.hashCode() * 31) + this.f38960b.hashCode()) * 31) + this.f38961c.hashCode()) * 31) + this.f38962d.hashCode()) * 31) + this.f38963e.hashCode()) * 31) + this.f38964f.hashCode()) * 31) + this.f38965g.hashCode()) * 31) + this.f38966h.hashCode()) * 31) + this.f38967i.hashCode()) * 31) + this.f38968j.hashCode()) * 31) + this.f38969k.hashCode()) * 31;
        String str = this.f38970l;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f38971m.hashCode()) * 31) + this.f38972n.hashCode();
    }

    public final String i() {
        return this.f38960b;
    }

    public final String j() {
        return this.f38971m;
    }

    public final String k() {
        return this.f38959a;
    }

    public final String l() {
        return this.f38968j;
    }

    public final String m() {
        return this.f38962d;
    }

    public final String n() {
        return this.f38963e;
    }

    public final String o() {
        return this.f38961c;
    }

    public String toString() {
        return "ChatConnectionSettings(mqttServerHost=" + this.f38959a + ", httpServerHost=" + this.f38960b + ", userType=" + this.f38961c + ", userId=" + this.f38962d + ", userName=" + this.f38963e + ", deviceId=" + this.f38964f + ", deviceName=" + this.f38965g + ", deviceType=" + this.f38966h + ", deviceOsVersion=" + this.f38967i + ", sessionId=" + this.f38968j + ", appVersion=" + this.f38969k + ", country=" + this.f38970l + ", language=" + this.f38971m + ", credentialsProvider=" + this.f38972n + ')';
    }
}
