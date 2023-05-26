package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void g(SupportSQLiteStatement supportSQLiteStatement, T t7);

    public final void h(Iterable<? extends T> iterable) {
        SupportSQLiteStatement a8 = a();
        try {
            for (T t7 : iterable) {
                g(a8, t7);
                a8.m0();
            }
        } finally {
            f(a8);
        }
    }

    public final void i(T t7) {
        SupportSQLiteStatement a8 = a();
        try {
            g(a8, t7);
            a8.m0();
        } finally {
            f(a8);
        }
    }

    public final List<Long> j(Collection<? extends T> collection) {
        SupportSQLiteStatement a8 = a();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i8 = 0;
            for (T t7 : collection) {
                g(a8, t7);
                arrayList.add(i8, Long.valueOf(a8.m0()));
                i8++;
            }
            return arrayList;
        } finally {
            f(a8);
        }
    }
}
