package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChildHelper {

    /* renamed from: a  reason: collision with root package name */
    final Callback f6932a;

    /* renamed from: b  reason: collision with root package name */
    final Bucket f6933b = new Bucket();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f6934c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Bucket {

        /* renamed from: a  reason: collision with root package name */
        long f6935a = 0;

        /* renamed from: b  reason: collision with root package name */
        Bucket f6936b;

        Bucket() {
        }

        private void c() {
            if (this.f6936b == null) {
                this.f6936b = new Bucket();
            }
        }

        void a(int i8) {
            if (i8 >= 64) {
                Bucket bucket = this.f6936b;
                if (bucket != null) {
                    bucket.a(i8 - 64);
                    return;
                }
                return;
            }
            this.f6935a &= ~(1 << i8);
        }

        int b(int i8) {
            Bucket bucket = this.f6936b;
            if (bucket == null) {
                if (i8 >= 64) {
                    return Long.bitCount(this.f6935a);
                }
                return Long.bitCount(this.f6935a & ((1 << i8) - 1));
            } else if (i8 < 64) {
                return Long.bitCount(this.f6935a & ((1 << i8) - 1));
            } else {
                return bucket.b(i8 - 64) + Long.bitCount(this.f6935a);
            }
        }

        boolean d(int i8) {
            if (i8 >= 64) {
                c();
                return this.f6936b.d(i8 - 64);
            } else if ((this.f6935a & (1 << i8)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        void e(int i8, boolean z7) {
            boolean z8;
            if (i8 >= 64) {
                c();
                this.f6936b.e(i8 - 64, z7);
                return;
            }
            long j8 = this.f6935a;
            if ((Long.MIN_VALUE & j8) != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            long j9 = (1 << i8) - 1;
            this.f6935a = ((j8 & (~j9)) << 1) | (j8 & j9);
            if (z7) {
                h(i8);
            } else {
                a(i8);
            }
            if (z8 || this.f6936b != null) {
                c();
                this.f6936b.e(0, z8);
            }
        }

        boolean f(int i8) {
            boolean z7;
            if (i8 >= 64) {
                c();
                return this.f6936b.f(i8 - 64);
            }
            long j8 = 1 << i8;
            long j9 = this.f6935a;
            if ((j9 & j8) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            long j10 = j9 & (~j8);
            this.f6935a = j10;
            long j11 = j8 - 1;
            this.f6935a = (j10 & j11) | Long.rotateRight((~j11) & j10, 1);
            Bucket bucket = this.f6936b;
            if (bucket != null) {
                if (bucket.d(0)) {
                    h(63);
                }
                this.f6936b.f(0);
            }
            return z7;
        }

        void g() {
            this.f6935a = 0L;
            Bucket bucket = this.f6936b;
            if (bucket != null) {
                bucket.g();
            }
        }

        void h(int i8) {
            if (i8 >= 64) {
                c();
                this.f6936b.h(i8 - 64);
                return;
            }
            this.f6935a |= 1 << i8;
        }

        public String toString() {
            if (this.f6936b == null) {
                return Long.toBinaryString(this.f6935a);
            }
            return this.f6936b.toString() + "xx" + Long.toBinaryString(this.f6935a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        View a(int i8);

        void b(View view);

        int c();

        RecyclerView.ViewHolder d(View view);

        void e(int i8);

        void f(View view, int i8);

        void g();

        int h(View view);

        void i(View view);

        void j(int i8);

        void k(View view, int i8, ViewGroup.LayoutParams layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildHelper(Callback callback) {
        this.f6932a = callback;
    }

    private int h(int i8) {
        if (i8 < 0) {
            return -1;
        }
        int c8 = this.f6932a.c();
        int i9 = i8;
        while (i9 < c8) {
            int b8 = i8 - (i9 - this.f6933b.b(i9));
            if (b8 == 0) {
                while (this.f6933b.d(i9)) {
                    i9++;
                }
                return i9;
            }
            i9 += b8;
        }
        return -1;
    }

    private void l(View view) {
        this.f6934c.add(view);
        this.f6932a.b(view);
    }

    private boolean t(View view) {
        if (this.f6934c.remove(view)) {
            this.f6932a.i(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i8, boolean z7) {
        int h8;
        if (i8 < 0) {
            h8 = this.f6932a.c();
        } else {
            h8 = h(i8);
        }
        this.f6933b.e(h8, z7);
        if (z7) {
            l(view);
        }
        this.f6932a.f(view, h8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z7) {
        a(view, -1, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i8, ViewGroup.LayoutParams layoutParams, boolean z7) {
        int h8;
        if (i8 < 0) {
            h8 = this.f6932a.c();
        } else {
            h8 = h(i8);
        }
        this.f6933b.e(h8, z7);
        if (z7) {
            l(view);
        }
        this.f6932a.k(view, h8, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i8) {
        int h8 = h(i8);
        this.f6933b.f(h8);
        this.f6932a.e(h8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i8) {
        int size = this.f6934c.size();
        for (int i9 = 0; i9 < size; i9++) {
            View view = this.f6934c.get(i9);
            RecyclerView.ViewHolder d8 = this.f6932a.d(view);
            if (d8.o() == i8 && !d8.v() && !d8.x()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i8) {
        return this.f6932a.a(h(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f6932a.c() - this.f6934c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i8) {
        return this.f6932a.a(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f6932a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int h8 = this.f6932a.h(view);
        if (h8 >= 0) {
            this.f6933b.h(h8);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int h8 = this.f6932a.h(view);
        if (h8 == -1 || this.f6933b.d(h8)) {
            return -1;
        }
        return h8 - this.f6933b.b(h8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f6934c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f6933b.g();
        for (int size = this.f6934c.size() - 1; size >= 0; size--) {
            this.f6932a.i(this.f6934c.get(size));
            this.f6934c.remove(size);
        }
        this.f6932a.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int h8 = this.f6932a.h(view);
        if (h8 < 0) {
            return;
        }
        if (this.f6933b.f(h8)) {
            t(view);
        }
        this.f6932a.j(h8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i8) {
        int h8 = h(i8);
        View a8 = this.f6932a.a(h8);
        if (a8 == null) {
            return;
        }
        if (this.f6933b.f(h8)) {
            t(a8);
        }
        this.f6932a.j(h8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int h8 = this.f6932a.h(view);
        if (h8 == -1) {
            t(view);
            return true;
        } else if (this.f6933b.d(h8)) {
            this.f6933b.f(h8);
            t(view);
            this.f6932a.j(h8);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int h8 = this.f6932a.h(view);
        if (h8 >= 0) {
            if (this.f6933b.d(h8)) {
                this.f6933b.a(h8);
                t(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public String toString() {
        return this.f6933b.toString() + ", hidden list:" + this.f6934c.size();
    }
}
