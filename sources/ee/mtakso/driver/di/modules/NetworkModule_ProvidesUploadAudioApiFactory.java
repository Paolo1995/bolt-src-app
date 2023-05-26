package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadAPI;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.UploadUnauthorised"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesUploadAudioApiFactory implements Factory<AudioRecordingUploadAPI> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20854a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20855b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20856c;

    public NetworkModule_ProvidesUploadAudioApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20854a = networkModule;
        this.f20855b = provider;
        this.f20856c = provider2;
    }

    public static NetworkModule_ProvidesUploadAudioApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesUploadAudioApiFactory(networkModule, provider, provider2);
    }

    public static AudioRecordingUploadAPI c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (AudioRecordingUploadAPI) Preconditions.checkNotNullFromProvides(networkModule.F(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingUploadAPI get() {
        return c(this.f20854a, this.f20855b.get(), this.f20856c.get());
    }
}
