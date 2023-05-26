package androidx.camera.core;

import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public interface CameraControl {

    /* loaded from: classes.dex */
    public static final class OperationCanceledException extends Exception {
        public OperationCanceledException(@NonNull String str) {
            super(str);
        }
    }

    @NonNull
    ListenableFuture<Void> e(boolean z7);
}
