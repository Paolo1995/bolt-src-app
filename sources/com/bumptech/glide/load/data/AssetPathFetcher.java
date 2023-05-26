package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: f  reason: collision with root package name */
    private final String f9933f;

    /* renamed from: g  reason: collision with root package name */
    private final AssetManager f9934g;

    /* renamed from: h  reason: collision with root package name */
    private T f9935h;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f9934g = assetManager;
        this.f9933f = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        T t7 = this.f9935h;
        if (t7 == null) {
            return;
        }
        try {
            c(t7);
        } catch (IOException unused) {
        }
    }

    protected abstract void c(T t7) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T f8 = f(this.f9934g, this.f9933f);
            this.f9935h = f8;
            dataCallback.f(f8);
        } catch (IOException e8) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e8);
            }
            dataCallback.c(e8);
        }
    }

    protected abstract T f(AssetManager assetManager, String str) throws IOException;
}
