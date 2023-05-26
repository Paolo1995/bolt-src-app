package ee.mtakso.driver.service.contact;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.voip.VoipService;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ContactOptionsService_Factory implements Factory<ContactOptionsService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ContactClient> f24130a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f24131b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<VoipService> f24132c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PlatformManager> f24133d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ChatService> f24134e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<TokenProvider> f24135f;

    public ContactOptionsService_Factory(Provider<ContactClient> provider, Provider<Features> provider2, Provider<VoipService> provider3, Provider<PlatformManager> provider4, Provider<ChatService> provider5, Provider<TokenProvider> provider6) {
        this.f24130a = provider;
        this.f24131b = provider2;
        this.f24132c = provider3;
        this.f24133d = provider4;
        this.f24134e = provider5;
        this.f24135f = provider6;
    }

    public static ContactOptionsService_Factory a(Provider<ContactClient> provider, Provider<Features> provider2, Provider<VoipService> provider3, Provider<PlatformManager> provider4, Provider<ChatService> provider5, Provider<TokenProvider> provider6) {
        return new ContactOptionsService_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ContactOptionsService c(ContactClient contactClient, Features features, VoipService voipService, PlatformManager platformManager, ChatService chatService, TokenProvider tokenProvider) {
        return new ContactOptionsService(contactClient, features, voipService, platformManager, chatService, tokenProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ContactOptionsService get() {
        return c(this.f24130a.get(), this.f24131b.get(), this.f24132c.get(), this.f24133d.get(), this.f24134e.get(), this.f24135f.get());
    }
}
