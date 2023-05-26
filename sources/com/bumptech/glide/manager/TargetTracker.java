package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class TargetTracker implements LifecycleListener {

    /* renamed from: f  reason: collision with root package name */
    private final Set<Target<?>> f10618f = Collections.newSetFromMap(new WeakHashMap());

    public void f() {
        this.f10618f.clear();
    }

    @NonNull
    public List<Target<?>> h() {
        return Util.j(this.f10618f);
    }

    public void j(@NonNull Target<?> target) {
        this.f10618f.add(target);
    }

    public void l(@NonNull Target<?> target) {
        this.f10618f.remove(target);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        for (Target target : Util.j(this.f10618f)) {
            target.onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        for (Target target : Util.j(this.f10618f)) {
            target.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        for (Target target : Util.j(this.f10618f)) {
            target.onStop();
        }
    }
}
