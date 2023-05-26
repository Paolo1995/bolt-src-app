package ee.mtakso.driver.ui.screens.work.dispatch;

import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchSettingsState.kt */
/* loaded from: classes5.dex */
public final class DispatchSettingsState {

    /* renamed from: a  reason: collision with root package name */
    private final List<DispatchCategorySetting> f33998a;

    /* renamed from: b  reason: collision with root package name */
    private final DispatchHeatmapSettings f33999b;

    /* renamed from: c  reason: collision with root package name */
    private final AutoOrderAcceptance f34000c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f34001d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f34002e;

    public DispatchSettingsState(List<DispatchCategorySetting> list, DispatchHeatmapSettings dispatchHeatmapSettings, AutoOrderAcceptance autoOrderAcceptance, boolean z7, boolean z8) {
        this.f33998a = list;
        this.f33999b = dispatchHeatmapSettings;
        this.f34000c = autoOrderAcceptance;
        this.f34001d = z7;
        this.f34002e = z8;
    }

    public final AutoOrderAcceptance a() {
        return this.f34000c;
    }

    public final List<DispatchCategorySetting> b() {
        return this.f33998a;
    }

    public final boolean c() {
        return this.f34001d;
    }

    public final DispatchHeatmapSettings d() {
        return this.f33999b;
    }

    public final boolean e() {
        return this.f34002e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispatchSettingsState) {
            DispatchSettingsState dispatchSettingsState = (DispatchSettingsState) obj;
            return Intrinsics.a(this.f33998a, dispatchSettingsState.f33998a) && Intrinsics.a(this.f33999b, dispatchSettingsState.f33999b) && this.f34000c == dispatchSettingsState.f34000c && this.f34001d == dispatchSettingsState.f34001d && this.f34002e == dispatchSettingsState.f34002e;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<DispatchCategorySetting> list = this.f33998a;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        DispatchHeatmapSettings dispatchHeatmapSettings = this.f33999b;
        int hashCode2 = (hashCode + (dispatchHeatmapSettings == null ? 0 : dispatchHeatmapSettings.hashCode())) * 31;
        AutoOrderAcceptance autoOrderAcceptance = this.f34000c;
        int hashCode3 = (hashCode2 + (autoOrderAcceptance != null ? autoOrderAcceptance.hashCode() : 0)) * 31;
        boolean z7 = this.f34001d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode3 + i8) * 31;
        boolean z8 = this.f34002e;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        List<DispatchCategorySetting> list = this.f33998a;
        DispatchHeatmapSettings dispatchHeatmapSettings = this.f33999b;
        AutoOrderAcceptance autoOrderAcceptance = this.f34000c;
        boolean z7 = this.f34001d;
        boolean z8 = this.f34002e;
        return "DispatchSettingsState(categories=" + list + ", heatmapSettings=" + dispatchHeatmapSettings + ", autoAcceptance=" + autoOrderAcceptance + ", error=" + z7 + ", shouldShowTooltip=" + z8 + ")";
    }
}
