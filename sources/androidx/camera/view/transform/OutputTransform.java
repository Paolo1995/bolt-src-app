package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class OutputTransform {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Matrix f4198a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final Size f4199b;

    public OutputTransform(@NonNull Matrix matrix, @NonNull Size size) {
        this.f4198a = matrix;
        this.f4199b = size;
    }
}
