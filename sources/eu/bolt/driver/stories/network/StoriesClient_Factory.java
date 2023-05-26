package eu.bolt.driver.stories.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StoriesClient_Factory implements Factory<StoriesClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StoriesApi> f41548a;

    public StoriesClient_Factory(Provider<StoriesApi> provider) {
        this.f41548a = provider;
    }

    public static StoriesClient_Factory a(Provider<StoriesApi> provider) {
        return new StoriesClient_Factory(provider);
    }

    public static StoriesClient c(StoriesApi storiesApi) {
        return new StoriesClient(storiesApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoriesClient get() {
        return c(this.f41548a.get());
    }
}
