package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
class ResourceRecycler {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10183a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f10184b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());

    /* loaded from: classes.dex */
    private static final class ResourceRecyclerCallback implements Handler.Callback {
        ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((Resource) message.obj).c();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Resource<?> resource, boolean z7) {
        if (!this.f10183a && !z7) {
            this.f10183a = true;
            resource.c();
            this.f10183a = false;
        }
        this.f10184b.obtainMessage(1, resource).sendToTarget();
    }
}
