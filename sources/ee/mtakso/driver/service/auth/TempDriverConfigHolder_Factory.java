package ee.mtakso.driver.service.auth;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TempDriverConfigHolder_Factory implements Factory<TempDriverConfigHolder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final TempDriverConfigHolder_Factory f23749a = new TempDriverConfigHolder_Factory();

        private InstanceHolder() {
        }
    }

    public static TempDriverConfigHolder_Factory a() {
        return InstanceHolder.f23749a;
    }

    public static TempDriverConfigHolder c() {
        return new TempDriverConfigHolder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TempDriverConfigHolder get() {
        return c();
    }
}
