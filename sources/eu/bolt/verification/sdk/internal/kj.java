package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class kj {

    /* renamed from: a  reason: collision with root package name */
    private final String f43875a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f43876b;

    public kj(String storyId, boolean z7) {
        Intrinsics.f(storyId, "storyId");
        this.f43875a = storyId;
        this.f43876b = z7;
    }

    public /* synthetic */ kj(String str, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? true : z7);
    }

    public final boolean a() {
        return this.f43876b;
    }

    public final String b() {
        return this.f43875a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kj) {
            kj kjVar = (kj) obj;
            return Intrinsics.a(this.f43875a, kjVar.f43875a) && this.f43876b == kjVar.f43876b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f43875a.hashCode() * 31;
        boolean z7 = this.f43876b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f43875a;
        boolean z7 = this.f43876b;
        return "StoryRibArgs(storyId=" + str + ", shouldAdjustWindow=" + z7 + ")";
    }
}
