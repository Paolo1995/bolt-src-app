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
public final class WorkNameDao_Impl implements WorkNameDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f8604a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<WorkName> f8605b;

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        this.f8604a = roomDatabase;
        this.f8605b = new EntityInsertionAdapter<WorkName>(roomDatabase) { // from class: androidx.work.impl.model.WorkNameDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
                String str = workName.f8602a;
                if (str == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, str);
                }
                String str2 = workName.f8603b;
                if (str2 == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, str2);
                }
            }
        };
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public void a(WorkName workName) {
        this.f8604a.d();
        this.f8604a.e();
        try {
            this.f8605b.i(workName);
            this.f8604a.E();
        } finally {
            this.f8604a.i();
        }
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public List<String> b(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8604a.d();
        Cursor c8 = DBUtil.c(this.f8604a, e8, false, null);
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
}
