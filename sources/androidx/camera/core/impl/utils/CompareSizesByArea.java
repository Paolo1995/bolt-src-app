package androidx.camera.core.impl.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class CompareSizesByArea implements Comparator<Size> {

    /* renamed from: f  reason: collision with root package name */
    private boolean f3761f;

    public CompareSizesByArea() {
        this(false);
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(@NonNull Size size, @NonNull Size size2) {
        int signum = Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        if (this.f3761f) {
            return signum * (-1);
        }
        return signum;
    }

    public CompareSizesByArea(boolean z7) {
        this.f3761f = z7;
    }
}
