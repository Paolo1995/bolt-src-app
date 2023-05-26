package ee.mtakso.driver.service.voip;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.voip.extractor.VoipInfoExtractorFactory;
import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObservableImpl;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipService_Factory implements Factory<VoipService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipInfoExtractorFactory> f26130a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f26131b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<VoipLifecycleObservableImpl> f26132c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PermissionManager> f26133d;

    public VoipService_Factory(Provider<VoipInfoExtractorFactory> provider, Provider<Context> provider2, Provider<VoipLifecycleObservableImpl> provider3, Provider<PermissionManager> provider4) {
        this.f26130a = provider;
        this.f26131b = provider2;
        this.f26132c = provider3;
        this.f26133d = provider4;
    }

    public static VoipService_Factory a(Provider<VoipInfoExtractorFactory> provider, Provider<Context> provider2, Provider<VoipLifecycleObservableImpl> provider3, Provider<PermissionManager> provider4) {
        return new VoipService_Factory(provider, provider2, provider3, provider4);
    }

    public static VoipService c(VoipInfoExtractorFactory voipInfoExtractorFactory, Context context, VoipLifecycleObservableImpl voipLifecycleObservableImpl, PermissionManager permissionManager) {
        return new VoipService(voipInfoExtractorFactory, context, voipLifecycleObservableImpl, permissionManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipService get() {
        return c(this.f26130a.get(), this.f26131b.get(), this.f26132c.get(), this.f26133d.get());
    }
}
