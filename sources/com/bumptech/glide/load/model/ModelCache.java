package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: classes.dex */
public class ModelCache<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<ModelKey<A>, B> f10329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ModelKey<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<ModelKey<?>> f10331d = Util.f(0);

        /* renamed from: a  reason: collision with root package name */
        private int f10332a;

        /* renamed from: b  reason: collision with root package name */
        private int f10333b;

        /* renamed from: c  reason: collision with root package name */
        private A f10334c;

        private ModelKey() {
        }

        static <A> ModelKey<A> a(A a8, int i8, int i9) {
            ModelKey<A> modelKey;
            Queue<ModelKey<?>> queue = f10331d;
            synchronized (queue) {
                modelKey = (ModelKey<A>) queue.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            modelKey.b(a8, i8, i9);
            return modelKey;
        }

        private void b(A a8, int i8, int i9) {
            this.f10334c = a8;
            this.f10333b = i8;
            this.f10332a = i9;
        }

        public void c() {
            Queue<ModelKey<?>> queue = f10331d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.f10333b != modelKey.f10333b || this.f10332a != modelKey.f10332a || !this.f10334c.equals(modelKey.f10334c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f10332a * 31) + this.f10333b) * 31) + this.f10334c.hashCode();
        }
    }

    public ModelCache() {
        this(250L);
    }

    public B a(A a8, int i8, int i9) {
        ModelKey<A> a9 = ModelKey.a(a8, i8, i9);
        B g8 = this.f10329a.g(a9);
        a9.c();
        return g8;
    }

    public void b(A a8, int i8, int i9, B b8) {
        this.f10329a.k(ModelKey.a(a8, i8, i9), b8);
    }

    public ModelCache(long j8) {
        this.f10329a = new LruCache<ModelKey<A>, B>(j8) { // from class: com.bumptech.glide.load.model.ModelCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bumptech.glide.util.LruCache
            /* renamed from: n */
            public void j(@NonNull ModelKey<A> modelKey, B b8) {
                modelKey.c();
            }
        };
    }
}
