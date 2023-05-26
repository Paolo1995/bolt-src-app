package ee.mtakso.driver.log.applog;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ApplogFactory_Factory implements Factory<ApplogFactory> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ApplogFactory_Factory f21056a = new ApplogFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static ApplogFactory_Factory a() {
        return InstanceHolder.f21056a;
    }

    public static ApplogFactory c() {
        return new ApplogFactory();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ApplogFactory get() {
        return c();
    }
}
