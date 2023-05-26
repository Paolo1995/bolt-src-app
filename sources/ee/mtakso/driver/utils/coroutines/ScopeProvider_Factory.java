package ee.mtakso.driver.utils.coroutines;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ScopeProvider_Factory implements Factory<ScopeProvider> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ScopeProvider_Factory f36389a = new ScopeProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static ScopeProvider_Factory a() {
        return InstanceHolder.f36389a;
    }

    public static ScopeProvider c() {
        return new ScopeProvider();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScopeProvider get() {
        return c();
    }
}
