package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Quirks {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final List<Quirk> f3670a;

    public Quirks(@NonNull List<Quirk> list) {
        this.f3670a = new ArrayList(list);
    }

    public boolean a(@NonNull Class<? extends Quirk> cls) {
        for (Quirk quirk : this.f3670a) {
            if (cls.isAssignableFrom(quirk.getClass())) {
                return true;
            }
        }
        return false;
    }

    public <T extends Quirk> T b(@NonNull Class<T> cls) {
        Iterator<Quirk> it = this.f3670a.iterator();
        while (it.hasNext()) {
            T t7 = (T) it.next();
            if (t7.getClass() == cls) {
                return t7;
            }
        }
        return null;
    }
}
