package ee.mtakso.driver.ui.screens.order.v2;

/* compiled from: OrderViewModel.kt */
/* loaded from: classes3.dex */
public final class StartPaidWaitingData {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32057a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32058b;

    public StartPaidWaitingData(boolean z7, boolean z8) {
        this.f32057a = z7;
        this.f32058b = z8;
    }

    public static /* synthetic */ StartPaidWaitingData b(StartPaidWaitingData startPaidWaitingData, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = startPaidWaitingData.f32057a;
        }
        if ((i8 & 2) != 0) {
            z8 = startPaidWaitingData.f32058b;
        }
        return startPaidWaitingData.a(z7, z8);
    }

    public final StartPaidWaitingData a(boolean z7, boolean z8) {
        return new StartPaidWaitingData(z7, z8);
    }

    public final boolean c() {
        return this.f32057a;
    }

    public final boolean d() {
        return this.f32058b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StartPaidWaitingData) {
            StartPaidWaitingData startPaidWaitingData = (StartPaidWaitingData) obj;
            return this.f32057a == startPaidWaitingData.f32057a && this.f32058b == startPaidWaitingData.f32058b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f32057a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i8 = r02 * 31;
        boolean z8 = this.f32058b;
        return i8 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        boolean z7 = this.f32057a;
        boolean z8 = this.f32058b;
        return "StartPaidWaitingData(allowedByInteractor=" + z7 + ", forceDisabled=" + z8 + ")";
    }
}
