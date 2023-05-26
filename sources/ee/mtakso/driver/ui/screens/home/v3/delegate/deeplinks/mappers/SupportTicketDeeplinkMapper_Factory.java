package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SupportTicketDeeplinkMapper_Factory implements Factory<SupportTicketDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final SupportTicketDeeplinkMapper_Factory f30000a = new SupportTicketDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SupportTicketDeeplinkMapper_Factory a() {
        return InstanceHolder.f30000a;
    }

    public static SupportTicketDeeplinkMapper c() {
        return new SupportTicketDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SupportTicketDeeplinkMapper get() {
        return c();
    }
}
