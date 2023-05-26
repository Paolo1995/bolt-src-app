package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.StartRecordingInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AudioRecordingViewModel_Factory implements Factory<AudioRecordingViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AudioRecordingManager> f32563a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StartRecordingInteractor> f32564b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AudioRecordingAnalytics> f32565c;

    public AudioRecordingViewModel_Factory(Provider<AudioRecordingManager> provider, Provider<StartRecordingInteractor> provider2, Provider<AudioRecordingAnalytics> provider3) {
        this.f32563a = provider;
        this.f32564b = provider2;
        this.f32565c = provider3;
    }

    public static AudioRecordingViewModel_Factory a(Provider<AudioRecordingManager> provider, Provider<StartRecordingInteractor> provider2, Provider<AudioRecordingAnalytics> provider3) {
        return new AudioRecordingViewModel_Factory(provider, provider2, provider3);
    }

    public static AudioRecordingViewModel c(AudioRecordingManager audioRecordingManager, StartRecordingInteractor startRecordingInteractor, AudioRecordingAnalytics audioRecordingAnalytics) {
        return new AudioRecordingViewModel(audioRecordingManager, startRecordingInteractor, audioRecordingAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingViewModel get() {
        return c(this.f32563a.get(), this.f32564b.get(), this.f32565c.get());
    }
}
