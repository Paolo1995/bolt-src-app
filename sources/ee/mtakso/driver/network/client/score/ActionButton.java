package ee.mtakso.driver.network.client.score;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.ButtonType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class ActionButton {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final ButtonType f22710a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f22711b;
    @SerializedName(ImagesContract.URL)

    /* renamed from: c  reason: collision with root package name */
    private final String f22712c;

    public final String a() {
        return this.f22711b;
    }

    public final String b() {
        return this.f22712c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActionButton) {
            ActionButton actionButton = (ActionButton) obj;
            return this.f22710a == actionButton.f22710a && Intrinsics.a(this.f22711b, actionButton.f22711b) && Intrinsics.a(this.f22712c, actionButton.f22712c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f22710a.hashCode() * 31) + this.f22711b.hashCode()) * 31) + this.f22712c.hashCode();
    }

    public String toString() {
        ButtonType buttonType = this.f22710a;
        String str = this.f22711b;
        String str2 = this.f22712c;
        return "ActionButton(type=" + buttonType + ", text=" + str + ", url=" + str2 + ")";
    }
}
