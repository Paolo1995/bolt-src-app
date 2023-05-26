package ee.mtakso.driver.network.client.modal;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ModalClient_Factory implements Factory<ModalClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ModalApi> f22281a;

    public ModalClient_Factory(Provider<ModalApi> provider) {
        this.f22281a = provider;
    }

    public static ModalClient_Factory a(Provider<ModalApi> provider) {
        return new ModalClient_Factory(provider);
    }

    public static ModalClient c(Lazy<ModalApi> lazy) {
        return new ModalClient(lazy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ModalClient get() {
        return c(DoubleCheck.lazy(this.f22281a));
    }
}
