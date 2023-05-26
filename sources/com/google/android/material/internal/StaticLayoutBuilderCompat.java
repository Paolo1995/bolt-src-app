package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.StaticLayout$Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
final class StaticLayoutBuilderCompat {

    /* renamed from: o  reason: collision with root package name */
    static final int f13654o;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f13655p;

    /* renamed from: q  reason: collision with root package name */
    private static Constructor<StaticLayout> f13656q;

    /* renamed from: r  reason: collision with root package name */
    private static Object f13657r;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f13658a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f13659b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13660c;

    /* renamed from: e  reason: collision with root package name */
    private int f13662e;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13669l;

    /* renamed from: n  reason: collision with root package name */
    private StaticLayoutBuilderConfigurer f13671n;

    /* renamed from: d  reason: collision with root package name */
    private int f13661d = 0;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f13663f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g  reason: collision with root package name */
    private int f13664g = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: h  reason: collision with root package name */
    private float f13665h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f13666i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f13667j = f13654o;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13668k = true;

    /* renamed from: m  reason: collision with root package name */
    private TextUtils.TruncateAt f13670m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        int i8;
        if (Build.VERSION.SDK_INT >= 23) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        f13654o = i8;
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i8) {
        this.f13658a = charSequence;
        this.f13659b = textPaint;
        this.f13660c = i8;
        this.f13662e = charSequence.length();
    }

    private void b() throws StaticLayoutBuilderCompatException {
        boolean z7;
        TextDirectionHeuristic textDirectionHeuristic;
        if (f13655p) {
            return;
        }
        try {
            if (this.f13669l && Build.VERSION.SDK_INT >= 23) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            f13657r = textDirectionHeuristic;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f13656q = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f13655p = true;
        } catch (Exception e8) {
            throw new StaticLayoutBuilderCompatException(e8);
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat c(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, int i8) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i8);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        TextDirectionHeuristic textDirectionHeuristic;
        if (this.f13658a == null) {
            this.f13658a = "";
        }
        int max = Math.max(0, this.f13660c);
        CharSequence charSequence = this.f13658a;
        if (this.f13664g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f13659b, max, this.f13670m);
        }
        int min = Math.min(charSequence.length(), this.f13662e);
        this.f13662e = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f13669l && this.f13664g == 1) {
                this.f13663f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout$Builder obtain = StaticLayout$Builder.obtain(charSequence, this.f13661d, min, this.f13659b, max);
            obtain.setAlignment(this.f13663f);
            obtain.setIncludePad(this.f13668k);
            if (this.f13669l) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            obtain.setTextDirection(textDirectionHeuristic);
            TextUtils.TruncateAt truncateAt = this.f13670m;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f13664g);
            float f8 = this.f13665h;
            if (f8 != 0.0f || this.f13666i != 1.0f) {
                obtain.setLineSpacing(f8, this.f13666i);
            }
            if (this.f13664g > 1) {
                obtain.setHyphenationFrequency(this.f13667j);
            }
            StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer = this.f13671n;
            if (staticLayoutBuilderConfigurer != null) {
                staticLayoutBuilderConfigurer.a(obtain);
            }
            return obtain.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) Preconditions.g(f13656q)).newInstance(charSequence, Integer.valueOf(this.f13661d), Integer.valueOf(this.f13662e), this.f13659b, Integer.valueOf(max), this.f13663f, Preconditions.g(f13657r), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f13668k), null, Integer.valueOf(max), Integer.valueOf(this.f13664g));
        } catch (Exception e8) {
            throw new StaticLayoutBuilderCompatException(e8);
        }
    }

    @NonNull
    public StaticLayoutBuilderCompat d(@NonNull Layout.Alignment alignment) {
        this.f13663f = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(TextUtils.TruncateAt truncateAt) {
        this.f13670m = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(int i8) {
        this.f13667j = i8;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat g(boolean z7) {
        this.f13668k = z7;
        return this;
    }

    public StaticLayoutBuilderCompat h(boolean z7) {
        this.f13669l = z7;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat i(float f8, float f9) {
        this.f13665h = f8;
        this.f13666i = f9;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat j(int i8) {
        this.f13664g = i8;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat k(StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.f13671n = staticLayoutBuilderConfigurer;
        return this;
    }
}
