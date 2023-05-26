package ee.mtakso.driver.di.application;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"eu.bolt.driver.core.di.coroutine.dispatcher.DispatcherIO"})
/* loaded from: classes3.dex */
public final class CoroutinesDispatcherModule_ProvideIoDispatcherFactory implements Factory<CoroutineDispatcher> {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutinesDispatcherModule f20275a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DispatcherProvider> f20276b;

    public CoroutinesDispatcherModule_ProvideIoDispatcherFactory(CoroutinesDispatcherModule coroutinesDispatcherModule, Provider<DispatcherProvider> provider) {
        this.f20275a = coroutinesDispatcherModule;
        this.f20276b = provider;
    }

    public static CoroutinesDispatcherModule_ProvideIoDispatcherFactory a(CoroutinesDispatcherModule coroutinesDispatcherModule, Provider<DispatcherProvider> provider) {
        return new CoroutinesDispatcherModule_ProvideIoDispatcherFactory(coroutinesDispatcherModule, provider);
    }

    public static CoroutineDispatcher c(CoroutinesDispatcherModule coroutinesDispatcherModule, DispatcherProvider dispatcherProvider) {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(coroutinesDispatcherModule.a(dispatcherProvider));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CoroutineDispatcher get() {
        return c(this.f20275a, this.f20276b.get());
    }
}
