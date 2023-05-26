package ee.mtakso.driver.service.push;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PushManagerImpl_Factory implements Factory<PushManagerImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Set<PushHandler>> f25609a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PushTokenManager> f25610b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Context> f25611c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<TokenProvider> f25612d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AuthManager> f25613e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<UiNotificationManager> f25614f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<PushTokenAnalytics> f25615g;

    public PushManagerImpl_Factory(Provider<Set<PushHandler>> provider, Provider<PushTokenManager> provider2, Provider<Context> provider3, Provider<TokenProvider> provider4, Provider<AuthManager> provider5, Provider<UiNotificationManager> provider6, Provider<PushTokenAnalytics> provider7) {
        this.f25609a = provider;
        this.f25610b = provider2;
        this.f25611c = provider3;
        this.f25612d = provider4;
        this.f25613e = provider5;
        this.f25614f = provider6;
        this.f25615g = provider7;
    }

    public static PushManagerImpl_Factory a(Provider<Set<PushHandler>> provider, Provider<PushTokenManager> provider2, Provider<Context> provider3, Provider<TokenProvider> provider4, Provider<AuthManager> provider5, Provider<UiNotificationManager> provider6, Provider<PushTokenAnalytics> provider7) {
        return new PushManagerImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PushManagerImpl c(Set<PushHandler> set, PushTokenManager pushTokenManager, Context context, TokenProvider tokenProvider, AuthManager authManager, UiNotificationManager uiNotificationManager, PushTokenAnalytics pushTokenAnalytics) {
        return new PushManagerImpl(set, pushTokenManager, context, tokenProvider, authManager, uiNotificationManager, pushTokenAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PushManagerImpl get() {
        return c(this.f25609a.get(), this.f25610b.get(), this.f25611c.get(), this.f25612d.get(), this.f25613e.get(), this.f25614f.get(), this.f25615g.get());
    }
}
