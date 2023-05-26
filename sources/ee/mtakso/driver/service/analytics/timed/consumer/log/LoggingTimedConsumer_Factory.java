package ee.mtakso.driver.service.analytics.timed.consumer.log;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LoggingTimedConsumer_Factory implements Factory<LoggingTimedConsumer> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final LoggingTimedConsumer_Factory f23547a = new LoggingTimedConsumer_Factory();

        private InstanceHolder() {
        }
    }

    public static LoggingTimedConsumer_Factory a() {
        return InstanceHolder.f23547a;
    }

    public static LoggingTimedConsumer c() {
        return new LoggingTimedConsumer();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LoggingTimedConsumer get() {
        return c();
    }
}
