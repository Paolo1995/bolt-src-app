package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StartRecordingInteractor_Factory implements Factory<StartRecordingInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f32589a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AudioRecordingClient> f32590b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AudioRecordingManager> f32591c;

    public StartRecordingInteractor_Factory(Provider<OrderProvider> provider, Provider<AudioRecordingClient> provider2, Provider<AudioRecordingManager> provider3) {
        this.f32589a = provider;
        this.f32590b = provider2;
        this.f32591c = provider3;
    }

    public static StartRecordingInteractor_Factory a(Provider<OrderProvider> provider, Provider<AudioRecordingClient> provider2, Provider<AudioRecordingManager> provider3) {
        return new StartRecordingInteractor_Factory(provider, provider2, provider3);
    }

    public static StartRecordingInteractor c(OrderProvider orderProvider, AudioRecordingClient audioRecordingClient, AudioRecordingManager audioRecordingManager) {
        return new StartRecordingInteractor(orderProvider, audioRecordingClient, audioRecordingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StartRecordingInteractor get() {
        return c(this.f32589a.get(), this.f32590b.get(), this.f32591c.get());
    }
}
