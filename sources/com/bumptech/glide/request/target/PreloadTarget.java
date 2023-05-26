package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public final class PreloadTarget<Z> extends CustomTarget<Z> {

    /* renamed from: j  reason: collision with root package name */
    private static final Handler f10739j = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bumptech.glide.request.target.PreloadTarget.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((PreloadTarget) message.obj).f();
                return true;
            }
            return false;
        }
    });

    /* renamed from: i  reason: collision with root package name */
    private final RequestManager f10740i;

    private PreloadTarget(RequestManager requestManager, int i8, int i9) {
        super(i8, i9);
        this.f10740i = requestManager;
    }

    public static <Z> PreloadTarget<Z> h(RequestManager requestManager, int i8, int i9) {
        return new PreloadTarget<>(requestManager, i8, i9);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void d(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void e(@NonNull Z z7, Transition<? super Z> transition) {
        f10739j.obtainMessage(1, this).sendToTarget();
    }

    void f() {
        this.f10740i.n(this);
    }
}
