package ee.mtakso.driver.network.client.audio_recording.upload;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AudioRecordingUploadClient_Factory implements Factory<AudioRecordingUploadClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AudioRecordingUploadAPI> f21389a;

    public AudioRecordingUploadClient_Factory(Provider<AudioRecordingUploadAPI> provider) {
        this.f21389a = provider;
    }

    public static AudioRecordingUploadClient_Factory a(Provider<AudioRecordingUploadAPI> provider) {
        return new AudioRecordingUploadClient_Factory(provider);
    }

    public static AudioRecordingUploadClient c(AudioRecordingUploadAPI audioRecordingUploadAPI) {
        return new AudioRecordingUploadClient(audioRecordingUploadAPI);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingUploadClient get() {
        return c(this.f21389a.get());
    }
}
