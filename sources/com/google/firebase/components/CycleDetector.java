package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
class CycleDetector {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ComponentNode {

        /* renamed from: a  reason: collision with root package name */
        private final Component<?> f15482a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<ComponentNode> f15483b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<ComponentNode> f15484c = new HashSet();

        ComponentNode(Component<?> component) {
            this.f15482a = component;
        }

        void a(ComponentNode componentNode) {
            this.f15483b.add(componentNode);
        }

        void b(ComponentNode componentNode) {
            this.f15484c.add(componentNode);
        }

        Component<?> c() {
            return this.f15482a;
        }

        Set<ComponentNode> d() {
            return this.f15483b;
        }

        boolean e() {
            return this.f15483b.isEmpty();
        }

        boolean f() {
            return this.f15484c.isEmpty();
        }

        void g(ComponentNode componentNode) {
            this.f15484c.remove(componentNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Dep {

        /* renamed from: a  reason: collision with root package name */
        private final Class<?> f15485a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f15486b;

        public boolean equals(Object obj) {
            if (!(obj instanceof Dep)) {
                return false;
            }
            Dep dep = (Dep) obj;
            if (!dep.f15485a.equals(this.f15485a) || dep.f15486b != this.f15486b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.f15485a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f15486b).hashCode();
        }

        private Dep(Class<?> cls, boolean z7) {
            this.f15485a = cls;
            this.f15486b = z7;
        }
    }

    CycleDetector() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<Component<?>> list) {
        Set<ComponentNode> c8 = c(list);
        Set<ComponentNode> b8 = b(c8);
        int i8 = 0;
        while (!b8.isEmpty()) {
            ComponentNode next = b8.iterator().next();
            b8.remove(next);
            i8++;
            for (ComponentNode componentNode : next.d()) {
                componentNode.g(next);
                if (componentNode.f()) {
                    b8.add(componentNode);
                }
            }
        }
        if (i8 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ComponentNode componentNode2 : c8) {
            if (!componentNode2.f() && !componentNode2.e()) {
                arrayList.add(componentNode2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set<ComponentNode> b(Set<ComponentNode> set) {
        HashSet hashSet = new HashSet();
        for (ComponentNode componentNode : set) {
            if (componentNode.f()) {
                hashSet.add(componentNode);
            }
        }
        return hashSet;
    }

    private static Set<ComponentNode> c(List<Component<?>> list) {
        Set<ComponentNode> set;
        HashMap hashMap = new HashMap(list.size());
        for (Component<?> component : list) {
            ComponentNode componentNode = new ComponentNode(component);
            for (Class<? super Object> cls : component.g()) {
                Dep dep = new Dep(cls, !component.m());
                if (!hashMap.containsKey(dep)) {
                    hashMap.put(dep, new HashSet());
                }
                Set set2 = (Set) hashMap.get(dep);
                if (!set2.isEmpty() && !dep.f15486b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(componentNode);
            }
        }
        for (Set<ComponentNode> set3 : hashMap.values()) {
            for (ComponentNode componentNode2 : set3) {
                for (Dependency dependency : componentNode2.c().e()) {
                    if (dependency.e() && (set = (Set) hashMap.get(new Dep(dependency.c(), dependency.g()))) != null) {
                        for (ComponentNode componentNode3 : set) {
                            componentNode2.a(componentNode3);
                            componentNode3.b(componentNode2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        return hashSet;
    }
}
