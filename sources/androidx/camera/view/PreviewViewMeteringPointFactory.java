package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PreviewViewMeteringPointFactory extends MeteringPointFactory {

    /* renamed from: d  reason: collision with root package name */
    static final PointF f4140d = new PointF(2.0f, 2.0f);
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final PreviewTransformation f4141b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f4142c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreviewViewMeteringPointFactory(@NonNull PreviewTransformation previewTransformation) {
        this.f4141b = previewTransformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Size size, int i8) {
        Threads.a();
        synchronized (this) {
            if (size.getWidth() != 0 && size.getHeight() != 0) {
                this.f4142c = this.f4141b.c(size, i8);
                return;
            }
            this.f4142c = null;
        }
    }
}
