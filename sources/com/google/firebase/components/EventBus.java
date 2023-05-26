package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class EventBus implements Subscriber, Publisher {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> f15491a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue<Event<?>> f15492b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f15493c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventBus(Executor executor) {
        this.f15493c = executor;
    }

    private synchronized Set<Map.Entry<EventHandler<Object>, Executor>> e(Event<?> event) {
        Set<Map.Entry<EventHandler<Object>, Executor>> entrySet;
        ConcurrentHashMap<EventHandler<Object>, Executor> concurrentHashMap = this.f15491a.get(event.b());
        if (concurrentHashMap == null) {
            entrySet = Collections.emptySet();
        } else {
            entrySet = concurrentHashMap.entrySet();
        }
        return entrySet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Map.Entry entry, Event event) {
        ((EventHandler) entry.getKey()).a(event);
    }

    @Override // com.google.firebase.events.Subscriber
    public <T> void a(Class<T> cls, EventHandler<? super T> eventHandler) {
        b(cls, this.f15493c, eventHandler);
    }

    @Override // com.google.firebase.events.Subscriber
    public synchronized <T> void b(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        Preconditions.b(cls);
        Preconditions.b(eventHandler);
        Preconditions.b(executor);
        if (!this.f15491a.containsKey(cls)) {
            this.f15491a.put(cls, new ConcurrentHashMap<>());
        }
        this.f15491a.get(cls).put(eventHandler, executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Queue<Event<?>> queue;
        synchronized (this) {
            queue = this.f15492b;
            if (queue != null) {
                this.f15492b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (Event<?> event : queue) {
                g(event);
            }
        }
    }

    public void g(final Event<?> event) {
        Preconditions.b(event);
        synchronized (this) {
            Queue<Event<?>> queue = this.f15492b;
            if (queue != null) {
                queue.add(event);
                return;
            }
            for (final Map.Entry<EventHandler<Object>, Executor> entry : e(event)) {
                entry.getValue().execute(new Runnable() { // from class: com.google.firebase.components.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        EventBus.f(entry, event);
                    }
                });
            }
        }
    }
}
