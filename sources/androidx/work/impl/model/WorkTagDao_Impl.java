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
public final class WorkTagDao_Impl implements WorkTagDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f8665a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<WorkTag> f8666b;

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        this.f8665a = roomDatabase;
        this.f8666b = new EntityInsertionAdapter<WorkTag>(roomDatabase) { // from class: androidx.work.impl.model.WorkTagDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
                String str = workTag.f8663a;
                if (str == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, str);
                }
                String str2 = workTag.f8664b;
                if (str2 == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, str2);
                }
            }
        };
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public List<String> a(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8665a.d();
        Cursor c8 = DBUtil.c(this.f8665a, e8, false, null);
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

    @Override // androidx.work.impl.model.WorkTagDao
    public void b(WorkTag workTag) {
        this.f8665a.d();
        this.f8665a.e();
        try {
            this.f8666b.i(workTag);
            this.f8665a.E();
        } finally {
            this.f8665a.i();
        }
    }
}
