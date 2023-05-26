package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarker;
import ee.mtakso.driver.ui.screens.order.MapStyleExtKt;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import ee.mtakso.driver.uikit.utils.image.ImageSize;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitingTimeMarkerRenderer.kt */
/* loaded from: classes3.dex */
public final class WaitingTimeMarkerRenderer {

    /* renamed from: a  reason: collision with root package name */
    private final MarkerCache f30236a;

    /* renamed from: b  reason: collision with root package name */
    private final MarkerParamsFactory f30237b;

    /* renamed from: c  reason: collision with root package name */
    private final HtmlEngine f30238c;

    /* renamed from: d  reason: collision with root package name */
    private final WaitingTimeTranslationProvider f30239d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f30240e;

    @Inject
    public WaitingTimeMarkerRenderer(MarkerCache cache, MarkerParamsFactory markerParamsFactory, HtmlEngine htmlEngine, WaitingTimeTranslationProvider translationProvider, Context context) {
        Intrinsics.f(cache, "cache");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(translationProvider, "translationProvider");
        Intrinsics.f(context, "context");
        this.f30236a = cache;
        this.f30237b = markerParamsFactory;
        this.f30238c = htmlEngine;
        this.f30239d = translationProvider;
        this.f30240e = context;
    }

    private final Bitmap b(WaitingTimeMarker waitingTimeMarker) {
        String b8 = WaitingTimeMarkerKt.b(waitingTimeMarker);
        if (b8 == null) {
            return null;
        }
        try {
            return ImageManager.Companion.b(ImageManager.f36075b, null, 1, null).d(new ImageRequest(b8, new ImageSize(Dimens.c(14), Dimens.c(14)), null, null, 12, null), this.f30240e);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.CharSequence c(ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarker r6) {
        /*
            r5 = this;
            ee.mtakso.driver.service.modules.tile.VectorProperties$Label r0 = r6.a()
            java.lang.String r0 = r0.d()
            r1 = 0
            if (r0 == 0) goto L46
            ee.mtakso.driver.service.modules.tile.VectorProperties$Label r0 = r6.a()
            java.util.List r0 = r0.c()
            r2 = 0
            if (r0 == 0) goto L1f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L1d
            goto L1f
        L1d:
            r0 = 0
            goto L20
        L1f:
            r0 = 1
        L20:
            if (r0 != 0) goto L46
            ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTranslationProvider r0 = r5.f30239d
            android.content.Context r3 = r5.f30240e
            ee.mtakso.driver.service.modules.tile.VectorProperties$Label r4 = r6.a()
            java.lang.String r4 = r4.d()
            ee.mtakso.driver.service.modules.tile.VectorProperties$Label r6 = r6.a()
            java.util.List r6 = r6.c()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object[] r6 = r6.toArray(r2)
            int r2 = r6.length
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r2)
            java.lang.String r6 = r0.b(r3, r4, r6)
            goto L5a
        L46:
            ee.mtakso.driver.service.modules.tile.VectorProperties$Label r0 = r6.a()
            java.lang.String r0 = r0.g()
            if (r0 == 0) goto L59
            ee.mtakso.driver.service.modules.tile.VectorProperties$Label r6 = r6.a()
            java.lang.String r6 = r6.g()
            goto L5a
        L59:
            r6 = r1
        L5a:
            if (r6 == 0) goto L62
            eu.bolt.android.engine.html.HtmlEngine r0 = r5.f30238c
            java.lang.CharSequence r1 = r0.a(r6)
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerRenderer.c(ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarker):java.lang.CharSequence");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarkerParams e(MapTileMarker<WaitingTimeMarker> mapTileMarker) {
        BitmapDrawable bitmapDrawable;
        int a8;
        WaitingTimeMarker b8 = mapTileMarker.b();
        Bitmap b9 = b(b8);
        MarkerParamsFactory markerParamsFactory = this.f30237b;
        Locatable c8 = mapTileMarker.c();
        CharSequence c9 = c(b8);
        if (b9 != null) {
            bitmapDrawable = new BitmapDrawable(this.f30240e.getResources(), b9);
        } else {
            bitmapDrawable = null;
        }
        BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        int b10 = MapStyleExtKt.b(b8.b(), this.f30240e);
        Integer a9 = WaitingTimeMarkerKt.a(b8);
        if (a9 != null) {
            a8 = a9.intValue();
        } else {
            a8 = MapStyleExtKt.a(b8.b(), this.f30240e);
        }
        return markerParamsFactory.l(c8, c9, bitmapDrawable2, b10, a8);
    }

    public final MarkerParams d(final MapTileMarker<WaitingTimeMarker> marker) {
        Intrinsics.f(marker, "marker");
        return MarkerParams.b(this.f30236a.a(marker.b(), new Function1<WaitingTimeMarker, MarkerParams>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerRenderer$render$prototype$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final MarkerParams invoke(WaitingTimeMarker it) {
                MarkerParams e8;
                Intrinsics.f(it, "it");
                e8 = WaitingTimeMarkerRenderer.this.e(marker);
                return e8;
            }
        }), marker.c(), null, null, null, 0.0f, 0, false, 126, null);
    }
}
