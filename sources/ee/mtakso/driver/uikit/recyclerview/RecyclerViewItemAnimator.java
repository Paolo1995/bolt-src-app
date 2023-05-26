package ee.mtakso.driver.uikit.recyclerview;

import android.animation.Animator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecyclerViewItemAnimator.kt */
/* loaded from: classes5.dex */
public abstract class RecyclerViewItemAnimator extends DefaultItemAnimator {

    /* renamed from: t  reason: collision with root package name */
    private final List<Add> f36000t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private final List<Add> f36001u = new ArrayList();

    /* renamed from: v  reason: collision with root package name */
    private final List<Change> f36002v = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private final List<Change> f36003w = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RecyclerViewItemAnimator.kt */
    /* loaded from: classes5.dex */
    public static final class Add {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclerView.ViewHolder f36012a;

        /* renamed from: b  reason: collision with root package name */
        private final Animator f36013b;

        public Add(RecyclerView.ViewHolder holder, Animator animator) {
            Intrinsics.f(holder, "holder");
            Intrinsics.f(animator, "animator");
            this.f36012a = holder;
            this.f36013b = animator;
        }

        public final Animator a() {
            return this.f36013b;
        }

        public final RecyclerView.ViewHolder b() {
            return this.f36012a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        if (!p()) {
            i();
        }
    }

    private final void Y(List<Change> list, RecyclerView.ViewHolder viewHolder) {
        for (Change change : list) {
            if (Intrinsics.a(change.c(), viewHolder)) {
                change.a().cancel();
                change.f(true);
                D(viewHolder, true);
            }
        }
        for (Change change2 : list) {
            if (Intrinsics.a(change2.b(), viewHolder)) {
                change2.a().cancel();
                change2.e(true);
                D(viewHolder, false);
            }
        }
        CollectionsKt__MutableCollectionsKt.I(list, new Function1<Change, Boolean>() { // from class: ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator$endChangeAnimation$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(RecyclerViewItemAnimator.Change it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(it.d());
            }
        });
    }

    private final void h0(List<Add> list, final RecyclerView.ViewHolder viewHolder) {
        boolean I;
        for (Add add : list) {
            if (Intrinsics.a(add.b(), viewHolder)) {
                add.a().cancel();
            }
        }
        I = CollectionsKt__MutableCollectionsKt.I(list, new Function1<Add, Boolean>() { // from class: ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator$endAddAnimations$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(RecyclerViewItemAnimator.Add it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(Intrinsics.a(it.b(), RecyclerView.ViewHolder.this));
            }
        });
        if (I) {
            B(viewHolder);
        }
    }

    public abstract Animator f0(RecyclerView.ViewHolder viewHolder);

    public abstract Animator g0(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i8, int i9, int i10, int i11);

    public abstract void i0(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void j(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        super.j(holder);
        i0(holder);
        h0(this.f36000t, holder);
        h0(this.f36001u, holder);
        Y(this.f36002v, holder);
        Y(this.f36003w, holder);
        X();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void k() {
        super.k();
        for (Add add : this.f36000t) {
            add.a().cancel();
            i0(add.b());
            B(add.b());
        }
        this.f36000t.clear();
        for (Add add2 : this.f36001u) {
            add2.a().cancel();
            i0(add2.b());
            B(add2.b());
        }
        this.f36001u.clear();
        for (Change change : this.f36002v) {
            change.a().cancel();
            i0(change.c());
            i0(change.b());
            D(change.c(), true);
            D(change.b(), false);
        }
        this.f36002v.clear();
        for (Change change2 : this.f36003w) {
            change2.a().cancel();
            i0(change2.c());
            i0(change2.b());
            D(change2.c(), true);
            D(change2.b(), false);
        }
        this.f36003w.clear();
        i();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean p() {
        if (super.p() || (!this.f36000t.isEmpty()) || (!this.f36001u.isEmpty()) || (!this.f36002v.isEmpty()) || (!this.f36003w.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void v() {
        super.v();
        for (final Add add : this.f36000t) {
            add.a().addListener(new Animator.AnimatorListener(add, this, add, this, add) { // from class: ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator$runPendingAnimations$lambda$3$$inlined$addListener$default$1

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ RecyclerViewItemAnimator.Add f36005b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ RecyclerViewItemAnimator.Add f36006c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ RecyclerViewItemAnimator.Add f36007d;

                {
                    this.f36006c = add;
                    this.f36007d = add;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.f(animator, "animator");
                    RecyclerViewItemAnimator.this.i0(this.f36006c.b());
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    List list;
                    Intrinsics.f(animator, "animator");
                    RecyclerViewItemAnimator.this.B(this.f36005b.b());
                    list = RecyclerViewItemAnimator.this.f36001u;
                    list.remove(this.f36005b);
                    RecyclerViewItemAnimator.this.X();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.f(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.f(animator, "animator");
                    RecyclerViewItemAnimator.this.C(this.f36007d.b());
                }
            });
            add.a().start();
            this.f36001u.add(add);
        }
        this.f36000t.clear();
        for (final Change change : this.f36002v) {
            change.a().addListener(new Animator.AnimatorListener(change, this, change, this, change) { // from class: ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator$runPendingAnimations$lambda$7$$inlined$addListener$default$1

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ RecyclerViewItemAnimator.Change f36009b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ RecyclerViewItemAnimator.Change f36010c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ RecyclerViewItemAnimator.Change f36011d;

                {
                    this.f36010c = change;
                    this.f36011d = change;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.f(animator, "animator");
                    RecyclerViewItemAnimator.this.i0(this.f36010c.c());
                    RecyclerViewItemAnimator.this.i0(this.f36010c.b());
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    List list;
                    Intrinsics.f(animator, "animator");
                    RecyclerViewItemAnimator.this.i0(this.f36009b.c());
                    RecyclerViewItemAnimator.this.i0(this.f36009b.b());
                    RecyclerViewItemAnimator.this.D(this.f36009b.c(), true);
                    RecyclerViewItemAnimator.this.D(this.f36009b.b(), false);
                    list = RecyclerViewItemAnimator.this.f36003w;
                    list.remove(this.f36009b);
                    RecyclerViewItemAnimator.this.X();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.f(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.f(animator, "animator");
                    RecyclerViewItemAnimator.this.E(this.f36011d.c(), true);
                    RecyclerViewItemAnimator.this.E(this.f36011d.b(), false);
                }
            });
            change.a().start();
            this.f36003w.add(change);
        }
        this.f36002v.clear();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean x(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        j(holder);
        Animator f02 = f0(holder);
        if (f02 == null) {
            return super.x(holder);
        }
        this.f36000t.add(new Add(holder, f02));
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean y(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i8, int i9, int i10, int i11) {
        if (Intrinsics.a(viewHolder, viewHolder2)) {
            return z(viewHolder2, i8, i9, i10, i11);
        }
        if (viewHolder != null) {
            j(viewHolder);
        }
        if (viewHolder2 != null) {
            j(viewHolder2);
        }
        Animator g02 = g0(viewHolder, viewHolder2, i8, i9, i10, i11);
        if (g02 == null) {
            return super.y(viewHolder, viewHolder2, i8, i9, i10, i11);
        }
        this.f36002v.add(new Change(viewHolder, viewHolder2, g02, false, false, 24, null));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RecyclerViewItemAnimator.kt */
    /* loaded from: classes5.dex */
    public static final class Change {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclerView.ViewHolder f36014a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView.ViewHolder f36015b;

        /* renamed from: c  reason: collision with root package name */
        private final Animator f36016c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f36017d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f36018e;

        public Change(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, Animator animator, boolean z7, boolean z8) {
            Intrinsics.f(animator, "animator");
            this.f36014a = viewHolder;
            this.f36015b = viewHolder2;
            this.f36016c = animator;
            this.f36017d = z7;
            this.f36018e = z8;
        }

        public final Animator a() {
            return this.f36016c;
        }

        public final RecyclerView.ViewHolder b() {
            return this.f36015b;
        }

        public final RecyclerView.ViewHolder c() {
            return this.f36014a;
        }

        public final boolean d() {
            if (this.f36017d && this.f36018e) {
                return true;
            }
            return false;
        }

        public final void e(boolean z7) {
            this.f36018e = z7;
        }

        public final void f(boolean z7) {
            this.f36017d = z7;
        }

        public /* synthetic */ Change(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, Animator animator, boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewHolder, viewHolder2, animator, (i8 & 8) != 0 ? false : z7, (i8 & 16) != 0 ? false : z8);
        }
    }
}
