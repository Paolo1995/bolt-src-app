package ee.mtakso.driver.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.utils.html.HtmlEngineFontMapper;
import ee.mtakso.driver.utils.html.HtmlEngineLogger;
import eu.bolt.android.engine.html.DesignHtmlEngine;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.engine.html.font.HtmlFontMapper;
import eu.bolt.android.engine.html.logger.Logger;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlEngineModule.kt */
@Module
/* loaded from: classes3.dex */
public final class HtmlEngineModule {
    @Provides
    @Singleton
    public final HtmlEngine a(Context context, HtmlFontMapper fontMapper, Logger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(fontMapper, "fontMapper");
        Intrinsics.f(logger, "logger");
        return new DesignHtmlEngine(context, fontMapper, logger);
    }

    @Provides
    @Singleton
    public final Logger b() {
        return new HtmlEngineLogger();
    }

    @Provides
    @Singleton
    public final HtmlFontMapper c(Context context) {
        Intrinsics.f(context, "context");
        return new HtmlEngineFontMapper(context);
    }
}
