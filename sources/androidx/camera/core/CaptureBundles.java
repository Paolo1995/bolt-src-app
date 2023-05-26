package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class CaptureBundles {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class CaptureBundleImpl implements CaptureBundle {

        /* renamed from: a  reason: collision with root package name */
        final List<CaptureStage> f3086a;

        CaptureBundleImpl(List<CaptureStage> list) {
            if (list != null && !list.isEmpty()) {
                this.f3086a = Collections.unmodifiableList(new ArrayList(list));
                return;
            }
            throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
        }

        @Override // androidx.camera.core.impl.CaptureBundle
        public List<CaptureStage> a() {
            return this.f3086a;
        }
    }

    private CaptureBundles() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static CaptureBundle a(@NonNull List<CaptureStage> list) {
        return new CaptureBundleImpl(list);
    }

    @NonNull
    static CaptureBundle b(@NonNull CaptureStage... captureStageArr) {
        return new CaptureBundleImpl(Arrays.asList(captureStageArr));
    }

    @NonNull
    public static CaptureBundle c() {
        return b(new CaptureStage.DefaultCaptureStage());
    }
}
