package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class DatabaseConfiguration {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f7443a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Context f7444b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7445c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RoomDatabase.MigrationContainer f7446d;

    /* renamed from: e  reason: collision with root package name */
    public final List<RoomDatabase.Callback> f7447e;

    /* renamed from: f  reason: collision with root package name */
    public final RoomDatabase.PrepackagedDatabaseCallback f7448f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final List<Object> f7449g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final List<AutoMigrationSpec> f7450h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f7451i;

    /* renamed from: j  reason: collision with root package name */
    public final RoomDatabase.JournalMode f7452j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final Executor f7453k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final Executor f7454l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f7455m;

    /* renamed from: n  reason: collision with root package name */
    public final Intent f7456n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f7457o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f7458p;

    /* renamed from: q  reason: collision with root package name */
    private final Set<Integer> f7459q;

    /* renamed from: r  reason: collision with root package name */
    public final String f7460r;

    /* renamed from: s  reason: collision with root package name */
    public final File f7461s;

    /* renamed from: t  reason: collision with root package name */
    public final Callable<InputStream> f7462t;

    @SuppressLint({"LambdaLast"})
    public DatabaseConfiguration(@NonNull Context context, String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> list, boolean z7, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, Intent intent, boolean z8, boolean z9, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<Object> list2, List<AutoMigrationSpec> list3) {
        this.f7443a = factory;
        this.f7444b = context;
        this.f7445c = str;
        this.f7446d = migrationContainer;
        this.f7447e = list;
        this.f7451i = z7;
        this.f7452j = journalMode;
        this.f7453k = executor;
        this.f7454l = executor2;
        this.f7456n = intent;
        this.f7455m = intent != null;
        this.f7457o = z8;
        this.f7458p = z9;
        this.f7459q = set;
        this.f7460r = str2;
        this.f7461s = file;
        this.f7462t = callable;
        this.f7448f = prepackagedDatabaseCallback;
        this.f7449g = list2 == null ? Collections.emptyList() : list2;
        this.f7450h = list3 == null ? Collections.emptyList() : list3;
    }

    public boolean a(int i8, int i9) {
        boolean z7;
        Set<Integer> set;
        if (i8 > i9) {
            z7 = true;
        } else {
            z7 = false;
        }
        if ((!z7 || !this.f7458p) && this.f7457o && ((set = this.f7459q) == null || !set.contains(Integer.valueOf(i8)))) {
            return true;
        }
        return false;
    }
}
