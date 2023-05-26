package ee.mtakso.driver.ui.screens.boltclub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BoltClubDataMapper_Factory implements Factory<BoltClubDataMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f27117a;

    public BoltClubDataMapper_Factory(Provider<HtmlEngine> provider) {
        this.f27117a = provider;
    }

    public static BoltClubDataMapper_Factory a(Provider<HtmlEngine> provider) {
        return new BoltClubDataMapper_Factory(provider);
    }

    public static BoltClubDataMapper c(HtmlEngine htmlEngine) {
        return new BoltClubDataMapper(htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BoltClubDataMapper get() {
        return c(this.f27117a.get());
    }
}
