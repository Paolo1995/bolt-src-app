package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.bk;
import eu.bolt.verification.sdk.internal.jk;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ck {

    /* renamed from: a  reason: collision with root package name */
    private final vj f42522a;

    @Inject
    public ck(vj storySlideAssetMapper) {
        Intrinsics.f(storySlideAssetMapper, "storySlideAssetMapper");
        this.f42522a = storySlideAssetMapper;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r3.equals("start") == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final eu.bolt.verification.sdk.internal.bk.a a(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            if (r0 == r1) goto L29
            r1 = 100571(0x188db, float:1.4093E-40)
            if (r0 == r1) goto L1d
            r1 = 109757538(0x68ac462, float:5.219839E-35)
            if (r0 == r1) goto L14
            goto L31
        L14:
            java.lang.String r0 = "start"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L47
            goto L31
        L1d:
            java.lang.String r0 = "end"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L26
            goto L31
        L26:
            eu.bolt.verification.sdk.internal.bk$a r3 = eu.bolt.verification.sdk.internal.bk.a.END
            goto L4c
        L29:
            java.lang.String r0 = "center"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L4a
        L31:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown align type in story content item: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r0 = 2
            r1 = 0
            eu.bolt.verification.sdk.internal.t3.c(r3, r1, r0, r1)
        L47:
            eu.bolt.verification.sdk.internal.bk$a r3 = eu.bolt.verification.sdk.internal.bk.a.START
            goto L4c
        L4a:
            eu.bolt.verification.sdk.internal.bk$a r3 = eu.bolt.verification.sdk.internal.bk.a.CENTER
        L4c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ck.a(java.lang.String):eu.bolt.verification.sdk.internal.bk$a");
    }

    public final bk.b b(jk.g from) {
        String str;
        jk.e eVar;
        StringBuilder sb;
        Intrinsics.f(from, "from");
        String e8 = from.e();
        bk.b bVar = null;
        if (Intrinsics.a(e8, "text")) {
            String c8 = from.c();
            String d8 = from.d();
            if (d8 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            String a8 = from.a();
            if (a8 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            bVar = new bk.b.C0037b(c8, d8, a(a8));
        } else {
            if (Intrinsics.a(e8, "asset")) {
                vj vjVar = this.f42522a;
                jk.e b8 = from.b();
                if (b8 == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                tj a9 = vjVar.a(b8);
                if (a9 == null) {
                    jk.e b9 = from.b();
                    str = "Unknown asset type in story item: ";
                    sb = new StringBuilder();
                    eVar = b9;
                } else {
                    String a10 = from.a();
                    if (a10 == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    bVar = new bk.b.a(a9, a(a10));
                }
            } else {
                str = "Unknown content type in story item: ";
                sb = new StringBuilder();
                eVar = from;
            }
            sb.append(str);
            sb.append(eVar);
            t3.c(sb.toString(), null, 2, null);
        }
        return bVar;
    }
}
