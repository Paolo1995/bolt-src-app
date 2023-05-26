package ee.mtakso.driver.utils.effects;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class EffectsFactory_Factory implements Factory<EffectsFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f36411a;

    public EffectsFactory_Factory(Provider<Context> provider) {
        this.f36411a = provider;
    }

    public static EffectsFactory_Factory a(Provider<Context> provider) {
        return new EffectsFactory_Factory(provider);
    }

    public static EffectsFactory c(Context context) {
        return new EffectsFactory(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EffectsFactory get() {
        return c(this.f36411a.get());
    }
}
