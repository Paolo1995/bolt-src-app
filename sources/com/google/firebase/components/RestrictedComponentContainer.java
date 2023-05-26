package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
final class RestrictedComponentContainer extends AbstractComponentContainer {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<?>> f15503a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<?>> f15504b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Class<?>> f15505c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Class<?>> f15506d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Class<?>> f15507e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Class<?>> f15508f;

    /* renamed from: g  reason: collision with root package name */
    private final ComponentContainer f15509g;

    /* loaded from: classes.dex */
    private static class RestrictedPublisher implements Publisher {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<?>> f15510a;

        /* renamed from: b  reason: collision with root package name */
        private final Publisher f15511b;

        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher) {
            this.f15510a = set;
            this.f15511b = publisher;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RestrictedComponentContainer(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency dependency : component.e()) {
            if (dependency.e()) {
                if (dependency.g()) {
                    hashSet4.add(dependency.c());
                } else {
                    hashSet.add(dependency.c());
                }
            } else if (dependency.d()) {
                hashSet3.add(dependency.c());
            } else if (dependency.g()) {
                hashSet5.add(dependency.c());
            } else {
                hashSet2.add(dependency.c());
            }
        }
        if (!component.h().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.f15503a = Collections.unmodifiableSet(hashSet);
        this.f15504b = Collections.unmodifiableSet(hashSet2);
        this.f15505c = Collections.unmodifiableSet(hashSet3);
        this.f15506d = Collections.unmodifiableSet(hashSet4);
        this.f15507e = Collections.unmodifiableSet(hashSet5);
        this.f15508f = component.h();
        this.f15509g = componentContainer;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> a(Class<T> cls) {
        if (this.f15507e.contains(cls)) {
            return this.f15509g.a(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public <T> Set<T> b(Class<T> cls) {
        if (this.f15506d.contains(cls)) {
            return this.f15509g.b(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> c(Class<T> cls) {
        if (this.f15504b.contains(cls)) {
            return this.f15509g.c(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> d(Class<T> cls) {
        if (this.f15505c.contains(cls)) {
            return this.f15509g.d(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", cls));
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public <T> T get(Class<T> cls) {
        if (this.f15503a.contains(cls)) {
            T t7 = (T) this.f15509g.get(cls);
            if (!cls.equals(Publisher.class)) {
                return t7;
            }
            return (T) new RestrictedPublisher(this.f15508f, (Publisher) t7);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }
}
