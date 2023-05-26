package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class GroupedLinkedMap<K extends Poolable, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedEntry<K, V> f10195a = new LinkedEntry<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, LinkedEntry<K, V>> f10196b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LinkedEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f10197a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f10198b;

        /* renamed from: c  reason: collision with root package name */
        LinkedEntry<K, V> f10199c;

        /* renamed from: d  reason: collision with root package name */
        LinkedEntry<K, V> f10200d;

        LinkedEntry() {
            this(null);
        }

        public void a(V v7) {
            if (this.f10198b == null) {
                this.f10198b = new ArrayList();
            }
            this.f10198b.add(v7);
        }

        public V b() {
            int c8 = c();
            if (c8 > 0) {
                return this.f10198b.remove(c8 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f10198b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        LinkedEntry(K k8) {
            this.f10200d = this;
            this.f10199c = this;
            this.f10197a = k8;
        }
    }

    private void b(LinkedEntry<K, V> linkedEntry) {
        e(linkedEntry);
        LinkedEntry<K, V> linkedEntry2 = this.f10195a;
        linkedEntry.f10200d = linkedEntry2;
        linkedEntry.f10199c = linkedEntry2.f10199c;
        g(linkedEntry);
    }

    private void c(LinkedEntry<K, V> linkedEntry) {
        e(linkedEntry);
        LinkedEntry<K, V> linkedEntry2 = this.f10195a;
        linkedEntry.f10200d = linkedEntry2.f10200d;
        linkedEntry.f10199c = linkedEntry2;
        g(linkedEntry);
    }

    private static <K, V> void e(LinkedEntry<K, V> linkedEntry) {
        LinkedEntry<K, V> linkedEntry2 = linkedEntry.f10200d;
        linkedEntry2.f10199c = linkedEntry.f10199c;
        linkedEntry.f10199c.f10200d = linkedEntry2;
    }

    private static <K, V> void g(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.f10199c.f10200d = linkedEntry;
        linkedEntry.f10200d.f10199c = linkedEntry;
    }

    public V a(K k8) {
        LinkedEntry<K, V> linkedEntry = this.f10196b.get(k8);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k8);
            this.f10196b.put(k8, linkedEntry);
        } else {
            k8.a();
        }
        b(linkedEntry);
        return linkedEntry.b();
    }

    public void d(K k8, V v7) {
        LinkedEntry<K, V> linkedEntry = this.f10196b.get(k8);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k8);
            c(linkedEntry);
            this.f10196b.put(k8, linkedEntry);
        } else {
            k8.a();
        }
        linkedEntry.a(v7);
    }

    public V f() {
        for (LinkedEntry linkedEntry = this.f10195a.f10200d; !linkedEntry.equals(this.f10195a); linkedEntry = linkedEntry.f10200d) {
            V v7 = (V) linkedEntry.b();
            if (v7 != null) {
                return v7;
            }
            e(linkedEntry);
            this.f10196b.remove(linkedEntry.f10197a);
            ((Poolable) linkedEntry.f10197a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z7 = false;
        for (LinkedEntry linkedEntry = this.f10195a.f10199c; !linkedEntry.equals(this.f10195a); linkedEntry = linkedEntry.f10199c) {
            z7 = true;
            sb.append('{');
            sb.append(linkedEntry.f10197a);
            sb.append(':');
            sb.append(linkedEntry.c());
            sb.append("}, ");
        }
        if (z7) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
