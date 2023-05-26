package ee.mtakso.driver.ui.interactor.rateme;

import ee.mtakso.driver.uikit.utils.Text;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeItem.kt */
/* loaded from: classes3.dex */
public final class RateMeCategory {

    /* renamed from: a  reason: collision with root package name */
    private final String f26835a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26836b;

    /* renamed from: c  reason: collision with root package name */
    private final Text f26837c;

    /* renamed from: d  reason: collision with root package name */
    private final List<RateMeItem> f26838d;

    public RateMeCategory(String eventId, int i8, Text name, List<RateMeItem> items) {
        Intrinsics.f(eventId, "eventId");
        Intrinsics.f(name, "name");
        Intrinsics.f(items, "items");
        this.f26835a = eventId;
        this.f26836b = i8;
        this.f26837c = name;
        this.f26838d = items;
    }

    public final String a() {
        return this.f26835a;
    }

    public final int b() {
        return this.f26836b;
    }

    public final List<RateMeItem> c() {
        return this.f26838d;
    }

    public final Text d() {
        return this.f26837c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RateMeCategory) {
            RateMeCategory rateMeCategory = (RateMeCategory) obj;
            return Intrinsics.a(this.f26835a, rateMeCategory.f26835a) && this.f26836b == rateMeCategory.f26836b && Intrinsics.a(this.f26837c, rateMeCategory.f26837c) && Intrinsics.a(this.f26838d, rateMeCategory.f26838d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f26835a.hashCode() * 31) + this.f26836b) * 31) + this.f26837c.hashCode()) * 31) + this.f26838d.hashCode();
    }

    public String toString() {
        String str = this.f26835a;
        int i8 = this.f26836b;
        Text text = this.f26837c;
        List<RateMeItem> list = this.f26838d;
        return "RateMeCategory(eventId=" + str + ", icon=" + i8 + ", name=" + text + ", items=" + list + ")";
    }
}
