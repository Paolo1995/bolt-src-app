package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"eu.bolt.driver.core.di.coroutine.dispatcher.DispatcherIO"})
/* loaded from: classes3.dex */
public final class AudioRecordingManager_Factory implements Factory<AudioRecordingManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AudioRecorderApi> f32611a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CoroutineDispatcher> f32612b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AudioRecordingMapper> f32613c;

    public AudioRecordingManager_Factory(Provider<AudioRecorderApi> provider, Provider<CoroutineDispatcher> provider2, Provider<AudioRecordingMapper> provider3) {
        this.f32611a = provider;
        this.f32612b = provider2;
        this.f32613c = provider3;
    }

    public static AudioRecordingManager_Factory a(Provider<AudioRecorderApi> provider, Provider<CoroutineDispatcher> provider2, Provider<AudioRecordingMapper> provider3) {
        return new AudioRecordingManager_Factory(provider, provider2, provider3);
    }

    public static AudioRecordingManager c(AudioRecorderApi audioRecorderApi, CoroutineDispatcher coroutineDispatcher, AudioRecordingMapper audioRecordingMapper) {
        return new AudioRecordingManager(audioRecorderApi, coroutineDispatcher, audioRecordingMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingManager get() {
        return c(this.f32611a.get(), this.f32612b.get(), this.f32613c.get());
    }
}
