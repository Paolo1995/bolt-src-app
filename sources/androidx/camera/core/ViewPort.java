package androidx.camera.core;

import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class ViewPort {

    /* renamed from: a  reason: collision with root package name */
    private int f3367a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private Rational f3368b;

    /* renamed from: c  reason: collision with root package name */
    private int f3369c;

    /* renamed from: d  reason: collision with root package name */
    private int f3370d;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: b  reason: collision with root package name */
        private final Rational f3372b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3373c;

        /* renamed from: a  reason: collision with root package name */
        private int f3371a = 1;

        /* renamed from: d  reason: collision with root package name */
        private int f3374d = 0;

        public Builder(@NonNull Rational rational, int i8) {
            this.f3372b = rational;
            this.f3373c = i8;
        }

        @NonNull
        public ViewPort a() {
            Preconditions.h(this.f3372b, "The crop aspect ratio must be set.");
            return new ViewPort(this.f3371a, this.f3372b, this.f3373c, this.f3374d);
        }

        @NonNull
        public Builder b(int i8) {
            this.f3374d = i8;
            return this;
        }

        @NonNull
        public Builder c(int i8) {
            this.f3371a = i8;
            return this;
        }
    }

    ViewPort(int i8, @NonNull Rational rational, int i9, int i10) {
        this.f3367a = i8;
        this.f3368b = rational;
        this.f3369c = i9;
        this.f3370d = i10;
    }

    @NonNull
    public Rational a() {
        return this.f3368b;
    }

    public int b() {
        return this.f3370d;
    }

    public int c() {
        return this.f3369c;
    }

    public int d() {
        return this.f3367a;
    }
}
