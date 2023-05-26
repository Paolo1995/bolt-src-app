package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

/* loaded from: classes.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f10434a = new AtLeast();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f10435b = new AtMost();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f10436c = new FitCenter();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f10437d = new CenterInside();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f10438e;

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f10439f;

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f10440g;

    /* renamed from: h  reason: collision with root package name */
    public static final Option<DownsampleStrategy> f10441h;

    /* renamed from: i  reason: collision with root package name */
    static final boolean f10442i;

    /* loaded from: classes.dex */
    private static class AtLeast extends DownsampleStrategy {
        AtLeast() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i8, int i9, int i10, int i11) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i8, int i9, int i10, int i11) {
            int min = Math.min(i9 / i11, i8 / i10);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }
    }

    /* loaded from: classes.dex */
    private static class AtMost extends DownsampleStrategy {
        AtMost() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i8, int i9, int i10, int i11) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i8, int i9, int i10, int i11) {
            int ceil = (int) Math.ceil(Math.max(i9 / i11, i8 / i10));
            int i12 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i12 = 0;
            }
            return 1.0f / (max << i12);
        }
    }

    /* loaded from: classes.dex */
    private static class CenterInside extends DownsampleStrategy {
        CenterInside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i8, int i9, int i10, int i11) {
            if (b(i8, i9, i10, i11) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.f10436c.a(i8, i9, i10, i11);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i8, int i9, int i10, int i11) {
            return Math.min(1.0f, DownsampleStrategy.f10436c.b(i8, i9, i10, i11));
        }
    }

    /* loaded from: classes.dex */
    private static class CenterOutside extends DownsampleStrategy {
        CenterOutside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i8, int i9, int i10, int i11) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i8, int i9, int i10, int i11) {
            return Math.max(i10 / i8, i11 / i9);
        }
    }

    /* loaded from: classes.dex */
    private static class FitCenter extends DownsampleStrategy {
        FitCenter() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i8, int i9, int i10, int i11) {
            if (DownsampleStrategy.f10442i) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i8, int i9, int i10, int i11) {
            if (DownsampleStrategy.f10442i) {
                return Math.min(i10 / i8, i11 / i9);
            }
            int max = Math.max(i9 / i11, i8 / i10);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(max);
        }
    }

    /* loaded from: classes.dex */
    private static class None extends DownsampleStrategy {
        None() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i8, int i9, int i10, int i11) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i8, int i9, int i10, int i11) {
            return 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    static {
        CenterOutside centerOutside = new CenterOutside();
        f10438e = centerOutside;
        f10439f = new None();
        f10440g = centerOutside;
        f10441h = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", centerOutside);
        f10442i = true;
    }

    public abstract SampleSizeRounding a(int i8, int i9, int i10, int i11);

    public abstract float b(int i8, int i9, int i10, int i11);
}
