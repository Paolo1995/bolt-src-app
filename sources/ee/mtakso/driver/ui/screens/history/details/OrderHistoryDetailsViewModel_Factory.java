package ee.mtakso.driver.ui.screens.history.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.audio_recording.support.TripAudioSupportClient;
import ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.network.client.order.RideHistoryClient;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import eu.bolt.driver.core.util.DateTimeFormatter;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderHistoryDetailsViewModel_Factory implements Factory<OrderHistoryDetailsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AudioRecordingManager> f29507a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AudioRecordingMapper> f29508b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DateTimeFormatter> f29509c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f29510d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HistoryAnalytics> f29511e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ContactClient> f29512f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<RideHistoryClient> f29513g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<SupportClient> f29514h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f29515i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<TripAudioSupportClient> f29516j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<UploadAudioRecordingManager> f29517k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<AudioRecordingAnalytics> f29518l;

    public OrderHistoryDetailsViewModel_Factory(Provider<AudioRecordingManager> provider, Provider<AudioRecordingMapper> provider2, Provider<DateTimeFormatter> provider3, Provider<DriverProvider> provider4, Provider<HistoryAnalytics> provider5, Provider<ContactClient> provider6, Provider<RideHistoryClient> provider7, Provider<SupportClient> provider8, Provider<TrueTimeProvider> provider9, Provider<TripAudioSupportClient> provider10, Provider<UploadAudioRecordingManager> provider11, Provider<AudioRecordingAnalytics> provider12) {
        this.f29507a = provider;
        this.f29508b = provider2;
        this.f29509c = provider3;
        this.f29510d = provider4;
        this.f29511e = provider5;
        this.f29512f = provider6;
        this.f29513g = provider7;
        this.f29514h = provider8;
        this.f29515i = provider9;
        this.f29516j = provider10;
        this.f29517k = provider11;
        this.f29518l = provider12;
    }

    public static OrderHistoryDetailsViewModel_Factory a(Provider<AudioRecordingManager> provider, Provider<AudioRecordingMapper> provider2, Provider<DateTimeFormatter> provider3, Provider<DriverProvider> provider4, Provider<HistoryAnalytics> provider5, Provider<ContactClient> provider6, Provider<RideHistoryClient> provider7, Provider<SupportClient> provider8, Provider<TrueTimeProvider> provider9, Provider<TripAudioSupportClient> provider10, Provider<UploadAudioRecordingManager> provider11, Provider<AudioRecordingAnalytics> provider12) {
        return new OrderHistoryDetailsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static OrderHistoryDetailsViewModel c(AudioRecordingManager audioRecordingManager, AudioRecordingMapper audioRecordingMapper, DateTimeFormatter dateTimeFormatter, DriverProvider driverProvider, HistoryAnalytics historyAnalytics, ContactClient contactClient, RideHistoryClient rideHistoryClient, SupportClient supportClient, TrueTimeProvider trueTimeProvider, TripAudioSupportClient tripAudioSupportClient, UploadAudioRecordingManager uploadAudioRecordingManager, AudioRecordingAnalytics audioRecordingAnalytics) {
        return new OrderHistoryDetailsViewModel(audioRecordingManager, audioRecordingMapper, dateTimeFormatter, driverProvider, historyAnalytics, contactClient, rideHistoryClient, supportClient, trueTimeProvider, tripAudioSupportClient, uploadAudioRecordingManager, audioRecordingAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderHistoryDetailsViewModel get() {
        return c(this.f29507a.get(), this.f29508b.get(), this.f29509c.get(), this.f29510d.get(), this.f29511e.get(), this.f29512f.get(), this.f29513g.get(), this.f29514h.get(), this.f29515i.get(), this.f29516j.get(), this.f29517k.get(), this.f29518l.get());
    }
}
