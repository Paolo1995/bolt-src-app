package eu.bolt.verification.sdk.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class di {

    /* renamed from: a  reason: collision with root package name */
    private final int f42649a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f42650b;

    public di(int i8, List<String> ids) {
        Intrinsics.f(ids, "ids");
        this.f42649a = i8;
        this.f42650b = ids;
    }

    public final List<String> a() {
        return this.f42650b;
    }

    public final int b() {
        return this.f42649a;
    }
}
