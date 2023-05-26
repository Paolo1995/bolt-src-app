package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

/* loaded from: classes.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final UnitModelLoader<?> f10368a = new UnitModelLoader<>();

    /* loaded from: classes.dex */
    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final Factory<?> f10369a = new Factory<>();

        public static <T> Factory<T> a() {
            return (Factory<T>) f10369a;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Model, Model> b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.c();
        }
    }

    /* loaded from: classes.dex */
    private static class UnitFetcher<Model> implements DataFetcher<Model> {

        /* renamed from: f  reason: collision with root package name */
        private final Model f10370f;

        UnitFetcher(Model model) {
            this.f10370f = model;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f10370f.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.f((Model) this.f10370f);
        }
    }

    public static <T> UnitModelLoader<T> c() {
        return (UnitModelLoader<T>) f10368a;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(@NonNull Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Model> b(@NonNull Model model, int i8, int i9, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new UnitFetcher(model));
    }
}
