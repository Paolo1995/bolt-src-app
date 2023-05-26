package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int a(@NonNull Canvas canvas, float f8, float f9, float f10, float f11, int i8) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f8, f9, f10, f11, i8);
        }
        return canvas.saveLayerAlpha(f8, f9, f10, f11, i8, 31);
    }
}
