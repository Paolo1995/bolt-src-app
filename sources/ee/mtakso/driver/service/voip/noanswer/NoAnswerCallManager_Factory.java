package ee.mtakso.driver.service.voip.noanswer;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.BackgroundManager;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NoAnswerCallManager_Factory implements Factory<NoAnswerCallManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f26189a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackgroundManager> f26190b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<NoAnswerCallCache> f26191c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<VoipNotificationDrawer> f26192d;

    public NoAnswerCallManager_Factory(Provider<OrderProvider> provider, Provider<BackgroundManager> provider2, Provider<NoAnswerCallCache> provider3, Provider<VoipNotificationDrawer> provider4) {
        this.f26189a = provider;
        this.f26190b = provider2;
        this.f26191c = provider3;
        this.f26192d = provider4;
    }

    public static NoAnswerCallManager_Factory a(Provider<OrderProvider> provider, Provider<BackgroundManager> provider2, Provider<NoAnswerCallCache> provider3, Provider<VoipNotificationDrawer> provider4) {
        return new NoAnswerCallManager_Factory(provider, provider2, provider3, provider4);
    }

    public static NoAnswerCallManager c(OrderProvider orderProvider, BackgroundManager backgroundManager, NoAnswerCallCache noAnswerCallCache, VoipNotificationDrawer voipNotificationDrawer) {
        return new NoAnswerCallManager(orderProvider, backgroundManager, noAnswerCallCache, voipNotificationDrawer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NoAnswerCallManager get() {
        return c(this.f26189a.get(), this.f26190b.get(), this.f26191c.get(), this.f26192d.get());
    }
}
