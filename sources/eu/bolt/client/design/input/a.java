package eu.bolt.client.design.input;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Date f40099a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f40100b;

    public a(Date date, boolean z7) {
        Intrinsics.f(date, "date");
        this.f40099a = date;
        this.f40100b = z7;
    }

    public final Date a() {
        return this.f40099a;
    }

    public final boolean b() {
        return this.f40100b;
    }
}
