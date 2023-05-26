package ee.mtakso.driver.di.modules;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.font.HtmlFontMapper;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HtmlEngineModule_ProvidesHtmlFontMapperFactory implements Factory<HtmlFontMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngineModule f20758a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f20759b;

    public HtmlEngineModule_ProvidesHtmlFontMapperFactory(HtmlEngineModule htmlEngineModule, Provider<Context> provider) {
        this.f20758a = htmlEngineModule;
        this.f20759b = provider;
    }

    public static HtmlEngineModule_ProvidesHtmlFontMapperFactory a(HtmlEngineModule htmlEngineModule, Provider<Context> provider) {
        return new HtmlEngineModule_ProvidesHtmlFontMapperFactory(htmlEngineModule, provider);
    }

    public static HtmlFontMapper c(HtmlEngineModule htmlEngineModule, Context context) {
        return (HtmlFontMapper) Preconditions.checkNotNullFromProvides(htmlEngineModule.c(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HtmlFontMapper get() {
        return c(this.f20758a, this.f20759b.get());
    }
}
