package ee.mtakso.driver.network.client.audio_recording;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"eu.bolt.driver.core.di.coroutine.dispatcher.DispatcherIO"})
/* loaded from: classes3.dex */
public final class AudioRecordingClient_Factory implements Factory<AudioRecordingClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CoroutineDispatcher> f21379a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AudioRecordingNetworkAPI> f21380b;

    public AudioRecordingClient_Factory(Provider<CoroutineDispatcher> provider, Provider<AudioRecordingNetworkAPI> provider2) {
        this.f21379a = provider;
        this.f21380b = provider2;
    }

    public static AudioRecordingClient_Factory a(Provider<CoroutineDispatcher> provider, Provider<AudioRecordingNetworkAPI> provider2) {
        return new AudioRecordingClient_Factory(provider, provider2);
    }

    public static AudioRecordingClient c(CoroutineDispatcher coroutineDispatcher, AudioRecordingNetworkAPI audioRecordingNetworkAPI) {
        return new AudioRecordingClient(coroutineDispatcher, audioRecordingNetworkAPI);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingClient get() {
        return c(this.f21379a.get(), this.f21380b.get());
    }
}
