package ee.mtakso.driver.ui.screens.home.v3.header.appearance;

import ee.mtakso.driver.uikit.widgets.RoundButton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OfflineButtonsHolder.kt */
/* loaded from: classes3.dex */
public final class OfflineButtonsHolder {

    /* renamed from: a  reason: collision with root package name */
    private final RoundButton f30035a;

    /* renamed from: b  reason: collision with root package name */
    private final RightButton f30036b;

    public OfflineButtonsHolder(RoundButton destination, RightButton rightButton) {
        Intrinsics.f(destination, "destination");
        Intrinsics.f(rightButton, "rightButton");
        this.f30035a = destination;
        this.f30036b = rightButton;
    }

    public final RoundButton a() {
        return this.f30035a;
    }

    public final RightButton b() {
        return this.f30036b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineButtonsHolder) {
            OfflineButtonsHolder offlineButtonsHolder = (OfflineButtonsHolder) obj;
            return Intrinsics.a(this.f30035a, offlineButtonsHolder.f30035a) && Intrinsics.a(this.f30036b, offlineButtonsHolder.f30036b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f30035a.hashCode() * 31) + this.f30036b.hashCode();
    }

    public String toString() {
        RoundButton roundButton = this.f30035a;
        RightButton rightButton = this.f30036b;
        return "OfflineButtonsHolder(destination=" + roundButton + ", rightButton=" + rightButton + ")";
    }
}
