package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.network.client.campaign.OptInChoiceV2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptInChoiceState.kt */
/* loaded from: classes3.dex */
public final class OptInChoiceState {

    /* renamed from: a  reason: collision with root package name */
    private final OptInChoiceV2 f27508a;

    public OptInChoiceState(OptInChoiceV2 choice) {
        Intrinsics.f(choice, "choice");
        this.f27508a = choice;
    }

    public final OptInChoiceV2 a() {
        return this.f27508a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OptInChoiceState) && Intrinsics.a(this.f27508a, ((OptInChoiceState) obj).f27508a);
    }

    public int hashCode() {
        return this.f27508a.hashCode();
    }

    public String toString() {
        OptInChoiceV2 optInChoiceV2 = this.f27508a;
        return "OptInChoiceState(choice=" + optInChoiceV2 + ")";
    }
}
