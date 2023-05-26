package com.mixpanel.android.viewcrawler;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
class UIThreadSet<T> {

    /* renamed from: a  reason: collision with root package name */
    private Set<T> f19502a = new HashSet();

    public void a(T t7) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f19502a.add(t7);
            return;
        }
        throw new RuntimeException("Can't add an activity when not on the UI thread");
    }

    public Set<T> b() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return Collections.unmodifiableSet(this.f19502a);
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }

    public void c(T t7) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f19502a.remove(t7);
            return;
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }
}
