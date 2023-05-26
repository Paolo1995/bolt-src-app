package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyAssistFooterData.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistFooterData {

    /* renamed from: a  reason: collision with root package name */
    private final Text f32672a;

    /* renamed from: b  reason: collision with root package name */
    private final Image f32673b;

    public EmergencyAssistFooterData(Text text, Image image) {
        this.f32672a = text;
        this.f32673b = image;
    }

    public final Text a() {
        return this.f32672a;
    }

    public final Image b() {
        return this.f32673b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmergencyAssistFooterData) {
            EmergencyAssistFooterData emergencyAssistFooterData = (EmergencyAssistFooterData) obj;
            return Intrinsics.a(this.f32672a, emergencyAssistFooterData.f32672a) && Intrinsics.a(this.f32673b, emergencyAssistFooterData.f32673b);
        }
        return false;
    }

    public int hashCode() {
        Text text = this.f32672a;
        int hashCode = (text == null ? 0 : text.hashCode()) * 31;
        Image image = this.f32673b;
        return hashCode + (image != null ? image.hashCode() : 0);
    }

    public String toString() {
        Text text = this.f32672a;
        Image image = this.f32673b;
        return "EmergencyAssistFooterData(keyText=" + text + ", logo=" + image + ")";
    }
}
