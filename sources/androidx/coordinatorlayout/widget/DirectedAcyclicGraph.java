package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Pools$Pool<ArrayList<T>> f5474a = new Pools$SimplePool(10);

    /* renamed from: b  reason: collision with root package name */
    private final SimpleArrayMap<T, ArrayList<T>> f5475b = new SimpleArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f5476c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f5477d = new HashSet<>();

    private void e(T t7, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t7)) {
            return;
        }
        if (!hashSet.contains(t7)) {
            hashSet.add(t7);
            ArrayList<T> arrayList2 = this.f5475b.get(t7);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i8 = 0; i8 < size; i8++) {
                    e(arrayList2.get(i8), arrayList, hashSet);
                }
            }
            hashSet.remove(t7);
            arrayList.add(t7);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    @NonNull
    private ArrayList<T> f() {
        ArrayList<T> b8 = this.f5474a.b();
        if (b8 == null) {
            return new ArrayList<>();
        }
        return b8;
    }

    private void k(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.f5474a.a(arrayList);
    }

    public void a(@NonNull T t7, @NonNull T t8) {
        if (this.f5475b.containsKey(t7) && this.f5475b.containsKey(t8)) {
            ArrayList<T> arrayList = this.f5475b.get(t7);
            if (arrayList == null) {
                arrayList = f();
                this.f5475b.put(t7, arrayList);
            }
            arrayList.add(t8);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void b(@NonNull T t7) {
        if (!this.f5475b.containsKey(t7)) {
            this.f5475b.put(t7, null);
        }
    }

    public void c() {
        int size = this.f5475b.size();
        for (int i8 = 0; i8 < size; i8++) {
            ArrayList<T> n8 = this.f5475b.n(i8);
            if (n8 != null) {
                k(n8);
            }
        }
        this.f5475b.clear();
    }

    public boolean d(@NonNull T t7) {
        return this.f5475b.containsKey(t7);
    }

    public List g(@NonNull T t7) {
        return this.f5475b.get(t7);
    }

    public List<T> h(@NonNull T t7) {
        int size = this.f5475b.size();
        ArrayList arrayList = null;
        for (int i8 = 0; i8 < size; i8++) {
            ArrayList<T> n8 = this.f5475b.n(i8);
            if (n8 != null && n8.contains(t7)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f5475b.j(i8));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> i() {
        this.f5476c.clear();
        this.f5477d.clear();
        int size = this.f5475b.size();
        for (int i8 = 0; i8 < size; i8++) {
            e(this.f5475b.j(i8), this.f5476c, this.f5477d);
        }
        return this.f5476c;
    }

    public boolean j(@NonNull T t7) {
        int size = this.f5475b.size();
        for (int i8 = 0; i8 < size; i8++) {
            ArrayList<T> n8 = this.f5475b.n(i8);
            if (n8 != null && n8.contains(t7)) {
                return true;
            }
        }
        return false;
    }
}
