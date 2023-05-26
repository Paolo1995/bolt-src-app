package ee.mtakso.driver.log;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogFilter_Factory implements Factory<LogFilter> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final LogFilter_Factory f21006a = new LogFilter_Factory();

        private InstanceHolder() {
        }
    }

    public static LogFilter_Factory a() {
        return InstanceHolder.f21006a;
    }

    public static LogFilter c() {
        return new LogFilter();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LogFilter get() {
        return c();
    }
}
