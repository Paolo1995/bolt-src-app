package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    int R;
    private ArrayList<Transition> P = new ArrayList<>();
    private boolean Q = true;
    boolean S = false;
    private int T = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TransitionSetListener extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f7871a;

        TransitionSetListener(TransitionSet transitionSet) {
            this.f7871a = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void b(@NonNull Transition transition) {
            TransitionSet transitionSet = this.f7871a;
            if (!transitionSet.S) {
                transitionSet.i0();
                this.f7871a.S = true;
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void d(@NonNull Transition transition) {
            TransitionSet transitionSet = this.f7871a;
            int i8 = transitionSet.R - 1;
            transitionSet.R = i8;
            if (i8 == 0) {
                transitionSet.S = false;
                transitionSet.q();
            }
            transition.X(this);
        }
    }

    private void o0(@NonNull Transition transition) {
        this.P.add(transition);
        transition.f7848w = this;
    }

    private void x0() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.P.iterator();
        while (it.hasNext()) {
            it.next().a(transitionSetListener);
        }
        this.R = this.P.size();
    }

    @Override // androidx.transition.Transition
    public void V(View view) {
        super.V(view);
        int size = this.P.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.P.get(i8).V(view);
        }
    }

    @Override // androidx.transition.Transition
    public void Z(View view) {
        super.Z(view);
        int size = this.P.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.P.get(i8).Z(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    public void b0() {
        if (this.P.isEmpty()) {
            i0();
            q();
            return;
        }
        x0();
        if (!this.Q) {
            for (int i8 = 1; i8 < this.P.size(); i8++) {
                final Transition transition = this.P.get(i8);
                this.P.get(i8 - 1).a(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void d(@NonNull Transition transition2) {
                        transition.b0();
                        transition2.X(this);
                    }
                });
            }
            Transition transition2 = this.P.get(0);
            if (transition2 != null) {
                transition2.b0();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.P.iterator();
        while (it.hasNext()) {
            it.next().b0();
        }
    }

    @Override // androidx.transition.Transition
    public void d0(Transition.EpicenterCallback epicenterCallback) {
        super.d0(epicenterCallback);
        this.T |= 8;
        int size = this.P.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.P.get(i8).d0(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    public void f0(PathMotion pathMotion) {
        super.f0(pathMotion);
        this.T |= 4;
        if (this.P != null) {
            for (int i8 = 0; i8 < this.P.size(); i8++) {
                this.P.get(i8).f0(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void g0(TransitionPropagation transitionPropagation) {
        super.g0(transitionPropagation);
        this.T |= 2;
        int size = this.P.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.P.get(i8).g0(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    public void h(@NonNull TransitionValues transitionValues) {
        if (O(transitionValues.f7876b)) {
            Iterator<Transition> it = this.P.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.O(transitionValues.f7876b)) {
                    next.h(transitionValues);
                    transitionValues.f7877c.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public void j(TransitionValues transitionValues) {
        super.j(transitionValues);
        int size = this.P.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.P.get(i8).j(transitionValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public String j0(String str) {
        String j02 = super.j0(str);
        for (int i8 = 0; i8 < this.P.size(); i8++) {
            StringBuilder sb = new StringBuilder();
            sb.append(j02);
            sb.append("\n");
            sb.append(this.P.get(i8).j0(str + "  "));
            j02 = sb.toString();
        }
        return j02;
    }

    @Override // androidx.transition.Transition
    public void k(@NonNull TransitionValues transitionValues) {
        if (O(transitionValues.f7876b)) {
            Iterator<Transition> it = this.P.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.O(transitionValues.f7876b)) {
                    next.k(transitionValues);
                    transitionValues.f7877c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: k0 */
    public TransitionSet a(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.a(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: l0 */
    public TransitionSet b(int i8) {
        for (int i9 = 0; i9 < this.P.size(); i9++) {
            this.P.get(i9).b(i8);
        }
        return (TransitionSet) super.b(i8);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: m0 */
    public TransitionSet c(@NonNull View view) {
        for (int i8 = 0; i8 < this.P.size(); i8++) {
            this.P.get(i8).c(view);
        }
        return (TransitionSet) super.c(view);
    }

    @Override // androidx.transition.Transition
    /* renamed from: n */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.P = new ArrayList<>();
        int size = this.P.size();
        for (int i8 = 0; i8 < size; i8++) {
            transitionSet.o0(this.P.get(i8).clone());
        }
        return transitionSet;
    }

    @NonNull
    public TransitionSet n0(@NonNull Transition transition) {
        o0(transition);
        long j8 = this.f7833h;
        if (j8 >= 0) {
            transition.c0(j8);
        }
        if ((this.T & 1) != 0) {
            transition.e0(x());
        }
        if ((this.T & 2) != 0) {
            transition.g0(C());
        }
        if ((this.T & 4) != 0) {
            transition.f0(B());
        }
        if ((this.T & 8) != 0) {
            transition.d0(v());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    public void p(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long E = E();
        int size = this.P.size();
        for (int i8 = 0; i8 < size; i8++) {
            Transition transition = this.P.get(i8);
            if (E > 0 && (this.Q || i8 == 0)) {
                long E2 = transition.E();
                if (E2 > 0) {
                    transition.h0(E2 + E);
                } else {
                    transition.h0(E);
                }
            }
            transition.p(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    public Transition p0(int i8) {
        if (i8 >= 0 && i8 < this.P.size()) {
            return this.P.get(i8);
        }
        return null;
    }

    public int q0() {
        return this.P.size();
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: r0 */
    public TransitionSet X(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.X(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: s0 */
    public TransitionSet Y(@NonNull View view) {
        for (int i8 = 0; i8 < this.P.size(); i8++) {
            this.P.get(i8).Y(view);
        }
        return (TransitionSet) super.Y(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public void t(ViewGroup viewGroup) {
        super.t(viewGroup);
        int size = this.P.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.P.get(i8).t(viewGroup);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: t0 */
    public TransitionSet c0(long j8) {
        ArrayList<Transition> arrayList;
        super.c0(j8);
        if (this.f7833h >= 0 && (arrayList = this.P) != null) {
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                this.P.get(i8).c0(j8);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: u0 */
    public TransitionSet e0(TimeInterpolator timeInterpolator) {
        this.T |= 1;
        ArrayList<Transition> arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                this.P.get(i8).e0(timeInterpolator);
            }
        }
        return (TransitionSet) super.e0(timeInterpolator);
    }

    @NonNull
    public TransitionSet v0(int i8) {
        if (i8 != 0) {
            if (i8 == 1) {
                this.Q = false;
            } else {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i8);
            }
        } else {
            this.Q = true;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: w0 */
    public TransitionSet h0(long j8) {
        return (TransitionSet) super.h0(j8);
    }
}
