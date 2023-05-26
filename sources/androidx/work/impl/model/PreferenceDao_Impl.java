package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final class PreferenceDao_Impl implements PreferenceDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f8592a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<Preference> f8593b;

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        this.f8592a = roomDatabase;
        this.f8593b = new EntityInsertionAdapter<Preference>(roomDatabase) { // from class: androidx.work.impl.model.PreferenceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
                String str = preference.f8590a;
                if (str == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, str);
                }
                Long l8 = preference.f8591b;
                if (l8 == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.B0(2, l8.longValue());
                }
            }
        };
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void a(Preference preference) {
        this.f8592a.d();
        this.f8592a.e();
        try {
            this.f8593b.i(preference);
            this.f8592a.E();
        } finally {
            this.f8592a.i();
        }
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public Long b(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8592a.d();
        Long l8 = null;
        Cursor c8 = DBUtil.c(this.f8592a, e8, false, null);
        try {
            if (c8.moveToFirst() && !c8.isNull(0)) {
                l8 = Long.valueOf(c8.getLong(0));
            }
            return l8;
        } finally {
            c8.close();
            e8.release();
        }
    }
}
