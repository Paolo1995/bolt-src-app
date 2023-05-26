package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class DependencyDao_Impl implements DependencyDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f8587a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<Dependency> f8588b;

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        this.f8587a = roomDatabase;
        this.f8588b = new EntityInsertionAdapter<Dependency>(roomDatabase) { // from class: androidx.work.impl.model.DependencyDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
                String str = dependency.f8585a;
                if (str == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, str);
                }
                String str2 = dependency.f8586b;
                if (str2 == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, str2);
                }
            }
        };
    }

    @Override // androidx.work.impl.model.DependencyDao
    public void a(Dependency dependency) {
        this.f8587a.d();
        this.f8587a.e();
        try {
            this.f8588b.i(dependency);
            this.f8587a.E();
        } finally {
            this.f8587a.i();
        }
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> b(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8587a.d();
        Cursor c8 = DBUtil.c(this.f8587a, e8, false, null);
        try {
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                arrayList.add(c8.getString(0));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean c(String str) {
        boolean z7 = true;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8587a.d();
        boolean z8 = false;
        Cursor c8 = DBUtil.c(this.f8587a, e8, false, null);
        try {
            if (c8.moveToFirst()) {
                if (c8.getInt(0) == 0) {
                    z7 = false;
                }
                z8 = z7;
            }
            return z8;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean d(String str) {
        boolean z7 = true;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8587a.d();
        boolean z8 = false;
        Cursor c8 = DBUtil.c(this.f8587a, e8, false, null);
        try {
            if (c8.moveToFirst()) {
                if (c8.getInt(0) == 0) {
                    z7 = false;
                }
                z8 = z7;
            }
            return z8;
        } finally {
            c8.close();
            e8.release();
        }
    }
}
