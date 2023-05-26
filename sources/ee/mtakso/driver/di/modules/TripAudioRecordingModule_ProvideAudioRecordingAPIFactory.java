package ee.mtakso.driver.di.modules;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TripAudioRecordingModule_ProvideAudioRecordingAPIFactory implements Factory<AudioRecorderApi> {

    /* renamed from: a  reason: collision with root package name */
    private final TripAudioRecordingModule f20877a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f20878b;

    public TripAudioRecordingModule_ProvideAudioRecordingAPIFactory(TripAudioRecordingModule tripAudioRecordingModule, Provider<Context> provider) {
        this.f20877a = tripAudioRecordingModule;
        this.f20878b = provider;
    }

    public static TripAudioRecordingModule_ProvideAudioRecordingAPIFactory a(TripAudioRecordingModule tripAudioRecordingModule, Provider<Context> provider) {
        return new TripAudioRecordingModule_ProvideAudioRecordingAPIFactory(tripAudioRecordingModule, provider);
    }

    public static AudioRecorderApi c(TripAudioRecordingModule tripAudioRecordingModule, Context context) {
        return (AudioRecorderApi) Preconditions.checkNotNullFromProvides(tripAudioRecordingModule.a(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecorderApi get() {
        return c(this.f20877a, this.f20878b.get());
    }
}
