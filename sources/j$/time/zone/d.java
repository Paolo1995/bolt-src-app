package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class d implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f50130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ArrayList arrayList) {
        this.f50130a = arrayList;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property == null) {
            f.e(new e());
            return null;
        }
        try {
            f fVar = (f) f.class.cast(Class.forName(property, true, f.class.getClassLoader()).newInstance());
            f.e(fVar);
            this.f50130a.add(fVar);
            return null;
        } catch (Exception e8) {
            throw new Error(e8);
        }
    }
}
