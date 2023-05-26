package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: s  reason: collision with root package name */
    private static TimeInterpolator f6937s;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f6938h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f6939i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<MoveInfo> f6940j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<ChangeInfo> f6941k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.ViewHolder>> f6942l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    ArrayList<ArrayList<MoveInfo>> f6943m = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    ArrayList<ArrayList<ChangeInfo>> f6944n = new ArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f6945o = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f6946p = new ArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f6947q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f6948r = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MoveInfo {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f6983a;

        /* renamed from: b  reason: collision with root package name */
        public int f6984b;

        /* renamed from: c  reason: collision with root package name */
        public int f6985c;

        /* renamed from: d  reason: collision with root package name */
        public int f6986d;

        /* renamed from: e  reason: collision with root package name */
        public int f6987e;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i8, int i9, int i10, int i11) {
            this.f6983a = viewHolder;
            this.f6984b = i8;
            this.f6985c = i9;
            this.f6986d = i10;
            this.f6987e = i11;
        }
    }

    private void V(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.f7332a;
        final ViewPropertyAnimator animate = view.animate();
        this.f6947q.add(viewHolder);
        animate.setDuration(o()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                DefaultItemAnimator.this.H(viewHolder);
                DefaultItemAnimator.this.f6947q.remove(viewHolder);
                DefaultItemAnimator.this.X();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.I(viewHolder);
            }
        }).start();
    }

    private void Y(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (a0(changeInfo, viewHolder) && changeInfo.f6977a == null && changeInfo.f6978b == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void Z(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.f6977a;
        if (viewHolder != null) {
            a0(changeInfo, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f6978b;
        if (viewHolder2 != null) {
            a0(changeInfo, viewHolder2);
        }
    }

    private boolean a0(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z7 = false;
        if (changeInfo.f6978b == viewHolder) {
            changeInfo.f6978b = null;
        } else if (changeInfo.f6977a != viewHolder) {
            return false;
        } else {
            changeInfo.f6977a = null;
            z7 = true;
        }
        viewHolder.f7332a.setAlpha(1.0f);
        viewHolder.f7332a.setTranslationX(0.0f);
        viewHolder.f7332a.setTranslationY(0.0f);
        D(viewHolder, z7);
        return true;
    }

    private void b0(RecyclerView.ViewHolder viewHolder) {
        if (f6937s == null) {
            f6937s = new ValueAnimator().getInterpolator();
        }
        viewHolder.f7332a.animate().setInterpolator(f6937s);
        j(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean A(RecyclerView.ViewHolder viewHolder) {
        b0(viewHolder);
        this.f6938h.add(viewHolder);
        return true;
    }

    void S(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.f7332a;
        final ViewPropertyAnimator animate = view.animate();
        this.f6945o.add(viewHolder);
        animate.alpha(1.0f).setDuration(l()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                DefaultItemAnimator.this.B(viewHolder);
                DefaultItemAnimator.this.f6945o.remove(viewHolder);
                DefaultItemAnimator.this.X();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.C(viewHolder);
            }
        }).start();
    }

    void T(final ChangeInfo changeInfo) {
        final View view;
        RecyclerView.ViewHolder viewHolder = changeInfo.f6977a;
        final View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.f7332a;
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f6978b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.f7332a;
        }
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f6948r.add(changeInfo.f6977a);
            duration.translationX(changeInfo.f6981e - changeInfo.f6979c);
            duration.translationY(changeInfo.f6982f - changeInfo.f6980d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    DefaultItemAnimator.this.D(changeInfo.f6977a, true);
                    DefaultItemAnimator.this.f6948r.remove(changeInfo.f6977a);
                    DefaultItemAnimator.this.X();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.E(changeInfo.f6977a, true);
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.f6948r.add(changeInfo.f6978b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    DefaultItemAnimator.this.D(changeInfo.f6978b, false);
                    DefaultItemAnimator.this.f6948r.remove(changeInfo.f6978b);
                    DefaultItemAnimator.this.X();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.E(changeInfo.f6978b, false);
                }
            }).start();
        }
    }

    void U(final RecyclerView.ViewHolder viewHolder, int i8, int i9, int i10, int i11) {
        final View view = viewHolder.f7332a;
        final int i12 = i10 - i8;
        final int i13 = i11 - i9;
        if (i12 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i13 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.f6946p.add(viewHolder);
        animate.setDuration(n()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i12 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i13 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                DefaultItemAnimator.this.F(viewHolder);
                DefaultItemAnimator.this.f6946p.remove(viewHolder);
                DefaultItemAnimator.this.X();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.G(viewHolder);
            }
        }).start();
    }

    void W(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f7332a.animate().cancel();
        }
    }

    void X() {
        if (!p()) {
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean g(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        if (list.isEmpty() && !super.g(viewHolder, list)) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void j(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.f7332a;
        view.animate().cancel();
        int size = this.f6940j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f6940j.get(size).f6983a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                F(viewHolder);
                this.f6940j.remove(size);
            }
        }
        Y(this.f6941k, viewHolder);
        if (this.f6938h.remove(viewHolder)) {
            view.setAlpha(1.0f);
            H(viewHolder);
        }
        if (this.f6939i.remove(viewHolder)) {
            view.setAlpha(1.0f);
            B(viewHolder);
        }
        for (int size2 = this.f6944n.size() - 1; size2 >= 0; size2--) {
            ArrayList<ChangeInfo> arrayList = this.f6944n.get(size2);
            Y(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f6944n.remove(size2);
            }
        }
        for (int size3 = this.f6943m.size() - 1; size3 >= 0; size3--) {
            ArrayList<MoveInfo> arrayList2 = this.f6943m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f6983a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    F(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f6943m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f6942l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.f6942l.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                B(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f6942l.remove(size5);
                }
            }
        }
        this.f6947q.remove(viewHolder);
        this.f6945o.remove(viewHolder);
        this.f6948r.remove(viewHolder);
        this.f6946p.remove(viewHolder);
        X();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void k() {
        int size = this.f6940j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.f6940j.get(size);
            View view = moveInfo.f6983a.f7332a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            F(moveInfo.f6983a);
            this.f6940j.remove(size);
        }
        for (int size2 = this.f6938h.size() - 1; size2 >= 0; size2--) {
            H(this.f6938h.get(size2));
            this.f6938h.remove(size2);
        }
        int size3 = this.f6939i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.f6939i.get(size3);
            viewHolder.f7332a.setAlpha(1.0f);
            B(viewHolder);
            this.f6939i.remove(size3);
        }
        for (int size4 = this.f6941k.size() - 1; size4 >= 0; size4--) {
            Z(this.f6941k.get(size4));
        }
        this.f6941k.clear();
        if (!p()) {
            return;
        }
        for (int size5 = this.f6943m.size() - 1; size5 >= 0; size5--) {
            ArrayList<MoveInfo> arrayList = this.f6943m.get(size5);
            for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                MoveInfo moveInfo2 = arrayList.get(size6);
                View view2 = moveInfo2.f6983a.f7332a;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                F(moveInfo2.f6983a);
                arrayList.remove(size6);
                if (arrayList.isEmpty()) {
                    this.f6943m.remove(arrayList);
                }
            }
        }
        for (int size7 = this.f6942l.size() - 1; size7 >= 0; size7--) {
            ArrayList<RecyclerView.ViewHolder> arrayList2 = this.f6942l.get(size7);
            for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                viewHolder2.f7332a.setAlpha(1.0f);
                B(viewHolder2);
                arrayList2.remove(size8);
                if (arrayList2.isEmpty()) {
                    this.f6942l.remove(arrayList2);
                }
            }
        }
        for (int size9 = this.f6944n.size() - 1; size9 >= 0; size9--) {
            ArrayList<ChangeInfo> arrayList3 = this.f6944n.get(size9);
            for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                Z(arrayList3.get(size10));
                if (arrayList3.isEmpty()) {
                    this.f6944n.remove(arrayList3);
                }
            }
        }
        W(this.f6947q);
        W(this.f6946p);
        W(this.f6945o);
        W(this.f6948r);
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean p() {
        if (this.f6939i.isEmpty() && this.f6941k.isEmpty() && this.f6940j.isEmpty() && this.f6938h.isEmpty() && this.f6946p.isEmpty() && this.f6947q.isEmpty() && this.f6945o.isEmpty() && this.f6948r.isEmpty() && this.f6943m.isEmpty() && this.f6942l.isEmpty() && this.f6944n.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void v() {
        long j8;
        long j9;
        boolean z7 = !this.f6938h.isEmpty();
        boolean z8 = !this.f6940j.isEmpty();
        boolean z9 = !this.f6941k.isEmpty();
        boolean z10 = !this.f6939i.isEmpty();
        if (!z7 && !z8 && !z10 && !z9) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.f6938h.iterator();
        while (it.hasNext()) {
            V(it.next());
        }
        this.f6938h.clear();
        if (z8) {
            final ArrayList<MoveInfo> arrayList = new ArrayList<>();
            arrayList.addAll(this.f6940j);
            this.f6943m.add(arrayList);
            this.f6940j.clear();
            Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        MoveInfo moveInfo = (MoveInfo) it2.next();
                        DefaultItemAnimator.this.U(moveInfo.f6983a, moveInfo.f6984b, moveInfo.f6985c, moveInfo.f6986d, moveInfo.f6987e);
                    }
                    arrayList.clear();
                    DefaultItemAnimator.this.f6943m.remove(arrayList);
                }
            };
            if (z7) {
                ViewCompat.l0(arrayList.get(0).f6983a.f7332a, runnable, o());
            } else {
                runnable.run();
            }
        }
        if (z9) {
            final ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f6941k);
            this.f6944n.add(arrayList2);
            this.f6941k.clear();
            Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        DefaultItemAnimator.this.T((ChangeInfo) it2.next());
                    }
                    arrayList2.clear();
                    DefaultItemAnimator.this.f6944n.remove(arrayList2);
                }
            };
            if (z7) {
                ViewCompat.l0(arrayList2.get(0).f6977a.f7332a, runnable2, o());
            } else {
                runnable2.run();
            }
        }
        if (z10) {
            final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f6939i);
            this.f6942l.add(arrayList3);
            this.f6939i.clear();
            Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList3.iterator();
                    while (it2.hasNext()) {
                        DefaultItemAnimator.this.S((RecyclerView.ViewHolder) it2.next());
                    }
                    arrayList3.clear();
                    DefaultItemAnimator.this.f6942l.remove(arrayList3);
                }
            };
            if (!z7 && !z8 && !z9) {
                runnable3.run();
                return;
            }
            long j10 = 0;
            if (z7) {
                j8 = o();
            } else {
                j8 = 0;
            }
            if (z8) {
                j9 = n();
            } else {
                j9 = 0;
            }
            if (z9) {
                j10 = m();
            }
            ViewCompat.l0(arrayList3.get(0).f7332a, runnable3, j8 + Math.max(j9, j10));
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean x(RecyclerView.ViewHolder viewHolder) {
        b0(viewHolder);
        viewHolder.f7332a.setAlpha(0.0f);
        this.f6939i.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean y(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i8, int i9, int i10, int i11) {
        if (viewHolder == viewHolder2) {
            return z(viewHolder, i8, i9, i10, i11);
        }
        float translationX = viewHolder.f7332a.getTranslationX();
        float translationY = viewHolder.f7332a.getTranslationY();
        float alpha = viewHolder.f7332a.getAlpha();
        b0(viewHolder);
        int i12 = (int) ((i10 - i8) - translationX);
        int i13 = (int) ((i11 - i9) - translationY);
        viewHolder.f7332a.setTranslationX(translationX);
        viewHolder.f7332a.setTranslationY(translationY);
        viewHolder.f7332a.setAlpha(alpha);
        if (viewHolder2 != null) {
            b0(viewHolder2);
            viewHolder2.f7332a.setTranslationX(-i12);
            viewHolder2.f7332a.setTranslationY(-i13);
            viewHolder2.f7332a.setAlpha(0.0f);
        }
        this.f6941k.add(new ChangeInfo(viewHolder, viewHolder2, i8, i9, i10, i11));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean z(RecyclerView.ViewHolder viewHolder, int i8, int i9, int i10, int i11) {
        View view = viewHolder.f7332a;
        int translationX = i8 + ((int) view.getTranslationX());
        int translationY = i9 + ((int) viewHolder.f7332a.getTranslationY());
        b0(viewHolder);
        int i12 = i10 - translationX;
        int i13 = i11 - translationY;
        if (i12 == 0 && i13 == 0) {
            F(viewHolder);
            return false;
        }
        if (i12 != 0) {
            view.setTranslationX(-i12);
        }
        if (i13 != 0) {
            view.setTranslationY(-i13);
        }
        this.f6940j.add(new MoveInfo(viewHolder, translationX, translationY, i10, i11));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ChangeInfo {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f6977a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.ViewHolder f6978b;

        /* renamed from: c  reason: collision with root package name */
        public int f6979c;

        /* renamed from: d  reason: collision with root package name */
        public int f6980d;

        /* renamed from: e  reason: collision with root package name */
        public int f6981e;

        /* renamed from: f  reason: collision with root package name */
        public int f6982f;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f6977a = viewHolder;
            this.f6978b = viewHolder2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f6977a + ", newHolder=" + this.f6978b + ", fromX=" + this.f6979c + ", fromY=" + this.f6980d + ", toX=" + this.f6981e + ", toY=" + this.f6982f + '}';
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i8, int i9, int i10, int i11) {
            this(viewHolder, viewHolder2);
            this.f6979c = i8;
            this.f6980d = i9;
            this.f6981e = i10;
            this.f6982f = i11;
        }
    }
}
