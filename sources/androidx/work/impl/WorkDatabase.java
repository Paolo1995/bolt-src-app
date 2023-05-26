package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {

    /* renamed from: o  reason: collision with root package name */
    private static final long f8373o = TimeUnit.DAYS.toMillis(1);

    @NonNull
    public static WorkDatabase G(@NonNull final Context context, @NonNull Executor executor, boolean z7) {
        RoomDatabase.Builder a8;
        if (z7) {
            a8 = Room.c(context, WorkDatabase.class).c();
        } else {
            a8 = Room.a(context, WorkDatabase.class, WorkDatabasePathHelper.d());
            a8.f(new SupportSQLiteOpenHelper.Factory() { // from class: androidx.work.impl.WorkDatabase.1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
                @NonNull
                public SupportSQLiteOpenHelper a(@NonNull SupportSQLiteOpenHelper.Configuration configuration) {
                    SupportSQLiteOpenHelper.Configuration.Builder a9 = SupportSQLiteOpenHelper.Configuration.a(context);
                    a9.c(configuration.f7741b).b(configuration.f7742c).d(true);
                    return new FrameworkSQLiteOpenHelperFactory().a(a9.a());
                }
            });
        }
        return (WorkDatabase) a8.g(executor).a(I()).b(WorkDatabaseMigrations.f8375a).b(new WorkDatabaseMigrations.RescheduleMigration(context, 2, 3)).b(WorkDatabaseMigrations.f8376b).b(WorkDatabaseMigrations.f8377c).b(new WorkDatabaseMigrations.RescheduleMigration(context, 5, 6)).b(WorkDatabaseMigrations.f8378d).b(WorkDatabaseMigrations.f8379e).b(WorkDatabaseMigrations.f8380f).b(new WorkDatabaseMigrations.WorkMigration9To10(context)).b(new WorkDatabaseMigrations.RescheduleMigration(context, 10, 11)).b(WorkDatabaseMigrations.f8381g).e().d();
    }

    static RoomDatabase.Callback I() {
        return new RoomDatabase.Callback() { // from class: androidx.work.impl.WorkDatabase.2
            @Override // androidx.room.RoomDatabase.Callback
            public void c(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                super.c(supportSQLiteDatabase);
                supportSQLiteDatabase.n();
                try {
                    supportSQLiteDatabase.u(WorkDatabase.K());
                    supportSQLiteDatabase.K();
                } finally {
                    supportSQLiteDatabase.S();
                }
            }
        };
    }

    static long J() {
        return System.currentTimeMillis() - f8373o;
    }

    @NonNull
    static String K() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + J() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    @NonNull
    public abstract DependencyDao H();

    @NonNull
    public abstract PreferenceDao L();

    @NonNull
    public abstract SystemIdInfoDao M();

    @NonNull
    public abstract WorkNameDao N();

    @NonNull
    public abstract WorkProgressDao O();

    @NonNull
    public abstract WorkSpecDao P();

    @NonNull
    public abstract WorkTagDao Q();
}
