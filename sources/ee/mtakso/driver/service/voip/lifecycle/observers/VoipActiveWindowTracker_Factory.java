package ee.mtakso.driver.service.voip.lifecycle.observers;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipActiveWindowTracker_Factory implements Factory<VoipActiveWindowTracker> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f26164a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f26165b;

    public VoipActiveWindowTracker_Factory(Provider<Context> provider, Provider<RoutingManager> provider2) {
        this.f26164a = provider;
        this.f26165b = provider2;
    }

    public static VoipActiveWindowTracker_Factory a(Provider<Context> provider, Provider<RoutingManager> provider2) {
        return new VoipActiveWindowTracker_Factory(provider, provider2);
    }

    public static VoipActiveWindowTracker c(Context context, RoutingManager routingManager) {
        return new VoipActiveWindowTracker(context, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipActiveWindowTracker get() {
        return c(this.f26164a.get(), this.f26165b.get());
    }
}
