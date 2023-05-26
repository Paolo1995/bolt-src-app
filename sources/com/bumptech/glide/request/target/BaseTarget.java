package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

@Deprecated
/* loaded from: classes.dex */
public abstract class BaseTarget<Z> implements Target<Z> {

    /* renamed from: f  reason: collision with root package name */
    private Request f10722f;

    @Override // com.bumptech.glide.request.target.Target
    public void b(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public Request c() {
        return this.f10722f;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void d(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void g(Request request) {
        this.f10722f = request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void i(Drawable drawable) {
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
}
