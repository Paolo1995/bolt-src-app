package ee.mtakso.driver.network.client.audio_recording.upload;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"eu.bolt.driver.core.di.coroutine.dispatcher.DispatcherIO"})
/* loaded from: classes3.dex */
public final class UploadAudioRecordingManager_Factory implements Factory<UploadAudioRecordingManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f21418a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AudioRecordingManager> f21419b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AudioRecordingMapper> f21420c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AudioRecordingClient> f21421d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AudioRecordingUploadClient> f21422e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<CoroutineDispatcher> f21423f;

    public UploadAudioRecordingManager_Factory(Provider<Context> provider, Provider<AudioRecordingManager> provider2, Provider<AudioRecordingMapper> provider3, Provider<AudioRecordingClient> provider4, Provider<AudioRecordingUploadClient> provider5, Provider<CoroutineDispatcher> provider6) {
        this.f21418a = provider;
        this.f21419b = provider2;
        this.f21420c = provider3;
        this.f21421d = provider4;
        this.f21422e = provider5;
        this.f21423f = provider6;
    }

    public static UploadAudioRecordingManager_Factory a(Provider<Context> provider, Provider<AudioRecordingManager> provider2, Provider<AudioRecordingMapper> provider3, Provider<AudioRecordingClient> provider4, Provider<AudioRecordingUploadClient> provider5, Provider<CoroutineDispatcher> provider6) {
        return new UploadAudioRecordingManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static UploadAudioRecordingManager c(Context context, AudioRecordingManager audioRecordingManager, AudioRecordingMapper audioRecordingMapper, AudioRecordingClient audioRecordingClient, AudioRecordingUploadClient audioRecordingUploadClient, CoroutineDispatcher coroutineDispatcher) {
        return new UploadAudioRecordingManager(context, audioRecordingManager, audioRecordingMapper, audioRecordingClient, audioRecordingUploadClient, coroutineDispatcher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UploadAudioRecordingManager get() {
        return c(this.f21418a.get(), this.f21419b.get(), this.f21420c.get(), this.f21421d.get(), this.f21422e.get(), this.f21423f.get());
    }
}
