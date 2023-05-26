package com.google.firebase.events;

/* loaded from: classes3.dex */
public class Event<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f16254a;

    /* renamed from: b  reason: collision with root package name */
    private final T f16255b;

    public T a() {
        return this.f16255b;
    }

    public Class<T> b() {
        return this.f16254a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f16254a, this.f16255b);
    }
}
