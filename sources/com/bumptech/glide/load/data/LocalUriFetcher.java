package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Uri f9957f;

    /* renamed from: g  reason: collision with root package name */
    private final ContentResolver f9958g;

    /* renamed from: h  reason: collision with root package name */
    private T f9959h;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f9958g = contentResolver;
        this.f9957f = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        T t7 = this.f9959h;
        if (t7 != null) {
            try {
                c(t7);
            } catch (IOException unused) {
            }
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
    public final void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T f8 = f(this.f9957f, this.f9958g);
            this.f9959h = f8;
            dataCallback.f(f8);
        } catch (FileNotFoundException e8) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e8);
            }
            dataCallback.c(e8);
        }
    }

    protected abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
