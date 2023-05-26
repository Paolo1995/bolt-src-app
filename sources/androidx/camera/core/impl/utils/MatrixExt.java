package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class MatrixExt {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f3819a = new float[16];

    private MatrixExt() {
    }

    private static void a(float[] fArr, float f8, float f9) {
        Matrix.translateM(fArr, 0, -f8, -f9, 0.0f);
    }

    private static void b(float[] fArr, float f8, float f9) {
        Matrix.translateM(fArr, 0, f8, f9, 0.0f);
    }

    public static void c(@NonNull float[] fArr, float f8, float f9, float f10) {
        b(fArr, f9, f10);
        Matrix.rotateM(fArr, 0, f8, 0.0f, 0.0f, 1.0f);
        a(fArr, f9, f10);
    }
}
