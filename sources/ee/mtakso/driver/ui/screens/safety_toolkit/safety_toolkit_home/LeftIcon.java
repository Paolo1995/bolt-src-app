package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Lottie;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeftIcon.kt */
/* loaded from: classes3.dex */
public final class LeftIcon {

    /* renamed from: a  reason: collision with root package name */
    private final LeftIconType f32750a;

    /* renamed from: b  reason: collision with root package name */
    private final Image f32751b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f32752c;

    /* renamed from: d  reason: collision with root package name */
    private final Lottie f32753d;

    public LeftIcon(LeftIconType type, Image image, Integer num, Lottie lottie) {
        Intrinsics.f(type, "type");
        this.f32750a = type;
        this.f32751b = image;
        this.f32752c = num;
        this.f32753d = lottie;
    }

    public final Image a() {
        return this.f32751b;
    }

    public final Lottie b() {
        return this.f32753d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LeftIcon) {
            LeftIcon leftIcon = (LeftIcon) obj;
            return this.f32750a == leftIcon.f32750a && Intrinsics.a(this.f32751b, leftIcon.f32751b) && Intrinsics.a(this.f32752c, leftIcon.f32752c) && Intrinsics.a(this.f32753d, leftIcon.f32753d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f32750a.hashCode() * 31;
        Image image = this.f32751b;
        int hashCode2 = (hashCode + (image == null ? 0 : image.hashCode())) * 31;
        Integer num = this.f32752c;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Lottie lottie = this.f32753d;
        return hashCode3 + (lottie != null ? lottie.hashCode() : 0);
    }

    public String toString() {
        LeftIconType leftIconType = this.f32750a;
        Image image = this.f32751b;
        Integer num = this.f32752c;
        Lottie lottie = this.f32753d;
        return "LeftIcon(type=" + leftIconType + ", leftIconImage=" + image + ", leftIconTint=" + num + ", leftIconLottie=" + lottie + ")";
    }
}
