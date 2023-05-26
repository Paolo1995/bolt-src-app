package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* loaded from: classes.dex */
public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {

    /* renamed from: g  reason: collision with root package name */
    public int f13807g;

    /* renamed from: h  reason: collision with root package name */
    public int f13808h;

    /* renamed from: i  reason: collision with root package name */
    public int f13809i;

    public CircularProgressIndicatorSpec(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    public void e() {
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, CircularProgressIndicator.f13806u);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        TypedArray i10 = ThemeEnforcement.i(context, attributeSet, R$styleable.E1, i8, i9, new int[0]);
        this.f13807g = Math.max(MaterialResources.d(context, i10, R$styleable.H1, dimensionPixelSize), this.f13781a * 2);
        this.f13808h = MaterialResources.d(context, i10, R$styleable.G1, dimensionPixelSize2);
        this.f13809i = i10.getInt(R$styleable.F1, 0);
        i10.recycle();
        e();
    }
}
