package eu.bolt.driver.chat.helper;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SoundEffectsPool_Factory implements Factory<SoundEffectsPool> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f40420a;

    public SoundEffectsPool_Factory(Provider<Context> provider) {
        this.f40420a = provider;
    }

    public static SoundEffectsPool_Factory a(Provider<Context> provider) {
        return new SoundEffectsPool_Factory(provider);
    }

    public static SoundEffectsPool c(Context context) {
        return new SoundEffectsPool(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SoundEffectsPool get() {
        return c(this.f40420a.get());
    }
}
