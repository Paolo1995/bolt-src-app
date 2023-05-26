package eu.bolt.driver.core.time;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SystemUptimeSource_Factory implements Factory<SystemUptimeSource> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final SystemUptimeSource_Factory f40989a = new SystemUptimeSource_Factory();

        private InstanceHolder() {
        }
    }

    public static SystemUptimeSource_Factory a() {
        return InstanceHolder.f40989a;
    }

    public static SystemUptimeSource c() {
        return new SystemUptimeSource();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SystemUptimeSource get() {
        return c();
    }
}
