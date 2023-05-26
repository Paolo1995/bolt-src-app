package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TimingHooks_Factory implements Factory<TimingHooks> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final TimingHooks_Factory f20876a = new TimingHooks_Factory();

        private InstanceHolder() {
        }
    }

    public static TimingHooks_Factory a() {
        return InstanceHolder.f20876a;
    }

    public static TimingHooks c() {
        return new TimingHooks();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TimingHooks get() {
        return c();
    }
}
