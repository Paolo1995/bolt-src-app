package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InlineList.kt */
/* loaded from: classes5.dex */
public final class InlineList<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i8 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e8) {
        if (obj == null) {
            return a(e8);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e8);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e8);
        return a(arrayList);
    }
}
