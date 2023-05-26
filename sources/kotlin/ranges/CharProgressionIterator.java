package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes5.dex */
public final class CharProgressionIterator extends CharIterator {

    /* renamed from: f  reason: collision with root package name */
    private final int f51043f;

    /* renamed from: g  reason: collision with root package name */
    private final int f51044g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51045h;

    /* renamed from: i  reason: collision with root package name */
    private int f51046i;

    public CharProgressionIterator(char c8, char c9, int i8) {
        this.f51043f = i8;
        this.f51044g = c9;
        boolean z7 = true;
        if (i8 <= 0 ? Intrinsics.h(c8, c9) < 0 : Intrinsics.h(c8, c9) > 0) {
            z7 = false;
        }
        this.f51045h = z7;
        this.f51046i = z7 ? c8 : c9;
    }

    @Override // kotlin.collections.CharIterator
    public char b() {
        int i8 = this.f51046i;
        if (i8 == this.f51044g) {
            if (this.f51045h) {
                this.f51045h = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f51046i = this.f51043f + i8;
        }
        return (char) i8;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.f51045h;
    }
}
