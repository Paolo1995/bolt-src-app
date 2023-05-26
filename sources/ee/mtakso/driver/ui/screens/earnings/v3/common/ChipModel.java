package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipModel.kt */
/* loaded from: classes3.dex */
public final class ChipModel {

    /* renamed from: a  reason: collision with root package name */
    private final Text f28993a;

    /* renamed from: b  reason: collision with root package name */
    private final Color f28994b;

    /* renamed from: c  reason: collision with root package name */
    private final Image f28995c;

    /* renamed from: d  reason: collision with root package name */
    private final Color f28996d;

    /* renamed from: e  reason: collision with root package name */
    private final Color f28997e;

    public ChipModel(Text text, Color textColor, Image image, Color color, Color backgroundColor) {
        Intrinsics.f(textColor, "textColor");
        Intrinsics.f(backgroundColor, "backgroundColor");
        this.f28993a = text;
        this.f28994b = textColor;
        this.f28995c = image;
        this.f28996d = color;
        this.f28997e = backgroundColor;
    }

    public final Color a() {
        return this.f28997e;
    }

    public final Image b() {
        return this.f28995c;
    }

    public final Text c() {
        return this.f28993a;
    }

    public final Color d() {
        return this.f28994b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChipModel) {
            ChipModel chipModel = (ChipModel) obj;
            return Intrinsics.a(this.f28993a, chipModel.f28993a) && Intrinsics.a(this.f28994b, chipModel.f28994b) && Intrinsics.a(this.f28995c, chipModel.f28995c) && Intrinsics.a(this.f28996d, chipModel.f28996d) && Intrinsics.a(this.f28997e, chipModel.f28997e);
        }
        return false;
    }

    public int hashCode() {
        Text text = this.f28993a;
        int hashCode = (((text == null ? 0 : text.hashCode()) * 31) + this.f28994b.hashCode()) * 31;
        Image image = this.f28995c;
        int hashCode2 = (hashCode + (image == null ? 0 : image.hashCode())) * 31;
        Color color = this.f28996d;
        return ((hashCode2 + (color != null ? color.hashCode() : 0)) * 31) + this.f28997e.hashCode();
    }

    public String toString() {
        Text text = this.f28993a;
        Color color = this.f28994b;
        Image image = this.f28995c;
        Color color2 = this.f28996d;
        Color color3 = this.f28997e;
        return "ChipModel(text=" + text + ", textColor=" + color + ", image=" + image + ", imageTint=" + color2 + ", backgroundColor=" + color3 + ")";
    }
}
