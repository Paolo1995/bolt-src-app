package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: f  reason: collision with root package name */
    private final Uri f9963f;

    /* renamed from: g  reason: collision with root package name */
    private final ThumbnailStreamOpener f9964g;

    /* renamed from: h  reason: collision with root package name */
    private InputStream f9965h;

    /* loaded from: classes.dex */
    static class ImageThumbnailQuery implements ThumbnailQuery {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f9966b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f9967a;

        ImageThumbnailQuery(ContentResolver contentResolver) {
            this.f9967a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor a(Uri uri) {
            return this.f9967a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f9966b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes.dex */
    static class VideoThumbnailQuery implements ThumbnailQuery {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f9968b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f9969a;

        VideoThumbnailQuery(ContentResolver contentResolver) {
            this.f9969a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor a(Uri uri) {
            return this.f9969a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f9968b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f9963f = uri;
        this.f9964g = thumbnailStreamOpener;
    }

    private static ThumbFetcher c(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.c(context).j().g(), thumbnailQuery, Glide.c(context).e(), context.getContentResolver()));
    }

    public static ThumbFetcher f(Context context, Uri uri) {
        return c(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher g(Context context, Uri uri) {
        return c(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    private InputStream h() throws FileNotFoundException {
        int i8;
        InputStream d8 = this.f9964g.d(this.f9963f);
        if (d8 != null) {
            i8 = this.f9964g.a(this.f9963f);
        } else {
            i8 = -1;
        }
        if (i8 != -1) {
            return new ExifOrientationStream(d8, i8);
        }
        return d8;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        InputStream inputStream = this.f9965h;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
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

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream h8 = h();
            this.f9965h = h8;
            dataCallback.f(h8);
        } catch (FileNotFoundException e8) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e8);
            }
            dataCallback.c(e8);
        }
    }
}
