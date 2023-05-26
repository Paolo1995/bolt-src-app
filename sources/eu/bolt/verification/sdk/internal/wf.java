package eu.bolt.verification.sdk.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class wf extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f45548a;

    /* renamed from: b  reason: collision with root package name */
    private final int f45549b;

    /* renamed from: c  reason: collision with root package name */
    private final int f45550c;

    public wf(Drawable decorated, int i8, int i9) {
        Intrinsics.f(decorated, "decorated");
        this.f45548a = decorated;
        this.f45549b = i8;
        this.f45550c = i9;
        setBounds(0, 0, i8, i9);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        this.f45548a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f45550c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f45549b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f45548a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f45548a.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i8, int i9, int i10, int i11) {
        super.setBounds(i8, i9, i10, i11);
        this.f45548a.setBounds(i8, i9, i10, i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f45548a.setColorFilter(colorFilter);
    }
}
