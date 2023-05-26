package eu.bolt.verification.sdk.internal;

import eu.bolt.client.network.model.common.RGBAColorResponse;
import eu.bolt.verification.sdk.internal.jk;
import eu.bolt.verification.sdk.internal.sj;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* loaded from: classes5.dex */
public final class dj {

    /* renamed from: a  reason: collision with root package name */
    private final vj f42651a;

    /* renamed from: b  reason: collision with root package name */
    private final si f42652b;

    /* renamed from: c  reason: collision with root package name */
    private final ek f42653c;

    @Inject
    public dj(vj storySlideAssetMapper, si storyButtonStyleMapper, ek storySlideContentMapper) {
        Intrinsics.f(storySlideAssetMapper, "storySlideAssetMapper");
        Intrinsics.f(storyButtonStyleMapper, "storyButtonStyleMapper");
        Intrinsics.f(storySlideContentMapper, "storySlideContentMapper");
        this.f42651a = storySlideAssetMapper;
        this.f42652b = storyButtonStyleMapper;
        this.f42653c = storySlideContentMapper;
    }

    private final sj.a b(jk jkVar) {
        String g8 = jkVar.g();
        int a8 = jkVar.b().a();
        jk.f j8 = jkVar.j();
        yj d8 = j8 != null ? d(j8) : null;
        Long a9 = jkVar.a();
        String f8 = jkVar.f();
        ek ekVar = this.f42653c;
        jk.b c8 = jkVar.c();
        if (c8 != null) {
            return new sj.a(g8, a8, d8, a9, f8, ekVar.b(c8));
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final ui c(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3321850) {
                if (hashCode != 94756344) {
                    if (hashCode == 109400031 && str.equals("share")) {
                        return ui.SHARE;
                    }
                } else if (str.equals("close")) {
                    return ui.CLOSE;
                }
            } else if (str.equals("link")) {
                return ui.LINK;
            }
        }
        t3.c("Unknown button type in story slide: " + str, null, 2, null);
        return null;
    }

    private final yj d(jk.f fVar) {
        ui c8 = c(fVar.d());
        if (c8 != null) {
            String b8 = fVar.b();
            String a8 = fVar.a();
            jk.a c9 = fVar.c();
            String b9 = c9 != null ? c9.b() : null;
            jk.a c10 = fVar.c();
            return new yj(b8, a8, b9, c10 != null ? c10.a() : null, c8, this.f42652b.a(fVar.e()));
        }
        return null;
    }

    private final sj.c e(jk jkVar) {
        String g8 = jkVar.g();
        int a8 = jkVar.b().a();
        RGBAColorResponse k8 = jkVar.k();
        Integer valueOf = k8 != null ? Integer.valueOf(k8.a()) : null;
        jk.f j8 = jkVar.j();
        yj d8 = j8 != null ? d(j8) : null;
        Long a9 = jkVar.a();
        String l8 = jkVar.l();
        String m8 = jkVar.m();
        String d9 = jkVar.d();
        String e8 = jkVar.e();
        jk.e i8 = jkVar.i();
        return new sj.c(g8, a8, valueOf, d8, a9, l8, m8, d9, e8, i8 != null ? this.f42651a.a(i8) : null);
    }

    private final sj f(jk jkVar) {
        String h8 = jkVar.h();
        if (Intrinsics.a(h8, "top_left_content")) {
            return e(jkVar);
        }
        if (Intrinsics.a(h8, "top_array_content_with_footer")) {
            return b(jkVar);
        }
        Timber.Forest forest = Timber.f53064a;
        String h9 = jkVar.h();
        forest.m("Unknown layout type in story slide: " + h9, new Object[0]);
        return null;
    }

    public final ki a(jj from) {
        Intrinsics.f(from, "from");
        String a8 = from.a();
        List<jk> b8 = from.b();
        ArrayList arrayList = new ArrayList();
        for (jk jkVar : b8) {
            sj f8 = f(jkVar);
            if (f8 != null) {
                arrayList.add(f8);
            }
        }
        return new ki(a8, arrayList);
    }
}
