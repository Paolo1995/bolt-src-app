package j$.util.stream;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class S2 {

    /* renamed from: a  reason: collision with root package name */
    final Map f50476a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S2(EnumMap enumMap) {
        this.f50476a = enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(T2 t22) {
        this.f50476a.put(t22, 1);
    }
}
