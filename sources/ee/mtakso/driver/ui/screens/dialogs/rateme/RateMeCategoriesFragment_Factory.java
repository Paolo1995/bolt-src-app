package ee.mtakso.driver.ui.screens.dialogs.rateme;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class RateMeCategoriesFragment_Factory implements Factory<RateMeCategoriesFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28335a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HtmlEngine> f28336b;

    public RateMeCategoriesFragment_Factory(Provider<BaseUiDependencies> provider, Provider<HtmlEngine> provider2) {
        this.f28335a = provider;
        this.f28336b = provider2;
    }

    public static RateMeCategoriesFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<HtmlEngine> provider2) {
        return new RateMeCategoriesFragment_Factory(provider, provider2);
    }

    public static RateMeCategoriesFragment c(BaseUiDependencies baseUiDependencies, HtmlEngine htmlEngine) {
        return new RateMeCategoriesFragment(baseUiDependencies, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateMeCategoriesFragment get() {
        return c(this.f28335a.get(), this.f28336b.get());
    }
}
