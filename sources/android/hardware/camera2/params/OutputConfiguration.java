package android.hardware.camera2.params;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Parcelable;
import android.util.Size;
import android.view.Surface;

/* loaded from: classes.dex */
public final /* synthetic */ class OutputConfiguration implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ OutputConfiguration(int i8, @NonNull Surface surface) {
    }

    public /* synthetic */ <T> OutputConfiguration(@NonNull Size size, @NonNull Class<T> cls) {
    }

    @Nullable
    public native /* synthetic */ Surface getSurface();

    public native /* synthetic */ int hashCode();

    public native /* synthetic */ void setStreamUseCase(long j8);
}
