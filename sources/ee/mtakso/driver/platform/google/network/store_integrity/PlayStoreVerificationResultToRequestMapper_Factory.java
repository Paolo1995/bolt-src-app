package ee.mtakso.driver.platform.google.network.store_integrity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PlayStoreVerificationResultToRequestMapper_Factory implements Factory<PlayStoreVerificationResultToRequestMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PlayStoreVerificationResultToRequestMapper_Factory f23333a = new PlayStoreVerificationResultToRequestMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static PlayStoreVerificationResultToRequestMapper_Factory a() {
        return InstanceHolder.f23333a;
    }

    public static PlayStoreVerificationResultToRequestMapper c() {
        return new PlayStoreVerificationResultToRequestMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PlayStoreVerificationResultToRequestMapper get() {
        return c();
    }
}
