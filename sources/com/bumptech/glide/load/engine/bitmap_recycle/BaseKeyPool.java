package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f10194a = Util.f(20);

    abstract T a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public T b() {
        T poll = this.f10194a.poll();
        if (poll == null) {
            return a();
        }
        return poll;
    }

    public void c(T t7) {
        if (this.f10194a.size() < 20) {
            this.f10194a.offer(t7);
        }
    }
}
