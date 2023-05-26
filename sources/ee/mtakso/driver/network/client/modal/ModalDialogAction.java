package ee.mtakso.driver.network.client.modal;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.ButtonType;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ModalDialogResponse.kt */
/* loaded from: classes3.dex */
public final class ModalDialogAction {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f22283a;
    @SerializedName("type")

    /* renamed from: b  reason: collision with root package name */
    private final ButtonType f22284b;
    @SerializedName("text")

    /* renamed from: c  reason: collision with root package name */
    private final String f22285c;
    @SerializedName("link")

    /* renamed from: d  reason: collision with root package name */
    private final String f22286d;

    public ModalDialogAction(String str, ButtonType buttonType, String text, String str2) {
        Intrinsics.f(text, "text");
        this.f22283a = str;
        this.f22284b = buttonType;
        this.f22285c = text;
        this.f22286d = str2;
    }

    public final String a() {
        return this.f22283a;
    }

    public final String b() {
        return this.f22286d;
    }

    public final String c() {
        return this.f22285c;
    }

    public final ButtonType d() {
        return this.f22284b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModalDialogAction) {
            ModalDialogAction modalDialogAction = (ModalDialogAction) obj;
            return Intrinsics.a(this.f22283a, modalDialogAction.f22283a) && this.f22284b == modalDialogAction.f22284b && Intrinsics.a(this.f22285c, modalDialogAction.f22285c) && Intrinsics.a(this.f22286d, modalDialogAction.f22286d);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22283a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ButtonType buttonType = this.f22284b;
        int hashCode2 = (((hashCode + (buttonType == null ? 0 : buttonType.hashCode())) * 31) + this.f22285c.hashCode()) * 31;
        String str2 = this.f22286d;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22283a;
        ButtonType buttonType = this.f22284b;
        String str2 = this.f22285c;
        String str3 = this.f22286d;
        return "ModalDialogAction(id=" + str + ", type=" + buttonType + ", text=" + str2 + ", link=" + str3 + ")";
    }
}
