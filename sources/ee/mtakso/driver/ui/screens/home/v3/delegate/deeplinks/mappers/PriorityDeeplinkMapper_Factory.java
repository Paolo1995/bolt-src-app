package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PriorityDeeplinkMapper_Factory implements Factory<PriorityDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PriorityDeeplinkMapper_Factory f29994a = new PriorityDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static PriorityDeeplinkMapper_Factory a() {
        return InstanceHolder.f29994a;
    }

    public static PriorityDeeplinkMapper c() {
        return new PriorityDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PriorityDeeplinkMapper get() {
        return c();
    }
}
