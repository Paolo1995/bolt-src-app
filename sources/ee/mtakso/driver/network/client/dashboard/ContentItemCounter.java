package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardContentItem.kt */
/* loaded from: classes3.dex */
public final class ContentItemCounter {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f21814a;
    @SerializedName("state")

    /* renamed from: b  reason: collision with root package name */
    private final CounterState f21815b;

    public final CounterState a() {
        return this.f21815b;
    }

    public final String b() {
        return this.f21814a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentItemCounter) {
            ContentItemCounter contentItemCounter = (ContentItemCounter) obj;
            return Intrinsics.a(this.f21814a, contentItemCounter.f21814a) && this.f21815b == contentItemCounter.f21815b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f21814a.hashCode() * 31) + this.f21815b.hashCode();
    }

    public String toString() {
        String str = this.f21814a;
        CounterState counterState = this.f21815b;
        return "ContentItemCounter(text=" + str + ", state=" + counterState + ")";
    }
}
