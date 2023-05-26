package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ModelLoaderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final MultiModelLoaderFactory f10338a;

    /* renamed from: b  reason: collision with root package name */
    private final ModelLoaderCache f10339b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ModelLoaderCache {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, Entry<?>> f10340a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Entry<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<ModelLoader<Model, ?>> f10341a;

            public Entry(List<ModelLoader<Model, ?>> list) {
                this.f10341a = list;
            }
        }

        ModelLoaderCache() {
        }

        public void a() {
            this.f10340a.clear();
        }

        public <Model> List<ModelLoader<Model, ?>> b(Class<Model> cls) {
            Entry<?> entry = this.f10340a.get(cls);
            if (entry == null) {
                return null;
            }
            return (List<ModelLoader<Model, ?>>) entry.f10341a;
        }

        public <Model> void c(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.f10340a.put(cls, new Entry<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public ModelLoaderRegistry(@NonNull Pools$Pool<List<Throwable>> pools$Pool) {
        this(new MultiModelLoaderFactory(pools$Pool));
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a8) {
        return (Class<A>) a8.getClass();
    }

    @NonNull
    private synchronized <A> List<ModelLoader<A, ?>> e(@NonNull Class<A> cls) {
        List<ModelLoader<A, ?>> b8;
        b8 = this.f10339b.b(cls);
        if (b8 == null) {
            b8 = Collections.unmodifiableList(this.f10338a.e(cls));
            this.f10339b.c(cls, b8);
        }
        return b8;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f10338a.b(cls, cls2, modelLoaderFactory);
        this.f10339b.a();
    }

    @NonNull
    public synchronized List<Class<?>> c(@NonNull Class<?> cls) {
        return this.f10338a.g(cls);
    }

    @NonNull
    public <A> List<ModelLoader<A, ?>> d(@NonNull A a8) {
        List<ModelLoader<A, ?>> e8 = e(b(a8));
        if (!e8.isEmpty()) {
            int size = e8.size();
            List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
            boolean z7 = true;
            for (int i8 = 0; i8 < size; i8++) {
                ModelLoader<A, ?> modelLoader = e8.get(i8);
                if (modelLoader.a(a8)) {
                    if (z7) {
                        emptyList = new ArrayList<>(size - i8);
                        z7 = false;
                    }
                    emptyList.add(modelLoader);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a8, e8);
        }
        throw new Registry.NoModelLoaderAvailableException(a8);
    }

    private ModelLoaderRegistry(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f10339b = new ModelLoaderCache();
        this.f10338a = multiModelLoaderFactory;
    }
}
