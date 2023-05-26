package ee.mtakso.driver.di.modules;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;
import ee.mtakso.driver.service.analytics.event.AnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl;
import ee.mtakso.driver.service.analytics.event.consumer.CrashlyticsAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.FirebaseAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.InternalAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.LeadInternalAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.LoggingAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AppVerificationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DeviceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ProcessRestorationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SignUpAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsImpl;
import ee.mtakso.driver.service.analytics.timed.TimedConsumer;
import ee.mtakso.driver.service.analytics.timed.consumer.firebase.FirebaseTimedConsumer;
import ee.mtakso.driver.service.analytics.timed.consumer.log.LoggingTimedConsumer;
import ee.mtakso.driver.service.analytics.timed.facade.OrderTracing;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.modules.reporters.AppReporter;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import eu.bolt.driver.verification.identity.VerificationAnalytics;
import java.util.Collections;
import java.util.Set;

@Module
/* loaded from: classes3.dex */
public abstract class AnalyticsModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static FirebaseAnalytics J(Context context) {
        return FirebaseAnalytics.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @ElementsIntoSet
    public static Set<AnalyticsConsumer> K(LoggingAnalyticsConsumer loggingAnalyticsConsumer) {
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @ElementsIntoSet
    public static Set<TimedConsumer> L(LoggingTimedConsumer loggingTimedConsumer) {
        return Collections.emptySet();
    }

    @Binds
    abstract PushTokenAnalytics A(AnalyticsImpl analyticsImpl);

    @Binds
    abstract QuickAccessStateAnalytics B(AnalyticsImpl analyticsImpl);

    @Binds
    abstract SafetyToolkitAnalytics C(AnalyticsImpl analyticsImpl);

    @Binds
    abstract ScreenAnalytics D(AnalyticsImpl analyticsImpl);

    @Binds
    abstract SignUpAnalytics E(AnalyticsImpl analyticsImpl);

    @Binds
    abstract StartUpTracing F(TimedAnalyticsImpl timedAnalyticsImpl);

    @Binds
    abstract NetworkErrorAnalytics G(AnalyticsImpl analyticsImpl);

    @Binds
    abstract VerificationAnalytics H(AnalyticsImpl analyticsImpl);

    @Binds
    abstract WebViewAnalytics I(AnalyticsImpl analyticsImpl);

    @Binds
    abstract NotRespondReporter M(AppReporter appReporter);

    @Binds
    abstract WrongStateReporter N(AppReporter appReporter);

    @Binds
    abstract AppPerformanceAnalytics a(AnalyticsImpl analyticsImpl);

    @Binds
    abstract AppStateAnalytics b(AnalyticsImpl analyticsImpl);

    @Binds
    abstract AppVerificationAnalytics c(AnalyticsImpl analyticsImpl);

    @Binds
    abstract AudioRecordingAnalytics d(AnalyticsImpl analyticsImpl);

    @Binds
    abstract CampaignAnalytics e(AnalyticsImpl analyticsImpl);

    @Binds
    abstract SettingsAnalytics f(AnalyticsImpl analyticsImpl);

    @Binds
    abstract ChatAnalytics g(AnalyticsImpl analyticsImpl);

    @Binds
    @IntoSet
    abstract AnalyticsConsumer h(CrashlyticsAnalyticsConsumer crashlyticsAnalyticsConsumer);

    @Binds
    abstract DeviceAnalytics i(AnalyticsImpl analyticsImpl);

    @Binds
    abstract DriverAnalytics j(AnalyticsImpl analyticsImpl);

    @Binds
    @Deprecated
    abstract OrderTracing k(TimedAnalyticsImpl timedAnalyticsImpl);

    @Binds
    @IntoSet
    abstract AnalyticsConsumer l(FirebaseAnalyticsConsumer firebaseAnalyticsConsumer);

    @Binds
    @IntoSet
    abstract TimedConsumer m(FirebaseTimedConsumer firebaseTimedConsumer);

    @Binds
    abstract HistoryAnalytics n(AnalyticsImpl analyticsImpl);

    @Binds
    @IntoSet
    abstract AnalyticsConsumer o(InternalAnalyticsConsumer internalAnalyticsConsumer);

    @Binds
    abstract ReferralCampaignsAnalytics p(AnalyticsImpl analyticsImpl);

    @Binds
    @IntoSet
    abstract AnalyticsConsumer q(LeadInternalAnalyticsConsumer leadInternalAnalyticsConsumer);

    @Binds
    abstract LoginAnalytics r(AnalyticsImpl analyticsImpl);

    @Binds
    abstract NewsAnalytics s(AnalyticsImpl analyticsImpl);

    @Binds
    abstract OptInCampaignAnalytics t(AnalyticsImpl analyticsImpl);

    @Binds
    abstract OrderAnalytics u(AnalyticsImpl analyticsImpl);

    @Binds
    abstract OrderFlowAnalytics v(AnalyticsImpl analyticsImpl);

    @Binds
    abstract PartnerOffersAnalytics w(AnalyticsImpl analyticsImpl);

    @Binds
    abstract PayoutAnalytics x(AnalyticsImpl analyticsImpl);

    @Binds
    abstract PermissionAnalytics y(AnalyticsImpl analyticsImpl);

    @Binds
    abstract ProcessRestorationAnalytics z(AnalyticsImpl analyticsImpl);
}
