package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingNetworkAPI;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideAudioRecordingNetworkApiFactory implements Factory<AudioRecordingNetworkAPI> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20291a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20292b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20293c;

    public AuthorisedNetworkModule_ProvideAudioRecordingNetworkApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20291a = authorisedNetworkModule;
        this.f20292b = provider;
        this.f20293c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideAudioRecordingNetworkApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideAudioRecordingNetworkApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static AudioRecordingNetworkAPI c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (AudioRecordingNetworkAPI) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.a(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingNetworkAPI get() {
        return c(this.f20291a, this.f20292b.get(), this.f20293c.get());
    }
}
