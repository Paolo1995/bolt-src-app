package ee.mtakso.driver.service.chat;

import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.client.auth.anonymous.AccessToken;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.session.SessionProvider;
import ee.mtakso.driver.service.token.TokenManager;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverChatUserInfoProvider.kt */
/* loaded from: classes3.dex */
public final class DriverChatUserInfoProvider implements UserInfoProvider {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f24049f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f24050a;

    /* renamed from: b  reason: collision with root package name */
    private final TokenManager f24051b;

    /* renamed from: c  reason: collision with root package name */
    private final SessionProvider f24052c;

    /* renamed from: d  reason: collision with root package name */
    private final LanguageManager f24053d;

    /* renamed from: e  reason: collision with root package name */
    private final DeviceInfo f24054e;

    /* compiled from: DriverChatUserInfoProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DriverChatUserInfoProvider(DriverProvider driverProvider, TokenManager tokenManager, SessionProvider sessionProvider, LanguageManager languageManager, DeviceInfo deviceInfo) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(tokenManager, "tokenManager");
        Intrinsics.f(sessionProvider, "sessionProvider");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(deviceInfo, "deviceInfo");
        this.f24050a = driverProvider;
        this.f24051b = tokenManager;
        this.f24052c = sessionProvider;
        this.f24053d = languageManager;
        this.f24054e = deviceInfo;
    }

    private final String t() {
        return this.f24050a.f();
    }

    @Override // eu.bolt.chat.chatcore.user.MqttMessageExtrasProvider, eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String a() {
        return this.f24052c.c().a();
    }

    @Override // eu.bolt.chat.chatcore.user.MqttMessageExtrasProvider, eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String b() {
        return this.f24053d.e();
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String c() {
        String A;
        DriverConfig d8 = this.f24050a.d();
        if (d8 == null || (A = d8.A()) == null) {
            return "";
        }
        return A;
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String d() {
        return "driver-broker.ws.bolt.eu";
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String e() {
        return this.f24054e.d();
    }

    @Override // eu.bolt.chat.chatcore.user.MqttInfoProvider
    public String f() {
        String t7 = t();
        String c8 = this.f24054e.c();
        return t7 + ":" + c8;
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String g() {
        return "android";
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String getDeviceId() {
        return this.f24054e.c();
    }

    @Override // eu.bolt.chat.chatcore.user.MqttInfoProvider
    public String h() {
        String a8;
        AccessToken c8 = this.f24051b.q().c();
        if (c8 == null || (a8 = c8.a()) == null) {
            return "";
        }
        return a8;
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String i() {
        return "node.bolt.eu";
    }

    @Override // eu.bolt.chat.chatcore.user.MqttInfoProvider
    public String j() {
        String t7 = t();
        return "pub/" + t7;
    }

    @Override // eu.bolt.chat.chatcore.user.UserInfoProvider
    public String k() {
        String r7 = r();
        String t7 = t();
        return r7 + ":" + t7;
    }

    @Override // eu.bolt.chat.chatcore.user.UserInfoProvider
    public String l() {
        return c();
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String m() {
        return this.f24054e.a();
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String n() {
        return t();
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String o() {
        return this.f24054e.b();
    }

    @Override // eu.bolt.chat.chatcore.user.MqttInfoProvider
    public String p() {
        return "";
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String q() {
        DriverConfig d8 = this.f24050a.d();
        if (d8 != null) {
            return d8.j();
        }
        return null;
    }

    @Override // eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider
    public String r() {
        return "driver";
    }

    @Override // eu.bolt.chat.chatcore.user.MqttInfoProvider
    public String s() {
        String t7 = t();
        return "sub/" + t7;
    }
}
