package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void g(SupportSQLiteStatement supportSQLiteStatement, T t7);

    public final int h(Iterable<? extends T> iterable) {
        SupportSQLiteStatement a8 = a();
        int i8 = 0;
        try {
            for (T t7 : iterable) {
                g(a8, t7);
                i8 += a8.x();
            }
            return i8;
        } finally {
            f(a8);
        }
    }
}
