package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.coroutines.dispatchers.DispatchersBundle;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class re implements Factory<qe> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchersBundle> f44810a;

    public re(Provider<DispatchersBundle> provider) {
        this.f44810a = provider;
    }

    public static qe b(DispatchersBundle dispatchersBundle) {
        return new qe(dispatchersBundle);
    }

    public static re c(Provider<DispatchersBundle> provider) {
        return new re(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public qe get() {
        return b(this.f44810a.get());
    }
}
