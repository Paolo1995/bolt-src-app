package eu.bolt.driver.core.storage;

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
public final class StorageFactory_Factory implements Factory<StorageFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f40944a;

    public StorageFactory_Factory(Provider<Context> provider) {
        this.f40944a = provider;
    }

    public static StorageFactory_Factory a(Provider<Context> provider) {
        return new StorageFactory_Factory(provider);
    }

    public static StorageFactory c(Context context) {
        return new StorageFactory(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StorageFactory get() {
        return c(this.f40944a.get());
    }
}
