package ee.mtakso.driver.ui.views.quickaccess;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessDetailsState.kt */
/* loaded from: classes5.dex */
public final class QuickAccessTimerState {

    /* renamed from: a  reason: collision with root package name */
    private final long f34494a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34495b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34496c;

    /* renamed from: d  reason: collision with root package name */
    private final QuickAccessTimerTarget f34497d;

    public QuickAccessTimerState(long j8, String stringToFormat, boolean z7, QuickAccessTimerTarget target) {
        Intrinsics.f(stringToFormat, "stringToFormat");
        Intrinsics.f(target, "target");
        this.f34494a = j8;
        this.f34495b = stringToFormat;
        this.f34496c = z7;
        this.f34497d = target;
    }

    public final String a() {
        return this.f34495b;
    }

    public final QuickAccessTimerTarget b() {
        return this.f34497d;
    }

    public final long c() {
        return this.f34494a;
    }

    public final boolean d() {
        return this.f34496c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickAccessTimerState) {
            QuickAccessTimerState quickAccessTimerState = (QuickAccessTimerState) obj;
            return this.f34494a == quickAccessTimerState.f34494a && Intrinsics.a(this.f34495b, quickAccessTimerState.f34495b) && this.f34496c == quickAccessTimerState.f34496c && this.f34497d == quickAccessTimerState.f34497d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = ((i0.a.a(this.f34494a) * 31) + this.f34495b.hashCode()) * 31;
        boolean z7 = this.f34496c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return ((a8 + i8) * 31) + this.f34497d.hashCode();
    }

    public String toString() {
        long j8 = this.f34494a;
        String str = this.f34495b;
        boolean z7 = this.f34496c;
        QuickAccessTimerTarget quickAccessTimerTarget = this.f34497d;
        return "QuickAccessTimerState(time=" + j8 + ", stringToFormat=" + str + ", isReverse=" + z7 + ", target=" + quickAccessTimerTarget + ")";
    }

    public /* synthetic */ QuickAccessTimerState(long j8, String str, boolean z7, QuickAccessTimerTarget quickAccessTimerTarget, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j8, str, (i8 & 4) != 0 ? false : z7, quickAccessTimerTarget);
    }
}
