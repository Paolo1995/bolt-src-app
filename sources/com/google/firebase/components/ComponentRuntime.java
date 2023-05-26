package com.google.firebase.components;

import android.util.Log;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class ComponentRuntime extends AbstractComponentContainer implements ComponentLoader {

    /* renamed from: g  reason: collision with root package name */
    private static final Provider<Set<Object>> f15472g = new Provider() { // from class: com.google.firebase.components.d
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Component<?>, Provider<?>> f15473a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Provider<?>> f15474b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, LazySet<?>> f15475c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Provider<ComponentRegistrar>> f15476d;

    /* renamed from: e  reason: collision with root package name */
    private final EventBus f15477e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<Boolean> f15478f;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f15479a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Provider<ComponentRegistrar>> f15480b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<Component<?>> f15481c = new ArrayList();

        Builder(Executor executor) {
            this.f15479a = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public Builder b(Component<?> component) {
            this.f15481c.add(component);
            return this;
        }

        public Builder c(final ComponentRegistrar componentRegistrar) {
            this.f15480b.add(new Provider() { // from class: com.google.firebase.components.h
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    ComponentRegistrar f8;
                    f8 = ComponentRuntime.Builder.f(ComponentRegistrar.this);
                    return f8;
                }
            });
            return this;
        }

        public Builder d(Collection<Provider<ComponentRegistrar>> collection) {
            this.f15480b.addAll(collection);
            return this;
        }

        public ComponentRuntime e() {
            return new ComponentRuntime(this.f15479a, this.f15480b, this.f15481c);
        }
    }

    public static Builder h(Executor executor) {
        return new Builder(executor);
    }

    private void i(List<Component<?>> list) {
        ArrayList<Runnable> arrayList = new ArrayList();
        synchronized (this) {
            Iterator<Provider<ComponentRegistrar>> it = this.f15476d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(componentRegistrar.getComponents());
                        it.remove();
                    }
                } catch (InvalidRegistrarException e8) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e8);
                }
            }
            if (this.f15473a.isEmpty()) {
                CycleDetector.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f15473a.keySet());
                arrayList2.addAll(list);
                CycleDetector.a(arrayList2);
            }
            for (final Component<?> component : list) {
                this.f15473a.put(component, new Lazy(new Provider() { // from class: com.google.firebase.components.e
                    @Override // com.google.firebase.inject.Provider
                    public final Object get() {
                        Object m8;
                        m8 = ComponentRuntime.this.m(component);
                        return m8;
                    }
                }));
            }
            arrayList.addAll(r(list));
            arrayList.addAll(s());
            q();
        }
        for (Runnable runnable : arrayList) {
            runnable.run();
        }
        p();
    }

    private void j(Map<Component<?>, Provider<?>> map, boolean z7) {
        for (Map.Entry<Component<?>, Provider<?>> entry : map.entrySet()) {
            Component<?> key = entry.getKey();
            Provider<?> value = entry.getValue();
            if (key.k() || (key.l() && z7)) {
                value.get();
            }
        }
        this.f15477e.d();
    }

    private static <T> List<T> l(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            arrayList.add(t7);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object m(Component component) {
        return component.f().a(new RestrictedComponentContainer(component, this));
    }

    private void p() {
        Boolean bool = this.f15478f.get();
        if (bool != null) {
            j(this.f15473a, bool.booleanValue());
        }
    }

    private void q() {
        for (Component<?> component : this.f15473a.keySet()) {
            for (Dependency dependency : component.e()) {
                if (dependency.g() && !this.f15475c.containsKey(dependency.c())) {
                    this.f15475c.put(dependency.c(), LazySet.b(Collections.emptySet()));
                } else if (this.f15474b.containsKey(dependency.c())) {
                    continue;
                } else if (!dependency.f()) {
                    if (!dependency.g()) {
                        this.f15474b.put(dependency.c(), OptionalProvider.e());
                    }
                } else {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.c()));
                }
            }
        }
    }

    private List<Runnable> r(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component<?> component : list) {
            if (component.m()) {
                final Provider<?> provider = this.f15473a.get(component);
                for (Class<? super Object> cls : component.g()) {
                    if (!this.f15474b.containsKey(cls)) {
                        this.f15474b.put(cls, provider);
                    } else {
                        final OptionalProvider optionalProvider = (OptionalProvider) this.f15474b.get(cls);
                        arrayList.add(new Runnable() { // from class: com.google.firebase.components.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                OptionalProvider.this.j(provider);
                            }
                        });
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> s() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry<Component<?>, Provider<?>> entry : this.f15473a.entrySet()) {
            Component<?> key = entry.getKey();
            if (!key.m()) {
                Provider<?> value = entry.getValue();
                for (Class<? super Object> cls : key.g()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (!this.f15475c.containsKey(entry2.getKey())) {
                this.f15475c.put((Class) entry2.getKey(), LazySet.b((Collection) entry2.getValue()));
            } else {
                final LazySet<?> lazySet = this.f15475c.get(entry2.getKey());
                for (final Provider provider : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: com.google.firebase.components.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            LazySet.this.a(provider);
                        }
                    });
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<Set<T>> a(Class<T> cls) {
        LazySet<?> lazySet = this.f15475c.get(cls);
        if (lazySet != null) {
            return lazySet;
        }
        return (Provider<Set<T>>) f15472g;
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Set b(Class cls) {
        return super.b(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<T> c(Class<T> cls) {
        Preconditions.c(cls, "Null interface requested.");
        return (Provider<T>) this.f15474b.get(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> d(Class<T> cls) {
        Provider<T> c8 = c(cls);
        if (c8 == null) {
            return OptionalProvider.e();
        }
        if (c8 instanceof OptionalProvider) {
            return (OptionalProvider) c8;
        }
        return OptionalProvider.i(c8);
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    public void k(boolean z7) {
        HashMap hashMap;
        if (!androidx.camera.view.e.a(this.f15478f, null, Boolean.valueOf(z7))) {
            return;
        }
        synchronized (this) {
            hashMap = new HashMap(this.f15473a);
        }
        j(hashMap, z7);
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection) {
        this.f15473a = new HashMap();
        this.f15474b = new HashMap();
        this.f15475c = new HashMap();
        this.f15478f = new AtomicReference<>();
        EventBus eventBus = new EventBus(executor);
        this.f15477e = eventBus;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.p(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList.add(Component.p(this, ComponentLoader.class, new Class[0]));
        for (Component<?> component : collection) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        this.f15476d = l(iterable);
        i(arrayList);
    }
}
