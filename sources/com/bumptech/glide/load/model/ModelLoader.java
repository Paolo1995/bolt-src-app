package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface ModelLoader<Model, Data> {

    /* loaded from: classes.dex */
    public static class LoadData<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Key f10335a;

        /* renamed from: b  reason: collision with root package name */
        public final List<Key> f10336b;

        /* renamed from: c  reason: collision with root package name */
        public final DataFetcher<Data> f10337c;

        public LoadData(@NonNull Key key, @NonNull DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public LoadData(@NonNull Key key, @NonNull List<Key> list, @NonNull DataFetcher<Data> dataFetcher) {
            this.f10335a = (Key) Preconditions.d(key);
            this.f10336b = (List) Preconditions.d(list);
            this.f10337c = (DataFetcher) Preconditions.d(dataFetcher);
        }
    }

    boolean a(@NonNull Model model);

    LoadData<Data> b(@NonNull Model model, int i8, int i9, @NonNull Options options);
}
