package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class ActivityFragmentLifecycle implements Lifecycle {

    /* renamed from: a  reason: collision with root package name */
    private final Set<LifecycleListener> f10582a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f10583b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10584c;

    @Override // com.bumptech.glide.manager.Lifecycle
    public void a(@NonNull LifecycleListener lifecycleListener) {
        this.f10582a.remove(lifecycleListener);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void b(@NonNull LifecycleListener lifecycleListener) {
        this.f10582a.add(lifecycleListener);
        if (this.f10584c) {
            lifecycleListener.onDestroy();
        } else if (this.f10583b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f10584c = true;
        for (LifecycleListener lifecycleListener : Util.j(this.f10582a)) {
            lifecycleListener.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f10583b = true;
        for (LifecycleListener lifecycleListener : Util.j(this.f10582a)) {
            lifecycleListener.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f10583b = false;
        for (LifecycleListener lifecycleListener : Util.j(this.f10582a)) {
            lifecycleListener.onStop();
        }
    }
}
