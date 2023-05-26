package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SupportDeeplinkMapper_Factory implements Factory<SupportDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final SupportDeeplinkMapper_Factory f29999a = new SupportDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SupportDeeplinkMapper_Factory a() {
        return InstanceHolder.f29999a;
    }

    public static SupportDeeplinkMapper c() {
        return new SupportDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SupportDeeplinkMapper get() {
        return c();
    }
}
