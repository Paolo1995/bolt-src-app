package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GapWorker implements Runnable {

    /* renamed from: j  reason: collision with root package name */
    static final ThreadLocal<GapWorker> f7044j = new ThreadLocal<>();

    /* renamed from: k  reason: collision with root package name */
    static Comparator<Task> f7045k = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Task task, Task task2) {
            boolean z7;
            boolean z8;
            RecyclerView recyclerView = task.f7057d;
            if (recyclerView == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (task2.f7057d == null) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z7 != z8) {
                if (recyclerView == null) {
                    return 1;
                }
                return -1;
            }
            boolean z9 = task.f7054a;
            if (z9 != task2.f7054a) {
                if (!z9) {
                    return 1;
                }
                return -1;
            }
            int i8 = task2.f7055b - task.f7055b;
            if (i8 != 0) {
                return i8;
            }
            int i9 = task.f7056c - task2.f7056c;
            if (i9 == 0) {
                return 0;
            }
            return i9;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    long f7047g;

    /* renamed from: h  reason: collision with root package name */
    long f7048h;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<RecyclerView> f7046f = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Task> f7049i = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a  reason: collision with root package name */
        int f7050a;

        /* renamed from: b  reason: collision with root package name */
        int f7051b;

        /* renamed from: c  reason: collision with root package name */
        int[] f7052c;

        /* renamed from: d  reason: collision with root package name */
        int f7053d;

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void a(int i8, int i9) {
            if (i8 >= 0) {
                if (i9 >= 0) {
                    int i10 = this.f7053d * 2;
                    int[] iArr = this.f7052c;
                    if (iArr == null) {
                        int[] iArr2 = new int[4];
                        this.f7052c = iArr2;
                        Arrays.fill(iArr2, -1);
                    } else if (i10 >= iArr.length) {
                        int[] iArr3 = new int[i10 * 2];
                        this.f7052c = iArr3;
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    }
                    int[] iArr4 = this.f7052c;
                    iArr4[i10] = i8;
                    iArr4[i10 + 1] = i9;
                    this.f7053d++;
                    return;
                }
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f7052c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f7053d = 0;
        }

        void c(RecyclerView recyclerView, boolean z7) {
            this.f7053d = 0;
            int[] iArr = this.f7052c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.f7205r;
            if (recyclerView.f7203q != null && layoutManager != null && layoutManager.B0()) {
                if (z7) {
                    if (!recyclerView.f7187i.p()) {
                        layoutManager.A(recyclerView.f7203q.r(), this);
                    }
                } else if (!recyclerView.r0()) {
                    layoutManager.z(this.f7050a, this.f7051b, recyclerView.f7198n0, this);
                }
                int i8 = this.f7053d;
                if (i8 > layoutManager.f7259r) {
                    layoutManager.f7259r = i8;
                    layoutManager.f7260s = z7;
                    recyclerView.f7183g.K();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i8) {
            if (this.f7052c != null) {
                int i9 = this.f7053d * 2;
                for (int i10 = 0; i10 < i9; i10 += 2) {
                    if (this.f7052c[i10] == i8) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i8, int i9) {
            this.f7050a = i8;
            this.f7051b = i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Task {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7054a;

        /* renamed from: b  reason: collision with root package name */
        public int f7055b;

        /* renamed from: c  reason: collision with root package name */
        public int f7056c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f7057d;

        /* renamed from: e  reason: collision with root package name */
        public int f7058e;

        Task() {
        }

        public void a() {
            this.f7054a = false;
            this.f7055b = 0;
            this.f7056c = 0;
            this.f7057d = null;
            this.f7058e = 0;
        }
    }

    private void b() {
        Task task;
        boolean z7;
        int size = this.f7046f.size();
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView recyclerView = this.f7046f.get(i9);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f7196m0.c(recyclerView, false);
                i8 += recyclerView.f7196m0.f7053d;
            }
        }
        this.f7049i.ensureCapacity(i8);
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView2 = this.f7046f.get(i11);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.f7196m0;
                int abs = Math.abs(layoutPrefetchRegistryImpl.f7050a) + Math.abs(layoutPrefetchRegistryImpl.f7051b);
                for (int i12 = 0; i12 < layoutPrefetchRegistryImpl.f7053d * 2; i12 += 2) {
                    if (i10 >= this.f7049i.size()) {
                        task = new Task();
                        this.f7049i.add(task);
                    } else {
                        task = this.f7049i.get(i10);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.f7052c;
                    int i13 = iArr[i12 + 1];
                    if (i13 <= abs) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    task.f7054a = z7;
                    task.f7055b = abs;
                    task.f7056c = i13;
                    task.f7057d = recyclerView2;
                    task.f7058e = iArr[i12];
                    i10++;
                }
            }
        }
        Collections.sort(this.f7049i, f7045k);
    }

    private void c(Task task, long j8) {
        long j9;
        if (task.f7054a) {
            j9 = Long.MAX_VALUE;
        } else {
            j9 = j8;
        }
        RecyclerView.ViewHolder i8 = i(task.f7057d, task.f7058e, j9);
        if (i8 != null && i8.f7333b != null && i8.u() && !i8.v()) {
            h(i8.f7333b.get(), j8);
        }
    }

    private void d(long j8) {
        for (int i8 = 0; i8 < this.f7049i.size(); i8++) {
            Task task = this.f7049i.get(i8);
            if (task.f7057d != null) {
                c(task, j8);
                task.a();
            } else {
                return;
            }
        }
    }

    static boolean e(RecyclerView recyclerView, int i8) {
        int j8 = recyclerView.f7189j.j();
        for (int i9 = 0; i9 < j8; i9++) {
            RecyclerView.ViewHolder k02 = RecyclerView.k0(recyclerView.f7189j.i(i9));
            if (k02.f7334c == i8 && !k02.v()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j8) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.J && recyclerView.f7189j.j() != 0) {
            recyclerView.b1();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.f7196m0;
        layoutPrefetchRegistryImpl.c(recyclerView, true);
        if (layoutPrefetchRegistryImpl.f7053d != 0) {
            try {
                TraceCompat.a("RV Nested Prefetch");
                recyclerView.f7198n0.f(recyclerView.f7203q);
                for (int i8 = 0; i8 < layoutPrefetchRegistryImpl.f7053d * 2; i8 += 2) {
                    i(recyclerView, layoutPrefetchRegistryImpl.f7052c[i8], j8);
                }
            } finally {
                TraceCompat.b();
            }
        }
    }

    private RecyclerView.ViewHolder i(RecyclerView recyclerView, int i8, long j8) {
        if (e(recyclerView, i8)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.f7183g;
        try {
            recyclerView.N0();
            RecyclerView.ViewHolder I = recycler.I(i8, false, j8);
            if (I != null) {
                if (I.u() && !I.v()) {
                    recycler.B(I.f7332a);
                } else {
                    recycler.a(I, false);
                }
            }
            return I;
        } finally {
            recyclerView.P0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f7046f.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i8, int i9) {
        if (recyclerView.isAttachedToWindow() && this.f7047g == 0) {
            this.f7047g = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f7196m0.e(i8, i9);
    }

    void g(long j8) {
        b();
        d(j8);
    }

    public void j(RecyclerView recyclerView) {
        this.f7046f.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.a("RV Prefetch");
            if (!this.f7046f.isEmpty()) {
                int size = this.f7046f.size();
                long j8 = 0;
                for (int i8 = 0; i8 < size; i8++) {
                    RecyclerView recyclerView = this.f7046f.get(i8);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j8 = Math.max(recyclerView.getDrawingTime(), j8);
                    }
                }
                if (j8 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j8) + this.f7048h);
                }
            }
        } finally {
            this.f7047g = 0L;
            TraceCompat.b();
        }
    }
}
