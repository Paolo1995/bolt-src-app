package eu.bolt.verification.sdk.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* loaded from: classes5.dex */
public class e0 {
    public static Bitmap a(Bitmap bitmap, float f8) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(f8);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
