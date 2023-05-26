package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10385a;

    /* renamed from: b  reason: collision with root package name */
    private final ModelLoader<File, DataT> f10386b;

    /* renamed from: c  reason: collision with root package name */
    private final ModelLoader<Uri, DataT> f10387c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f10388d;

    /* loaded from: classes.dex */
    private static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f10389a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<DataT> f10390b;

        Factory(Context context, Class<DataT> cls) {
            this.f10389a = context;
            this.f10390b = cls;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public final ModelLoader<Uri, DataT> b(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.f10389a, multiModelLoaderFactory.d(File.class, this.f10390b), multiModelLoaderFactory.d(Uri.class, this.f10390b), this.f10390b);
        }
    }

    /* loaded from: classes.dex */
    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {

        /* renamed from: p  reason: collision with root package name */
        private static final String[] f10391p = {"_data"};

        /* renamed from: f  reason: collision with root package name */
        private final Context f10392f;

        /* renamed from: g  reason: collision with root package name */
        private final ModelLoader<File, DataT> f10393g;

        /* renamed from: h  reason: collision with root package name */
        private final ModelLoader<Uri, DataT> f10394h;

        /* renamed from: i  reason: collision with root package name */
        private final Uri f10395i;

        /* renamed from: j  reason: collision with root package name */
        private final int f10396j;

        /* renamed from: k  reason: collision with root package name */
        private final int f10397k;

        /* renamed from: l  reason: collision with root package name */
        private final Options f10398l;

        /* renamed from: m  reason: collision with root package name */
        private final Class<DataT> f10399m;

        /* renamed from: n  reason: collision with root package name */
        private volatile boolean f10400n;

        /* renamed from: o  reason: collision with root package name */
        private volatile DataFetcher<DataT> f10401o;

        QMediaStoreUriFetcher(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Uri uri, int i8, int i9, Options options, Class<DataT> cls) {
            this.f10392f = context.getApplicationContext();
            this.f10393g = modelLoader;
            this.f10394h = modelLoader2;
            this.f10395i = uri;
            this.f10396j = i8;
            this.f10397k = i9;
            this.f10398l = options;
            this.f10399m = cls;
        }

        private ModelLoader.LoadData<DataT> c() throws FileNotFoundException {
            boolean isExternalStorageLegacy;
            Uri uri;
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (isExternalStorageLegacy) {
                return this.f10393g.b(h(this.f10395i), this.f10396j, this.f10397k, this.f10398l);
            }
            if (g()) {
                uri = MediaStore.setRequireOriginal(this.f10395i);
            } else {
                uri = this.f10395i;
            }
            return this.f10394h.b(uri, this.f10396j, this.f10397k, this.f10398l);
        }

        private DataFetcher<DataT> f() throws FileNotFoundException {
            ModelLoader.LoadData<DataT> c8 = c();
            if (c8 != null) {
                return c8.f10337c;
            }
            return null;
        }

        private boolean g() {
            int checkSelfPermission;
            checkSelfPermission = this.f10392f.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
            if (checkSelfPermission == 0) {
                return true;
            }
            return false;
        }

        @NonNull
        private File h(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor query = this.f10392f.getContentResolver().query(uri, f10391p, null, null, null);
                if (query != null && query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        query.close();
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<DataT> a() {
            return this.f10399m;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            DataFetcher<DataT> dataFetcher = this.f10401o;
            if (dataFetcher != null) {
                dataFetcher.b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.f10400n = true;
            DataFetcher<DataT> dataFetcher = this.f10401o;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataFetcher<DataT> f8 = f();
                if (f8 == null) {
                    dataCallback.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f10395i));
                    return;
                }
                this.f10401o = f8;
                if (this.f10400n) {
                    cancel();
                } else {
                    f8.e(priority, dataCallback);
                }
            } catch (FileNotFoundException e8) {
                dataCallback.c(e8);
            }
        }
    }

    QMediaStoreUriLoader(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Class<DataT> cls) {
        this.f10385a = context.getApplicationContext();
        this.f10386b = modelLoader;
        this.f10387c = modelLoader2;
        this.f10388d = cls;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.LoadData<DataT> b(@NonNull Uri uri, int i8, int i9, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new QMediaStoreUriFetcher(this.f10385a, this.f10386b, this.f10387c, uri, i8, i9, options, this.f10388d));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.b(uri)) {
            return true;
        }
        return false;
    }
}
