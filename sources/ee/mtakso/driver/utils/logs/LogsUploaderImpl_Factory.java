package ee.mtakso.driver.utils.logs;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class LogsUploaderImpl_Factory implements Factory<LogsUploaderImpl> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final LogsUploaderImpl_Factory f36445a = new LogsUploaderImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static LogsUploaderImpl_Factory a() {
        return InstanceHolder.f36445a;
    }

    public static LogsUploaderImpl c() {
        return new LogsUploaderImpl();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LogsUploaderImpl get() {
        return c();
    }
}
