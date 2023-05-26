package j$.util.stream;

import java.util.Collections;
import java.util.EnumSet;

/* renamed from: j$.util.stream.n  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0218n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f50620a = 0;

    static {
        EnumC0202j enumC0202j = EnumC0202j.CONCURRENT;
        EnumC0202j enumC0202j2 = EnumC0202j.UNORDERED;
        EnumC0202j enumC0202j3 = EnumC0202j.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(enumC0202j, enumC0202j2, enumC0202j3));
        Collections.unmodifiableSet(EnumSet.of(enumC0202j, enumC0202j2));
        Collections.unmodifiableSet(EnumSet.of(enumC0202j3));
        Collections.unmodifiableSet(EnumSet.of(enumC0202j2, enumC0202j3));
        Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(double[] dArr, double d8) {
        double d9 = d8 - dArr[1];
        double d10 = dArr[0];
        double d11 = d10 + d9;
        dArr[1] = (d11 - d10) - d9;
        dArr[0] = d11;
    }
}
