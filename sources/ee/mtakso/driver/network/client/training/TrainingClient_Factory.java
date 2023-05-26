package ee.mtakso.driver.network.client.training;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TrainingClient_Factory implements Factory<TrainingClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TrainingApi> f22878a;

    public TrainingClient_Factory(Provider<TrainingApi> provider) {
        this.f22878a = provider;
    }

    public static TrainingClient_Factory a(Provider<TrainingApi> provider) {
        return new TrainingClient_Factory(provider);
    }

    public static TrainingClient c(TrainingApi trainingApi) {
        return new TrainingClient(trainingApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TrainingClient get() {
        return c(this.f22878a.get());
    }
}
