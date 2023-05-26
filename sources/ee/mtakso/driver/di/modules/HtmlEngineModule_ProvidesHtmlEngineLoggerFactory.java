package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.logger.Logger;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HtmlEngineModule_ProvidesHtmlEngineLoggerFactory implements Factory<Logger> {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngineModule f20757a;

    public HtmlEngineModule_ProvidesHtmlEngineLoggerFactory(HtmlEngineModule htmlEngineModule) {
        this.f20757a = htmlEngineModule;
    }

    public static HtmlEngineModule_ProvidesHtmlEngineLoggerFactory a(HtmlEngineModule htmlEngineModule) {
        return new HtmlEngineModule_ProvidesHtmlEngineLoggerFactory(htmlEngineModule);
    }

    public static Logger c(HtmlEngineModule htmlEngineModule) {
        return (Logger) Preconditions.checkNotNullFromProvides(htmlEngineModule.b());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Logger get() {
        return c(this.f20757a);
    }
}
