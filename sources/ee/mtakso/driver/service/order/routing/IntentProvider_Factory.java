package ee.mtakso.driver.service.order.routing;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IntentProvider_Factory implements Factory<IntentProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f25500a;

    public IntentProvider_Factory(Provider<Context> provider) {
        this.f25500a = provider;
    }

    public static IntentProvider_Factory a(Provider<Context> provider) {
        return new IntentProvider_Factory(provider);
    }

    public static IntentProvider c(Context context) {
        return new IntentProvider(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IntentProvider get() {
        return c(this.f25500a.get());
    }
}
