package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* loaded from: classes.dex */
public abstract class BaseProgressIndicatorSpec {

    /* renamed from: a  reason: collision with root package name */
    public int f13781a;

    /* renamed from: b  reason: collision with root package name */
    public int f13782b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public int[] f13783c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    public int f13784d;

    /* renamed from: e  reason: collision with root package name */
    public int f13785e;

    /* renamed from: f  reason: collision with root package name */
    public int f13786f;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseProgressIndicatorSpec(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        TypedArray i10 = ThemeEnforcement.i(context, attributeSet, R$styleable.S, i8, i9, new int[0]);
        this.f13781a = MaterialResources.d(context, i10, R$styleable.f12496a0, dimensionPixelSize);
        this.f13782b = Math.min(MaterialResources.d(context, i10, R$styleable.Z, 0), this.f13781a / 2);
        this.f13785e = i10.getInt(R$styleable.W, 0);
        this.f13786f = i10.getInt(R$styleable.T, 0);
        c(context, i10);
        d(context, i10);
        i10.recycle();
    }

    private void c(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i8 = R$styleable.U;
        if (!typedArray.hasValue(i8)) {
            this.f13783c = new int[]{MaterialColors.b(context, R$attr.f12486p, -1)};
        } else if (typedArray.peekValue(i8).type != 1) {
            this.f13783c = new int[]{typedArray.getColor(i8, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i8, -1));
            this.f13783c = intArray;
            if (intArray.length != 0) {
                return;
            }
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void d(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i8 = R$styleable.Y;
        if (typedArray.hasValue(i8)) {
            this.f13784d = typedArray.getColor(i8, -1);
            return;
        }
        this.f13784d = this.f13783c[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
        float f8 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f13784d = MaterialColors.a(this.f13784d, (int) (f8 * 255.0f));
    }

    public boolean a() {
        if (this.f13786f != 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f13785e != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();
}
