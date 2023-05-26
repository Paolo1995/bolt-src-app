package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AdapterHelper implements OpReorderer.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Pools$Pool<UpdateOp> f6889a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<UpdateOp> f6890b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<UpdateOp> f6891c;

    /* renamed from: d  reason: collision with root package name */
    final Callback f6892d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f6893e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f6894f;

    /* renamed from: g  reason: collision with root package name */
    final OpReorderer f6895g;

    /* renamed from: h  reason: collision with root package name */
    private int f6896h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        void a(int i8, int i9);

        void b(UpdateOp updateOp);

        void c(UpdateOp updateOp);

        void d(int i8, int i9);

        void e(int i8, int i9, Object obj);

        RecyclerView.ViewHolder f(int i8);

        void g(int i8, int i9);

        void h(int i8, int i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class UpdateOp {

        /* renamed from: a  reason: collision with root package name */
        int f6897a;

        /* renamed from: b  reason: collision with root package name */
        int f6898b;

        /* renamed from: c  reason: collision with root package name */
        Object f6899c;

        /* renamed from: d  reason: collision with root package name */
        int f6900d;

        UpdateOp(int i8, int i9, int i10, Object obj) {
            this.f6897a = i8;
            this.f6898b = i9;
            this.f6900d = i10;
            this.f6899c = obj;
        }

        String a() {
            int i8 = this.f6897a;
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 4) {
                        if (i8 != 8) {
                            return "??";
                        }
                        return "mv";
                    }
                    return "up";
                }
                return "rm";
            }
            return "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i8 = this.f6897a;
            if (i8 != updateOp.f6897a) {
                return false;
            }
            if (i8 == 8 && Math.abs(this.f6900d - this.f6898b) == 1 && this.f6900d == updateOp.f6898b && this.f6898b == updateOp.f6900d) {
                return true;
            }
            if (this.f6900d != updateOp.f6900d || this.f6898b != updateOp.f6898b) {
                return false;
            }
            Object obj2 = this.f6899c;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.f6899c)) {
                    return false;
                }
            } else if (updateOp.f6899c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f6897a * 31) + this.f6898b) * 31) + this.f6900d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f6898b + "c:" + this.f6900d + ",p:" + this.f6899c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void c(UpdateOp updateOp) {
        v(updateOp);
    }

    private void d(UpdateOp updateOp) {
        v(updateOp);
    }

    private void f(UpdateOp updateOp) {
        boolean z7;
        char c8;
        int i8 = updateOp.f6898b;
        int i9 = updateOp.f6900d + i8;
        char c9 = 65535;
        int i10 = i8;
        int i11 = 0;
        while (i10 < i9) {
            if (this.f6892d.f(i10) == null && !h(i10)) {
                if (c9 == 1) {
                    v(a(2, i8, i11, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                c8 = 0;
            } else {
                if (c9 == 0) {
                    k(a(2, i8, i11, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                c8 = 1;
            }
            if (z7) {
                i10 -= i11;
                i9 -= i11;
                i11 = 1;
            } else {
                i11++;
            }
            i10++;
            c9 = c8;
        }
        if (i11 != updateOp.f6900d) {
            b(updateOp);
            updateOp = a(2, i8, i11, null);
        }
        if (c9 == 0) {
            k(updateOp);
        } else {
            v(updateOp);
        }
    }

    private void g(UpdateOp updateOp) {
        int i8 = updateOp.f6898b;
        int i9 = updateOp.f6900d + i8;
        int i10 = i8;
        char c8 = 65535;
        int i11 = 0;
        while (i8 < i9) {
            if (this.f6892d.f(i8) == null && !h(i8)) {
                if (c8 == 1) {
                    v(a(4, i10, i11, updateOp.f6899c));
                    i10 = i8;
                    i11 = 0;
                }
                c8 = 0;
            } else {
                if (c8 == 0) {
                    k(a(4, i10, i11, updateOp.f6899c));
                    i10 = i8;
                    i11 = 0;
                }
                c8 = 1;
            }
            i11++;
            i8++;
        }
        if (i11 != updateOp.f6900d) {
            Object obj = updateOp.f6899c;
            b(updateOp);
            updateOp = a(4, i10, i11, obj);
        }
        if (c8 == 0) {
            k(updateOp);
        } else {
            v(updateOp);
        }
    }

    private boolean h(int i8) {
        int size = this.f6891c.size();
        for (int i9 = 0; i9 < size; i9++) {
            UpdateOp updateOp = this.f6891c.get(i9);
            int i10 = updateOp.f6897a;
            if (i10 == 8) {
                if (n(updateOp.f6900d, i9 + 1) == i8) {
                    return true;
                }
            } else if (i10 == 1) {
                int i11 = updateOp.f6898b;
                int i12 = updateOp.f6900d + i11;
                while (i11 < i12) {
                    if (n(i11, i9 + 1) == i8) {
                        return true;
                    }
                    i11++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(UpdateOp updateOp) {
        int i8;
        boolean z7;
        int i9 = updateOp.f6897a;
        if (i9 != 1 && i9 != 8) {
            int z8 = z(updateOp.f6898b, i9);
            int i10 = updateOp.f6898b;
            int i11 = updateOp.f6897a;
            if (i11 != 2) {
                if (i11 == 4) {
                    i8 = 1;
                } else {
                    throw new IllegalArgumentException("op should be remove or update." + updateOp);
                }
            } else {
                i8 = 0;
            }
            int i12 = 1;
            for (int i13 = 1; i13 < updateOp.f6900d; i13++) {
                int z9 = z(updateOp.f6898b + (i8 * i13), updateOp.f6897a);
                int i14 = updateOp.f6897a;
                if (i14 == 2 ? z9 != z8 : i14 != 4 || z9 != z8 + 1) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (z7) {
                    i12++;
                } else {
                    UpdateOp a8 = a(i14, z8, i12, updateOp.f6899c);
                    l(a8, i10);
                    b(a8);
                    if (updateOp.f6897a == 4) {
                        i10 += i12;
                    }
                    z8 = z9;
                    i12 = 1;
                }
            }
            Object obj = updateOp.f6899c;
            b(updateOp);
            if (i12 > 0) {
                UpdateOp a9 = a(updateOp.f6897a, z8, i12, obj);
                l(a9, i10);
                b(a9);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void v(UpdateOp updateOp) {
        this.f6891c.add(updateOp);
        int i8 = updateOp.f6897a;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 4) {
                    if (i8 == 8) {
                        this.f6892d.a(updateOp.f6898b, updateOp.f6900d);
                        return;
                    }
                    throw new IllegalArgumentException("Unknown update op type for " + updateOp);
                }
                this.f6892d.e(updateOp.f6898b, updateOp.f6900d, updateOp.f6899c);
                return;
            }
            this.f6892d.d(updateOp.f6898b, updateOp.f6900d);
            return;
        }
        this.f6892d.g(updateOp.f6898b, updateOp.f6900d);
    }

    private int z(int i8, int i9) {
        int i10;
        int i11;
        for (int size = this.f6891c.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.f6891c.get(size);
            int i12 = updateOp.f6897a;
            if (i12 == 8) {
                int i13 = updateOp.f6898b;
                int i14 = updateOp.f6900d;
                if (i13 < i14) {
                    i11 = i13;
                    i10 = i14;
                } else {
                    i10 = i13;
                    i11 = i14;
                }
                if (i8 >= i11 && i8 <= i10) {
                    if (i11 == i13) {
                        if (i9 == 1) {
                            updateOp.f6900d = i14 + 1;
                        } else if (i9 == 2) {
                            updateOp.f6900d = i14 - 1;
                        }
                        i8++;
                    } else {
                        if (i9 == 1) {
                            updateOp.f6898b = i13 + 1;
                        } else if (i9 == 2) {
                            updateOp.f6898b = i13 - 1;
                        }
                        i8--;
                    }
                } else if (i8 < i13) {
                    if (i9 == 1) {
                        updateOp.f6898b = i13 + 1;
                        updateOp.f6900d = i14 + 1;
                    } else if (i9 == 2) {
                        updateOp.f6898b = i13 - 1;
                        updateOp.f6900d = i14 - 1;
                    }
                }
            } else {
                int i15 = updateOp.f6898b;
                if (i15 <= i8) {
                    if (i12 == 1) {
                        i8 -= updateOp.f6900d;
                    } else if (i12 == 2) {
                        i8 += updateOp.f6900d;
                    }
                } else if (i9 == 1) {
                    updateOp.f6898b = i15 + 1;
                } else if (i9 == 2) {
                    updateOp.f6898b = i15 - 1;
                }
            }
        }
        for (int size2 = this.f6891c.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.f6891c.get(size2);
            if (updateOp2.f6897a == 8) {
                int i16 = updateOp2.f6900d;
                if (i16 == updateOp2.f6898b || i16 < 0) {
                    this.f6891c.remove(size2);
                    b(updateOp2);
                }
            } else if (updateOp2.f6900d <= 0) {
                this.f6891c.remove(size2);
                b(updateOp2);
            }
        }
        return i8;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp a(int i8, int i9, int i10, Object obj) {
        UpdateOp b8 = this.f6889a.b();
        if (b8 == null) {
            return new UpdateOp(i8, i9, i10, obj);
        }
        b8.f6897a = i8;
        b8.f6898b = i9;
        b8.f6900d = i10;
        b8.f6899c = obj;
        return b8;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void b(UpdateOp updateOp) {
        if (!this.f6894f) {
            updateOp.f6899c = null;
            this.f6889a.a(updateOp);
        }
    }

    public int e(int i8) {
        int size = this.f6890b.size();
        for (int i9 = 0; i9 < size; i9++) {
            UpdateOp updateOp = this.f6890b.get(i9);
            int i10 = updateOp.f6897a;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 8) {
                        int i11 = updateOp.f6898b;
                        if (i11 == i8) {
                            i8 = updateOp.f6900d;
                        } else {
                            if (i11 < i8) {
                                i8--;
                            }
                            if (updateOp.f6900d <= i8) {
                                i8++;
                            }
                        }
                    }
                } else {
                    int i12 = updateOp.f6898b;
                    if (i12 <= i8) {
                        int i13 = updateOp.f6900d;
                        if (i12 + i13 > i8) {
                            return -1;
                        }
                        i8 -= i13;
                    } else {
                        continue;
                    }
                }
            } else if (updateOp.f6898b <= i8) {
                i8 += updateOp.f6900d;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f6891c.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f6892d.c(this.f6891c.get(i8));
        }
        x(this.f6891c);
        this.f6896h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f6890b.size();
        for (int i8 = 0; i8 < size; i8++) {
            UpdateOp updateOp = this.f6890b.get(i8);
            int i9 = updateOp.f6897a;
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 4) {
                        if (i9 == 8) {
                            this.f6892d.c(updateOp);
                            this.f6892d.a(updateOp.f6898b, updateOp.f6900d);
                        }
                    } else {
                        this.f6892d.c(updateOp);
                        this.f6892d.e(updateOp.f6898b, updateOp.f6900d, updateOp.f6899c);
                    }
                } else {
                    this.f6892d.c(updateOp);
                    this.f6892d.h(updateOp.f6898b, updateOp.f6900d);
                }
            } else {
                this.f6892d.c(updateOp);
                this.f6892d.g(updateOp.f6898b, updateOp.f6900d);
            }
            Runnable runnable = this.f6893e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f6890b);
        this.f6896h = 0;
    }

    void l(UpdateOp updateOp, int i8) {
        this.f6892d.b(updateOp);
        int i9 = updateOp.f6897a;
        if (i9 != 2) {
            if (i9 == 4) {
                this.f6892d.e(i8, updateOp.f6900d, updateOp.f6899c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        this.f6892d.h(i8, updateOp.f6900d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i8) {
        return n(i8, 0);
    }

    int n(int i8, int i9) {
        int size = this.f6891c.size();
        while (i9 < size) {
            UpdateOp updateOp = this.f6891c.get(i9);
            int i10 = updateOp.f6897a;
            if (i10 == 8) {
                int i11 = updateOp.f6898b;
                if (i11 == i8) {
                    i8 = updateOp.f6900d;
                } else {
                    if (i11 < i8) {
                        i8--;
                    }
                    if (updateOp.f6900d <= i8) {
                        i8++;
                    }
                }
            } else {
                int i12 = updateOp.f6898b;
                if (i12 > i8) {
                    continue;
                } else if (i10 == 2) {
                    int i13 = updateOp.f6900d;
                    if (i8 < i12 + i13) {
                        return -1;
                    }
                    i8 -= i13;
                } else if (i10 == 1) {
                    i8 += updateOp.f6900d;
                }
            }
            i9++;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i8) {
        if ((i8 & this.f6896h) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        if (this.f6890b.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        if (!this.f6891c.isEmpty() && !this.f6890b.isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i8, int i9, Object obj) {
        if (i9 < 1) {
            return false;
        }
        this.f6890b.add(a(4, i8, i9, obj));
        this.f6896h |= 4;
        if (this.f6890b.size() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(int i8, int i9) {
        if (i9 < 1) {
            return false;
        }
        this.f6890b.add(a(1, i8, i9, null));
        this.f6896h |= 1;
        if (this.f6890b.size() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(int i8, int i9, int i10) {
        if (i8 == i9) {
            return false;
        }
        if (i10 == 1) {
            this.f6890b.add(a(8, i8, i9, null));
            this.f6896h |= 8;
            if (this.f6890b.size() != 1) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(int i8, int i9) {
        if (i9 < 1) {
            return false;
        }
        this.f6890b.add(a(2, i8, i9, null));
        this.f6896h |= 2;
        if (this.f6890b.size() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f6895g.b(this.f6890b);
        int size = this.f6890b.size();
        for (int i8 = 0; i8 < size; i8++) {
            UpdateOp updateOp = this.f6890b.get(i8);
            int i9 = updateOp.f6897a;
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 4) {
                        if (i9 == 8) {
                            d(updateOp);
                        }
                    } else {
                        g(updateOp);
                    }
                } else {
                    f(updateOp);
                }
            } else {
                c(updateOp);
            }
            Runnable runnable = this.f6893e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f6890b.clear();
    }

    void x(List<UpdateOp> list) {
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            b(list.get(i8));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        x(this.f6890b);
        x(this.f6891c);
        this.f6896h = 0;
    }

    AdapterHelper(Callback callback, boolean z7) {
        this.f6889a = new Pools$SimplePool(30);
        this.f6890b = new ArrayList<>();
        this.f6891c = new ArrayList<>();
        this.f6896h = 0;
        this.f6892d = callback;
        this.f6894f = z7;
        this.f6895g = new OpReorderer(this);
    }
}
