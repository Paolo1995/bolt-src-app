package ee.mtakso.driver.service.modules.reminder;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AutoReminderImpl_Factory implements Factory<AutoReminderImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UpcomingStopDistanceService> f25206a;

    public AutoReminderImpl_Factory(Provider<UpcomingStopDistanceService> provider) {
        this.f25206a = provider;
    }

    public static AutoReminderImpl_Factory a(Provider<UpcomingStopDistanceService> provider) {
        return new AutoReminderImpl_Factory(provider);
    }

    public static AutoReminderImpl c(UpcomingStopDistanceService upcomingStopDistanceService) {
        return new AutoReminderImpl(upcomingStopDistanceService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AutoReminderImpl get() {
        return c(this.f25206a.get());
    }
}
