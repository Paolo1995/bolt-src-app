package ee.mtakso.driver.ui.screens.home.v2.subpage.activity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class DriverActivityFragment_Factory implements Factory<DriverActivityFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29634a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DateTimeConverter> f29635b;

    public DriverActivityFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DateTimeConverter> provider2) {
        this.f29634a = provider;
        this.f29635b = provider2;
    }

    public static DriverActivityFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DateTimeConverter> provider2) {
        return new DriverActivityFragment_Factory(provider, provider2);
    }

    public static DriverActivityFragment c(BaseUiDependencies baseUiDependencies, DateTimeConverter dateTimeConverter) {
        return new DriverActivityFragment(baseUiDependencies, dateTimeConverter);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverActivityFragment get() {
        return c(this.f29634a.get(), this.f29635b.get());
    }
}
