package com.bumptech.glide.load.model;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final DataDecoder<Data> f10296a;

    /* loaded from: classes.dex */
    public interface DataDecoder<Data> {
        Class<Data> a();

        Data b(String str) throws IllegalArgumentException;

        void close(Data data) throws IOException;
    }

    /* loaded from: classes.dex */
    private static final class DataUriFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: f  reason: collision with root package name */
        private final String f10297f;

        /* renamed from: g  reason: collision with root package name */
        private final DataDecoder<Data> f10298g;

        /* renamed from: h  reason: collision with root package name */
        private Data f10299h;

        DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            this.f10297f = str;
            this.f10298g = dataDecoder;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> a() {
            return this.f10298g.a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            try {
                this.f10298g.close(this.f10299h);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data b8 = this.f10298g.b(this.f10297f);
                this.f10299h = b8;
                dataCallback.f(b8);
            } catch (IllegalArgumentException e8) {
                dataCallback.c(e8);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final DataDecoder<InputStream> f10300a = new DataDecoder<InputStream>() { // from class: com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.1
            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            /* renamed from: c */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            /* renamed from: d */
            public InputStream b(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        };

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Model, InputStream> b(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f10300a);
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.f10296a = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> b(@NonNull Model model, int i8, int i9, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new DataUriFetcher(model.toString(), this.f10296a));
    }
}
