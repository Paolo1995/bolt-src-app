package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes5.dex */
public final class LongProgressionIterator extends LongIterator {

    /* renamed from: f  reason: collision with root package name */
    private final long f51065f;

    /* renamed from: g  reason: collision with root package name */
    private final long f51066g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51067h;

    /* renamed from: i  reason: collision with root package name */
    private long f51068i;

    public LongProgressionIterator(long j8, long j9, long j10) {
        this.f51065f = j10;
        this.f51066g = j9;
        boolean z7 = true;
        int i8 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        int i9 = (j8 > j9 ? 1 : (j8 == j9 ? 0 : -1));
        if (i8 <= 0 ? i9 < 0 : i9 > 0) {
            z7 = false;
        }
        this.f51067h = z7;
        this.f51068i = z7 ? j8 : j9;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.f51067h;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        long j8 = this.f51068i;
        if (j8 == this.f51066g) {
            if (this.f51067h) {
                this.f51067h = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f51068i = this.f51065f + j8;
        }
        return j8;
    }
}
