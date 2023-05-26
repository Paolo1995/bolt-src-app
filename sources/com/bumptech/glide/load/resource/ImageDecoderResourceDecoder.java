package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {

    /* renamed from: a  reason: collision with root package name */
    final HardwareConfigState f10403a = HardwareConfigState.b();

    protected abstract Resource<T> c(ImageDecoder.Source source, int i8, int i9, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public final Resource<T> b(@NonNull ImageDecoder.Source source, final int i8, final int i9, @NonNull Options options) throws IOException {
        final boolean z7;
        final DecodeFormat decodeFormat = (DecodeFormat) options.c(Downsampler.f10446f);
        final DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f10441h);
        Option<Boolean> option = Downsampler.f10450j;
        if (options.c(option) != null && ((Boolean) options.c(option)).booleanValue()) {
            z7 = true;
        } else {
            z7 = false;
        }
        final PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.c(Downsampler.f10447g);
        return c(source, i8, i9, new ImageDecoder.OnHeaderDecodedListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1
            @SuppressLint({"Override"})
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                ColorSpace.Named named;
                boolean z8 = false;
                if (ImageDecoderResourceDecoder.this.f10403a.e(i8, i9, z7, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1.1
                    public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                Size size = imageInfo.getSize();
                int i10 = i8;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = size.getWidth();
                }
                int i11 = i9;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = size.getHeight();
                }
                float b8 = downsampleStrategy.b(size.getWidth(), size.getHeight(), i10, i11);
                int round = Math.round(size.getWidth() * b8);
                int round2 = Math.round(size.getHeight() * b8);
                if (Log.isLoggable("ImageDecoder", 2)) {
                    Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b8);
                }
                imageDecoder.setTargetSize(round, round2);
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 28) {
                    if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                        z8 = true;
                    }
                    if (z8) {
                        named = ColorSpace.Named.DISPLAY_P3;
                    } else {
                        named = ColorSpace.Named.SRGB;
                    }
                    imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                } else if (i12 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            }
        });
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: e */
    public final boolean a(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        return true;
    }
}
