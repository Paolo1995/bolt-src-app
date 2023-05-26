package ee.mtakso.driver.ui.screens.home.v3.map.surge;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool;
import eu.bolt.driver.maps.tile.mvt.MvtTile;
import java.io.ByteArrayOutputStream;
import javax.inject.Inject;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MvtToRasterConverter.kt */
/* loaded from: classes3.dex */
public final class MvtToRasterConverter {

    /* renamed from: a  reason: collision with root package name */
    private final MvtRenderer f30324a;

    /* renamed from: b  reason: collision with root package name */
    private final VectorTileBitmapPool f30325b;

    @Inject
    public MvtToRasterConverter(MvtRenderer renderer, VectorTileBitmapPool bitmapPool) {
        Intrinsics.f(renderer, "renderer");
        Intrinsics.f(bitmapPool, "bitmapPool");
        this.f30324a = renderer;
        this.f30325b = bitmapPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] c(Bitmap bitmap) {
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

    public final byte[] d(final MvtTile tile, int i8, int i9) {
        Intrinsics.f(tile, "tile");
        return (byte[]) this.f30325b.b(i8, i9, new Function1<Bitmap, byte[]>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.surge.MvtToRasterConverter$convert$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final byte[] invoke(Bitmap bitmap) {
                MvtRenderer mvtRenderer;
                byte[] c8;
                Intrinsics.f(bitmap, "bitmap");
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                Canvas canvas = new Canvas(bitmap);
                mvtRenderer = MvtToRasterConverter.this.f30324a;
                mvtRenderer.c(canvas, rect, tile);
                c8 = MvtToRasterConverter.this.c(bitmap);
                return c8;
            }
        });
    }
}
