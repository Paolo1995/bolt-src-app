package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ButtonData.kt */
/* loaded from: classes3.dex */
public final class ButtonData<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Text f28988a;

    /* renamed from: b  reason: collision with root package name */
    private final UiKitRoundButtonType f28989b;

    /* renamed from: c  reason: collision with root package name */
    private final UiKitRoundButtonSize f28990c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f28991d;

    /* renamed from: e  reason: collision with root package name */
    private final T f28992e;

    public ButtonData(Text text, UiKitRoundButtonType type, UiKitRoundButtonSize size, Boolean bool, T t7) {
        Intrinsics.f(type, "type");
        Intrinsics.f(size, "size");
        this.f28988a = text;
        this.f28989b = type;
        this.f28990c = size;
        this.f28991d = bool;
        this.f28992e = t7;
    }

    public final T a() {
        return this.f28992e;
    }

    public final UiKitRoundButtonSize b() {
        return this.f28990c;
    }

    public final Text c() {
        return this.f28988a;
    }

    public final UiKitRoundButtonType d() {
        return this.f28989b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ButtonData) {
            ButtonData buttonData = (ButtonData) obj;
            return Intrinsics.a(this.f28988a, buttonData.f28988a) && this.f28989b == buttonData.f28989b && this.f28990c == buttonData.f28990c && Intrinsics.a(this.f28991d, buttonData.f28991d) && Intrinsics.a(this.f28992e, buttonData.f28992e);
        }
        return false;
    }

    public int hashCode() {
        Text text = this.f28988a;
        int hashCode = (((((text == null ? 0 : text.hashCode()) * 31) + this.f28989b.hashCode()) * 31) + this.f28990c.hashCode()) * 31;
        Boolean bool = this.f28991d;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        T t7 = this.f28992e;
        return hashCode2 + (t7 != null ? t7.hashCode() : 0);
    }

    public String toString() {
        Text text = this.f28988a;
        UiKitRoundButtonType uiKitRoundButtonType = this.f28989b;
        UiKitRoundButtonSize uiKitRoundButtonSize = this.f28990c;
        Boolean bool = this.f28991d;
        T t7 = this.f28992e;
        return "ButtonData(text=" + text + ", type=" + uiKitRoundButtonType + ", size=" + uiKitRoundButtonSize + ", enabled=" + bool + ", payload=" + t7 + ")";
    }
}
