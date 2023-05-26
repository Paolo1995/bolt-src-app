package ee.mtakso.driver.ui.screens.boltclub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.boltclub.BoltClubApi;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BoltClubClient_Factory implements Factory<BoltClubClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BoltClubApi> f27113a;

    public BoltClubClient_Factory(Provider<BoltClubApi> provider) {
        this.f27113a = provider;
    }

    public static BoltClubClient_Factory a(Provider<BoltClubApi> provider) {
        return new BoltClubClient_Factory(provider);
    }

    public static BoltClubClient c(BoltClubApi boltClubApi) {
        return new BoltClubClient(boltClubApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BoltClubClient get() {
        return c(this.f27113a.get());
    }
}
