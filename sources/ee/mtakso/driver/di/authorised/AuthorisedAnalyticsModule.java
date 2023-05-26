package ee.mtakso.driver.di.authorised;

import dagger.Binds;
import dagger.Module;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl;
import ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AutoAcceptanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.BackendModalDialogAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DestinationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.EarningsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics;
import ee.mtakso.driver.service.analytics.event.facade.HeatmapAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsImpl;
import ee.mtakso.driver.service.analytics.timed.facade.RateMeTracing;
import eu.bolt.driver.chat.service.analytics.ChatAnalytics;
import eu.bolt.driver.stories.service.analytic.StoryAnalytics;

/* compiled from: AuthorisedAnalyticsModule.kt */
@Module
/* loaded from: classes3.dex */
public interface AuthorisedAnalyticsModule {
    @Binds
    AutoAcceptanceAnalytics a(AnalyticsImpl analyticsImpl);

    @Binds
    PushTokenAnalytics b(AnalyticsImpl analyticsImpl);

    @Binds
    OrderAnalytics c(AnalyticsImpl analyticsImpl);

    @Binds
    AppStateAnalytics d(AnalyticsImpl analyticsImpl);

    @Binds
    RateMeAnalytics e(AnalyticsImpl analyticsImpl);

    @Binds
    StoryAnalytics f(AnalyticsImpl analyticsImpl);

    @Binds
    RateMeTracing g(TimedAnalyticsImpl timedAnalyticsImpl);

    @Binds
    EarningsGoalAnalytics h(AnalyticsImpl analyticsImpl);

    @Binds
    EarningsV2Analytics i(AnalyticsImpl analyticsImpl);

    @Binds
    ChatAnalytics j(AnalyticsImpl analyticsImpl);

    @Binds
    DestinationAnalytics k(AnalyticsImpl analyticsImpl);

    @Binds
    EarningsAnalytics l(AnalyticsImpl analyticsImpl);

    @Binds
    DriverScoreAnalytics m(AnalyticsImpl analyticsImpl);

    @Binds
    BackendModalDialogAnalytics n(AnalyticsImpl analyticsImpl);

    @Binds
    HeatmapAnalytics o(AnalyticsImpl analyticsImpl);

    @Binds
    DriverPricingAnalytics p(AnalyticsImpl analyticsImpl);
}
