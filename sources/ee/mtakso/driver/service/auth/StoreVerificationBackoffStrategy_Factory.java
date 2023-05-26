package ee.mtakso.driver.service.auth;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StoreVerificationBackoffStrategy_Factory implements Factory<StoreVerificationBackoffStrategy> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final StoreVerificationBackoffStrategy_Factory f23747a = new StoreVerificationBackoffStrategy_Factory();

        private InstanceHolder() {
        }
    }

    public static StoreVerificationBackoffStrategy_Factory a() {
        return InstanceHolder.f23747a;
    }

    public static StoreVerificationBackoffStrategy c() {
        return new StoreVerificationBackoffStrategy();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoreVerificationBackoffStrategy get() {
        return c();
    }
}
