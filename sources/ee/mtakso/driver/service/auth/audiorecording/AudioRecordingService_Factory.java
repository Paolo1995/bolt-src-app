package ee.mtakso.driver.service.auth.audiorecording;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider;
import ee.mtakso.driver.utils.coroutines.ScopeProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AudioRecordingService_Factory implements Factory<AudioRecordingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScopeProvider> f23757a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DispatcherProvider> f23758b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderProvider> f23759c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AudioRecordingManager> f23760d;

    public AudioRecordingService_Factory(Provider<ScopeProvider> provider, Provider<DispatcherProvider> provider2, Provider<OrderProvider> provider3, Provider<AudioRecordingManager> provider4) {
        this.f23757a = provider;
        this.f23758b = provider2;
        this.f23759c = provider3;
        this.f23760d = provider4;
    }

    public static AudioRecordingService_Factory a(Provider<ScopeProvider> provider, Provider<DispatcherProvider> provider2, Provider<OrderProvider> provider3, Provider<AudioRecordingManager> provider4) {
        return new AudioRecordingService_Factory(provider, provider2, provider3, provider4);
    }

    public static AudioRecordingService c(ScopeProvider scopeProvider, DispatcherProvider dispatcherProvider, OrderProvider orderProvider, AudioRecordingManager audioRecordingManager) {
        return new AudioRecordingService(scopeProvider, dispatcherProvider, orderProvider, audioRecordingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingService get() {
        return c(this.f23757a.get(), this.f23758b.get(), this.f23759c.get(), this.f23760d.get());
    }
}
