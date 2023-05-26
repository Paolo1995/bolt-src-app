package ee.mtakso.driver.ui.screens.settings;

/* compiled from: SettingsScreenState.kt */
/* loaded from: classes5.dex */
public final class QuickAccessConfig {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f33020a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f33021b;

    public QuickAccessConfig(boolean z7, boolean z8) {
        this.f33020a = z7;
        this.f33021b = z8;
    }

    public final boolean a() {
        return this.f33020a;
    }

    public final boolean b() {
        return this.f33021b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickAccessConfig) {
            QuickAccessConfig quickAccessConfig = (QuickAccessConfig) obj;
            return this.f33020a == quickAccessConfig.f33020a && this.f33021b == quickAccessConfig.f33021b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f33020a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i8 = r02 * 31;
        boolean z8 = this.f33021b;
        return i8 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        boolean z7 = this.f33020a;
        boolean z8 = this.f33021b;
        return "QuickAccessConfig(isButtonEnabled=" + z7 + ", isWidgetEnabled=" + z8 + ")";
    }
}
