package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes5.dex */
public final class IntProgressionIterator extends IntIterator {

    /* renamed from: f  reason: collision with root package name */
    private final int f51055f;

    /* renamed from: g  reason: collision with root package name */
    private final int f51056g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51057h;

    /* renamed from: i  reason: collision with root package name */
    private int f51058i;

    public IntProgressionIterator(int i8, int i9, int i10) {
        this.f51055f = i10;
        this.f51056g = i9;
        boolean z7 = true;
        if (i10 <= 0 ? i8 < i9 : i8 > i9) {
            z7 = false;
        }
        this.f51057h = z7;
        this.f51058i = z7 ? i8 : i9;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.f51057h;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int i8 = this.f51058i;
        if (i8 == this.f51056g) {
            if (this.f51057h) {
                this.f51057h = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f51058i = this.f51055f + i8;
        }
        return i8;
    }
}
