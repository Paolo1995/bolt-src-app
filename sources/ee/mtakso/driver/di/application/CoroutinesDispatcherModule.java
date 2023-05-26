package ee.mtakso.driver.di.application;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: CoroutinesDispatcherModule.kt */
@Module
/* loaded from: classes3.dex */
public final class CoroutinesDispatcherModule {
    @Provides
    @Singleton
    public final CoroutineDispatcher a(DispatcherProvider provider) {
        Intrinsics.f(provider, "provider");
        return provider.a();
    }
}
