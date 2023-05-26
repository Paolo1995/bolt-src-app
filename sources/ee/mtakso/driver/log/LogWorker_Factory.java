package ee.mtakso.driver.log;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogWorker_Factory implements Factory<LogWorker> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final LogWorker_Factory f21033a = new LogWorker_Factory();

        private InstanceHolder() {
        }
    }

    public static LogWorker_Factory a() {
        return InstanceHolder.f21033a;
    }

    public static LogWorker c() {
        return new LogWorker();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LogWorker get() {
        return c();
    }
}
