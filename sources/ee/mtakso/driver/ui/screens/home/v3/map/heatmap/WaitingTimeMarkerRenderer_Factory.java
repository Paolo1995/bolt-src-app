package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WaitingTimeMarkerRenderer_Factory implements Factory<WaitingTimeMarkerRenderer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MarkerCache> f30243a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MarkerParamsFactory> f30244b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HtmlEngine> f30245c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<WaitingTimeTranslationProvider> f30246d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Context> f30247e;

    public WaitingTimeMarkerRenderer_Factory(Provider<MarkerCache> provider, Provider<MarkerParamsFactory> provider2, Provider<HtmlEngine> provider3, Provider<WaitingTimeTranslationProvider> provider4, Provider<Context> provider5) {
        this.f30243a = provider;
        this.f30244b = provider2;
        this.f30245c = provider3;
        this.f30246d = provider4;
        this.f30247e = provider5;
    }

    public static WaitingTimeMarkerRenderer_Factory a(Provider<MarkerCache> provider, Provider<MarkerParamsFactory> provider2, Provider<HtmlEngine> provider3, Provider<WaitingTimeTranslationProvider> provider4, Provider<Context> provider5) {
        return new WaitingTimeMarkerRenderer_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static WaitingTimeMarkerRenderer c(MarkerCache markerCache, MarkerParamsFactory markerParamsFactory, HtmlEngine htmlEngine, WaitingTimeTranslationProvider waitingTimeTranslationProvider, Context context) {
        return new WaitingTimeMarkerRenderer(markerCache, markerParamsFactory, htmlEngine, waitingTimeTranslationProvider, context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WaitingTimeMarkerRenderer get() {
        return c(this.f30243a.get(), this.f30244b.get(), this.f30245c.get(), this.f30246d.get(), this.f30247e.get());
    }
}
