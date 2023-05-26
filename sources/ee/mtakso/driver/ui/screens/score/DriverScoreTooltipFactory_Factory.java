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
public final class DriverScoreTooltipFactory_Factory implements Factory<DriverScoreTooltipFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<InformationMessageMapper> f32949a;

    public DriverScoreTooltipFactory_Factory(Provider<InformationMessageMapper> provider) {
        this.f32949a = provider;
    }

    public static DriverScoreTooltipFactory_Factory a(Provider<InformationMessageMapper> provider) {
        return new DriverScoreTooltipFactory_Factory(provider);
    }

    public static DriverScoreTooltipFactory c(InformationMessageMapper informationMessageMapper) {
        return new DriverScoreTooltipFactory(informationMessageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreTooltipFactory get() {
        return c(this.f32949a.get());
    }
}
