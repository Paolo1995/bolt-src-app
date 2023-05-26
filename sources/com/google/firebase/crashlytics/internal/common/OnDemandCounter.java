package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class OnDemandCounter {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f15716a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f15717b = new AtomicInteger();

    public void a() {
        this.f15717b.getAndIncrement();
    }

    public void b() {
        this.f15716a.getAndIncrement();
    }

    public void c() {
        this.f15717b.set(0);
    }
}
