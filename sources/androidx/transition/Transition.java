package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    private static final int[] M = {2, 1, 3, 4};
    private static final PathMotion N = new PathMotion() { // from class: androidx.transition.Transition.1
        @Override // androidx.transition.PathMotion
        public Path a(float f8, float f9, float f10, float f11) {
            Path path = new Path();
            path.moveTo(f8, f9);
            path.lineTo(f10, f11);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> O = new ThreadLocal<>();
    TransitionPropagation I;
    private EpicenterCallback J;
    private ArrayMap<String, String> K;

    /* renamed from: y  reason: collision with root package name */
    private ArrayList<TransitionValues> f7850y;

    /* renamed from: z  reason: collision with root package name */
    private ArrayList<TransitionValues> f7851z;

    /* renamed from: f  reason: collision with root package name */
    private String f7831f = getClass().getName();

    /* renamed from: g  reason: collision with root package name */
    private long f7832g = -1;

    /* renamed from: h  reason: collision with root package name */
    long f7833h = -1;

    /* renamed from: i  reason: collision with root package name */
    private TimeInterpolator f7834i = null;

    /* renamed from: j  reason: collision with root package name */
    ArrayList<Integer> f7835j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    ArrayList<View> f7836k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<String> f7837l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<Class<?>> f7838m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<Integer> f7839n = null;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<View> f7840o = null;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList<Class<?>> f7841p = null;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<String> f7842q = null;

    /* renamed from: r  reason: collision with root package name */
    private ArrayList<Integer> f7843r = null;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<View> f7844s = null;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<Class<?>> f7845t = null;

    /* renamed from: u  reason: collision with root package name */
    private TransitionValuesMaps f7846u = new TransitionValuesMaps();

    /* renamed from: v  reason: collision with root package name */
    private TransitionValuesMaps f7847v = new TransitionValuesMaps();

    /* renamed from: w  reason: collision with root package name */
    TransitionSet f7848w = null;

    /* renamed from: x  reason: collision with root package name */
    private int[] f7849x = M;
    private ViewGroup A = null;
    boolean B = false;
    ArrayList<Animator> C = new ArrayList<>();
    private int D = 0;
    private boolean E = false;
    private boolean F = false;
    private ArrayList<TransitionListener> G = null;
    private ArrayList<Animator> H = new ArrayList<>();
    private PathMotion L = N;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnimationInfo {

        /* renamed from: a  reason: collision with root package name */
        View f7855a;

        /* renamed from: b  reason: collision with root package name */
        String f7856b;

        /* renamed from: c  reason: collision with root package name */
        TransitionValues f7857c;

        /* renamed from: d  reason: collision with root package name */
        WindowIdImpl f7858d;

        /* renamed from: e  reason: collision with root package name */
        Transition f7859e;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.f7855a = view;
            this.f7856b = str;
            this.f7857c = transitionValues;
            this.f7858d = windowIdImpl;
            this.f7859e = transition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t7) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t7)) {
                arrayList.add(t7);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t7) {
            if (arrayList != null) {
                arrayList.remove(t7);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class EpicenterCallback {
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void a(@NonNull Transition transition);

        void b(@NonNull Transition transition);

        void c(@NonNull Transition transition);

        void d(@NonNull Transition transition);

        void e(@NonNull Transition transition);
    }

    private static ArrayMap<Animator, AnimationInfo> D() {
        ArrayMap<Animator, AnimationInfo> arrayMap = O.get();
        if (arrayMap == null) {
            ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
            O.set(arrayMap2);
            return arrayMap2;
        }
        return arrayMap;
    }

    private static boolean P(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.f7875a.get(str);
        Object obj2 = transitionValues2.f7875a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void Q(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i8 = 0; i8 < size; i8++) {
            View valueAt = sparseArray.valueAt(i8);
            if (valueAt != null && O(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i8))) != null && O(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f7850y.add(transitionValues);
                    this.f7851z.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void R(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View j8 = arrayMap.j(size);
            if (j8 != null && O(j8) && (remove = arrayMap2.remove(j8)) != null && O(remove.f7876b)) {
                this.f7850y.add(arrayMap.l(size));
                this.f7851z.add(remove);
            }
        }
    }

    private void S(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View f8;
        int o8 = longSparseArray.o();
        for (int i8 = 0; i8 < o8; i8++) {
            View p8 = longSparseArray.p(i8);
            if (p8 != null && O(p8) && (f8 = longSparseArray2.f(longSparseArray.k(i8))) != null && O(f8)) {
                TransitionValues transitionValues = arrayMap.get(p8);
                TransitionValues transitionValues2 = arrayMap2.get(f8);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f7850y.add(transitionValues);
                    this.f7851z.add(transitionValues2);
                    arrayMap.remove(p8);
                    arrayMap2.remove(f8);
                }
            }
        }
    }

    private void T(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i8 = 0; i8 < size; i8++) {
            View n8 = arrayMap3.n(i8);
            if (n8 != null && O(n8) && (view = arrayMap4.get(arrayMap3.j(i8))) != null && O(view)) {
                TransitionValues transitionValues = arrayMap.get(n8);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f7850y.add(transitionValues);
                    this.f7851z.add(transitionValues2);
                    arrayMap.remove(n8);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void U(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.f7878a);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.f7878a);
        int i8 = 0;
        while (true) {
            int[] iArr = this.f7849x;
            if (i8 < iArr.length) {
                int i9 = iArr[i8];
                if (i9 != 1) {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            if (i9 == 4) {
                                S(arrayMap, arrayMap2, transitionValuesMaps.f7880c, transitionValuesMaps2.f7880c);
                            }
                        } else {
                            Q(arrayMap, arrayMap2, transitionValuesMaps.f7879b, transitionValuesMaps2.f7879b);
                        }
                    } else {
                        T(arrayMap, arrayMap2, transitionValuesMaps.f7881d, transitionValuesMaps2.f7881d);
                    }
                } else {
                    R(arrayMap, arrayMap2);
                }
                i8++;
            } else {
                d(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private void a0(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.C.remove(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.C.add(animator2);
                }
            });
            f(animator);
        }
    }

    private void d(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i8 = 0; i8 < arrayMap.size(); i8++) {
            TransitionValues n8 = arrayMap.n(i8);
            if (O(n8.f7876b)) {
                this.f7850y.add(n8);
                this.f7851z.add(null);
            }
        }
        for (int i9 = 0; i9 < arrayMap2.size(); i9++) {
            TransitionValues n9 = arrayMap2.n(i9);
            if (O(n9.f7876b)) {
                this.f7851z.add(n9);
                this.f7850y.add(null);
            }
        }
    }

    private static void e(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f7878a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f7879b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f7879b.put(id, null);
            } else {
                transitionValuesMaps.f7879b.put(id, view);
            }
        }
        String M2 = ViewCompat.M(view);
        if (M2 != null) {
            if (transitionValuesMaps.f7881d.containsKey(M2)) {
                transitionValuesMaps.f7881d.put(M2, null);
            } else {
                transitionValuesMaps.f7881d.put(M2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f7880c.i(itemIdAtPosition) >= 0) {
                    View f8 = transitionValuesMaps.f7880c.f(itemIdAtPosition);
                    if (f8 != null) {
                        ViewCompat.C0(f8, false);
                        transitionValuesMaps.f7880c.l(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.C0(view, true);
                transitionValuesMaps.f7880c.l(itemIdAtPosition, view);
            }
        }
    }

    private void i(View view, boolean z7) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f7839n;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return;
        }
        ArrayList<View> arrayList2 = this.f7840o;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return;
        }
        ArrayList<Class<?>> arrayList3 = this.f7841p;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i8 = 0; i8 < size; i8++) {
                if (this.f7841p.get(i8).isInstance(view)) {
                    return;
                }
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            TransitionValues transitionValues = new TransitionValues(view);
            if (z7) {
                k(transitionValues);
            } else {
                h(transitionValues);
            }
            transitionValues.f7877c.add(this);
            j(transitionValues);
            if (z7) {
                e(this.f7846u, view, transitionValues);
            } else {
                e(this.f7847v, view, transitionValues);
            }
        }
        if (view instanceof ViewGroup) {
            ArrayList<Integer> arrayList4 = this.f7843r;
            if (arrayList4 != null && arrayList4.contains(Integer.valueOf(id))) {
                return;
            }
            ArrayList<View> arrayList5 = this.f7844s;
            if (arrayList5 != null && arrayList5.contains(view)) {
                return;
            }
            ArrayList<Class<?>> arrayList6 = this.f7845t;
            if (arrayList6 != null) {
                int size2 = arrayList6.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    if (this.f7845t.get(i9).isInstance(view)) {
                        return;
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                i(viewGroup.getChildAt(i10), z7);
            }
        }
    }

    private ArrayList<View> s(ArrayList<View> arrayList, View view, boolean z7) {
        if (view != null) {
            if (z7) {
                return ArrayListManager.a(arrayList, view);
            }
            return ArrayListManager.b(arrayList, view);
        }
        return arrayList;
    }

    @NonNull
    public String A() {
        return this.f7831f;
    }

    @NonNull
    public PathMotion B() {
        return this.L;
    }

    public TransitionPropagation C() {
        return this.I;
    }

    public long E() {
        return this.f7832g;
    }

    @NonNull
    public List<Integer> G() {
        return this.f7835j;
    }

    public List<String> H() {
        return this.f7837l;
    }

    public List<Class<?>> J() {
        return this.f7838m;
    }

    @NonNull
    public List<View> K() {
        return this.f7836k;
    }

    public String[] L() {
        return null;
    }

    public TransitionValues M(@NonNull View view, boolean z7) {
        TransitionValuesMaps transitionValuesMaps;
        TransitionSet transitionSet = this.f7848w;
        if (transitionSet != null) {
            return transitionSet.M(view, z7);
        }
        if (z7) {
            transitionValuesMaps = this.f7846u;
        } else {
            transitionValuesMaps = this.f7847v;
        }
        return transitionValuesMaps.f7878a.get(view);
    }

    public boolean N(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] L = L();
        if (L != null) {
            for (String str : L) {
                if (!P(transitionValues, transitionValues2, str)) {
                }
            }
            return false;
        }
        for (String str2 : transitionValues.f7875a.keySet()) {
            if (P(transitionValues, transitionValues2, str2)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f7839n;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f7840o;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f7841p;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i8 = 0; i8 < size; i8++) {
                if (this.f7841p.get(i8).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f7842q != null && ViewCompat.M(view) != null && this.f7842q.contains(ViewCompat.M(view))) {
            return false;
        }
        if ((this.f7835j.size() == 0 && this.f7836k.size() == 0 && (((arrayList = this.f7838m) == null || arrayList.isEmpty()) && ((arrayList2 = this.f7837l) == null || arrayList2.isEmpty()))) || this.f7835j.contains(Integer.valueOf(id)) || this.f7836k.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f7837l;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.M(view))) {
            return true;
        }
        if (this.f7838m != null) {
            for (int i9 = 0; i9 < this.f7838m.size(); i9++) {
                if (this.f7838m.get(i9).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void V(View view) {
        if (!this.F) {
            ArrayMap<Animator, AnimationInfo> D = D();
            int size = D.size();
            WindowIdImpl d8 = ViewUtils.d(view);
            for (int i8 = size - 1; i8 >= 0; i8--) {
                AnimationInfo n8 = D.n(i8);
                if (n8.f7855a != null && d8.equals(n8.f7858d)) {
                    AnimatorUtils.b(D.j(i8));
                }
            }
            ArrayList<TransitionListener> arrayList = this.G;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.G.clone();
                int size2 = arrayList2.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    ((TransitionListener) arrayList2.get(i9)).c(this);
                }
            }
            this.E = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        boolean z7;
        this.f7850y = new ArrayList<>();
        this.f7851z = new ArrayList<>();
        U(this.f7846u, this.f7847v);
        ArrayMap<Animator, AnimationInfo> D = D();
        int size = D.size();
        WindowIdImpl d8 = ViewUtils.d(viewGroup);
        for (int i8 = size - 1; i8 >= 0; i8--) {
            Animator j8 = D.j(i8);
            if (j8 != null && (animationInfo = D.get(j8)) != null && animationInfo.f7855a != null && d8.equals(animationInfo.f7858d)) {
                TransitionValues transitionValues = animationInfo.f7857c;
                View view = animationInfo.f7855a;
                TransitionValues M2 = M(view, true);
                TransitionValues z8 = z(view, true);
                if (M2 == null && z8 == null) {
                    z8 = this.f7847v.f7878a.get(view);
                }
                if ((M2 != null || z8 != null) && animationInfo.f7859e.N(transitionValues, z8)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    if (!j8.isRunning() && !j8.isStarted()) {
                        D.remove(j8);
                    } else {
                        j8.cancel();
                    }
                }
            }
        }
        p(viewGroup, this.f7846u, this.f7847v, this.f7850y, this.f7851z);
        b0();
    }

    @NonNull
    public Transition X(@NonNull TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.G;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.G.size() == 0) {
            this.G = null;
        }
        return this;
    }

    @NonNull
    public Transition Y(@NonNull View view) {
        this.f7836k.remove(view);
        return this;
    }

    public void Z(View view) {
        if (this.E) {
            if (!this.F) {
                ArrayMap<Animator, AnimationInfo> D = D();
                int size = D.size();
                WindowIdImpl d8 = ViewUtils.d(view);
                for (int i8 = size - 1; i8 >= 0; i8--) {
                    AnimationInfo n8 = D.n(i8);
                    if (n8.f7855a != null && d8.equals(n8.f7858d)) {
                        AnimatorUtils.c(D.j(i8));
                    }
                }
                ArrayList<TransitionListener> arrayList = this.G;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.G.clone();
                    int size2 = arrayList2.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        ((TransitionListener) arrayList2.get(i9)).a(this);
                    }
                }
            }
            this.E = false;
        }
    }

    @NonNull
    public Transition a(@NonNull TransitionListener transitionListener) {
        if (this.G == null) {
            this.G = new ArrayList<>();
        }
        this.G.add(transitionListener);
        return this;
    }

    @NonNull
    public Transition b(int i8) {
        if (i8 != 0) {
            this.f7835j.add(Integer.valueOf(i8));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b0() {
        i0();
        ArrayMap<Animator, AnimationInfo> D = D();
        Iterator<Animator> it = this.H.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (D.containsKey(next)) {
                i0();
                a0(next, D);
            }
        }
        this.H.clear();
        q();
    }

    @NonNull
    public Transition c(@NonNull View view) {
        this.f7836k.add(view);
        return this;
    }

    @NonNull
    public Transition c0(long j8) {
        this.f7833h = j8;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.C.size() - 1; size >= 0; size--) {
            this.C.get(size).cancel();
        }
        ArrayList<TransitionListener> arrayList = this.G;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.G.clone();
            int size2 = arrayList2.size();
            for (int i8 = 0; i8 < size2; i8++) {
                ((TransitionListener) arrayList2.get(i8)).e(this);
            }
        }
    }

    public void d0(EpicenterCallback epicenterCallback) {
        this.J = epicenterCallback;
    }

    @NonNull
    public Transition e0(TimeInterpolator timeInterpolator) {
        this.f7834i = timeInterpolator;
        return this;
    }

    protected void f(Animator animator) {
        if (animator == null) {
            q();
            return;
        }
        if (u() >= 0) {
            animator.setDuration(u());
        }
        if (E() >= 0) {
            animator.setStartDelay(E() + animator.getStartDelay());
        }
        if (x() != null) {
            animator.setInterpolator(x());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.q();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    public void f0(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.L = N;
        } else {
            this.L = pathMotion;
        }
    }

    public void g0(TransitionPropagation transitionPropagation) {
        this.I = transitionPropagation;
    }

    public abstract void h(@NonNull TransitionValues transitionValues);

    @NonNull
    public Transition h0(long j8) {
        this.f7832g = j8;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0() {
        if (this.D == 0) {
            ArrayList<TransitionListener> arrayList = this.G;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.G.clone();
                int size = arrayList2.size();
                for (int i8 = 0; i8 < size; i8++) {
                    ((TransitionListener) arrayList2.get(i8)).b(this);
                }
            }
            this.F = false;
        }
        this.D++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(TransitionValues transitionValues) {
        String[] b8;
        if (this.I == null || transitionValues.f7875a.isEmpty() || (b8 = this.I.b()) == null) {
            return;
        }
        boolean z7 = false;
        int i8 = 0;
        while (true) {
            if (i8 < b8.length) {
                if (!transitionValues.f7875a.containsKey(b8[i8])) {
                    break;
                }
                i8++;
            } else {
                z7 = true;
                break;
            }
        }
        if (!z7) {
            this.I.a(transitionValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f7833h != -1) {
            str2 = str2 + "dur(" + this.f7833h + ") ";
        }
        if (this.f7832g != -1) {
            str2 = str2 + "dly(" + this.f7832g + ") ";
        }
        if (this.f7834i != null) {
            str2 = str2 + "interp(" + this.f7834i + ") ";
        }
        if (this.f7835j.size() > 0 || this.f7836k.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.f7835j.size() > 0) {
                for (int i8 = 0; i8 < this.f7835j.size(); i8++) {
                    if (i8 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.f7835j.get(i8);
                }
            }
            if (this.f7836k.size() > 0) {
                for (int i9 = 0; i9 < this.f7836k.size(); i9++) {
                    if (i9 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.f7836k.get(i9);
                }
            }
            return str3 + ")";
        }
        return str2;
    }

    public abstract void k(@NonNull TransitionValues transitionValues);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(ViewGroup viewGroup, boolean z7) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        ArrayMap<String, String> arrayMap;
        m(z7);
        if ((this.f7835j.size() <= 0 && this.f7836k.size() <= 0) || (((arrayList = this.f7837l) != null && !arrayList.isEmpty()) || ((arrayList2 = this.f7838m) != null && !arrayList2.isEmpty()))) {
            i(viewGroup, z7);
        } else {
            for (int i8 = 0; i8 < this.f7835j.size(); i8++) {
                View findViewById = viewGroup.findViewById(this.f7835j.get(i8).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z7) {
                        k(transitionValues);
                    } else {
                        h(transitionValues);
                    }
                    transitionValues.f7877c.add(this);
                    j(transitionValues);
                    if (z7) {
                        e(this.f7846u, findViewById, transitionValues);
                    } else {
                        e(this.f7847v, findViewById, transitionValues);
                    }
                }
            }
            for (int i9 = 0; i9 < this.f7836k.size(); i9++) {
                View view = this.f7836k.get(i9);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z7) {
                    k(transitionValues2);
                } else {
                    h(transitionValues2);
                }
                transitionValues2.f7877c.add(this);
                j(transitionValues2);
                if (z7) {
                    e(this.f7846u, view, transitionValues2);
                } else {
                    e(this.f7847v, view, transitionValues2);
                }
            }
        }
        if (!z7 && (arrayMap = this.K) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                arrayList3.add(this.f7846u.f7881d.remove(this.K.j(i10)));
            }
            for (int i11 = 0; i11 < size; i11++) {
                View view2 = (View) arrayList3.get(i11);
                if (view2 != null) {
                    this.f7846u.f7881d.put(this.K.n(i11), view2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z7) {
        if (z7) {
            this.f7846u.f7878a.clear();
            this.f7846u.f7879b.clear();
            this.f7846u.f7880c.b();
            return;
        }
        this.f7847v.f7878a.clear();
        this.f7847v.f7879b.clear();
        this.f7847v.f7880c.b();
    }

    @Override // 
    /* renamed from: n */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.H = new ArrayList<>();
            transition.f7846u = new TransitionValuesMaps();
            transition.f7847v = new TransitionValuesMaps();
            transition.f7850y = null;
            transition.f7851z = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator o(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        boolean z7;
        Animator o8;
        int i8;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        Animator animator2;
        TransitionValues transitionValues2;
        ArrayMap<Animator, AnimationInfo> D = D();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j8 = Long.MAX_VALUE;
        int i9 = 0;
        while (i9 < size) {
            TransitionValues transitionValues3 = arrayList.get(i9);
            TransitionValues transitionValues4 = arrayList2.get(i9);
            if (transitionValues3 != null && !transitionValues3.f7877c.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.f7877c.contains(this)) {
                transitionValues4 = null;
            }
            if (transitionValues3 != null || transitionValues4 != null) {
                if (transitionValues3 != null && transitionValues4 != null && !N(transitionValues3, transitionValues4)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (z7 && (o8 = o(viewGroup, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        view = transitionValues4.f7876b;
                        String[] L = L();
                        if (L != null && L.length > 0) {
                            transitionValues2 = new TransitionValues(view);
                            i8 = size;
                            TransitionValues transitionValues5 = transitionValuesMaps2.f7878a.get(view);
                            if (transitionValues5 != null) {
                                int i10 = 0;
                                while (i10 < L.length) {
                                    Map<String, Object> map = transitionValues2.f7875a;
                                    String str = L[i10];
                                    map.put(str, transitionValues5.f7875a.get(str));
                                    i10++;
                                    L = L;
                                }
                            }
                            int size2 = D.size();
                            int i11 = 0;
                            while (true) {
                                if (i11 < size2) {
                                    AnimationInfo animationInfo = D.get(D.j(i11));
                                    if (animationInfo.f7857c != null && animationInfo.f7855a == view && animationInfo.f7856b.equals(A()) && animationInfo.f7857c.equals(transitionValues2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i11++;
                                } else {
                                    animator2 = o8;
                                    break;
                                }
                            }
                        } else {
                            i8 = size;
                            animator2 = o8;
                            transitionValues2 = null;
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        i8 = size;
                        view = transitionValues3.f7876b;
                        animator = o8;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        TransitionPropagation transitionPropagation = this.I;
                        if (transitionPropagation != null) {
                            long c8 = transitionPropagation.c(viewGroup, this, transitionValues3, transitionValues4);
                            sparseIntArray.put(this.H.size(), (int) c8);
                            j8 = Math.min(c8, j8);
                        }
                        D.put(animator, new AnimationInfo(view, A(), this, ViewUtils.d(viewGroup), transitionValues));
                        this.H.add(animator);
                        j8 = j8;
                    }
                    i9++;
                    size = i8;
                }
            }
            i8 = size;
            i9++;
            size = i8;
        }
        if (sparseIntArray.size() != 0) {
            for (int i12 = 0; i12 < sparseIntArray.size(); i12++) {
                Animator animator3 = this.H.get(sparseIntArray.keyAt(i12));
                animator3.setStartDelay((sparseIntArray.valueAt(i12) - j8) + animator3.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        int i8 = this.D - 1;
        this.D = i8;
        if (i8 == 0) {
            ArrayList<TransitionListener> arrayList = this.G;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.G.clone();
                int size = arrayList2.size();
                for (int i9 = 0; i9 < size; i9++) {
                    ((TransitionListener) arrayList2.get(i9)).d(this);
                }
            }
            for (int i10 = 0; i10 < this.f7846u.f7880c.o(); i10++) {
                View p8 = this.f7846u.f7880c.p(i10);
                if (p8 != null) {
                    ViewCompat.C0(p8, false);
                }
            }
            for (int i11 = 0; i11 < this.f7847v.f7880c.o(); i11++) {
                View p9 = this.f7847v.f7880c.p(i11);
                if (p9 != null) {
                    ViewCompat.C0(p9, false);
                }
            }
            this.F = true;
        }
    }

    @NonNull
    public Transition r(@NonNull View view, boolean z7) {
        this.f7844s = s(this.f7844s, view, z7);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(ViewGroup viewGroup) {
        ArrayMap<Animator, AnimationInfo> D = D();
        int size = D.size();
        if (viewGroup != null && size != 0) {
            WindowIdImpl d8 = ViewUtils.d(viewGroup);
            ArrayMap arrayMap = new ArrayMap(D);
            D.clear();
            for (int i8 = size - 1; i8 >= 0; i8--) {
                AnimationInfo animationInfo = (AnimationInfo) arrayMap.n(i8);
                if (animationInfo.f7855a != null && d8 != null && d8.equals(animationInfo.f7858d)) {
                    ((Animator) arrayMap.j(i8)).end();
                }
            }
        }
    }

    public String toString() {
        return j0("");
    }

    public long u() {
        return this.f7833h;
    }

    public EpicenterCallback v() {
        return this.J;
    }

    public TimeInterpolator x() {
        return this.f7834i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransitionValues z(View view, boolean z7) {
        ArrayList<TransitionValues> arrayList;
        ArrayList<TransitionValues> arrayList2;
        TransitionSet transitionSet = this.f7848w;
        if (transitionSet != null) {
            return transitionSet.z(view, z7);
        }
        if (z7) {
            arrayList = this.f7850y;
        } else {
            arrayList = this.f7851z;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i8 = -1;
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                break;
            }
            TransitionValues transitionValues = arrayList.get(i9);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.f7876b == view) {
                i8 = i9;
                break;
            }
            i9++;
        }
        if (i8 < 0) {
            return null;
        }
        if (z7) {
            arrayList2 = this.f7851z;
        } else {
            arrayList2 = this.f7850y;
        }
        return arrayList2.get(i8);
    }
}
