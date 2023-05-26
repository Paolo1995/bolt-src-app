package ee.mtakso.driver.uikit.widgets.gridlayout;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: SpannedGridLayoutManager.kt */
/* loaded from: classes5.dex */
public class SpannedGridLayoutManager extends RecyclerView.LayoutManager {
    public static final Companion M = new Companion(null);
    private final HeightUpdater A;
    private int B;
    private final Lazy C;
    private int D;
    private int E;
    private final Map<Integer, ChildFrame> F;
    private Integer G;
    private boolean H;
    private SpanSizeLookup I;
    private final HashMap<Integer, List<View>> J;
    private Function1<? super Integer, Unit> K;
    private final HashMap<Integer, Integer> L;

    /* renamed from: x  reason: collision with root package name */
    private final Orientation f36245x;

    /* renamed from: y  reason: collision with root package name */
    private final int f36246y;

    /* renamed from: z  reason: collision with root package name */
    private final Integer f36247z;

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public static final class ChildFrame {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f36248a;

        /* renamed from: b  reason: collision with root package name */
        private final int f36249b;

        /* renamed from: c  reason: collision with root package name */
        private final int f36250c;

        /* renamed from: d  reason: collision with root package name */
        private final int f36251d;

        /* renamed from: e  reason: collision with root package name */
        private final int f36252e;

        public ChildFrame(Rect frame, int i8, int i9, int i10, int i11) {
            Intrinsics.f(frame, "frame");
            this.f36248a = frame;
            this.f36249b = i8;
            this.f36250c = i9;
            this.f36251d = i10;
            this.f36252e = i11;
        }

        public final Rect a() {
            return this.f36248a;
        }

        public final int b() {
            return this.f36252e;
        }

        public final int c() {
            return this.f36249b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChildFrame) {
                ChildFrame childFrame = (ChildFrame) obj;
                return Intrinsics.a(this.f36248a, childFrame.f36248a) && this.f36249b == childFrame.f36249b && this.f36250c == childFrame.f36250c && this.f36251d == childFrame.f36251d && this.f36252e == childFrame.f36252e;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f36248a.hashCode() * 31) + this.f36249b) * 31) + this.f36250c) * 31) + this.f36251d) * 31) + this.f36252e;
        }

        public String toString() {
            Rect rect = this.f36248a;
            int i8 = this.f36249b;
            int i9 = this.f36250c;
            int i10 = this.f36251d;
            int i11 = this.f36252e;
            return "ChildFrame(frame=" + rect + ", row=" + i8 + ", col=" + i9 + ", width=" + i10 + ", height=" + i11 + ")";
        }
    }

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String message) {
            Intrinsics.f(message, "message");
        }
    }

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public enum Direction {
        START,
        END
    }

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public interface HeightUpdater {
        void a(View view, int i8);
    }

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public static final class PendingViewToAdd {

        /* renamed from: a  reason: collision with root package name */
        private final int f36259a;

        /* renamed from: b  reason: collision with root package name */
        private final View f36260b;

        public PendingViewToAdd(int i8, View view) {
            Intrinsics.f(view, "view");
            this.f36259a = i8;
            this.f36260b = view;
        }

        public final int a() {
            return this.f36259a;
        }

        public final View b() {
            return this.f36260b;
        }

        public final int c() {
            return this.f36259a;
        }

        public final View d() {
            return this.f36260b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PendingViewToAdd) {
                PendingViewToAdd pendingViewToAdd = (PendingViewToAdd) obj;
                return this.f36259a == pendingViewToAdd.f36259a && Intrinsics.a(this.f36260b, pendingViewToAdd.f36260b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f36259a * 31) + this.f36260b.hashCode();
        }

        public String toString() {
            int i8 = this.f36259a;
            View view = this.f36260b;
            return "PendingViewToAdd(pos=" + i8 + ", view=" + view + ")";
        }
    }

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public static final class SavedState implements Parcelable {

        /* renamed from: f  reason: collision with root package name */
        private final int f36262f;

        /* renamed from: g  reason: collision with root package name */
        public static final Companion f36261g = new Companion(null);
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SpannedGridLayoutManager.SavedState createFromParcel(Parcel source) {
                Intrinsics.f(source, "source");
                return new SpannedGridLayoutManager.SavedState(source.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SpannedGridLayoutManager.SavedState[] newArray(int i8) {
                return new SpannedGridLayoutManager.SavedState[i8];
            }
        };

        /* compiled from: SpannedGridLayoutManager.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SavedState(int i8) {
            this.f36262f = i8;
        }

        public final int a() {
            return this.f36262f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i8) {
            Intrinsics.f(dest, "dest");
            dest.writeInt(this.f36262f);
        }
    }

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36266a;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f36266a = iArr;
        }
    }

    public SpannedGridLayoutManager(Orientation orientation, int i8, Integer num, HeightUpdater heightUpdater) {
        Lazy b8;
        Intrinsics.f(orientation, "orientation");
        Intrinsics.f(heightUpdater, "heightUpdater");
        this.f36245x = orientation;
        this.f36246y = i8;
        this.f36247z = num;
        this.A = heightUpdater;
        b8 = LazyKt__LazyJVMKt.b(new Function0<RectsHelper>() { // from class: ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager$rectsHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final RectsHelper invoke() {
                SpannedGridLayoutManager spannedGridLayoutManager = SpannedGridLayoutManager.this;
                return new RectsHelper(spannedGridLayoutManager, spannedGridLayoutManager.i2(), SpannedGridLayoutManager.this.j2());
            }
        });
        this.C = b8;
        this.F = new LinkedHashMap();
        if (i8 >= 1) {
            this.J = new HashMap<>();
            this.K = new Function1<Integer, Unit>() { // from class: ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager$maxHeightListener$1
                public final void b(int i9) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num2) {
                    b(num2.intValue());
                    return Unit.f50853a;
                }
            };
            this.L = new HashMap<>();
            return;
        }
        throw new InvalidMaxSpansException(i8);
    }

    private final int Z1() {
        if (U() == 0) {
            return 0;
        }
        return g2();
    }

    protected int A2(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z7;
        Direction direction;
        Intrinsics.f(recycler, "recycler");
        Intrinsics.f(state, "state");
        if (i8 == 0) {
            return 0;
        }
        boolean z8 = true;
        if (g2() >= 0 && this.B > 0 && i8 < 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        z8 = (g2() + U() > state.b() || this.B + p2() >= this.E + k2() || i8 <= 0) ? false : false;
        if (!z7 && !z8) {
            return 0;
        }
        int B2 = B2(-i8, state);
        if (i8 > 0) {
            direction = Direction.END;
        } else {
            direction = Direction.START;
        }
        z2(direction, recycler);
        c2(direction, recycler, state);
        return -B2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B(RecyclerView.State state) {
        Intrinsics.f(state, "state");
        return U();
    }

    protected int B2(int i8, RecyclerView.State state) {
        Intrinsics.f(state, "state");
        int f8 = this.E + m2().f() + k2();
        int i9 = this.B - i8;
        this.B = i9;
        if (i9 < 0) {
            i8 += i9;
            this.B = 0;
        }
        if (this.B + p2() > f8 && g2() + U() + this.f36246y >= state.b()) {
            i8 -= (f8 - this.B) - p2();
            this.B = f8 - p2();
        }
        if (this.f36245x == Orientation.VERTICAL) {
            M0(i8);
        } else {
            L0(i8);
        }
        return i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int C(RecyclerView.State state) {
        Intrinsics.f(state, "state");
        return Z1();
    }

    public final void C2(Function1<? super Integer, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.K = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D(RecyclerView.State state) {
        Intrinsics.f(state, "state");
        return state.b();
    }

    public final void D2(int i8, int i9) {
        this.L.put(Integer.valueOf(i8), Integer.valueOf(i9));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int E(RecyclerView.State state) {
        Intrinsics.f(state, "state");
        return U();
    }

    public final void E2(SpanSizeLookup spanSizeLookup) {
        this.I = spanSizeLookup;
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int F(RecyclerView.State state) {
        Intrinsics.f(state, "state");
        return Z1();
    }

    protected void F2(View view) {
        Intrinsics.f(view, "view");
        int f22 = f2(view) + this.B + l2();
        if (f22 < this.D) {
            this.D = f22;
        }
        int h22 = h2();
        if (h22 > this.E) {
            this.E = h22;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G(RecyclerView.State state) {
        Intrinsics.f(state, "state");
        return state.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.f(recycler, "recycler");
        Intrinsics.f(state, "state");
        return A2(i8, recycler, state);
    }

    protected void G2(View view, Direction direction) {
        Intrinsics.f(view, "view");
        Intrinsics.f(direction, "direction");
        int f22 = f2(view) + this.B;
        int e22 = e2(view) + this.B;
        if (direction == Direction.END) {
            this.D = l2() + e22;
        } else if (direction == Direction.START) {
            this.E = l2() + f22;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void H1(int i8) {
        this.G = Integer.valueOf(i8);
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int I1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.f(recycler, "recycler");
        Intrinsics.f(state, "state");
        return A2(i8, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams O() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void T1(RecyclerView recyclerView, RecyclerView.State state, int i8) {
        Intrinsics.f(recyclerView, "recyclerView");
        Intrinsics.f(state, "state");
        final Context context = recyclerView.getContext();
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(context) { // from class: ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager$smoothScrollToPosition$smoothScroller$1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int B() {
                return -1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF a(int i9) {
                int i10;
                if (c() == 0) {
                    return null;
                }
                if (i9 < SpannedGridLayoutManager.this.g2()) {
                    i10 = -1;
                } else {
                    i10 = 1;
                }
                return new PointF(0.0f, i10);
            }
        };
        linearSmoothScroller.p(i8);
        U1(linearSmoothScroller);
    }

    protected View X1(View view, int i8, Direction direction, RecyclerView.Recycler recycler) {
        Intrinsics.f(view, "view");
        Intrinsics.f(direction, "direction");
        Intrinsics.f(recycler, "recycler");
        if (direction == Direction.END) {
            o(view);
        } else {
            p(view, 0);
        }
        return view;
    }

    public final void Y1(List<PendingViewToAdd> pendingViews) {
        Rect a8;
        Intrinsics.f(pendingViews, "pendingViews");
        Set<Map.Entry<Integer, ChildFrame>> entrySet = this.F.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            Integer valueOf = Integer.valueOf(((ChildFrame) entry.getValue()).b() + ((ChildFrame) entry.getValue()).c());
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            int n22 = n2(0, ((Number) entry2.getKey()).intValue());
            for (Map.Entry entry3 : (List) entry2.getValue()) {
                ((ChildFrame) entry3.getValue()).a().bottom = n22;
            }
        }
        for (PendingViewToAdd pendingViewToAdd : pendingViews) {
            int a9 = pendingViewToAdd.a();
            View b8 = pendingViewToAdd.b();
            ChildFrame childFrame = this.F.get(Integer.valueOf(a9));
            if (childFrame != null && (a8 = childFrame.a()) != null && b8.getMeasuredHeight() != a8.height() && b8.getLayoutParams().height != a8.height()) {
                b8.getLayoutParams().height = a8.height();
                J0(b8, a8.width(), a8.height());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int Z(View child) {
        Intrinsics.f(child, "child");
        ChildFrame s22 = s2(child);
        Intrinsics.c(s22);
        Rect a8 = s22.a();
        int t02 = a8.bottom + t0(child) + S(child);
        if (this.f36245x == Orientation.VERTICAL) {
            return t02 - (this.B - l2());
        }
        return t02;
    }

    protected void a2(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z7;
        View r22;
        Intrinsics.f(recycler, "recycler");
        Intrinsics.f(state, "state");
        int p22 = this.B + p2();
        int d22 = d2(this.B);
        ArrayList<PendingViewToAdd> arrayList = new ArrayList();
        int n22 = n2(0, d22);
        while (n22 <= p22) {
            Set<Integer> set = m2().h().get(Integer.valueOf(d22));
            if (set != null) {
                for (Integer num : set) {
                    int intValue = num.intValue();
                    if (N(intValue) == null) {
                        boolean z8 = true;
                        if (!arrayList.isEmpty()) {
                            for (PendingViewToAdd pendingViewToAdd : arrayList) {
                                if (pendingViewToAdd.c() == intValue) {
                                    z7 = true;
                                    continue;
                                } else {
                                    z7 = false;
                                    continue;
                                }
                                if (z7) {
                                    break;
                                }
                            }
                        }
                        z8 = false;
                        if (!z8 && (r22 = r2(recycler, state, intValue)) != null) {
                            arrayList.add(new PendingViewToAdd(intValue, u2(intValue, Direction.END, r22)));
                        }
                    }
                }
            }
            d22++;
            n22 = n2(0, d22);
        }
        if (this.f36245x == Orientation.VERTICAL) {
            Y1(arrayList);
        }
        for (PendingViewToAdd pendingViewToAdd2 : arrayList) {
            t2(pendingViewToAdd2.c(), pendingViewToAdd2.d());
            X1(pendingViewToAdd2.d(), pendingViewToAdd2.c(), Direction.END, recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int b0(View child) {
        Intrinsics.f(child, "child");
        ChildFrame s22 = s2(child);
        Intrinsics.c(s22);
        Rect a8 = s22.a();
        int l02 = a8.left + l0(child);
        if (this.f36245x == Orientation.HORIZONTAL) {
            return l02 - this.B;
        }
        return l02;
    }

    protected void b2(RecyclerView.Recycler recycler, RecyclerView.State state) {
        IntRange o8;
        IntProgression m8;
        List<Number> r02;
        boolean z7;
        View r22;
        Intrinsics.f(recycler, "recycler");
        Intrinsics.f(state, "state");
        int l22 = (this.B - l2()) / m2().f();
        int p22 = ((this.B + p2()) - l2()) / m2().f();
        ArrayList<PendingViewToAdd> arrayList = new ArrayList();
        o8 = RangesKt___RangesKt.o(l22, p22);
        m8 = RangesKt___RangesKt.m(o8);
        int g8 = m8.g();
        int i8 = m8.i();
        int k8 = m8.k();
        if ((k8 > 0 && g8 <= i8) || (k8 < 0 && i8 <= g8)) {
            while (true) {
                r02 = CollectionsKt___CollectionsKt.r0(m2().c(g8));
                for (Number number : r02) {
                    int intValue = number.intValue();
                    if (N(intValue) == null) {
                        boolean z8 = true;
                        if (!arrayList.isEmpty()) {
                            for (PendingViewToAdd pendingViewToAdd : arrayList) {
                                if (pendingViewToAdd.c() == intValue) {
                                    z7 = true;
                                    continue;
                                } else {
                                    z7 = false;
                                    continue;
                                }
                                if (z7) {
                                    break;
                                }
                            }
                        }
                        z8 = false;
                        if (!z8 && (r22 = r2(recycler, state, intValue)) != null) {
                            arrayList.add(new PendingViewToAdd(intValue, u2(intValue, Direction.START, r22)));
                        }
                    }
                }
                if (g8 == i8) {
                    break;
                }
                g8 += k8;
            }
        }
        if (this.f36245x == Orientation.VERTICAL) {
            Y1(arrayList);
        }
        for (PendingViewToAdd pendingViewToAdd2 : arrayList) {
            t2(pendingViewToAdd2.c(), pendingViewToAdd2.d());
            X1(pendingViewToAdd2.d(), pendingViewToAdd2.c(), Direction.START, recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int c0(View child) {
        Intrinsics.f(child, "child");
        ChildFrame s22 = s2(child);
        Intrinsics.c(s22);
        return s22.a().height();
    }

    protected void c2(Direction direction, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.f(direction, "direction");
        Intrinsics.f(recycler, "recycler");
        Intrinsics.f(state, "state");
        if (direction != Direction.END && this.f36245x != Orientation.VERTICAL) {
            b2(recycler, state);
        } else {
            a2(recycler, state);
        }
        this.K.invoke(Integer.valueOf(h2()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int d0(View child) {
        Intrinsics.f(child, "child");
        ChildFrame s22 = s2(child);
        Intrinsics.c(s22);
        return s22.a().width();
    }

    public final int d2(int i8) {
        int i9 = 0;
        int o22 = o2(0);
        while (o22 <= i8 && o22 < 50000) {
            i9++;
            o22 += o2(o22);
        }
        return i9;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int e0(View child) {
        Intrinsics.f(child, "child");
        ChildFrame s22 = s2(child);
        Intrinsics.c(s22);
        Rect a8 = s22.a();
        int l02 = a8.right + l0(child) + q0(child);
        if (this.f36245x == Orientation.HORIZONTAL) {
            return l02 - (this.B - l2());
        }
        return l02;
    }

    protected int e2(View child) {
        Intrinsics.f(child, "child");
        if (this.f36245x == Orientation.VERTICAL) {
            return Z(child);
        }
        return e0(child);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int f0(View child) {
        Intrinsics.f(child, "child");
        ChildFrame s22 = s2(child);
        Intrinsics.c(s22);
        Rect a8 = s22.a();
        int t02 = a8.top + t0(child);
        if (this.f36245x == Orientation.VERTICAL) {
            return t02 - this.B;
        }
        return t02;
    }

    protected int f2(View child) {
        Intrinsics.f(child, "child");
        if (this.f36245x == Orientation.VERTICAL) {
            return f0(child);
        }
        return b0(child);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void g1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int k22;
        IntRange o8;
        int v7;
        Object X;
        SpanSize spanSize;
        Intrinsics.f(recycler, "recycler");
        Intrinsics.f(state, "state");
        int l22 = l2();
        this.D = l22;
        int i8 = this.B;
        if (i8 != 0) {
            k22 = ((i8 - l22) / m2().f()) * m2().f();
        } else {
            k22 = k2();
        }
        this.E = k22;
        this.F.clear();
        H(recycler);
        System.currentTimeMillis();
        m2().b();
        int b8 = state.b();
        boolean z7 = false;
        for (int i9 = 0; i9 < b8; i9++) {
            SpanSizeLookup spanSizeLookup = this.I;
            if (spanSizeLookup == null || (spanSize = spanSizeLookup.b(i9)) == null) {
                spanSize = new SpanSize(1, 1);
            }
            m2().j(i9, m2().d(i9, spanSize));
        }
        Integer num = this.G;
        if (j0() != 0 && num != null && num.intValue() >= this.f36246y) {
            Map<Integer, Set<Integer>> h8 = m2().h();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, Set<Integer>> entry : h8.entrySet()) {
                if (entry.getValue().contains(num)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            X = CollectionsKt___CollectionsKt.X(linkedHashMap.keySet());
            Integer num2 = (Integer) X;
            if (num2 != null) {
                this.B = l2() + n2(0, num2.intValue());
            }
            this.G = null;
        }
        Direction direction = Direction.END;
        c2(direction, recycler, state);
        z2(direction, recycler);
        int p22 = ((this.B + p2()) - this.E) - k2();
        o8 = RangesKt___RangesKt.o(0, U());
        v7 = CollectionsKt__IterablesKt.v(o8, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<Integer> it = o8.iterator();
        while (it.hasNext()) {
            View T = T(((IntIterator) it).nextInt());
            Intrinsics.c(T);
            arrayList.add(Integer.valueOf(o0(T)));
        }
        boolean contains = arrayList.contains(Integer.valueOf(j0() - 1));
        if (j0() == 0 || (g2() == 0 && contains)) {
            z7 = true;
        }
        if (!z7 && p22 > 0) {
            B2(p22, state);
            if (p22 > 0 && this.f36245x == Orientation.HORIZONTAL) {
                a2(recycler, state);
            } else {
                b2(recycler, state);
            }
        }
    }

    public int g2() {
        if (U() == 0) {
            return 0;
        }
        View T = T(0);
        Intrinsics.c(T);
        return o0(T);
    }

    public final int h2() {
        int v7;
        Comparable j02;
        Collection<ChildFrame> values = this.F.values();
        v7 = CollectionsKt__IterablesKt.v(values, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (ChildFrame childFrame : values) {
            arrayList.add(Integer.valueOf(childFrame.a().bottom));
        }
        j02 = CollectionsKt___CollectionsKt.j0(arrayList);
        Integer num = (Integer) j02;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final Orientation i2() {
        return this.f36245x;
    }

    public final Integer j2() {
        return this.f36247z;
    }

    protected int k2() {
        if (this.f36245x == Orientation.VERTICAL) {
            return getPaddingBottom();
        }
        return getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void l1(Parcelable state) {
        SavedState savedState;
        Intrinsics.f(state, "state");
        M.a("Restoring state");
        if (state instanceof SavedState) {
            savedState = (SavedState) state;
        } else {
            savedState = null;
        }
        if (savedState != null) {
            H1(savedState.a());
        }
    }

    protected int l2() {
        if (this.f36245x == Orientation.VERTICAL) {
            return getPaddingTop();
        }
        return getPaddingLeft();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable m1() {
        if (this.H && U() > 0) {
            Companion companion = M;
            int g22 = g2();
            companion.a("Saving first visible position: " + g22);
            return new SavedState(g2());
        }
        return null;
    }

    protected final RectsHelper m2() {
        return (RectsHelper) this.C.getValue();
    }

    public final int n2(int i8, int i9) {
        IntRange o8;
        int v7;
        int i10 = 0;
        if (i8 != i9) {
            o8 = RangesKt___RangesKt.o(i8, i9);
            v7 = CollectionsKt__IterablesKt.v(o8, 10);
            ArrayList<Number> arrayList = new ArrayList(v7);
            Iterator<Integer> it = o8.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(o2(((IntIterator) it).nextInt())));
            }
            for (Number number : arrayList) {
                i10 += number.intValue();
            }
        }
        return i10;
    }

    public final int o2(int i8) {
        Integer num = this.L.get(Integer.valueOf(i8));
        if (num == null) {
            num = Integer.valueOf(m2().f());
        }
        return num.intValue();
    }

    public final int p2() {
        if (this.f36245x == Orientation.VERTICAL) {
            return h0();
        }
        return v0();
    }

    public final int q2() {
        return this.f36246y;
    }

    protected final View r2(RecyclerView.Recycler recycler, RecyclerView.State state, int i8) {
        Intrinsics.f(recycler, "recycler");
        Intrinsics.f(state, "state");
        if (i8 < 0 || i8 >= state.b()) {
            return null;
        }
        return recycler.o(i8);
    }

    public final ChildFrame s2(View child) {
        Intrinsics.f(child, "child");
        return this.F.get(Integer.valueOf(o0(child)));
    }

    protected void t2(int i8, View view) {
        Rect rect;
        Intrinsics.f(view, "view");
        ChildFrame childFrame = this.F.get(Integer.valueOf(i8));
        if (childFrame != null) {
            rect = childFrame.a();
        } else {
            rect = null;
        }
        if (rect != null) {
            int i9 = this.B;
            int l22 = l2();
            if (this.f36245x == Orientation.VERTICAL) {
                H0(view, rect.left + getPaddingLeft(), (rect.top - i9) + l22, rect.right + getPaddingLeft(), (rect.bottom - i9) + l22);
            } else {
                H0(view, (rect.left - i9) + l22, rect.top + getPaddingTop(), (rect.right - i9) + l22, rect.bottom + getPaddingTop());
            }
        }
        F2(view);
    }

    protected View u2(int i8, Direction direction, View view) {
        Intrinsics.f(direction, "direction");
        Intrinsics.f(view, "view");
        int i9 = WhenMappings.f36266a[this.f36245x.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                v2(i8, view);
            }
        } else {
            w2(i8, view);
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean v() {
        if (this.f36245x == Orientation.HORIZONTAL) {
            return true;
        }
        return false;
    }

    protected void v2(int i8, View view) {
        int g8;
        int f8;
        SpanSize spanSize;
        int b8;
        Intrinsics.f(view, "view");
        RectsHelper m22 = m2();
        Orientation orientation = this.f36245x;
        int[] iArr = WhenMappings.f36266a;
        int i9 = iArr[orientation.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                g8 = m22.f();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            g8 = m22.g();
        }
        int i10 = iArr[this.f36245x.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                f8 = m22.g();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            f8 = m22.f();
        }
        SpanSizeLookup spanSizeLookup = this.I;
        if (spanSizeLookup == null || (spanSize = spanSizeLookup.b(i8)) == null) {
            spanSize = new SpanSize(1, 1);
        }
        if (this.f36245x == Orientation.HORIZONTAL) {
            b8 = spanSize.a();
        } else {
            b8 = spanSize.b();
        }
        if (b8 <= this.f36246y && b8 >= 1) {
            Rect d8 = m22.d(i8, spanSize);
            int i11 = d8.left * g8;
            int i12 = d8.right * g8;
            int i13 = d8.top * f8;
            int i14 = d8.bottom * f8;
            Rect rect = new Rect();
            u(view, rect);
            int i15 = ((i12 - i11) - rect.left) - rect.right;
            int i16 = ((i14 - i13) - rect.top) - rect.bottom;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i15;
            layoutParams.height = i16;
            J0(view, i15, i16);
            this.F.put(Integer.valueOf(i8), new ChildFrame(new Rect(i11, i13, i12, i14), d8.top, d8.left, d8.width(), d8.height()));
            return;
        }
        throw new InvalidSpanSizeException(b8, this.f36246y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean w() {
        if (this.f36245x == Orientation.VERTICAL) {
            return true;
        }
        return false;
    }

    protected void w2(int i8, View view) {
        int g8;
        SpanSize spanSize;
        int b8;
        IntRange o8;
        Intrinsics.f(view, "view");
        int i9 = WhenMappings.f36266a[this.f36245x.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                g8 = m2().f();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            g8 = m2().g();
        }
        SpanSizeLookup spanSizeLookup = this.I;
        if (spanSizeLookup == null || (spanSize = spanSizeLookup.b(i8)) == null) {
            spanSize = new SpanSize(1, 1);
        }
        if (this.f36245x == Orientation.HORIZONTAL) {
            b8 = spanSize.a();
        } else {
            b8 = spanSize.b();
        }
        if (b8 <= this.f36246y && b8 >= 1) {
            Rect d8 = m2().d(i8, spanSize);
            int i10 = d8.left * g8;
            int i11 = d8.right * g8;
            int n22 = n2(0, d8.top);
            int n23 = n2(0, d8.bottom);
            Rect rect = new Rect();
            u(view, rect);
            int i12 = ((i11 - i10) - rect.left) - rect.right;
            int i13 = ((n23 - n22) - rect.top) - rect.bottom;
            view.getLayoutParams().width = i12;
            this.A.a(view, i8);
            J0(view, i12, i13);
            int measuredHeight = view.getMeasuredHeight() / d8.height();
            o8 = RangesKt___RangesKt.o(d8.top, d8.bottom);
            Iterator<Integer> it = o8.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                if (measuredHeight > o2(nextInt)) {
                    D2(nextInt, measuredHeight);
                }
            }
            if (view.getMeasuredHeight() != i13) {
                view.getLayoutParams().height = i13;
                J0(view, i12, i13);
            }
            this.F.put(Integer.valueOf(i8), new ChildFrame(new Rect(i10, n22, i11, n2(0, d8.bottom)), d8.top, d8.left, d8.width(), d8.height()));
            return;
        }
        throw new InvalidSpanSizeException(b8, this.f36246y);
    }

    protected void x2(Direction direction, RecyclerView.Recycler recycler) {
        IntRange o8;
        IntProgression m8;
        Intrinsics.f(direction, "direction");
        Intrinsics.f(recycler, "recycler");
        int U = U();
        int p22 = p2() + k2();
        ArrayList<View> arrayList = new ArrayList();
        o8 = RangesKt___RangesKt.o(0, U);
        m8 = RangesKt___RangesKt.m(o8);
        int g8 = m8.g();
        int i8 = m8.i();
        int k8 = m8.k();
        if ((k8 > 0 && g8 <= i8) || (k8 < 0 && i8 <= g8)) {
            while (true) {
                View T = T(g8);
                Intrinsics.c(T);
                if (f2(T) > p22) {
                    arrayList.add(T);
                }
                if (g8 == i8) {
                    break;
                }
                g8 += k8;
            }
        }
        for (View view : arrayList) {
            w1(view, recycler);
            G2(view, direction);
        }
    }

    protected void y2(Direction direction, RecyclerView.Recycler recycler) {
        Intrinsics.f(direction, "direction");
        Intrinsics.f(recycler, "recycler");
        int U = U();
        int l22 = l2();
        ArrayList<View> arrayList = new ArrayList();
        for (int i8 = 0; i8 < U; i8++) {
            View T = T(i8);
            Intrinsics.c(T);
            if (e2(T) < l22) {
                arrayList.add(T);
            }
        }
        for (View view : arrayList) {
            w1(view, recycler);
            G2(view, direction);
        }
    }

    protected void z2(Direction direction, RecyclerView.Recycler recycler) {
        Intrinsics.f(direction, "direction");
        Intrinsics.f(recycler, "recycler");
        if (direction == Direction.END) {
            y2(direction, recycler);
        } else {
            x2(direction, recycler);
        }
    }

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public static class SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        private Function1<? super Integer, SpanSize> f36263a;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<SpanSize> f36264b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f36265c;

        public SpanSizeLookup() {
            this(null, 1, null);
        }

        public SpanSizeLookup(Function1<? super Integer, SpanSize> function1) {
            this.f36263a = function1;
            this.f36264b = new SparseArray<>();
        }

        private final SpanSize c(int i8) {
            SpanSize invoke;
            Function1<? super Integer, SpanSize> function1 = this.f36263a;
            if (function1 == null || (invoke = function1.invoke(Integer.valueOf(i8))) == null) {
                return a();
            }
            return invoke;
        }

        protected SpanSize a() {
            return new SpanSize(1, 1);
        }

        public final SpanSize b(int i8) {
            if (this.f36265c) {
                SpanSize spanSize = this.f36264b.get(i8);
                if (spanSize != null) {
                    return spanSize;
                }
                SpanSize c8 = c(i8);
                this.f36264b.put(i8, c8);
                return c8;
            }
            return c(i8);
        }

        public /* synthetic */ SpanSizeLookup(Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : function1);
        }
    }
}
