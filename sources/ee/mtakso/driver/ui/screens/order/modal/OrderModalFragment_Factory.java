package ee.mtakso.driver.ui.screens.order.modal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class OrderModalFragment_Factory implements Factory<OrderModalFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31512a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HtmlEngine> f31513b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DeeplinkDelegate> f31514c;

    public OrderModalFragment_Factory(Provider<BaseUiDependencies> provider, Provider<HtmlEngine> provider2, Provider<DeeplinkDelegate> provider3) {
        this.f31512a = provider;
        this.f31513b = provider2;
        this.f31514c = provider3;
    }

    public static OrderModalFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<HtmlEngine> provider2, Provider<DeeplinkDelegate> provider3) {
        return new OrderModalFragment_Factory(provider, provider2, provider3);
    }

    public static OrderModalFragment c(BaseUiDependencies baseUiDependencies, HtmlEngine htmlEngine, DeeplinkDelegate deeplinkDelegate) {
        return new OrderModalFragment(baseUiDependencies, htmlEngine, deeplinkDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderModalFragment get() {
        return c(this.f31512a.get(), this.f31513b.get(), this.f31514c.get());
    }
}
