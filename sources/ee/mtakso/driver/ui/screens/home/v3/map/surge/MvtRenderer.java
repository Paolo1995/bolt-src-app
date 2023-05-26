package ee.mtakso.driver.ui.screens.home.v3.map.surge;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import ee.mtakso.driver.service.modules.tile.MvtUtils;
import ee.mtakso.driver.uikit.utils.ColorParser;
import ee.mtakso.driver.uikit.utils.Dimens;
import eu.bolt.driver.maps.tile.mvt.MvtFeature;
import eu.bolt.driver.maps.tile.mvt.MvtLayer;
import eu.bolt.driver.maps.tile.mvt.MvtTile;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vector_tile.VectorTile$Tile;

/* compiled from: MvtRenderer.kt */
/* loaded from: classes3.dex */
public final class MvtRenderer {

    /* compiled from: MvtRenderer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30322a;

        static {
            int[] iArr = new int[VectorTile$Tile.GeomType.values().length];
            try {
                iArr[VectorTile$Tile.GeomType.LINESTRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VectorTile$Tile.GeomType.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f30322a = iArr;
        }
    }

    private final int a(Map<String, ? extends Object> map) {
        String str;
        Object obj = map.get("fill");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null) {
            return ColorParser.f36034a.a(str);
        }
        return 0;
    }

    private final int b(Map<String, ? extends Object> map) {
        String str;
        Object obj = map.get("stroke");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null) {
            return ColorParser.f36034a.a(str);
        }
        return 0;
    }

    public final void c(Canvas canvas, Rect bounds, MvtTile tile) {
        Intrinsics.f(canvas, "canvas");
        Intrinsics.f(bounds, "bounds");
        Intrinsics.f(tile, "tile");
        for (MvtLayer mvtLayer : tile.a()) {
            float width = bounds.width() / mvtLayer.a();
            float height = bounds.height() / mvtLayer.a();
            for (MvtFeature mvtFeature : mvtLayer.b()) {
                Map<String, Object> d8 = mvtFeature.d();
                int i8 = WhenMappings.f30322a[mvtFeature.e().ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        Path a8 = MvtUtils.f25351a.a(mvtFeature.a(), width, height);
                        Paint paint = new Paint();
                        paint.setColor(a(d8));
                        paint.setStyle(Paint.Style.FILL);
                        paint.setStrokeWidth(0.0f);
                        canvas.drawPath(a8, paint);
                    }
                } else {
                    Path a9 = MvtUtils.f25351a.a(mvtFeature.a(), width, height);
                    Paint paint2 = new Paint();
                    paint2.setColor(b(d8));
                    paint2.setStyle(Paint.Style.STROKE);
                    paint2.setStrokeWidth(Dimens.b(2.0f));
                    canvas.drawPath(a9, paint2);
                }
            }
        }
    }
}
