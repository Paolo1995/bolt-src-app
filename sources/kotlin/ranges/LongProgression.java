package kotlin.ranges;

import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Progressions.kt */
/* loaded from: classes5.dex */
public class LongProgression implements Iterable<Long>, KMappedMarker {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f51061i = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final long f51062f;

    /* renamed from: g  reason: collision with root package name */
    private final long f51063g;

    /* renamed from: h  reason: collision with root package name */
    private final long f51064h;

    /* compiled from: Progressions.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongProgression(long j8, long j9, long j10) {
        if (j10 != 0) {
            if (j10 != Long.MIN_VALUE) {
                this.f51062f = j8;
                this.f51063g = ProgressionUtilKt.d(j8, j9, j10);
                this.f51064h = j10;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final long g() {
        return this.f51062f;
    }

    public final long i() {
        return this.f51063g;
    }

    @Override // java.lang.Iterable
    /* renamed from: k */
    public LongIterator iterator() {
        return new LongProgressionIterator(this.f51062f, this.f51063g, this.f51064h);
    }
}
