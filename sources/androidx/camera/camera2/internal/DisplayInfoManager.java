package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.workaround.MaxPreviewSize;

/* loaded from: classes.dex */
public class DisplayInfoManager {

    /* renamed from: d  reason: collision with root package name */
    private static final Size f2584d = new Size(1920, 1080);

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2585e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static volatile DisplayInfoManager f2586f;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DisplayManager f2587a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Size f2588b = null;

    /* renamed from: c  reason: collision with root package name */
    private final MaxPreviewSize f2589c = new MaxPreviewSize();

    private DisplayInfoManager(@NonNull Context context) {
        this.f2587a = (DisplayManager) context.getSystemService("display");
    }

    private Size a() {
        Size size;
        Point point = new Point();
        c().getRealSize(point);
        if (point.x > point.y) {
            size = new Size(point.x, point.y);
        } else {
            size = new Size(point.y, point.x);
        }
        int width = size.getWidth() * size.getHeight();
        Size size2 = f2584d;
        if (width > size2.getWidth() * size2.getHeight()) {
            size = size2;
        }
        return this.f2589c.a(size);
    }

    @NonNull
    public static DisplayInfoManager b(@NonNull Context context) {
        if (f2586f == null) {
            synchronized (f2585e) {
                if (f2586f == null) {
                    f2586f = new DisplayInfoManager(context);
                }
            }
        }
        return f2586f;
    }

    @NonNull
    public Display c() {
        Display[] displays = this.f2587a.getDisplays();
        if (displays.length == 1) {
            return displays[0];
        }
        Display display = null;
        int i8 = -1;
        for (Display display2 : displays) {
            if (display2.getState() != 1) {
                Point point = new Point();
                display2.getRealSize(point);
                int i9 = point.x;
                int i10 = point.y;
                if (i9 * i10 > i8) {
                    display = display2;
                    i8 = i9 * i10;
                }
            }
        }
        if (display != null) {
            return display;
        }
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Size d() {
        if (this.f2588b != null) {
            return this.f2588b;
        }
        this.f2588b = a();
        return this.f2588b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f2588b = a();
    }
}
