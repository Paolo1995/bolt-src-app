package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class z6 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f45820f;

    /* renamed from: g  reason: collision with root package name */
    private final Serializable f45821g;

    public z6(String tag, Serializable serializable) {
        Intrinsics.f(tag, "tag");
        this.f45820f = tag;
        this.f45821g = serializable;
    }

    public /* synthetic */ z6(String str, Serializable serializable, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? null : serializable);
    }

    public final String a() {
        return this.f45820f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z6) {
            z6 z6Var = (z6) obj;
            return Intrinsics.a(this.f45820f, z6Var.f45820f) && Intrinsics.a(this.f45821g, z6Var.f45821g);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f45820f.hashCode() * 31;
        Serializable serializable = this.f45821g;
        return hashCode + (serializable == null ? 0 : serializable.hashCode());
    }

    public String toString() {
        String str = this.f45820f;
        Serializable serializable = this.f45821g;
        return "ErrorRibTag(tag=" + str + ", payload=" + serializable + ")";
    }
}
