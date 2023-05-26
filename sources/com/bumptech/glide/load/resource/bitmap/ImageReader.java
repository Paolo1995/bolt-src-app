package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
interface ImageReader {

    /* loaded from: classes.dex */
    public static final class InputStreamImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStreamRewinder f10475a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayPool f10476b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f10477c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.f10476b = (ArrayPool) Preconditions.d(arrayPool);
            this.f10477c = (List) Preconditions.d(list);
            this.f10475a = new InputStreamRewinder(inputStream, arrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f10475a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void b() {
            this.f10475a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int c() throws IOException {
            return ImageHeaderParserUtils.b(this.f10477c, this.f10475a.a(), this.f10476b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType d() throws IOException {
            return ImageHeaderParserUtils.e(this.f10477c, this.f10475a.a(), this.f10476b);
        }
    }

    /* loaded from: classes.dex */
    public static final class ParcelFileDescriptorImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayPool f10478a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f10479b;

        /* renamed from: c  reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f10480c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.f10478a = (ArrayPool) Preconditions.d(arrayPool);
            this.f10479b = (List) Preconditions.d(list);
            this.f10480c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f10480c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int c() throws IOException {
            return ImageHeaderParserUtils.a(this.f10479b, this.f10480c, this.f10478a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType d() throws IOException {
            return ImageHeaderParserUtils.d(this.f10479b, this.f10480c, this.f10478a);
        }
    }

    Bitmap a(BitmapFactory.Options options) throws IOException;

    void b();

    int c() throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
