package ee.mtakso.driver.ui.screens.score;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.common.mapping.InformationMessageMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverScoreMapper_Factory implements Factory<DriverScoreMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<InformationMessageMapper> f32932a;

    public DriverScoreMapper_Factory(Provider<InformationMessageMapper> provider) {
        this.f32932a = provider;
    }

    public static DriverScoreMapper_Factory a(Provider<InformationMessageMapper> provider) {
        return new DriverScoreMapper_Factory(provider);
    }

    public static DriverScoreMapper c(InformationMessageMapper informationMessageMapper) {
        return new DriverScoreMapper(informationMessageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreMapper get() {
        return c(this.f32932a.get());
    }
}
