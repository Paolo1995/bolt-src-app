package android.view;

import android.annotation.NonNull;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final /* synthetic */ class PointerIcon implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ PointerIcon create(@NonNull Bitmap bitmap, float f8, float f9);

    @NonNull
    public static native /* synthetic */ PointerIcon getSystemIcon(@NonNull Context context, int i8);

    @NonNull
    public static native /* synthetic */ PointerIcon load(@NonNull Resources resources, int i8);
}
