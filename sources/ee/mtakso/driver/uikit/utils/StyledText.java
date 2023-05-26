package ee.mtakso.driver.uikit.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StyledText.kt */
/* loaded from: classes5.dex */
public final class StyledText {

    /* renamed from: a  reason: collision with root package name */
    private final Text f36060a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f36061b;

    /* renamed from: c  reason: collision with root package name */
    private final Color f36062c;

    public StyledText(Text text, Integer num, Color color) {
        Intrinsics.f(text, "text");
        this.f36060a = text;
        this.f36061b = num;
        this.f36062c = color;
    }

    public final Text a() {
        return this.f36060a;
    }

    public final Integer b() {
        return this.f36061b;
    }

    public final Color c() {
        return this.f36062c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StyledText) {
            StyledText styledText = (StyledText) obj;
            return Intrinsics.a(this.f36060a, styledText.f36060a) && Intrinsics.a(this.f36061b, styledText.f36061b) && Intrinsics.a(this.f36062c, styledText.f36062c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f36060a.hashCode() * 31;
        Integer num = this.f36061b;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Color color = this.f36062c;
        return hashCode2 + (color != null ? color.hashCode() : 0);
    }

    public String toString() {
        Text text = this.f36060a;
        Integer num = this.f36061b;
        Color color = this.f36062c;
        return "StyledText(text=" + text + ", textAppearance=" + num + ", textColor=" + color + ")";
    }

    public /* synthetic */ StyledText(Text text, Integer num, Color color, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(text, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? null : color);
    }
}
