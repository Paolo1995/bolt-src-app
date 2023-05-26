package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import j$.util.Spliterator;

/* loaded from: classes.dex */
public final class MemorySizeCalculator {

    /* renamed from: a  reason: collision with root package name */
    private final int f10248a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10249b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f10250c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10251d;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: i  reason: collision with root package name */
        static final int f10252i;

        /* renamed from: a  reason: collision with root package name */
        final Context f10253a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f10254b;

        /* renamed from: c  reason: collision with root package name */
        ScreenDimensions f10255c;

        /* renamed from: e  reason: collision with root package name */
        float f10257e;

        /* renamed from: d  reason: collision with root package name */
        float f10256d = 2.0f;

        /* renamed from: f  reason: collision with root package name */
        float f10258f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        float f10259g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        int f10260h = 4194304;

        static {
            int i8;
            if (Build.VERSION.SDK_INT < 26) {
                i8 = 4;
            } else {
                i8 = 1;
            }
            f10252i = i8;
        }

        public Builder(Context context) {
            this.f10257e = f10252i;
            this.f10253a = context;
            this.f10254b = (ActivityManager) context.getSystemService("activity");
            this.f10255c = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && MemorySizeCalculator.e(this.f10254b)) {
                this.f10257e = 0.0f;
            }
        }

        public MemorySizeCalculator a() {
            return new MemorySizeCalculator(this);
        }
    }

    /* loaded from: classes.dex */
    private static final class DisplayMetricsScreenDimensions implements ScreenDimensions {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f10261a;

        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.f10261a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int a() {
            return this.f10261a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int b() {
            return this.f10261a.widthPixels;
        }
    }

    /* loaded from: classes.dex */
    interface ScreenDimensions {
        int a();

        int b();
    }

    MemorySizeCalculator(Builder builder) {
        int i8;
        boolean z7;
        this.f10250c = builder.f10253a;
        if (e(builder.f10254b)) {
            i8 = builder.f10260h / 2;
        } else {
            i8 = builder.f10260h;
        }
        this.f10251d = i8;
        int c8 = c(builder.f10254b, builder.f10258f, builder.f10259g);
        float b8 = builder.f10255c.b() * builder.f10255c.a() * 4;
        int round = Math.round(builder.f10257e * b8);
        int round2 = Math.round(b8 * builder.f10256d);
        int i9 = c8 - i8;
        int i10 = round2 + round;
        if (i10 <= i9) {
            this.f10249b = round2;
            this.f10248a = round;
        } else {
            float f8 = i9;
            float f9 = builder.f10257e;
            float f10 = builder.f10256d;
            float f11 = f8 / (f9 + f10);
            this.f10249b = Math.round(f10 * f11);
            this.f10248a = Math.round(f11 * builder.f10257e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f10249b));
            sb.append(", pool size: ");
            sb.append(f(this.f10248a));
            sb.append(", byte array size: ");
            sb.append(f(i8));
            sb.append(", memory class limited? ");
            if (i10 > c8) {
                z7 = true;
            } else {
                z7 = false;
            }
            sb.append(z7);
            sb.append(", max size: ");
            sb.append(f(c8));
            sb.append(", memoryClass: ");
            sb.append(builder.f10254b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(builder.f10254b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f8, float f9) {
        float memoryClass = activityManager.getMemoryClass() * Spliterator.IMMUTABLE * Spliterator.IMMUTABLE;
        if (e(activityManager)) {
            f8 = f9;
        }
        return Math.round(memoryClass * f8);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i8) {
        return Formatter.formatFileSize(this.f10250c, i8);
    }

    public int a() {
        return this.f10251d;
    }

    public int b() {
        return this.f10248a;
    }

    public int d() {
        return this.f10249b;
    }
}
