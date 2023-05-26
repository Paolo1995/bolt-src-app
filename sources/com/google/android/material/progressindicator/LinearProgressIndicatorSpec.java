package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

/* loaded from: classes.dex */
public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {

    /* renamed from: g  reason: collision with root package name */
    public int f13865g;

    /* renamed from: h  reason: collision with root package name */
    public int f13866h;

    /* renamed from: i  reason: collision with root package name */
    boolean f13867i;

    public LinearProgressIndicatorSpec(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    public void e() {
        if (this.f13865g == 0) {
            if (this.f13782b <= 0) {
                if (this.f13783c.length < 3) {
                    throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
                }
                return;
            }
            throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
        }
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, LinearProgressIndicator.f13864u);
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        TypedArray i10 = ThemeEnforcement.i(context, attributeSet, R$styleable.f12607m3, R$attr.linearProgressIndicatorStyle, LinearProgressIndicator.f13864u, new int[0]);
        this.f13865g = i10.getInt(R$styleable.f12616n3, 1);
        this.f13866h = i10.getInt(R$styleable.f12625o3, 0);
        i10.recycle();
        e();
        this.f13867i = this.f13866h == 1;
    }
}
