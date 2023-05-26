package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class Component<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<? super T>> f15457a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Dependency> f15458b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15459c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15460d;

    /* renamed from: e  reason: collision with root package name */
    private final ComponentFactory<T> f15461e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Class<?>> f15462f;

    /* loaded from: classes.dex */
    public static class Builder<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<? super T>> f15463a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Dependency> f15464b;

        /* renamed from: c  reason: collision with root package name */
        private int f15465c;

        /* renamed from: d  reason: collision with root package name */
        private int f15466d;

        /* renamed from: e  reason: collision with root package name */
        private ComponentFactory<T> f15467e;

        /* renamed from: f  reason: collision with root package name */
        private Set<Class<?>> f15468f;

        /* JADX INFO: Access modifiers changed from: private */
        public Builder<T> g() {
            this.f15466d = 1;
            return this;
        }

        private Builder<T> h(int i8) {
            boolean z7;
            if (this.f15465c == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.d(z7, "Instantiation type has already been set.");
            this.f15465c = i8;
            return this;
        }

        private void i(Class<?> cls) {
            Preconditions.a(!this.f15463a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public Builder<T> b(Dependency dependency) {
            Preconditions.c(dependency, "Null dependency");
            i(dependency.c());
            this.f15464b.add(dependency);
            return this;
        }

        public Builder<T> c() {
            return h(1);
        }

        public Component<T> d() {
            boolean z7;
            if (this.f15467e != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.d(z7, "Missing required property: factory.");
            return new Component<>(new HashSet(this.f15463a), new HashSet(this.f15464b), this.f15465c, this.f15466d, this.f15467e, this.f15468f);
        }

        public Builder<T> e() {
            return h(2);
        }

        public Builder<T> f(ComponentFactory<T> componentFactory) {
            this.f15467e = (ComponentFactory) Preconditions.c(componentFactory, "Null factory");
            return this;
        }

        @SafeVarargs
        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.f15463a = hashSet;
            this.f15464b = new HashSet();
            this.f15465c = 0;
            this.f15466d = 0;
            this.f15468f = new HashSet();
            Preconditions.c(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                Preconditions.c(cls2, "Null interface");
            }
            Collections.addAll(this.f15463a, clsArr);
        }
    }

    public static <T> Builder<T> c(Class<T> cls) {
        return new Builder<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> Builder<T> d(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>(cls, clsArr);
    }

    public static <T> Component<T> i(final T t7, Class<T> cls) {
        return j(cls).f(new ComponentFactory() { // from class: com.google.firebase.components.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                Object n8;
                n8 = Component.n(t7, componentContainer);
                return n8;
            }
        }).d();
    }

    public static <T> Builder<T> j(Class<T> cls) {
        return c(cls).g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object n(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object o(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    @SafeVarargs
    public static <T> Component<T> p(final T t7, Class<T> cls, Class<? super T>... clsArr) {
        return d(cls, clsArr).f(new ComponentFactory() { // from class: com.google.firebase.components.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                Object o8;
                o8 = Component.o(t7, componentContainer);
                return o8;
            }
        }).d();
    }

    public Set<Dependency> e() {
        return this.f15458b;
    }

    public ComponentFactory<T> f() {
        return this.f15461e;
    }

    public Set<Class<? super T>> g() {
        return this.f15457a;
    }

    public Set<Class<?>> h() {
        return this.f15462f;
    }

    public boolean k() {
        if (this.f15459c == 1) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f15459c == 2) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f15460d == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f15457a.toArray()) + ">{" + this.f15459c + ", type=" + this.f15460d + ", deps=" + Arrays.toString(this.f15458b.toArray()) + "}";
    }

    private Component(Set<Class<? super T>> set, Set<Dependency> set2, int i8, int i9, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.f15457a = Collections.unmodifiableSet(set);
        this.f15458b = Collections.unmodifiableSet(set2);
        this.f15459c = i8;
        this.f15460d = i9;
        this.f15461e = componentFactory;
        this.f15462f = Collections.unmodifiableSet(set3);
    }
}
