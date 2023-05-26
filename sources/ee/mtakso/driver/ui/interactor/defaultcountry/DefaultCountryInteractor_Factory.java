package ee.mtakso.driver.ui.interactor.defaultcountry;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DefaultCountryInteractor_Factory implements Factory<DefaultCountryInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f26425a;

    public DefaultCountryInteractor_Factory(Provider<Context> provider) {
        this.f26425a = provider;
    }

    public static DefaultCountryInteractor_Factory a(Provider<Context> provider) {
        return new DefaultCountryInteractor_Factory(provider);
    }

    public static DefaultCountryInteractor c(Context context) {
        return new DefaultCountryInteractor(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DefaultCountryInteractor get() {
        return c(this.f26425a.get());
    }
}
