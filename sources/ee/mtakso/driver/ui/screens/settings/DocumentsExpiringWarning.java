package ee.mtakso.driver.ui.screens.settings;

/* compiled from: SettingsScreenState.kt */
/* loaded from: classes5.dex */
public final class DocumentsExpiringWarning {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f33002a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33003b;

    public DocumentsExpiringWarning(boolean z7, int i8) {
        this.f33002a = z7;
        this.f33003b = i8;
    }

    public final int a() {
        return this.f33003b;
    }

    public final boolean b() {
        return this.f33002a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DocumentsExpiringWarning) {
            DocumentsExpiringWarning documentsExpiringWarning = (DocumentsExpiringWarning) obj;
            return this.f33002a == documentsExpiringWarning.f33002a && this.f33003b == documentsExpiringWarning.f33003b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f33002a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        return (r02 * 31) + this.f33003b;
    }

    public String toString() {
        boolean z7 = this.f33002a;
        int i8 = this.f33003b;
        return "DocumentsExpiringWarning(hasExpired=" + z7 + ", expiringInDays=" + i8 + ")";
    }
}
