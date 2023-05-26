package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;

/* loaded from: classes.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f8609a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<WorkProgress> f8610b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f8611c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f8612d;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        this.f8609a = roomDatabase;
        this.f8610b = new EntityInsertionAdapter<WorkProgress>(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, WorkProgress workProgress) {
                String str = workProgress.f8607a;
                if (str == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, str);
                }
                byte[] k8 = Data.k(workProgress.f8608b);
                if (k8 == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.F0(2, k8);
                }
            }
        };
        this.f8611c = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.f8612d = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void a() {
        this.f8609a.d();
        SupportSQLiteStatement a8 = this.f8612d.a();
        this.f8609a.e();
        try {
            a8.x();
            this.f8609a.E();
        } finally {
            this.f8609a.i();
            this.f8612d.f(a8);
        }
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void b(String str) {
        this.f8609a.d();
        SupportSQLiteStatement a8 = this.f8611c.a();
        if (str == null) {
            a8.Q0(1);
        } else {
            a8.q0(1, str);
        }
        this.f8609a.e();
        try {
            a8.x();
            this.f8609a.E();
        } finally {
            this.f8609a.i();
            this.f8611c.f(a8);
        }
    }
}
