package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KTypeProjection.kt */
/* loaded from: classes5.dex */
public final class KTypeProjection {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f51072c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    public static final KTypeProjection f51073d = new KTypeProjection(null, null);

    /* renamed from: a  reason: collision with root package name */
    private final KVariance f51074a;

    /* renamed from: b  reason: collision with root package name */
    private final KType f51075b;

    /* compiled from: KTypeProjection.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KTypeProjection a(KType type) {
            Intrinsics.f(type, "type");
            return new KTypeProjection(KVariance.INVARIANT, type);
        }
    }

    /* compiled from: KTypeProjection.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51076a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f51076a = iArr;
        }
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        boolean z7;
        boolean z8;
        String str;
        this.f51074a = kVariance;
        this.f51075b = kType;
        if (kVariance == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (kType == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!(z7 == z8)) {
            if (kVariance == null) {
                str = "Star projection must have no type specified.";
            } else {
                str = "The projection variance " + kVariance + " requires type to be specified.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public final KVariance a() {
        return this.f51074a;
    }

    public final KType b() {
        return this.f51075b;
    }

    public final KType c() {
        return this.f51075b;
    }

    public final KVariance d() {
        return this.f51074a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KTypeProjection) {
            KTypeProjection kTypeProjection = (KTypeProjection) obj;
            return this.f51074a == kTypeProjection.f51074a && Intrinsics.a(this.f51075b, kTypeProjection.f51075b);
        }
        return false;
    }

    public int hashCode() {
        KVariance kVariance = this.f51074a;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        KType kType = this.f51075b;
        return hashCode + (kType != null ? kType.hashCode() : 0);
    }

    public String toString() {
        int i8;
        KVariance kVariance = this.f51074a;
        if (kVariance == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f51076a[kVariance.ordinal()];
        }
        if (i8 != -1) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        return "out " + this.f51075b;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "in " + this.f51075b;
            }
            return String.valueOf(this.f51075b);
        }
        return "*";
    }
}
