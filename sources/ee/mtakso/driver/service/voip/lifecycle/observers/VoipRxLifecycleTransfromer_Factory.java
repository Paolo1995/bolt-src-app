package ee.mtakso.driver.service.voip.lifecycle.observers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipRxLifecycleTransfromer_Factory implements Factory<VoipRxLifecycleTransfromer> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final VoipRxLifecycleTransfromer_Factory f26172a = new VoipRxLifecycleTransfromer_Factory();

        private InstanceHolder() {
        }
    }

    public static VoipRxLifecycleTransfromer_Factory a() {
        return InstanceHolder.f26172a;
    }

    public static VoipRxLifecycleTransfromer c() {
        return new VoipRxLifecycleTransfromer();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipRxLifecycleTransfromer get() {
        return c();
    }
}
