package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionManager {

    /* renamed from: c  reason: collision with root package name */
    private static Transition f7860c = new AutoTransition();

    /* renamed from: d  reason: collision with root package name */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f7861d = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    static ArrayList<ViewGroup> f7862e = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private ArrayMap<Scene, Transition> f7863a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> f7864b = new ArrayMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: f  reason: collision with root package name */
        Transition f7865f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f7866g;

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f7865f = transition;
            this.f7866g = viewGroup;
        }

        private void a() {
            this.f7866g.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f7866g.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!TransitionManager.f7862e.remove(this.f7866g)) {
                return true;
            }
            final ArrayMap<ViewGroup, ArrayList<Transition>> d8 = TransitionManager.d();
            ArrayList<Transition> arrayList = d8.get(this.f7866g);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                d8.put(this.f7866g, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f7865f);
            this.f7865f.a(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void d(@NonNull Transition transition) {
                    ((ArrayList) d8.get(MultiListener.this.f7866g)).remove(transition);
                    transition.X(this);
                }
            });
            this.f7865f.l(this.f7866g, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).Z(this.f7866g);
                }
            }
            this.f7865f.W(this.f7866g);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.f7862e.remove(this.f7866g);
            ArrayList<Transition> arrayList = TransitionManager.d().get(this.f7866g);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().Z(this.f7866g);
                }
            }
            this.f7865f.m(true);
        }
    }

    public static void a(@NonNull ViewGroup viewGroup) {
        b(viewGroup, null);
    }

    public static void b(@NonNull ViewGroup viewGroup, Transition transition) {
        if (!f7862e.contains(viewGroup) && ViewCompat.W(viewGroup)) {
            f7862e.add(viewGroup);
            if (transition == null) {
                transition = f7860c;
            }
            Transition clone = transition.clone();
            f(viewGroup, clone);
            Scene.c(viewGroup, null);
            e(viewGroup, clone);
        }
    }

    public static void c(ViewGroup viewGroup) {
        f7862e.remove(viewGroup);
        ArrayList<Transition> arrayList = d().get(viewGroup);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((Transition) arrayList2.get(size)).t(viewGroup);
            }
        }
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> d() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = f7861d.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        f7861d.set(new WeakReference<>(arrayMap2));
        return arrayMap2;
    }

    private static void e(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static void f(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = d().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().V(viewGroup);
            }
        }
        if (transition != null) {
            transition.l(viewGroup, true);
        }
        Scene b8 = Scene.b(viewGroup);
        if (b8 != null) {
            b8.a();
        }
    }
}
