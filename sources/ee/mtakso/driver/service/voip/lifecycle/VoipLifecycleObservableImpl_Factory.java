package ee.mtakso.driver.service.voip.lifecycle;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.modules.IncomingCallObservers", "ee.mtakso.driver.di.modules.OutgoingCallObservers"})
/* loaded from: classes3.dex */
public final class VoipLifecycleObservableImpl_Factory implements Factory<VoipLifecycleObservableImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Set<VoipLifecycleObserver>> f26149a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Set<VoipLifecycleObserver>> f26150b;

    public VoipLifecycleObservableImpl_Factory(Provider<Set<VoipLifecycleObserver>> provider, Provider<Set<VoipLifecycleObserver>> provider2) {
        this.f26149a = provider;
        this.f26150b = provider2;
    }

    public static VoipLifecycleObservableImpl_Factory a(Provider<Set<VoipLifecycleObserver>> provider, Provider<Set<VoipLifecycleObserver>> provider2) {
        return new VoipLifecycleObservableImpl_Factory(provider, provider2);
    }

    public static VoipLifecycleObservableImpl c(Set<VoipLifecycleObserver> set, Set<VoipLifecycleObserver> set2) {
        return new VoipLifecycleObservableImpl(set, set2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipLifecycleObservableImpl get() {
        return c(this.f26149a.get(), this.f26150b.get());
    }
}
