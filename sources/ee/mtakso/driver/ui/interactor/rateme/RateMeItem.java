package ee.mtakso.driver.ui.interactor.rateme;

import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeItem.kt */
/* loaded from: classes3.dex */
public final class RateMeItem {

    /* renamed from: a  reason: collision with root package name */
    private final String f26840a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f26841b;

    public RateMeItem(String eventId, Text name) {
        Intrinsics.f(eventId, "eventId");
        Intrinsics.f(name, "name");
        this.f26840a = eventId;
        this.f26841b = name;
    }

    public final String a() {
        return this.f26840a;
    }

    public final Text b() {
        return this.f26841b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RateMeItem) {
            RateMeItem rateMeItem = (RateMeItem) obj;
            return Intrinsics.a(this.f26840a, rateMeItem.f26840a) && Intrinsics.a(this.f26841b, rateMeItem.f26841b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f26840a.hashCode() * 31) + this.f26841b.hashCode();
    }

    public String toString() {
        String str = this.f26840a;
        Text text = this.f26841b;
        return "RateMeItem(eventId=" + str + ", name=" + text + ")";
    }
}
