package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f8597a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<SystemIdInfo> f8598b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f8599c;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        this.f8597a = roomDatabase;
        this.f8598b = new EntityInsertionAdapter<SystemIdInfo>(roomDatabase) { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
                String str = systemIdInfo.f8595a;
                if (str == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, str);
                }
                supportSQLiteStatement.B0(2, systemIdInfo.f8596b);
            }
        };
        this.f8599c = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo a(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8597a.d();
        SystemIdInfo systemIdInfo = null;
        Cursor c8 = DBUtil.c(this.f8597a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "work_spec_id");
            int e10 = CursorUtil.e(c8, "system_id");
            if (c8.moveToFirst()) {
                systemIdInfo = new SystemIdInfo(c8.getString(e9), c8.getInt(e10));
            }
            return systemIdInfo;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public List<String> b() {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f8597a.d();
        Cursor c8 = DBUtil.c(this.f8597a, e8, false, null);
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

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void c(SystemIdInfo systemIdInfo) {
        this.f8597a.d();
        this.f8597a.e();
        try {
            this.f8598b.i(systemIdInfo);
            this.f8597a.E();
        } finally {
            this.f8597a.i();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void d(String str) {
        this.f8597a.d();
        SupportSQLiteStatement a8 = this.f8599c.a();
        if (str == null) {
            a8.Q0(1);
        } else {
            a8.q0(1, str);
        }
        this.f8597a.e();
        try {
            a8.x();
            this.f8597a.E();
        } finally {
            this.f8597a.i();
            this.f8599c.f(a8);
        }
    }
}
