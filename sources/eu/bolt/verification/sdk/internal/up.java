package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.nh;
import eu.bolt.verification.sdk.internal.ro;
import eu.bolt.verification.sdk.internal.yp;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class up {

    /* renamed from: a  reason: collision with root package name */
    private final po f45401a;

    /* renamed from: b  reason: collision with root package name */
    private final no f45402b;

    /* renamed from: c  reason: collision with root package name */
    private final de f45403c;

    /* renamed from: d  reason: collision with root package name */
    private final gq f45404d;

    @Inject
    public up(po layoutElementMapper, no layoutAlignmentMapper, de textAlignmentCalculator, gq textAlignmentMapper) {
        Intrinsics.f(layoutElementMapper, "layoutElementMapper");
        Intrinsics.f(layoutAlignmentMapper, "layoutAlignmentMapper");
        Intrinsics.f(textAlignmentCalculator, "textAlignmentCalculator");
        Intrinsics.f(textAlignmentMapper, "textAlignmentMapper");
        this.f45401a = layoutElementMapper;
        this.f45402b = layoutAlignmentMapper;
        this.f45403c = textAlignmentCalculator;
        this.f45404d = textAlignmentMapper;
    }

    public final nh.b a(yp.b from) {
        int v7;
        int v8;
        ob a8;
        Intrinsics.f(from, "from");
        fl a9 = this.f45404d.a(from.e());
        nh.b.a a10 = this.f45402b.a(from.g().a());
        List<ro> c8 = from.g().c();
        v7 = CollectionsKt__IterablesKt.v(c8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (ro roVar : c8) {
            if (roVar instanceof ro.g) {
                ob a11 = this.f45401a.a(roVar);
                Intrinsics.d(a11, "null cannot be cast to non-null type eu.bolt.verification.core.domain.model.layoutelements.Paragraph");
                be beVar = (be) a11;
                a8 = be.b(beVar, null, null, null, this.f45403c.a(beVar.f(), a9, a10), null, null, 55, null);
            } else {
                a8 = this.f45401a.a(roVar);
            }
            arrayList.add(a8);
        }
        List<ro> b8 = from.g().b();
        v8 = CollectionsKt__IterablesKt.v(b8, 10);
        ArrayList arrayList2 = new ArrayList(v8);
        for (ro roVar2 : b8) {
            arrayList2.add(this.f45401a.a(roVar2));
        }
        return new nh.b(a10, arrayList, arrayList2);
    }
}
