package ee.mtakso.driver.network.client.audio_recording.support;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class TripAudioSupportClient_Factory implements Factory<TripAudioSupportClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f21387a;

    public TripAudioSupportClient_Factory(Provider<OkHttpClient> provider) {
        this.f21387a = provider;
    }

    public static TripAudioSupportClient_Factory a(Provider<OkHttpClient> provider) {
        return new TripAudioSupportClient_Factory(provider);
    }

    public static TripAudioSupportClient c(OkHttpClient okHttpClient) {
        return new TripAudioSupportClient(okHttpClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TripAudioSupportClient get() {
        return c(this.f21387a.get());
    }
}
