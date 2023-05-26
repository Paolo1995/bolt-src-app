package ee.mtakso.driver.di.modules;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.network.ClientFactory;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* compiled from: ReleaseNetworkModule.kt */
@Module(includes = {NetworkModule.class})
/* loaded from: classes3.dex */
public final class ReleaseNetworkModule {
    @Provides
    @Singleton
    public final OkHttpClient a(ClientFactory factory) {
        Intrinsics.f(factory, "factory");
        return factory.e();
    }
}
