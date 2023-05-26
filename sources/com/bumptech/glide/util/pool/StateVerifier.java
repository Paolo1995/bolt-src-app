package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class StateVerifier {

    /* loaded from: classes.dex */
    private static class DefaultStateVerifier extends StateVerifier {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f10794a;

        DefaultStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void b(boolean z7) {
            this.f10794a = z7;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void c() {
            if (!this.f10794a) {
                return;
            }
            throw new IllegalStateException("Already released");
        }
    }

    private StateVerifier() {
    }

    @NonNull
    public static StateVerifier a() {
        return new DefaultStateVerifier();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(boolean z7);

    public abstract void c();
}
