package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class SpreadBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Object> f51020a;

    public SpreadBuilder(int i8) {
        this.f51020a = new ArrayList<>(i8);
    }

    public void a(Object obj) {
        this.f51020a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f51020a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f51020a, objArr);
            }
        } else if (obj instanceof Collection) {
            this.f51020a.addAll((Collection) obj);
        } else if (obj instanceof Iterable) {
            for (Object obj2 : (Iterable) obj) {
                this.f51020a.add(obj2);
            }
        } else if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                this.f51020a.add(it.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f51020a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f51020a.toArray(objArr);
    }
}
