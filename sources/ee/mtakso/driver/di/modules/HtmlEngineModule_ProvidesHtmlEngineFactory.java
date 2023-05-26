package ee.mtakso.driver.di.modules;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.engine.html.font.HtmlFontMapper;
import eu.bolt.android.engine.html.logger.Logger;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HtmlEngineModule_ProvidesHtmlEngineFactory implements Factory<HtmlEngine> {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngineModule f20753a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f20754b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HtmlFontMapper> f20755c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Logger> f20756d;

    public HtmlEngineModule_ProvidesHtmlEngineFactory(HtmlEngineModule htmlEngineModule, Provider<Context> provider, Provider<HtmlFontMapper> provider2, Provider<Logger> provider3) {
        this.f20753a = htmlEngineModule;
        this.f20754b = provider;
        this.f20755c = provider2;
        this.f20756d = provider3;
    }

    public static HtmlEngineModule_ProvidesHtmlEngineFactory a(HtmlEngineModule htmlEngineModule, Provider<Context> provider, Provider<HtmlFontMapper> provider2, Provider<Logger> provider3) {
        return new HtmlEngineModule_ProvidesHtmlEngineFactory(htmlEngineModule, provider, provider2, provider3);
    }

    public static HtmlEngine c(HtmlEngineModule htmlEngineModule, Context context, HtmlFontMapper htmlFontMapper, Logger logger) {
        return (HtmlEngine) Preconditions.checkNotNullFromProvides(htmlEngineModule.a(context, htmlFontMapper, logger));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HtmlEngine get() {
        return c(this.f20753a, this.f20754b.get(), this.f20755c.get(), this.f20756d.get());
    }
}
