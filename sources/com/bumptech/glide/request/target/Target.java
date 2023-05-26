package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public interface Target<R> extends LifecycleListener {
    void a(@NonNull SizeReadyCallback sizeReadyCallback);

    void b(Drawable drawable);

    Request c();

    void d(Drawable drawable);

    void e(@NonNull R r7, Transition<? super R> transition);

    void g(Request request);

    void i(Drawable drawable);

    void k(@NonNull SizeReadyCallback sizeReadyCallback);
}
