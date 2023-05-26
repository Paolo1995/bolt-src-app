package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToolkitState.kt */
/* loaded from: classes3.dex */
public final class ToolkitState {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32855a;

    /* renamed from: b  reason: collision with root package name */
    private final ExternalHelpProviderResponse f32856b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f32857c;

    /* renamed from: d  reason: collision with root package name */
    private final RecorderState f32858d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f32859e;

    public ToolkitState(boolean z7, ExternalHelpProviderResponse incidentData, boolean z8, RecorderState recorderState, boolean z9) {
        Intrinsics.f(incidentData, "incidentData");
        Intrinsics.f(recorderState, "recorderState");
        this.f32855a = z7;
        this.f32856b = incidentData;
        this.f32857c = z8;
        this.f32858d = recorderState;
        this.f32859e = z9;
    }

    public final boolean a() {
        return this.f32857c;
    }

    public final boolean b() {
        return this.f32855a;
    }

    public final ExternalHelpProviderResponse c() {
        return this.f32856b;
    }

    public final boolean d() {
        return this.f32859e;
    }

    public final RecorderState e() {
        return this.f32858d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToolkitState) {
            ToolkitState toolkitState = (ToolkitState) obj;
            return this.f32855a == toolkitState.f32855a && Intrinsics.a(this.f32856b, toolkitState.f32856b) && this.f32857c == toolkitState.f32857c && Intrinsics.a(this.f32858d, toolkitState.f32858d) && this.f32859e == toolkitState.f32859e;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z7 = this.f32855a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int hashCode = ((r02 * 31) + this.f32856b.hashCode()) * 31;
        ?? r22 = this.f32857c;
        int i8 = r22;
        if (r22 != 0) {
            i8 = 1;
        }
        int hashCode2 = (((hashCode + i8) * 31) + this.f32858d.hashCode()) * 31;
        boolean z8 = this.f32859e;
        return hashCode2 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        boolean z7 = this.f32855a;
        ExternalHelpProviderResponse externalHelpProviderResponse = this.f32856b;
        boolean z8 = this.f32857c;
        RecorderState recorderState = this.f32858d;
        boolean z9 = this.f32859e;
        return "ToolkitState(hasActiveOrder=" + z7 + ", incidentData=" + externalHelpProviderResponse + ", hasActiveIncident=" + z8 + ", recorderState=" + recorderState + ", recordAudioPermissionGranted=" + z9 + ")";
    }
}
