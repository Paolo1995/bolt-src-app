package com.bumptech.glide.manager;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class ApplicationLifecycle implements Lifecycle {
    @Override // com.bumptech.glide.manager.Lifecycle
    public void a(@NonNull LifecycleListener lifecycleListener) {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void b(@NonNull LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
