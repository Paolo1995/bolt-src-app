package ee.mtakso.driver.ui.screens.order.v2.order;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.route_sharing.RouteSharingClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RouteSharingInteractor_Factory implements Factory<RouteSharingInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RouteSharingClient> f32325a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f32326b;

    public RouteSharingInteractor_Factory(Provider<RouteSharingClient> provider, Provider<Context> provider2) {
        this.f32325a = provider;
        this.f32326b = provider2;
    }

    public static RouteSharingInteractor_Factory a(Provider<RouteSharingClient> provider, Provider<Context> provider2) {
        return new RouteSharingInteractor_Factory(provider, provider2);
    }

    public static RouteSharingInteractor c(RouteSharingClient routeSharingClient, Context context) {
        return new RouteSharingInteractor(routeSharingClient, context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RouteSharingInteractor get() {
        return c(this.f32325a.get(), this.f32326b.get());
    }
}
