package ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallManager;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncomingWindowManager_Factory implements Factory<IncomingWindowManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f26177a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NoAnswerCallManager> f26178b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<VoipNotificationDrawer> f26179c;

    public IncomingWindowManager_Factory(Provider<Context> provider, Provider<NoAnswerCallManager> provider2, Provider<VoipNotificationDrawer> provider3) {
        this.f26177a = provider;
        this.f26178b = provider2;
        this.f26179c = provider3;
    }

    public static IncomingWindowManager_Factory a(Provider<Context> provider, Provider<NoAnswerCallManager> provider2, Provider<VoipNotificationDrawer> provider3) {
        return new IncomingWindowManager_Factory(provider, provider2, provider3);
    }

    public static IncomingWindowManager c(Context context, NoAnswerCallManager noAnswerCallManager, VoipNotificationDrawer voipNotificationDrawer) {
        return new IncomingWindowManager(context, noAnswerCallManager, voipNotificationDrawer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingWindowManager get() {
        return c(this.f26177a.get(), this.f26178b.get(), this.f26179c.get());
    }
}
