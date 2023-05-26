package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

/* loaded from: classes.dex */
public abstract class CustomTarget<T> implements Target<T> {

    /* renamed from: f  reason: collision with root package name */
    private final int f10723f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10724g;

    /* renamed from: h  reason: collision with root package name */
    private Request f10725h;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void a(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void b(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request c() {
        return this.f10725h;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void g(Request request) {
        this.f10725h = request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void i(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void k(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.e(this.f10723f, this.f10724g);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    public CustomTarget(int i8, int i9) {
        if (Util.t(i8, i9)) {
            this.f10723f = i8;
            this.f10724g = i9;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i8 + " and height: " + i9);
    }
}
