package ee.mtakso.driver.ui.screens.home.v3.map.vector;

import android.graphics.Bitmap;
import androidx.core.util.Pools$SynchronizedPool;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.concurrent.Semaphore;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorTileBitmapPool.kt */
@Singleton
/* loaded from: classes3.dex */
public final class VectorTileBitmapPool {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f30330a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30331b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Pools$SynchronizedPool<Bitmap> f30332c;

    /* renamed from: d  reason: collision with root package name */
    private final Semaphore f30333d;

    @Inject
    public VectorTileBitmapPool(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f30330a = driverProvider;
        this.f30331b = 4;
        this.f30332c = new Pools$SynchronizedPool<>(4);
        this.f30333d = new Semaphore(4);
    }

    private final Bitmap a(int i8, int i9) {
        boolean z7;
        Bitmap b8 = this.f30332c.b();
        if (b8 != null && b8.getWidth() == i8) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 && b8.getHeight() == i9) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.a(g8, "reuse bitmap", null, 2, null);
            }
            b8.eraseColor(0);
            return b8;
        }
        FastLog g9 = Kalev.f41674e.g();
        if (g9 != null) {
            FastLog.DefaultImpls.a(g9, "create new bitmap", null, 2, null);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
        Intrinsics.e(createBitmap, "{\n            Kalev.fast…nfig.ARGB_8888)\n        }");
        return createBitmap;
    }

    public final <T> T b(int i8, int i9, Function1<? super Bitmap, ? extends T> consumer) {
        Bitmap bitmap;
        Intrinsics.f(consumer, "consumer");
        DriverFeatures q8 = this.f30330a.q();
        boolean N = q8.N();
        boolean M = q8.M();
        if (N) {
            this.f30333d.acquire();
        }
        if (M) {
            bitmap = a(i8, i9);
        } else {
            bitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
        }
        try {
            Intrinsics.e(bitmap, "bitmap");
            return consumer.invoke(bitmap);
        } finally {
            if (M) {
                this.f30332c.a(bitmap);
            }
            if (N) {
                this.f30333d.release();
            }
        }
    }
}
