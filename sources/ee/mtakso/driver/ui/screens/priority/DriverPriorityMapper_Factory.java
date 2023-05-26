package ee.mtakso.driver.ui.screens.priority;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.common.mapping.InformationMessageMapper;
import ee.mtakso.driver.ui.common.mapping.SimpleTextMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverPriorityMapper_Factory implements Factory<DriverPriorityMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<InformationMessageMapper> f32520a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SimpleTextMapper> f32521b;

    public DriverPriorityMapper_Factory(Provider<InformationMessageMapper> provider, Provider<SimpleTextMapper> provider2) {
        this.f32520a = provider;
        this.f32521b = provider2;
    }

    public static DriverPriorityMapper_Factory a(Provider<InformationMessageMapper> provider, Provider<SimpleTextMapper> provider2) {
        return new DriverPriorityMapper_Factory(provider, provider2);
    }

    public static DriverPriorityMapper c(InformationMessageMapper informationMessageMapper, SimpleTextMapper simpleTextMapper) {
        return new DriverPriorityMapper(informationMessageMapper, simpleTextMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverPriorityMapper get() {
        return c(this.f32520a.get(), this.f32521b.get());
    }
}
