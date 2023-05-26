package ee.mtakso.driver.network.client.contact;

import ee.mtakso.driver.network.client.contact.ContactConfiguration;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactConfiguration.kt */
/* loaded from: classes3.dex */
public final class VoipConfiguration extends ContactConfiguration {

    /* renamed from: b  reason: collision with root package name */
    private final ContactConfiguration.Type f21798b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21799c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21800d;

    /* renamed from: e  reason: collision with root package name */
    private final String f21801e;

    /* renamed from: f  reason: collision with root package name */
    private final String f21802f;

    /* renamed from: g  reason: collision with root package name */
    private final String f21803g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoipConfiguration(Map<String, String> fields) {
        super(null);
        Intrinsics.f(fields, "fields");
        this.f21798b = ContactConfiguration.Type.VOIP;
        this.f21799c = (String) MapsKt.g(fields, "provider");
        this.f21800d = (String) MapsKt.g(fields, "application_key");
        this.f21801e = (String) MapsKt.g(fields, "voip_id");
        this.f21802f = (String) MapsKt.g(fields, "access_token");
        this.f21803g = (String) MapsKt.g(fields, "token_expiry");
    }

    @Override // ee.mtakso.driver.network.client.contact.ContactConfiguration
    public ContactConfiguration.Type a() {
        return this.f21798b;
    }

    public final String b() {
        return this.f21800d;
    }

    public final String c() {
        return this.f21799c;
    }

    public final String d() {
        return this.f21802f;
    }

    public final String e() {
        return this.f21801e;
    }
}
