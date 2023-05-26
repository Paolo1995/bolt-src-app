package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiModelLoaderFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final Factory f10351e = new Factory();

    /* renamed from: f  reason: collision with root package name */
    private static final ModelLoader<Object, Object> f10352f = new EmptyModelLoader();

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?, ?>> f10353a;

    /* renamed from: b  reason: collision with root package name */
    private final Factory f10354b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Entry<?, ?>> f10355c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f10356d;

    /* loaded from: classes.dex */
    private static class EmptyModelLoader implements ModelLoader<Object, Object> {
        EmptyModelLoader() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean a(@NonNull Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public ModelLoader.LoadData<Object> b(@NonNull Object obj, int i8, int i9, @NonNull Options options) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Entry<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f10357a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f10358b;

        /* renamed from: c  reason: collision with root package name */
        final ModelLoaderFactory<? extends Model, ? extends Data> f10359c;

        public Entry(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f10357a = cls;
            this.f10358b = cls2;
            this.f10359c = modelLoaderFactory;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f10357a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (a(cls) && this.f10358b.isAssignableFrom(cls2)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class Factory {
        Factory() {
        }

        @NonNull
        public <Model, Data> MultiModelLoader<Model, Data> a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools$Pool<List<Throwable>> pools$Pool) {
            return new MultiModelLoader<>(list, pools$Pool);
        }
    }

    public MultiModelLoaderFactory(@NonNull Pools$Pool<List<Throwable>> pools$Pool) {
        this(pools$Pool, f10351e);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z7) {
        int i8;
        Entry<?, ?> entry = new Entry<>(cls, cls2, modelLoaderFactory);
        List<Entry<?, ?>> list = this.f10353a;
        if (z7) {
            i8 = list.size();
        } else {
            i8 = 0;
        }
        list.add(i8, entry);
    }

    @NonNull
    private <Model, Data> ModelLoader<Model, Data> c(@NonNull Entry<?, ?> entry) {
        return (ModelLoader) Preconditions.d(entry.f10359c.b(this));
    }

    @NonNull
    private static <Model, Data> ModelLoader<Model, Data> f() {
        return (ModelLoader<Model, Data>) f10352f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        a(cls, cls2, modelLoaderFactory, true);
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z7 = false;
            for (Entry<?, ?> entry : this.f10353a) {
                if (this.f10355c.contains(entry)) {
                    z7 = true;
                } else if (entry.b(cls, cls2)) {
                    this.f10355c.add(entry);
                    arrayList.add(c(entry));
                    this.f10355c.remove(entry);
                }
            }
            if (arrayList.size() > 1) {
                return this.f10354b.a(arrayList, this.f10356d);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z7) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f10355c.clear();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<ModelLoader<Model, ?>> e(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Entry<?, ?> entry : this.f10353a) {
                if (!this.f10355c.contains(entry) && entry.a(cls)) {
                    this.f10355c.add(entry);
                    arrayList.add(c(entry));
                    this.f10355c.remove(entry);
                }
            }
        } catch (Throwable th) {
            this.f10355c.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Entry<?, ?> entry : this.f10353a) {
            if (!arrayList.contains(entry.f10358b) && entry.a(cls)) {
                arrayList.add(entry.f10358b);
            }
        }
        return arrayList;
    }

    MultiModelLoaderFactory(@NonNull Pools$Pool<List<Throwable>> pools$Pool, @NonNull Factory factory) {
        this.f10353a = new ArrayList();
        this.f10355c = new HashSet();
        this.f10356d = pools$Pool;
        this.f10354b = factory;
    }
}
