package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class IndeterminateAnimatorDelegate<T extends Animator> {

    /* renamed from: a  reason: collision with root package name */
    protected IndeterminateDrawable f13835a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f13836b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f13837c;

    /* JADX INFO: Access modifiers changed from: protected */
    public IndeterminateAnimatorDelegate(int i8) {
        this.f13836b = new float[i8 * 2];
        this.f13837c = new int[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public float b(int i8, int i9, int i10) {
        return (i8 - i9) / i10;
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull IndeterminateDrawable indeterminateDrawable) {
        this.f13835a = indeterminateDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
