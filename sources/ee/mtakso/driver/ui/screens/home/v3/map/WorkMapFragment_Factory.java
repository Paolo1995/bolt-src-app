package ee.mtakso.driver.ui.screens.home.v3.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileSource;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.HeatmapTileSourceFactory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerRenderer;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTileSourceFactory;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class WorkMapFragment_Factory implements Factory<WorkMapFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30108a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MapProvider> f30109b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HeatmapTileSourceFactory> f30110c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<WaitingTimeTileSourceFactory> f30111d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<WaitingTimeMarkerRenderer> f30112e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<FifoQueueTileSource> f30113f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<FifoQueueTileSource> f30114g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<MarkerParamsFactory> f30115h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<HtmlEngine> f30116i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<DriverFeatures> f30117j;

    public WorkMapFragment_Factory(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<HeatmapTileSourceFactory> provider3, Provider<WaitingTimeTileSourceFactory> provider4, Provider<WaitingTimeMarkerRenderer> provider5, Provider<FifoQueueTileSource> provider6, Provider<FifoQueueTileSource> provider7, Provider<MarkerParamsFactory> provider8, Provider<HtmlEngine> provider9, Provider<DriverFeatures> provider10) {
        this.f30108a = provider;
        this.f30109b = provider2;
        this.f30110c = provider3;
        this.f30111d = provider4;
        this.f30112e = provider5;
        this.f30113f = provider6;
        this.f30114g = provider7;
        this.f30115h = provider8;
        this.f30116i = provider9;
        this.f30117j = provider10;
    }

    public static WorkMapFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<HeatmapTileSourceFactory> provider3, Provider<WaitingTimeTileSourceFactory> provider4, Provider<WaitingTimeMarkerRenderer> provider5, Provider<FifoQueueTileSource> provider6, Provider<FifoQueueTileSource> provider7, Provider<MarkerParamsFactory> provider8, Provider<HtmlEngine> provider9, Provider<DriverFeatures> provider10) {
        return new WorkMapFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static WorkMapFragment c(BaseUiDependencies baseUiDependencies, MapProvider mapProvider, HeatmapTileSourceFactory heatmapTileSourceFactory, WaitingTimeTileSourceFactory waitingTimeTileSourceFactory, WaitingTimeMarkerRenderer waitingTimeMarkerRenderer, FifoQueueTileSource fifoQueueTileSource, FifoQueueTileSource fifoQueueTileSource2, MarkerParamsFactory markerParamsFactory, HtmlEngine htmlEngine, DriverFeatures driverFeatures) {
        return new WorkMapFragment(baseUiDependencies, mapProvider, heatmapTileSourceFactory, waitingTimeTileSourceFactory, waitingTimeMarkerRenderer, fifoQueueTileSource, fifoQueueTileSource2, markerParamsFactory, htmlEngine, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkMapFragment get() {
        return c(this.f30108a.get(), this.f30109b.get(), this.f30110c.get(), this.f30111d.get(), this.f30112e.get(), this.f30113f.get(), this.f30114g.get(), this.f30115h.get(), this.f30116i.get(), this.f30117j.get());
    }
}
