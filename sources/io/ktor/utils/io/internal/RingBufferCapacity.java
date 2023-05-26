package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;

/* compiled from: RingBufferCapacity.kt */
/* loaded from: classes5.dex */
public final class RingBufferCapacity {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f47455b = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_availableForRead$internal");

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f47456c = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_availableForWrite$internal");

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f47457d = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_pendingToFlush");
    public volatile /* synthetic */ int _availableForWrite$internal;

    /* renamed from: a  reason: collision with root package name */
    private final int f47458a;
    public volatile /* synthetic */ int _availableForRead$internal = 0;
    volatile /* synthetic */ int _pendingToFlush = 0;

    public RingBufferCapacity(int i8) {
        this.f47458a = i8;
        this._availableForWrite$internal = i8;
    }

    private final Void b(int i8, int i9, int i10) {
        throw new IllegalArgumentException("Completed read overflow: " + i8 + " + " + i10 + " = " + i9 + " > " + this.f47458a);
    }

    private final Void d(int i8, int i9) {
        throw new IllegalArgumentException("Complete write overflow: " + i8 + " + " + i9 + " > " + this.f47458a);
    }

    public final void a(int i8) {
        int i9;
        int i10;
        do {
            i9 = this._availableForWrite$internal;
            i10 = i9 + i8;
            if (i10 > this.f47458a) {
                b(i9, i10, i8);
                throw new KotlinNothingValueException();
            }
        } while (!f47456c.compareAndSet(this, i9, i10));
    }

    public final void c(int i8) {
        int i9;
        int i10;
        do {
            i9 = this._pendingToFlush;
            i10 = i9 + i8;
            if (i10 > this.f47458a) {
                d(i9, i8);
                throw new KotlinNothingValueException();
            }
        } while (!f47457d.compareAndSet(this, i9, i10));
    }

    public final boolean e() {
        int andSet = f47457d.getAndSet(this, 0);
        if (andSet == 0) {
            if (this._availableForRead$internal <= 0) {
                return false;
            }
            return true;
        } else if (f47455b.addAndGet(this, andSet) <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public final void f() {
        f47456c.getAndSet(this, 0);
    }

    public final boolean g() {
        if (this._availableForWrite$internal == this.f47458a) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        if (this._availableForWrite$internal == 0) {
            return true;
        }
        return false;
    }

    public final void i() {
        this._availableForRead$internal = this.f47458a;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    public final void j() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.f47458a;
    }

    public final boolean k() {
        int i8;
        do {
            i8 = this._availableForWrite$internal;
            if (this._pendingToFlush > 0 || this._availableForRead$internal > 0 || i8 != this.f47458a) {
                return false;
            }
        } while (!f47456c.compareAndSet(this, i8, 0));
        return true;
    }

    public final int l(int i8) {
        int i9;
        int min;
        do {
            i9 = this._availableForRead$internal;
            min = Math.min(i8, i9);
            if (min == 0) {
                return 0;
            }
        } while (!f47455b.compareAndSet(this, i9, i9 - min));
        return Math.min(i8, i9);
    }

    public final boolean m(int i8) {
        int i9;
        do {
            i9 = this._availableForRead$internal;
            if (i9 < i8) {
                return false;
            }
        } while (!f47455b.compareAndSet(this, i9, i9 - i8));
        return true;
    }

    public final int n(int i8) {
        int i9;
        do {
            i9 = this._availableForWrite$internal;
            if (i9 < i8) {
                return 0;
            }
        } while (!f47456c.compareAndSet(this, i9, 0));
        return i9;
    }

    public final int o(int i8) {
        int i9;
        int min;
        do {
            i9 = this._availableForWrite$internal;
            min = Math.min(i8, i9);
            if (min == 0) {
                return 0;
            }
        } while (!f47456c.compareAndSet(this, i9, i9 - min));
        return Math.min(i8, i9);
    }

    public String toString() {
        return "RingBufferCapacity[read: " + this._availableForRead$internal + ", write: " + this._availableForWrite$internal + ", flush: " + this._pendingToFlush + ", capacity: " + this.f47458a + ']';
    }
}
