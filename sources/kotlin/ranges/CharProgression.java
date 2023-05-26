package kotlin.ranges;

import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Progressions.kt */
/* loaded from: classes5.dex */
public class CharProgression implements Iterable<Character>, KMappedMarker {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f51039i = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final char f51040f;

    /* renamed from: g  reason: collision with root package name */
    private final char f51041g;

    /* renamed from: h  reason: collision with root package name */
    private final int f51042h;

    /* compiled from: Progressions.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharProgression(char c8, char c9, int i8) {
        if (i8 != 0) {
            if (i8 != Integer.MIN_VALUE) {
                this.f51040f = c8;
                this.f51041g = (char) ProgressionUtilKt.c(c8, c9, i8);
                this.f51042h = i8;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final char g() {
        return this.f51040f;
    }

    public final char i() {
        return this.f51041g;
    }

    @Override // java.lang.Iterable
    /* renamed from: k */
    public CharIterator iterator() {
        return new CharProgressionIterator(this.f51040f, this.f51041g, this.f51042h);
    }
}
