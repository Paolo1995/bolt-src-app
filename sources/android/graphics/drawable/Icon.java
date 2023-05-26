package android.graphics.drawable;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final /* synthetic */ class Icon implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ Icon createWithBitmap(Bitmap bitmap);

    @NonNull
    public static native /* synthetic */ Icon createWithContentUri(String str);

    @NonNull
    public static native /* synthetic */ Icon createWithData(byte[] bArr, int i8, int i9);

    @NonNull
    public static native /* synthetic */ Icon createWithResource(String str, int i8);

    @Nullable
    public native /* synthetic */ Drawable loadDrawable(Context context);

    @NonNull
    public native /* synthetic */ Icon setTintList(ColorStateList colorStateList);

    @NonNull
    public native /* synthetic */ Icon setTintMode(@NonNull PorterDuff.Mode mode);
}
