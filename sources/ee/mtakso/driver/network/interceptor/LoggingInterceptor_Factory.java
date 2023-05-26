package ee.mtakso.driver.network.interceptor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.time.SystemUptimeSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LoggingInterceptor_Factory implements Factory<LoggingInterceptor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SystemUptimeSource> f22966a;

    public LoggingInterceptor_Factory(Provider<SystemUptimeSource> provider) {
        this.f22966a = provider;
    }

    public static LoggingInterceptor_Factory a(Provider<SystemUptimeSource> provider) {
        return new LoggingInterceptor_Factory(provider);
    }

    public static LoggingInterceptor c(SystemUptimeSource systemUptimeSource) {
        return new LoggingInterceptor(systemUptimeSource);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LoggingInterceptor get() {
        return c(this.f22966a.get());
    }
}
