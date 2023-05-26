package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class ViewBoundsCheck {

    /* renamed from: a  reason: collision with root package name */
    final Callback f7397a;

    /* renamed from: b  reason: collision with root package name */
    BoundFlags f7398b = new BoundFlags();

    /* loaded from: classes.dex */
    static class BoundFlags {

        /* renamed from: a  reason: collision with root package name */
        int f7399a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f7400b;

        /* renamed from: c  reason: collision with root package name */
        int f7401c;

        /* renamed from: d  reason: collision with root package name */
        int f7402d;

        /* renamed from: e  reason: collision with root package name */
        int f7403e;

        BoundFlags() {
        }

        void a(int i8) {
            this.f7399a = i8 | this.f7399a;
        }

        boolean b() {
            int i8 = this.f7399a;
            if ((i8 & 7) != 0 && (i8 & (c(this.f7402d, this.f7400b) << 0)) == 0) {
                return false;
            }
            int i9 = this.f7399a;
            if ((i9 & 112) != 0 && (i9 & (c(this.f7402d, this.f7401c) << 4)) == 0) {
                return false;
            }
            int i10 = this.f7399a;
            if ((i10 & 1792) != 0 && (i10 & (c(this.f7403e, this.f7400b) << 8)) == 0) {
                return false;
            }
            int i11 = this.f7399a;
            if ((i11 & 28672) != 0 && (i11 & (c(this.f7403e, this.f7401c) << 12)) == 0) {
                return false;
            }
            return true;
        }

        int c(int i8, int i9) {
            if (i8 > i9) {
                return 1;
            }
            return i8 == i9 ? 2 : 4;
        }

        void d() {
            this.f7399a = 0;
        }

        void e(int i8, int i9, int i10, int i11) {
            this.f7400b = i8;
            this.f7401c = i9;
            this.f7402d = i10;
            this.f7403e = i11;
        }
    }

    /* loaded from: classes.dex */
    interface Callback {
        View a(int i8);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewBoundsCheck(Callback callback) {
        this.f7397a = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i8, int i9, int i10, int i11) {
        int i12;
        int c8 = this.f7397a.c();
        int d8 = this.f7397a.d();
        if (i9 > i8) {
            i12 = 1;
        } else {
            i12 = -1;
        }
        View view = null;
        while (i8 != i9) {
            View a8 = this.f7397a.a(i8);
            this.f7398b.e(c8, d8, this.f7397a.b(a8), this.f7397a.e(a8));
            if (i10 != 0) {
                this.f7398b.d();
                this.f7398b.a(i10);
                if (this.f7398b.b()) {
                    return a8;
                }
            }
            if (i11 != 0) {
                this.f7398b.d();
                this.f7398b.a(i11);
                if (this.f7398b.b()) {
                    view = a8;
                }
            }
            i8 += i12;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view, int i8) {
        this.f7398b.e(this.f7397a.c(), this.f7397a.d(), this.f7397a.b(view), this.f7397a.e(view));
        if (i8 != 0) {
            this.f7398b.d();
            this.f7398b.a(i8);
            return this.f7398b.b();
        }
        return false;
    }
}
