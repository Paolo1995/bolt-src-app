package ee.mtakso.driver.ui.views.quickaccess;

/* compiled from: QuickAccessDetailsState.kt */
/* loaded from: classes5.dex */
public final class PaidWaitingButtonState {

    /* renamed from: a  reason: collision with root package name */
    private final int f34377a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f34378b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34379c;

    public PaidWaitingButtonState(int i8, boolean z7, boolean z8) {
        this.f34377a = i8;
        this.f34378b = z7;
        this.f34379c = z8;
    }

    public final int a() {
        return this.f34377a;
    }

    public final boolean b() {
        return this.f34379c;
    }

    public final boolean c() {
        return this.f34378b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaidWaitingButtonState) {
            PaidWaitingButtonState paidWaitingButtonState = (PaidWaitingButtonState) obj;
            return this.f34377a == paidWaitingButtonState.f34377a && this.f34378b == paidWaitingButtonState.f34378b && this.f34379c == paidWaitingButtonState.f34379c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i8 = this.f34377a * 31;
        boolean z7 = this.f34378b;
        int i9 = z7;
        if (z7 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z8 = this.f34379c;
        return i10 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        int i8 = this.f34377a;
        boolean z7 = this.f34378b;
        boolean z8 = this.f34379c;
        return "PaidWaitingButtonState(icon=" + i8 + ", isClickable=" + z7 + ", showTooltip=" + z8 + ")";
    }
}
