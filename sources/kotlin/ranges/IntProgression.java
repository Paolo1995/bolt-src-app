package kotlin.ranges;

import kotlin.collections.IntIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Progressions.kt */
/* loaded from: classes5.dex */
public class IntProgression implements Iterable<Integer>, KMappedMarker {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f51051i = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final int f51052f;

    /* renamed from: g  reason: collision with root package name */
    private final int f51053g;

    /* renamed from: h  reason: collision with root package name */
    private final int f51054h;

    /* compiled from: Progressions.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntProgression a(int i8, int i9, int i10) {
            return new IntProgression(i8, i9, i10);
        }
    }

    public IntProgression(int i8, int i9, int i10) {
        if (i10 != 0) {
            if (i10 != Integer.MIN_VALUE) {
                this.f51052f = i8;
                this.f51053g = ProgressionUtilKt.c(i8, i9, i10);
                this.f51054h = i10;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) obj).isEmpty()) {
                IntProgression intProgression = (IntProgression) obj;
                if (this.f51052f != intProgression.f51052f || this.f51053g != intProgression.f51053g || this.f51054h != intProgression.f51054h) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f51052f;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f51052f * 31) + this.f51053g) * 31) + this.f51054h;
    }

    public final int i() {
        return this.f51053g;
    }

    public boolean isEmpty() {
        if (this.f51054h > 0) {
            if (this.f51052f > this.f51053g) {
                return true;
            }
        } else if (this.f51052f < this.f51053g) {
            return true;
        }
        return false;
    }

    public final int k() {
        return this.f51054h;
    }

    @Override // java.lang.Iterable
    /* renamed from: m */
    public IntIterator iterator() {
        return new IntProgressionIterator(this.f51052f, this.f51053g, this.f51054h);
    }

    public String toString() {
        StringBuilder sb;
        int i8;
        if (this.f51054h > 0) {
            sb = new StringBuilder();
            sb.append(this.f51052f);
            sb.append("..");
            sb.append(this.f51053g);
            sb.append(" step ");
            i8 = this.f51054h;
        } else {
            sb = new StringBuilder();
            sb.append(this.f51052f);
            sb.append(" downTo ");
            sb.append(this.f51053g);
            sb.append(" step ");
            i8 = -this.f51054h;
        }
        sb.append(i8);
        return sb.toString();
    }
}
