package ee.mtakso.driver.ui.screens.home.v3.map.fifo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import ee.mtakso.driver.network.client.tile.TileVariant;
import ee.mtakso.driver.service.modules.map.TileIndex;
import ee.mtakso.driver.service.modules.map.TilePosition;
import ee.mtakso.driver.service.modules.map.TileRequestMerger;
import ee.mtakso.driver.service.modules.tile.MvtUtils;
import ee.mtakso.driver.service.modules.tile.VectorProperties;
import ee.mtakso.driver.service.modules.tile.VectorPropertiesExtKt;
import ee.mtakso.driver.service.modules.tile.VectorPropertiesFactory;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool;
import ee.mtakso.driver.uikit.utils.Dimens;
import eu.bolt.android.maps.core.plugin.driver.Tile;
import eu.bolt.android.maps.core.plugin.driver.TileSource;
import eu.bolt.driver.maps.tile.mvt.MvtFeature;
import eu.bolt.driver.maps.tile.mvt.MvtLayer;
import eu.bolt.kalev.Kalev;
import java.io.ByteArrayOutputStream;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vector_tile.VectorTile$Tile;

/* compiled from: FifoQueueTileSource.kt */
/* loaded from: classes3.dex */
public final class FifoQueueTileSource implements TileSource {

    /* renamed from: a  reason: collision with root package name */
    private final VectorTileBitmapPool f30187a;

    /* renamed from: b  reason: collision with root package name */
    private final TileRequestMerger f30188b;

    /* renamed from: c  reason: collision with root package name */
    private final VectorPropertiesFactory f30189c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f30190d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Function1<? super FifoQueueTileLabel, Unit> f30191e;

    /* renamed from: f  reason: collision with root package name */
    private volatile FifoQueueTileState f30192f;

    @Inject
    public FifoQueueTileSource(VectorTileBitmapPool bitmapPool, TileRequestMerger tileRequestMerger, VectorPropertiesFactory vectorPropertiesFactory) {
        Intrinsics.f(bitmapPool, "bitmapPool");
        Intrinsics.f(tileRequestMerger, "tileRequestMerger");
        Intrinsics.f(vectorPropertiesFactory, "vectorPropertiesFactory");
        this.f30187a = bitmapPool;
        this.f30188b = tileRequestMerger;
        this.f30189c = vectorPropertiesFactory;
        this.f30190d = new Handler(Looper.getMainLooper());
        this.f30191e = new Function1<FifoQueueTileLabel, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileSource$labelRenderer$1
            public final void b(FifoQueueTileLabel it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FifoQueueTileLabel fifoQueueTileLabel) {
                b(fifoQueueTileLabel);
                return Unit.f50853a;
            }
        };
        this.f30192f = new FifoQueueTileState(0, null, null, null, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] d(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            CloseableKt.a(byteArrayOutputStream, null);
            Intrinsics.e(byteArray, "ByteArrayOutputStream().…m.toByteArray()\n        }");
            return byteArray;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Canvas canvas, MvtLayer mvtLayer, float f8, final FifoQueueTileState fifoQueueTileState, int i8, int i9, int i10) {
        for (MvtFeature mvtFeature : mvtLayer.b()) {
            VectorProperties a8 = this.f30189c.a(mvtFeature, fifoQueueTileState.a());
            if (mvtFeature.e() == VectorTile$Tile.GeomType.POINT && (a8 instanceof VectorProperties.Label)) {
                VectorProperties.Label label = (VectorProperties.Label) a8;
                String g8 = label.g();
                String d8 = VectorPropertiesExtKt.d(label, fifoQueueTileState.b());
                Integer a9 = VectorPropertiesExtKt.a(label, fifoQueueTileState.b());
                Point b8 = MvtUtils.f25351a.b(mvtFeature.a(), 1.0f, 1.0f);
                if (b8 != null) {
                    final FifoQueueTileLabel fifoQueueTileLabel = new FifoQueueTileLabel(mvtFeature.c(), new TilePosition(i8, i9, i10), mvtLayer.a(), b8.x, b8.y, g8, d8, a9);
                    this.f30190d.post(new Runnable() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.fifo.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            FifoQueueTileSource.g(FifoQueueTileState.this, this, fifoQueueTileLabel);
                        }
                    });
                }
            } else {
                VectorTile$Tile.GeomType e8 = mvtFeature.e();
                VectorTile$Tile.GeomType geomType = VectorTile$Tile.GeomType.POLYGON;
                Unit unit = null;
                if (e8 == geomType && (a8 instanceof VectorProperties.Polygon)) {
                    Integer c8 = VectorPropertiesExtKt.c((VectorProperties.Polygon) a8, fifoQueueTileState.b());
                    if (c8 != null) {
                        int intValue = c8.intValue();
                        Path a10 = MvtUtils.f25351a.a(mvtFeature.a(), f8, f8);
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.FILL);
                        paint.setColor(intValue);
                        paint.setStrokeWidth(0.0f);
                        canvas.drawPath(a10, paint);
                        unit = Unit.f50853a;
                    }
                    if (unit == null) {
                        Kalev.m(new IllegalStateException("Fill color is required"), "Fill color is required");
                    }
                } else if (mvtFeature.e() == geomType && (a8 instanceof VectorProperties.LocationAwarePolygon)) {
                    Integer b9 = VectorPropertiesExtKt.b((VectorProperties.LocationAwarePolygon) a8, fifoQueueTileState.b(), Intrinsics.a(mvtFeature.c(), fifoQueueTileState.c()));
                    if (b9 != null) {
                        int intValue2 = b9.intValue();
                        Path a11 = MvtUtils.f25351a.a(mvtFeature.a(), f8, f8);
                        Paint paint2 = new Paint();
                        paint2.setStyle(Paint.Style.FILL);
                        paint2.setColor(intValue2);
                        paint2.setStrokeWidth(0.0f);
                        canvas.drawPath(a11, paint2);
                        unit = Unit.f50853a;
                    }
                    if (unit == null) {
                        Kalev.m(new IllegalStateException("Fill color is required"), "Fill color is required");
                    }
                } else if (mvtFeature.e() == VectorTile$Tile.GeomType.LINESTRING && (a8 instanceof VectorProperties.LocationAwareLine)) {
                    Integer e9 = VectorPropertiesExtKt.e((VectorProperties.LocationAwareLine) a8, fifoQueueTileState.b(), Intrinsics.a(mvtFeature.c(), fifoQueueTileState.c()));
                    if (e9 != null) {
                        int intValue3 = e9.intValue();
                        Path a12 = MvtUtils.f25351a.a(mvtFeature.a(), f8, f8);
                        Paint paint3 = new Paint();
                        paint3.setStyle(Paint.Style.STROKE);
                        paint3.setColor(intValue3);
                        paint3.setStrokeWidth(Dimens.b(4.0f));
                        canvas.drawPath(a12, paint3);
                        unit = Unit.f50853a;
                    }
                    if (unit == null) {
                        Kalev.m(new IllegalStateException("Stroke color is required"), "Fill color is required");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FifoQueueTileState state, FifoQueueTileSource this$0, FifoQueueTileLabel label) {
        Intrinsics.f(state, "$state");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(label, "$label");
        if (Intrinsics.a(state, this$0.f30192f)) {
            this$0.f30191e.invoke(label);
        }
    }

    public final FifoQueueTileState e() {
        return this.f30192f;
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.TileSource
    public Tile getTile(final int i8, final int i9, final int i10) {
        String str;
        final FifoQueueTileState fifoQueueTileState = this.f30192f;
        TileCollectionConfig a8 = fifoQueueTileState.a();
        if (a8 != null) {
            str = a8.c();
        } else {
            str = null;
        }
        if (str == null) {
            Kalev.m(new IllegalArgumentException("Tile collection id is required!"), "Tile collection id is required!");
            return null;
        }
        final TileVariant d8 = this.f30188b.h(new TileIndex(str, new TilePosition(i8, i9, i10))).d();
        if (d8 instanceof TileVariant.Empty) {
            return null;
        }
        if (!(d8 instanceof TileVariant.Mvt)) {
            String str2 = "Unsupported tile format " + d8;
            Kalev.m(new IllegalArgumentException(str2), str2);
            return null;
        }
        final int d9 = fifoQueueTileState.d();
        return new Tile(d9, d9, (byte[]) this.f30187a.b(d9, d9, new Function1<Bitmap, byte[]>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileSource$getTile$bytes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final byte[] invoke(Bitmap bitmap) {
                byte[] d10;
                Intrinsics.f(bitmap, "bitmap");
                Canvas canvas = new Canvas(bitmap);
                Iterable<MvtLayer> a9 = ((TileVariant.Mvt) TileVariant.this).a().a();
                int i11 = d9;
                FifoQueueTileSource fifoQueueTileSource = this;
                FifoQueueTileState fifoQueueTileState2 = fifoQueueTileState;
                int i12 = i8;
                int i13 = i9;
                int i14 = i10;
                for (MvtLayer mvtLayer : a9) {
                    fifoQueueTileSource.f(canvas, mvtLayer, i11 / mvtLayer.a(), fifoQueueTileState2, i12, i13, i14);
                }
                d10 = this.d(bitmap);
                return d10;
            }
        }));
    }

    public final void h(Function1<? super FifoQueueTileLabel, Unit> renderer) {
        Intrinsics.f(renderer, "renderer");
        this.f30191e = renderer;
    }

    public final void i(FifoQueueTileState fifoQueueTileState) {
        Intrinsics.f(fifoQueueTileState, "<set-?>");
        this.f30192f = fifoQueueTileState;
    }
}
