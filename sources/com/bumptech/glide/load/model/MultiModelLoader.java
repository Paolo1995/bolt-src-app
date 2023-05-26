package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader<Model, Data>> f10342a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f10343b;

    /* loaded from: classes.dex */
    static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: f  reason: collision with root package name */
        private final List<DataFetcher<Data>> f10344f;

        /* renamed from: g  reason: collision with root package name */
        private final Pools$Pool<List<Throwable>> f10345g;

        /* renamed from: h  reason: collision with root package name */
        private int f10346h;

        /* renamed from: i  reason: collision with root package name */
        private Priority f10347i;

        /* renamed from: j  reason: collision with root package name */
        private DataFetcher.DataCallback<? super Data> f10348j;

        /* renamed from: k  reason: collision with root package name */
        private List<Throwable> f10349k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f10350l;

        MultiFetcher(@NonNull List<DataFetcher<Data>> list, @NonNull Pools$Pool<List<Throwable>> pools$Pool) {
            this.f10345g = pools$Pool;
            Preconditions.c(list);
            this.f10344f = list;
            this.f10346h = 0;
        }

        private void g() {
            if (this.f10350l) {
                return;
            }
            if (this.f10346h < this.f10344f.size() - 1) {
                this.f10346h++;
                e(this.f10347i, this.f10348j);
                return;
            }
            Preconditions.d(this.f10349k);
            this.f10348j.c(new GlideException("Fetch failed", new ArrayList(this.f10349k)));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> a() {
            return this.f10344f.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            List<Throwable> list = this.f10349k;
            if (list != null) {
                this.f10345g.a(list);
            }
            this.f10349k = null;
            for (DataFetcher<Data> dataFetcher : this.f10344f) {
                dataFetcher.b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void c(@NonNull Exception exc) {
            ((List) Preconditions.d(this.f10349k)).add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.f10350l = true;
            for (DataFetcher<Data> dataFetcher : this.f10344f) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource d() {
            return this.f10344f.get(0).d();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.f10347i = priority;
            this.f10348j = dataCallback;
            this.f10349k = this.f10345g.b();
            this.f10344f.get(this.f10346h).e(priority, this);
            if (this.f10350l) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void f(Data data) {
            if (data != null) {
                this.f10348j.f(data);
            } else {
                g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools$Pool<List<Throwable>> pools$Pool) {
        this.f10342a = list;
        this.f10343b = pools$Pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(@NonNull Model model) {
        for (ModelLoader<Model, Data> modelLoader : this.f10342a) {
            if (modelLoader.a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> b(@NonNull Model model, int i8, int i9, @NonNull Options options) {
        ModelLoader.LoadData<Data> b8;
        int size = this.f10342a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i10 = 0; i10 < size; i10++) {
            ModelLoader<Model, Data> modelLoader = this.f10342a.get(i10);
            if (modelLoader.a(model) && (b8 = modelLoader.b(model, i8, i9, options)) != null) {
                key = b8.f10335a;
                arrayList.add(b8.f10337c);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new MultiFetcher(arrayList, this.f10343b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f10342a.toArray()) + '}';
    }
}
