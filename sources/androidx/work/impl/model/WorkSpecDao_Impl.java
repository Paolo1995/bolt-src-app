package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f8644a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<WorkSpec> f8645b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f8646c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f8647d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f8648e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f8649f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f8650g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f8651h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedSQLiteStatement f8652i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedSQLiteStatement f8653j;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.f8644a = roomDatabase;
        this.f8645b = new EntityInsertionAdapter<WorkSpec>(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                String str = workSpec.f8618a;
                if (str == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, str);
                }
                supportSQLiteStatement.B0(2, WorkTypeConverters.j(workSpec.f8619b));
                String str2 = workSpec.f8620c;
                if (str2 == null) {
                    supportSQLiteStatement.Q0(3);
                } else {
                    supportSQLiteStatement.q0(3, str2);
                }
                String str3 = workSpec.f8621d;
                if (str3 == null) {
                    supportSQLiteStatement.Q0(4);
                } else {
                    supportSQLiteStatement.q0(4, str3);
                }
                byte[] k8 = Data.k(workSpec.f8622e);
                if (k8 == null) {
                    supportSQLiteStatement.Q0(5);
                } else {
                    supportSQLiteStatement.F0(5, k8);
                }
                byte[] k9 = Data.k(workSpec.f8623f);
                if (k9 == null) {
                    supportSQLiteStatement.Q0(6);
                } else {
                    supportSQLiteStatement.F0(6, k9);
                }
                supportSQLiteStatement.B0(7, workSpec.f8624g);
                supportSQLiteStatement.B0(8, workSpec.f8625h);
                supportSQLiteStatement.B0(9, workSpec.f8626i);
                supportSQLiteStatement.B0(10, workSpec.f8628k);
                supportSQLiteStatement.B0(11, WorkTypeConverters.a(workSpec.f8629l));
                supportSQLiteStatement.B0(12, workSpec.f8630m);
                supportSQLiteStatement.B0(13, workSpec.f8631n);
                supportSQLiteStatement.B0(14, workSpec.f8632o);
                supportSQLiteStatement.B0(15, workSpec.f8633p);
                supportSQLiteStatement.B0(16, workSpec.f8634q ? 1L : 0L);
                supportSQLiteStatement.B0(17, WorkTypeConverters.i(workSpec.f8635r));
                Constraints constraints = workSpec.f8627j;
                if (constraints != null) {
                    supportSQLiteStatement.B0(18, WorkTypeConverters.h(constraints.b()));
                    supportSQLiteStatement.B0(19, constraints.g() ? 1L : 0L);
                    supportSQLiteStatement.B0(20, constraints.h() ? 1L : 0L);
                    supportSQLiteStatement.B0(21, constraints.f() ? 1L : 0L);
                    supportSQLiteStatement.B0(22, constraints.i() ? 1L : 0L);
                    supportSQLiteStatement.B0(23, constraints.c());
                    supportSQLiteStatement.B0(24, constraints.d());
                    byte[] c8 = WorkTypeConverters.c(constraints.a());
                    if (c8 == null) {
                        supportSQLiteStatement.Q0(25);
                        return;
                    } else {
                        supportSQLiteStatement.F0(25, c8);
                        return;
                    }
                }
                supportSQLiteStatement.Q0(18);
                supportSQLiteStatement.Q0(19);
                supportSQLiteStatement.Q0(20);
                supportSQLiteStatement.Q0(21);
                supportSQLiteStatement.Q0(22);
                supportSQLiteStatement.Q0(23);
                supportSQLiteStatement.Q0(24);
                supportSQLiteStatement.Q0(25);
            }
        };
        this.f8646c = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.f8647d = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.f8648e = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.f8649f = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.f8650g = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.f8651h = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.f8652i = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.f8653j = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int a(WorkInfo.State state, String... strArr) {
        this.f8644a.d();
        StringBuilder b8 = StringUtil.b();
        b8.append("UPDATE workspec SET state=");
        b8.append("?");
        b8.append(" WHERE id IN (");
        StringUtil.a(b8, strArr.length);
        b8.append(")");
        SupportSQLiteStatement f8 = this.f8644a.f(b8.toString());
        f8.B0(1, WorkTypeConverters.j(state));
        int i8 = 2;
        for (String str : strArr) {
            if (str == null) {
                f8.Q0(i8);
            } else {
                f8.q0(i8, str);
            }
            i8++;
        }
        this.f8644a.e();
        try {
            int x7 = f8.x();
            this.f8644a.E();
            return x7;
        } finally {
            this.f8644a.i();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void b(String str) {
        this.f8644a.d();
        SupportSQLiteStatement a8 = this.f8646c.a();
        if (str == null) {
            a8.Q0(1);
        } else {
            a8.q0(1, str);
        }
        this.f8644a.e();
        try {
            a8.x();
            this.f8644a.E();
        } finally {
            this.f8644a.i();
            this.f8646c.f(a8);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> c(long j8) {
        RoomSQLiteQuery roomSQLiteQuery;
        int e8;
        int e9;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        RoomSQLiteQuery e22 = RoomSQLiteQuery.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        e22.B0(1, j8);
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e22, false, null);
        try {
            e8 = CursorUtil.e(c8, "required_network_type");
            e9 = CursorUtil.e(c8, "requires_charging");
            e10 = CursorUtil.e(c8, "requires_device_idle");
            e11 = CursorUtil.e(c8, "requires_battery_not_low");
            e12 = CursorUtil.e(c8, "requires_storage_not_low");
            e13 = CursorUtil.e(c8, "trigger_content_update_delay");
            e14 = CursorUtil.e(c8, "trigger_max_content_delay");
            e15 = CursorUtil.e(c8, "content_uri_triggers");
            e16 = CursorUtil.e(c8, Name.MARK);
            e17 = CursorUtil.e(c8, "state");
            e18 = CursorUtil.e(c8, "worker_class_name");
            e19 = CursorUtil.e(c8, "input_merger_class_name");
            e20 = CursorUtil.e(c8, "input");
            e21 = CursorUtil.e(c8, "output");
            roomSQLiteQuery = e22;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = e22;
        }
        try {
            int e23 = CursorUtil.e(c8, "initial_delay");
            int e24 = CursorUtil.e(c8, "interval_duration");
            int e25 = CursorUtil.e(c8, "flex_duration");
            int e26 = CursorUtil.e(c8, "run_attempt_count");
            int e27 = CursorUtil.e(c8, "backoff_policy");
            int e28 = CursorUtil.e(c8, "backoff_delay_duration");
            int e29 = CursorUtil.e(c8, "period_start_time");
            int e30 = CursorUtil.e(c8, "minimum_retention_duration");
            int e31 = CursorUtil.e(c8, "schedule_requested_at");
            int e32 = CursorUtil.e(c8, "run_in_foreground");
            int e33 = CursorUtil.e(c8, "out_of_quota_policy");
            int i8 = e21;
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                String string = c8.getString(e16);
                int i9 = e16;
                String string2 = c8.getString(e18);
                int i10 = e18;
                Constraints constraints = new Constraints();
                int i11 = e8;
                constraints.k(WorkTypeConverters.e(c8.getInt(e8)));
                if (c8.getInt(e9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                constraints.m(z7);
                if (c8.getInt(e10) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                constraints.n(z8);
                if (c8.getInt(e11) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                constraints.l(z9);
                if (c8.getInt(e12) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                constraints.o(z10);
                int i12 = e9;
                int i13 = e10;
                constraints.p(c8.getLong(e13));
                constraints.q(c8.getLong(e14));
                constraints.j(WorkTypeConverters.b(c8.getBlob(e15)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.f8619b = WorkTypeConverters.g(c8.getInt(e17));
                workSpec.f8621d = c8.getString(e19);
                workSpec.f8622e = Data.g(c8.getBlob(e20));
                int i14 = i8;
                workSpec.f8623f = Data.g(c8.getBlob(i14));
                int i15 = e23;
                i8 = i14;
                workSpec.f8624g = c8.getLong(i15);
                int i16 = e19;
                int i17 = e24;
                workSpec.f8625h = c8.getLong(i17);
                int i18 = e11;
                int i19 = e25;
                workSpec.f8626i = c8.getLong(i19);
                int i20 = e26;
                workSpec.f8628k = c8.getInt(i20);
                int i21 = e27;
                workSpec.f8629l = WorkTypeConverters.d(c8.getInt(i21));
                e25 = i19;
                int i22 = e28;
                workSpec.f8630m = c8.getLong(i22);
                int i23 = e29;
                workSpec.f8631n = c8.getLong(i23);
                e29 = i23;
                int i24 = e30;
                workSpec.f8632o = c8.getLong(i24);
                int i25 = e31;
                workSpec.f8633p = c8.getLong(i25);
                int i26 = e32;
                if (c8.getInt(i26) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                workSpec.f8634q = z11;
                int i27 = e33;
                workSpec.f8635r = WorkTypeConverters.f(c8.getInt(i27));
                workSpec.f8627j = constraints;
                arrayList.add(workSpec);
                e9 = i12;
                e33 = i27;
                e19 = i16;
                e23 = i15;
                e24 = i17;
                e26 = i20;
                e31 = i25;
                e16 = i9;
                e18 = i10;
                e8 = i11;
                e32 = i26;
                e30 = i24;
                e10 = i13;
                e28 = i22;
                e11 = i18;
                e27 = i21;
            }
            c8.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            c8.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void d(WorkSpec workSpec) {
        this.f8644a.d();
        this.f8644a.e();
        try {
            this.f8645b.i(workSpec);
            this.f8644a.E();
        } finally {
            this.f8644a.i();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> e() {
        RoomSQLiteQuery roomSQLiteQuery;
        int e8;
        int e9;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        RoomSQLiteQuery e22 = RoomSQLiteQuery.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e22, false, null);
        try {
            e8 = CursorUtil.e(c8, "required_network_type");
            e9 = CursorUtil.e(c8, "requires_charging");
            e10 = CursorUtil.e(c8, "requires_device_idle");
            e11 = CursorUtil.e(c8, "requires_battery_not_low");
            e12 = CursorUtil.e(c8, "requires_storage_not_low");
            e13 = CursorUtil.e(c8, "trigger_content_update_delay");
            e14 = CursorUtil.e(c8, "trigger_max_content_delay");
            e15 = CursorUtil.e(c8, "content_uri_triggers");
            e16 = CursorUtil.e(c8, Name.MARK);
            e17 = CursorUtil.e(c8, "state");
            e18 = CursorUtil.e(c8, "worker_class_name");
            e19 = CursorUtil.e(c8, "input_merger_class_name");
            e20 = CursorUtil.e(c8, "input");
            e21 = CursorUtil.e(c8, "output");
            roomSQLiteQuery = e22;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = e22;
        }
        try {
            int e23 = CursorUtil.e(c8, "initial_delay");
            int e24 = CursorUtil.e(c8, "interval_duration");
            int e25 = CursorUtil.e(c8, "flex_duration");
            int e26 = CursorUtil.e(c8, "run_attempt_count");
            int e27 = CursorUtil.e(c8, "backoff_policy");
            int e28 = CursorUtil.e(c8, "backoff_delay_duration");
            int e29 = CursorUtil.e(c8, "period_start_time");
            int e30 = CursorUtil.e(c8, "minimum_retention_duration");
            int e31 = CursorUtil.e(c8, "schedule_requested_at");
            int e32 = CursorUtil.e(c8, "run_in_foreground");
            int e33 = CursorUtil.e(c8, "out_of_quota_policy");
            int i8 = e21;
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                String string = c8.getString(e16);
                int i9 = e16;
                String string2 = c8.getString(e18);
                int i10 = e18;
                Constraints constraints = new Constraints();
                int i11 = e8;
                constraints.k(WorkTypeConverters.e(c8.getInt(e8)));
                if (c8.getInt(e9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                constraints.m(z7);
                if (c8.getInt(e10) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                constraints.n(z8);
                if (c8.getInt(e11) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                constraints.l(z9);
                if (c8.getInt(e12) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                constraints.o(z10);
                int i12 = e9;
                int i13 = e10;
                constraints.p(c8.getLong(e13));
                constraints.q(c8.getLong(e14));
                constraints.j(WorkTypeConverters.b(c8.getBlob(e15)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.f8619b = WorkTypeConverters.g(c8.getInt(e17));
                workSpec.f8621d = c8.getString(e19);
                workSpec.f8622e = Data.g(c8.getBlob(e20));
                int i14 = i8;
                workSpec.f8623f = Data.g(c8.getBlob(i14));
                i8 = i14;
                int i15 = e23;
                workSpec.f8624g = c8.getLong(i15);
                int i16 = e20;
                int i17 = e24;
                workSpec.f8625h = c8.getLong(i17);
                int i18 = e11;
                int i19 = e25;
                workSpec.f8626i = c8.getLong(i19);
                int i20 = e26;
                workSpec.f8628k = c8.getInt(i20);
                int i21 = e27;
                workSpec.f8629l = WorkTypeConverters.d(c8.getInt(i21));
                e25 = i19;
                int i22 = e28;
                workSpec.f8630m = c8.getLong(i22);
                int i23 = e29;
                workSpec.f8631n = c8.getLong(i23);
                e29 = i23;
                int i24 = e30;
                workSpec.f8632o = c8.getLong(i24);
                int i25 = e31;
                workSpec.f8633p = c8.getLong(i25);
                int i26 = e32;
                if (c8.getInt(i26) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                workSpec.f8634q = z11;
                int i27 = e33;
                workSpec.f8635r = WorkTypeConverters.f(c8.getInt(i27));
                workSpec.f8627j = constraints;
                arrayList.add(workSpec);
                e33 = i27;
                e9 = i12;
                e20 = i16;
                e23 = i15;
                e24 = i17;
                e26 = i20;
                e31 = i25;
                e16 = i9;
                e18 = i10;
                e8 = i11;
                e32 = i26;
                e30 = i24;
                e10 = i13;
                e28 = i22;
                e11 = i18;
                e27 = i21;
            }
            c8.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            c8.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> f(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e8, false, null);
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

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State g(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8644a.d();
        WorkInfo.State state = null;
        Cursor c8 = DBUtil.c(this.f8644a, e8, false, null);
        try {
            if (c8.moveToFirst()) {
                state = WorkTypeConverters.g(c8.getInt(0));
            }
            return state;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec h(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int e8;
        int e9;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        WorkSpec workSpec;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        RoomSQLiteQuery e22 = RoomSQLiteQuery.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            e22.Q0(1);
        } else {
            e22.q0(1, str);
        }
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e22, false, null);
        try {
            e8 = CursorUtil.e(c8, "required_network_type");
            e9 = CursorUtil.e(c8, "requires_charging");
            e10 = CursorUtil.e(c8, "requires_device_idle");
            e11 = CursorUtil.e(c8, "requires_battery_not_low");
            e12 = CursorUtil.e(c8, "requires_storage_not_low");
            e13 = CursorUtil.e(c8, "trigger_content_update_delay");
            e14 = CursorUtil.e(c8, "trigger_max_content_delay");
            e15 = CursorUtil.e(c8, "content_uri_triggers");
            e16 = CursorUtil.e(c8, Name.MARK);
            e17 = CursorUtil.e(c8, "state");
            e18 = CursorUtil.e(c8, "worker_class_name");
            e19 = CursorUtil.e(c8, "input_merger_class_name");
            e20 = CursorUtil.e(c8, "input");
            e21 = CursorUtil.e(c8, "output");
            roomSQLiteQuery = e22;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = e22;
        }
        try {
            int e23 = CursorUtil.e(c8, "initial_delay");
            int e24 = CursorUtil.e(c8, "interval_duration");
            int e25 = CursorUtil.e(c8, "flex_duration");
            int e26 = CursorUtil.e(c8, "run_attempt_count");
            int e27 = CursorUtil.e(c8, "backoff_policy");
            int e28 = CursorUtil.e(c8, "backoff_delay_duration");
            int e29 = CursorUtil.e(c8, "period_start_time");
            int e30 = CursorUtil.e(c8, "minimum_retention_duration");
            int e31 = CursorUtil.e(c8, "schedule_requested_at");
            int e32 = CursorUtil.e(c8, "run_in_foreground");
            int e33 = CursorUtil.e(c8, "out_of_quota_policy");
            if (c8.moveToFirst()) {
                String string = c8.getString(e16);
                String string2 = c8.getString(e18);
                Constraints constraints = new Constraints();
                constraints.k(WorkTypeConverters.e(c8.getInt(e8)));
                if (c8.getInt(e9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                constraints.m(z7);
                if (c8.getInt(e10) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                constraints.n(z8);
                if (c8.getInt(e11) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                constraints.l(z9);
                if (c8.getInt(e12) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                constraints.o(z10);
                constraints.p(c8.getLong(e13));
                constraints.q(c8.getLong(e14));
                constraints.j(WorkTypeConverters.b(c8.getBlob(e15)));
                WorkSpec workSpec2 = new WorkSpec(string, string2);
                workSpec2.f8619b = WorkTypeConverters.g(c8.getInt(e17));
                workSpec2.f8621d = c8.getString(e19);
                workSpec2.f8622e = Data.g(c8.getBlob(e20));
                workSpec2.f8623f = Data.g(c8.getBlob(e21));
                workSpec2.f8624g = c8.getLong(e23);
                workSpec2.f8625h = c8.getLong(e24);
                workSpec2.f8626i = c8.getLong(e25);
                workSpec2.f8628k = c8.getInt(e26);
                workSpec2.f8629l = WorkTypeConverters.d(c8.getInt(e27));
                workSpec2.f8630m = c8.getLong(e28);
                workSpec2.f8631n = c8.getLong(e29);
                workSpec2.f8632o = c8.getLong(e30);
                workSpec2.f8633p = c8.getLong(e31);
                if (c8.getInt(e32) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                workSpec2.f8634q = z11;
                workSpec2.f8635r = WorkTypeConverters.f(c8.getInt(e33));
                workSpec2.f8627j = constraints;
                workSpec = workSpec2;
            } else {
                workSpec = null;
            }
            c8.close();
            roomSQLiteQuery.release();
            return workSpec;
        } catch (Throwable th2) {
            th = th2;
            c8.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> i(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e8, false, null);
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

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> j(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e8, false, null);
        try {
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                arrayList.add(Data.g(c8.getBlob(0)));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> k(int i8) {
        RoomSQLiteQuery roomSQLiteQuery;
        int e8;
        int e9;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        RoomSQLiteQuery e22 = RoomSQLiteQuery.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        e22.B0(1, i8);
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e22, false, null);
        try {
            e8 = CursorUtil.e(c8, "required_network_type");
            e9 = CursorUtil.e(c8, "requires_charging");
            e10 = CursorUtil.e(c8, "requires_device_idle");
            e11 = CursorUtil.e(c8, "requires_battery_not_low");
            e12 = CursorUtil.e(c8, "requires_storage_not_low");
            e13 = CursorUtil.e(c8, "trigger_content_update_delay");
            e14 = CursorUtil.e(c8, "trigger_max_content_delay");
            e15 = CursorUtil.e(c8, "content_uri_triggers");
            e16 = CursorUtil.e(c8, Name.MARK);
            e17 = CursorUtil.e(c8, "state");
            e18 = CursorUtil.e(c8, "worker_class_name");
            e19 = CursorUtil.e(c8, "input_merger_class_name");
            e20 = CursorUtil.e(c8, "input");
            e21 = CursorUtil.e(c8, "output");
            roomSQLiteQuery = e22;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = e22;
        }
        try {
            int e23 = CursorUtil.e(c8, "initial_delay");
            int e24 = CursorUtil.e(c8, "interval_duration");
            int e25 = CursorUtil.e(c8, "flex_duration");
            int e26 = CursorUtil.e(c8, "run_attempt_count");
            int e27 = CursorUtil.e(c8, "backoff_policy");
            int e28 = CursorUtil.e(c8, "backoff_delay_duration");
            int e29 = CursorUtil.e(c8, "period_start_time");
            int e30 = CursorUtil.e(c8, "minimum_retention_duration");
            int e31 = CursorUtil.e(c8, "schedule_requested_at");
            int e32 = CursorUtil.e(c8, "run_in_foreground");
            int e33 = CursorUtil.e(c8, "out_of_quota_policy");
            int i9 = e21;
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                String string = c8.getString(e16);
                int i10 = e16;
                String string2 = c8.getString(e18);
                int i11 = e18;
                Constraints constraints = new Constraints();
                int i12 = e8;
                constraints.k(WorkTypeConverters.e(c8.getInt(e8)));
                if (c8.getInt(e9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                constraints.m(z7);
                if (c8.getInt(e10) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                constraints.n(z8);
                if (c8.getInt(e11) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                constraints.l(z9);
                if (c8.getInt(e12) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                constraints.o(z10);
                int i13 = e9;
                int i14 = e10;
                constraints.p(c8.getLong(e13));
                constraints.q(c8.getLong(e14));
                constraints.j(WorkTypeConverters.b(c8.getBlob(e15)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.f8619b = WorkTypeConverters.g(c8.getInt(e17));
                workSpec.f8621d = c8.getString(e19);
                workSpec.f8622e = Data.g(c8.getBlob(e20));
                int i15 = i9;
                workSpec.f8623f = Data.g(c8.getBlob(i15));
                i9 = i15;
                int i16 = e23;
                workSpec.f8624g = c8.getLong(i16);
                int i17 = e19;
                int i18 = e24;
                workSpec.f8625h = c8.getLong(i18);
                int i19 = e11;
                int i20 = e25;
                workSpec.f8626i = c8.getLong(i20);
                int i21 = e26;
                workSpec.f8628k = c8.getInt(i21);
                int i22 = e27;
                workSpec.f8629l = WorkTypeConverters.d(c8.getInt(i22));
                e25 = i20;
                int i23 = e28;
                workSpec.f8630m = c8.getLong(i23);
                int i24 = e29;
                workSpec.f8631n = c8.getLong(i24);
                e29 = i24;
                int i25 = e30;
                workSpec.f8632o = c8.getLong(i25);
                int i26 = e31;
                workSpec.f8633p = c8.getLong(i26);
                int i27 = e32;
                if (c8.getInt(i27) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                workSpec.f8634q = z11;
                int i28 = e33;
                workSpec.f8635r = WorkTypeConverters.f(c8.getInt(i28));
                workSpec.f8627j = constraints;
                arrayList.add(workSpec);
                e33 = i28;
                e9 = i13;
                e19 = i17;
                e23 = i16;
                e24 = i18;
                e26 = i21;
                e31 = i26;
                e16 = i10;
                e18 = i11;
                e8 = i12;
                e32 = i27;
                e30 = i25;
                e10 = i14;
                e28 = i23;
                e11 = i19;
                e27 = i22;
            }
            c8.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            c8.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int l() {
        this.f8644a.d();
        SupportSQLiteStatement a8 = this.f8652i.a();
        this.f8644a.e();
        try {
            int x7 = a8.x();
            this.f8644a.E();
            return x7;
        } finally {
            this.f8644a.i();
            this.f8652i.f(a8);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int m(String str, long j8) {
        this.f8644a.d();
        SupportSQLiteStatement a8 = this.f8651h.a();
        a8.B0(1, j8);
        if (str == null) {
            a8.Q0(2);
        } else {
            a8.q0(2, str);
        }
        this.f8644a.e();
        try {
            int x7 = a8.x();
            this.f8644a.E();
            return x7;
        } finally {
            this.f8644a.i();
            this.f8651h.f(a8);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> n(String str) {
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, Name.MARK);
            int e10 = CursorUtil.e(c8, "state");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.f8636a = c8.getString(e9);
                idAndState.f8637b = WorkTypeConverters.g(c8.getInt(e10));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> o(int i8) {
        RoomSQLiteQuery roomSQLiteQuery;
        int e8;
        int e9;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        RoomSQLiteQuery e22 = RoomSQLiteQuery.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        e22.B0(1, i8);
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e22, false, null);
        try {
            e8 = CursorUtil.e(c8, "required_network_type");
            e9 = CursorUtil.e(c8, "requires_charging");
            e10 = CursorUtil.e(c8, "requires_device_idle");
            e11 = CursorUtil.e(c8, "requires_battery_not_low");
            e12 = CursorUtil.e(c8, "requires_storage_not_low");
            e13 = CursorUtil.e(c8, "trigger_content_update_delay");
            e14 = CursorUtil.e(c8, "trigger_max_content_delay");
            e15 = CursorUtil.e(c8, "content_uri_triggers");
            e16 = CursorUtil.e(c8, Name.MARK);
            e17 = CursorUtil.e(c8, "state");
            e18 = CursorUtil.e(c8, "worker_class_name");
            e19 = CursorUtil.e(c8, "input_merger_class_name");
            e20 = CursorUtil.e(c8, "input");
            e21 = CursorUtil.e(c8, "output");
            roomSQLiteQuery = e22;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = e22;
        }
        try {
            int e23 = CursorUtil.e(c8, "initial_delay");
            int e24 = CursorUtil.e(c8, "interval_duration");
            int e25 = CursorUtil.e(c8, "flex_duration");
            int e26 = CursorUtil.e(c8, "run_attempt_count");
            int e27 = CursorUtil.e(c8, "backoff_policy");
            int e28 = CursorUtil.e(c8, "backoff_delay_duration");
            int e29 = CursorUtil.e(c8, "period_start_time");
            int e30 = CursorUtil.e(c8, "minimum_retention_duration");
            int e31 = CursorUtil.e(c8, "schedule_requested_at");
            int e32 = CursorUtil.e(c8, "run_in_foreground");
            int e33 = CursorUtil.e(c8, "out_of_quota_policy");
            int i9 = e21;
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                String string = c8.getString(e16);
                int i10 = e16;
                String string2 = c8.getString(e18);
                int i11 = e18;
                Constraints constraints = new Constraints();
                int i12 = e8;
                constraints.k(WorkTypeConverters.e(c8.getInt(e8)));
                if (c8.getInt(e9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                constraints.m(z7);
                if (c8.getInt(e10) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                constraints.n(z8);
                if (c8.getInt(e11) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                constraints.l(z9);
                if (c8.getInt(e12) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                constraints.o(z10);
                int i13 = e9;
                int i14 = e10;
                constraints.p(c8.getLong(e13));
                constraints.q(c8.getLong(e14));
                constraints.j(WorkTypeConverters.b(c8.getBlob(e15)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.f8619b = WorkTypeConverters.g(c8.getInt(e17));
                workSpec.f8621d = c8.getString(e19);
                workSpec.f8622e = Data.g(c8.getBlob(e20));
                int i15 = i9;
                workSpec.f8623f = Data.g(c8.getBlob(i15));
                i9 = i15;
                int i16 = e23;
                workSpec.f8624g = c8.getLong(i16);
                int i17 = e19;
                int i18 = e24;
                workSpec.f8625h = c8.getLong(i18);
                int i19 = e11;
                int i20 = e25;
                workSpec.f8626i = c8.getLong(i20);
                int i21 = e26;
                workSpec.f8628k = c8.getInt(i21);
                int i22 = e27;
                workSpec.f8629l = WorkTypeConverters.d(c8.getInt(i22));
                e25 = i20;
                int i23 = e28;
                workSpec.f8630m = c8.getLong(i23);
                int i24 = e29;
                workSpec.f8631n = c8.getLong(i24);
                e29 = i24;
                int i25 = e30;
                workSpec.f8632o = c8.getLong(i25);
                int i26 = e31;
                workSpec.f8633p = c8.getLong(i26);
                int i27 = e32;
                if (c8.getInt(i27) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                workSpec.f8634q = z11;
                int i28 = e33;
                workSpec.f8635r = WorkTypeConverters.f(c8.getInt(i28));
                workSpec.f8627j = constraints;
                arrayList.add(workSpec);
                e33 = i28;
                e9 = i13;
                e19 = i17;
                e23 = i16;
                e24 = i18;
                e26 = i21;
                e31 = i26;
                e16 = i10;
                e18 = i11;
                e8 = i12;
                e32 = i27;
                e30 = i25;
                e10 = i14;
                e28 = i23;
                e11 = i19;
                e27 = i22;
            }
            c8.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            c8.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void p(String str, Data data) {
        this.f8644a.d();
        SupportSQLiteStatement a8 = this.f8647d.a();
        byte[] k8 = Data.k(data);
        if (k8 == null) {
            a8.Q0(1);
        } else {
            a8.F0(1, k8);
        }
        if (str == null) {
            a8.Q0(2);
        } else {
            a8.q0(2, str);
        }
        this.f8644a.e();
        try {
            a8.x();
            this.f8644a.E();
        } finally {
            this.f8644a.i();
            this.f8647d.f(a8);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> q() {
        RoomSQLiteQuery roomSQLiteQuery;
        int e8;
        int e9;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        RoomSQLiteQuery e22 = RoomSQLiteQuery.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e22, false, null);
        try {
            e8 = CursorUtil.e(c8, "required_network_type");
            e9 = CursorUtil.e(c8, "requires_charging");
            e10 = CursorUtil.e(c8, "requires_device_idle");
            e11 = CursorUtil.e(c8, "requires_battery_not_low");
            e12 = CursorUtil.e(c8, "requires_storage_not_low");
            e13 = CursorUtil.e(c8, "trigger_content_update_delay");
            e14 = CursorUtil.e(c8, "trigger_max_content_delay");
            e15 = CursorUtil.e(c8, "content_uri_triggers");
            e16 = CursorUtil.e(c8, Name.MARK);
            e17 = CursorUtil.e(c8, "state");
            e18 = CursorUtil.e(c8, "worker_class_name");
            e19 = CursorUtil.e(c8, "input_merger_class_name");
            e20 = CursorUtil.e(c8, "input");
            e21 = CursorUtil.e(c8, "output");
            roomSQLiteQuery = e22;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = e22;
        }
        try {
            int e23 = CursorUtil.e(c8, "initial_delay");
            int e24 = CursorUtil.e(c8, "interval_duration");
            int e25 = CursorUtil.e(c8, "flex_duration");
            int e26 = CursorUtil.e(c8, "run_attempt_count");
            int e27 = CursorUtil.e(c8, "backoff_policy");
            int e28 = CursorUtil.e(c8, "backoff_delay_duration");
            int e29 = CursorUtil.e(c8, "period_start_time");
            int e30 = CursorUtil.e(c8, "minimum_retention_duration");
            int e31 = CursorUtil.e(c8, "schedule_requested_at");
            int e32 = CursorUtil.e(c8, "run_in_foreground");
            int e33 = CursorUtil.e(c8, "out_of_quota_policy");
            int i8 = e21;
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                String string = c8.getString(e16);
                int i9 = e16;
                String string2 = c8.getString(e18);
                int i10 = e18;
                Constraints constraints = new Constraints();
                int i11 = e8;
                constraints.k(WorkTypeConverters.e(c8.getInt(e8)));
                if (c8.getInt(e9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                constraints.m(z7);
                if (c8.getInt(e10) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                constraints.n(z8);
                if (c8.getInt(e11) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                constraints.l(z9);
                if (c8.getInt(e12) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                constraints.o(z10);
                int i12 = e9;
                int i13 = e10;
                constraints.p(c8.getLong(e13));
                constraints.q(c8.getLong(e14));
                constraints.j(WorkTypeConverters.b(c8.getBlob(e15)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.f8619b = WorkTypeConverters.g(c8.getInt(e17));
                workSpec.f8621d = c8.getString(e19);
                workSpec.f8622e = Data.g(c8.getBlob(e20));
                int i14 = i8;
                workSpec.f8623f = Data.g(c8.getBlob(i14));
                i8 = i14;
                int i15 = e23;
                workSpec.f8624g = c8.getLong(i15);
                int i16 = e20;
                int i17 = e24;
                workSpec.f8625h = c8.getLong(i17);
                int i18 = e11;
                int i19 = e25;
                workSpec.f8626i = c8.getLong(i19);
                int i20 = e26;
                workSpec.f8628k = c8.getInt(i20);
                int i21 = e27;
                workSpec.f8629l = WorkTypeConverters.d(c8.getInt(i21));
                e25 = i19;
                int i22 = e28;
                workSpec.f8630m = c8.getLong(i22);
                int i23 = e29;
                workSpec.f8631n = c8.getLong(i23);
                e29 = i23;
                int i24 = e30;
                workSpec.f8632o = c8.getLong(i24);
                int i25 = e31;
                workSpec.f8633p = c8.getLong(i25);
                int i26 = e32;
                if (c8.getInt(i26) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                workSpec.f8634q = z11;
                int i27 = e33;
                workSpec.f8635r = WorkTypeConverters.f(c8.getInt(i27));
                workSpec.f8627j = constraints;
                arrayList.add(workSpec);
                e33 = i27;
                e9 = i12;
                e20 = i16;
                e23 = i15;
                e24 = i17;
                e26 = i20;
                e31 = i25;
                e16 = i9;
                e18 = i10;
                e8 = i11;
                e32 = i26;
                e30 = i24;
                e10 = i13;
                e28 = i22;
                e11 = i18;
                e27 = i21;
            }
            c8.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            c8.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public boolean r() {
        boolean z7 = false;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f8644a.d();
        Cursor c8 = DBUtil.c(this.f8644a, e8, false, null);
        try {
            if (c8.moveToFirst()) {
                if (c8.getInt(0) != 0) {
                    z7 = true;
                }
            }
            return z7;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int s(String str) {
        this.f8644a.d();
        SupportSQLiteStatement a8 = this.f8650g.a();
        if (str == null) {
            a8.Q0(1);
        } else {
            a8.q0(1, str);
        }
        this.f8644a.e();
        try {
            int x7 = a8.x();
            this.f8644a.E();
            return x7;
        } finally {
            this.f8644a.i();
            this.f8650g.f(a8);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int t(String str) {
        this.f8644a.d();
        SupportSQLiteStatement a8 = this.f8649f.a();
        if (str == null) {
            a8.Q0(1);
        } else {
            a8.q0(1, str);
        }
        this.f8644a.e();
        try {
            int x7 = a8.x();
            this.f8644a.E();
            return x7;
        } finally {
            this.f8644a.i();
            this.f8649f.f(a8);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void u(String str, long j8) {
        this.f8644a.d();
        SupportSQLiteStatement a8 = this.f8648e.a();
        a8.B0(1, j8);
        if (str == null) {
            a8.Q0(2);
        } else {
            a8.q0(2, str);
        }
        this.f8644a.e();
        try {
            a8.x();
            this.f8644a.E();
        } finally {
            this.f8644a.i();
            this.f8648e.f(a8);
        }
    }
}
