package ee.mtakso.driver.utils.coroutines;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class DispatcherProvider_Factory implements Factory<DispatcherProvider> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DispatcherProvider_Factory f36388a = new DispatcherProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static DispatcherProvider_Factory a() {
        return InstanceHolder.f36388a;
    }

    public static DispatcherProvider c() {
        return new DispatcherProvider();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DispatcherProvider get() {
        return c();
    }
}
