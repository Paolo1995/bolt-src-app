package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R$attr;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes.dex */
public class ElevationOverlayProvider {

    /* renamed from: f  reason: collision with root package name */
    private static final int f13390f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f13391a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13392b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13393c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13394d;

    /* renamed from: e  reason: collision with root package name */
    private final float f13395e;

    public ElevationOverlayProvider(@NonNull Context context) {
        this(MaterialAttributes.b(context, R$attr.elevationOverlayEnabled, false), MaterialColors.b(context, R$attr.elevationOverlayColor, 0), MaterialColors.b(context, R$attr.elevationOverlayAccentColor, 0), MaterialColors.b(context, R$attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean f(int i8) {
        if (ColorUtils.j(i8, 255) == this.f13394d) {
            return true;
        }
        return false;
    }

    public float a(float f8) {
        float f9 = this.f13395e;
        if (f9 <= 0.0f || f8 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f8 / f9)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i8, float f8) {
        int i9;
        float a8 = a(f8);
        int alpha = Color.alpha(i8);
        int j8 = MaterialColors.j(ColorUtils.j(i8, 255), this.f13392b, a8);
        if (a8 > 0.0f && (i9 = this.f13393c) != 0) {
            j8 = MaterialColors.i(j8, ColorUtils.j(i9, f13390f));
        }
        return ColorUtils.j(j8, alpha);
    }

    public int c(int i8, float f8) {
        if (this.f13391a && f(i8)) {
            return b(i8, f8);
        }
        return i8;
    }

    public int d(float f8) {
        return c(this.f13394d, f8);
    }

    public boolean e() {
        return this.f13391a;
    }

    public ElevationOverlayProvider(boolean z7, int i8, int i9, int i10, float f8) {
        this.f13391a = z7;
        this.f13392b = i8;
        this.f13393c = i9;
        this.f13394d = i10;
        this.f13395e = f8;
    }
}
