package com.clevertap.android.sdk.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.inbox.CTMessageDAO;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DBAdapter {

    /* renamed from: d  reason: collision with root package name */
    private static final String f11098d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f11099e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f11100f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f11101g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f11102h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f11103i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f11104j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f11105k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f11106l;

    /* renamed from: m  reason: collision with root package name */
    private static final String f11107m;

    /* renamed from: n  reason: collision with root package name */
    private static final String f11108n;

    /* renamed from: o  reason: collision with root package name */
    private static final String f11109o;

    /* renamed from: p  reason: collision with root package name */
    private static final String f11110p;

    /* renamed from: q  reason: collision with root package name */
    private static final String f11111q;

    /* renamed from: r  reason: collision with root package name */
    private static final String f11112r;

    /* renamed from: s  reason: collision with root package name */
    private static final String f11113s;

    /* renamed from: a  reason: collision with root package name */
    private CleverTapInstanceConfig f11114a;

    /* renamed from: b  reason: collision with root package name */
    private final DatabaseHelper f11115b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11116c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DatabaseHelper extends SQLiteOpenHelper {

        /* renamed from: f  reason: collision with root package name */
        private final int f11117f;

        /* renamed from: g  reason: collision with root package name */
        private final File f11118g;

        DatabaseHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
            this.f11117f = 20971520;
            this.f11118g = context.getDatabasePath(str);
        }

        @SuppressLint({"UsableSpace"})
        boolean a() {
            if (!this.f11118g.exists() || Math.max(this.f11118g.getUsableSpace(), 20971520L) >= this.f11118g.length()) {
                return true;
            }
            return false;
        }

        void c() {
            close();
            this.f11118g.delete();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @SuppressLint({"SQLiteString"})
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Logger.n("Creating CleverTap DB");
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(DBAdapter.f11098d);
            Logger.n("Executing - " + DBAdapter.f11098d);
            compileStatement.execute();
            SQLiteStatement compileStatement2 = sQLiteDatabase.compileStatement(DBAdapter.f11099e);
            Logger.n("Executing - " + DBAdapter.f11099e);
            compileStatement2.execute();
            SQLiteStatement compileStatement3 = sQLiteDatabase.compileStatement(DBAdapter.f11100f);
            Logger.n("Executing - " + DBAdapter.f11100f);
            compileStatement3.execute();
            SQLiteStatement compileStatement4 = sQLiteDatabase.compileStatement(DBAdapter.f11101g);
            Logger.n("Executing - " + DBAdapter.f11101g);
            compileStatement4.execute();
            SQLiteStatement compileStatement5 = sQLiteDatabase.compileStatement(DBAdapter.f11105k);
            Logger.n("Executing - " + DBAdapter.f11105k);
            compileStatement5.execute();
            SQLiteStatement compileStatement6 = sQLiteDatabase.compileStatement(DBAdapter.f11107m);
            Logger.n("Executing - " + DBAdapter.f11107m);
            compileStatement6.execute();
            SQLiteStatement compileStatement7 = sQLiteDatabase.compileStatement(DBAdapter.f11109o);
            Logger.n("Executing - " + DBAdapter.f11109o);
            compileStatement7.execute();
            SQLiteStatement compileStatement8 = sQLiteDatabase.compileStatement(DBAdapter.f11103i);
            Logger.n("Executing - " + DBAdapter.f11103i);
            compileStatement8.execute();
            SQLiteStatement compileStatement9 = sQLiteDatabase.compileStatement(DBAdapter.f11104j);
            Logger.n("Executing - " + DBAdapter.f11104j);
            compileStatement9.execute();
            SQLiteStatement compileStatement10 = sQLiteDatabase.compileStatement(DBAdapter.f11108n);
            Logger.n("Executing - " + DBAdapter.f11108n);
            compileStatement10.execute();
            SQLiteStatement compileStatement11 = sQLiteDatabase.compileStatement(DBAdapter.f11106l);
            Logger.n("Executing - " + DBAdapter.f11106l);
            compileStatement11.execute();
            SQLiteStatement compileStatement12 = sQLiteDatabase.compileStatement(DBAdapter.f11102h);
            Logger.n("Executing - " + DBAdapter.f11102h);
            compileStatement12.execute();
            SQLiteStatement compileStatement13 = sQLiteDatabase.compileStatement(DBAdapter.f11110p);
            Logger.n("Executing - " + DBAdapter.f11110p);
            compileStatement13.execute();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @SuppressLint({"SQLiteString"})
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
            Logger.n("Upgrading CleverTap DB to version " + i9);
            if (i8 != 1) {
                if (i8 == 2) {
                    SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(DBAdapter.f11113s);
                    Logger.n("Executing - " + DBAdapter.f11113s);
                    compileStatement.execute();
                    SQLiteStatement compileStatement2 = sQLiteDatabase.compileStatement(DBAdapter.f11109o);
                    Logger.n("Executing - " + DBAdapter.f11109o);
                    compileStatement2.execute();
                    SQLiteStatement compileStatement3 = sQLiteDatabase.compileStatement(DBAdapter.f11110p);
                    Logger.n("Executing - " + DBAdapter.f11110p);
                    compileStatement3.execute();
                    return;
                }
                return;
            }
            SQLiteStatement compileStatement4 = sQLiteDatabase.compileStatement(DBAdapter.f11111q);
            Logger.n("Executing - " + DBAdapter.f11111q);
            compileStatement4.execute();
            SQLiteStatement compileStatement5 = sQLiteDatabase.compileStatement(DBAdapter.f11112r);
            Logger.n("Executing - " + DBAdapter.f11112r);
            compileStatement5.execute();
            SQLiteStatement compileStatement6 = sQLiteDatabase.compileStatement(DBAdapter.f11113s);
            Logger.n("Executing - " + DBAdapter.f11113s);
            compileStatement6.execute();
            SQLiteStatement compileStatement7 = sQLiteDatabase.compileStatement(DBAdapter.f11101g);
            Logger.n("Executing - " + DBAdapter.f11101g);
            compileStatement7.execute();
            SQLiteStatement compileStatement8 = sQLiteDatabase.compileStatement(DBAdapter.f11105k);
            Logger.n("Executing - " + DBAdapter.f11105k);
            compileStatement8.execute();
            SQLiteStatement compileStatement9 = sQLiteDatabase.compileStatement(DBAdapter.f11107m);
            Logger.n("Executing - " + DBAdapter.f11107m);
            compileStatement9.execute();
            SQLiteStatement compileStatement10 = sQLiteDatabase.compileStatement(DBAdapter.f11109o);
            Logger.n("Executing - " + DBAdapter.f11109o);
            compileStatement10.execute();
            SQLiteStatement compileStatement11 = sQLiteDatabase.compileStatement(DBAdapter.f11108n);
            Logger.n("Executing - " + DBAdapter.f11108n);
            compileStatement11.execute();
            SQLiteStatement compileStatement12 = sQLiteDatabase.compileStatement(DBAdapter.f11106l);
            Logger.n("Executing - " + DBAdapter.f11106l);
            compileStatement12.execute();
            SQLiteStatement compileStatement13 = sQLiteDatabase.compileStatement(DBAdapter.f11102h);
            Logger.n("Executing - " + DBAdapter.f11102h);
            compileStatement13.execute();
            SQLiteStatement compileStatement14 = sQLiteDatabase.compileStatement(DBAdapter.f11110p);
            Logger.n("Executing - " + DBAdapter.f11110p);
            compileStatement14.execute();
        }
    }

    /* loaded from: classes.dex */
    public enum Table {
        EVENTS("events"),
        PROFILE_EVENTS("profileEvents"),
        USER_PROFILES("userProfiles"),
        INBOX_MESSAGES("inboxMessages"),
        PUSH_NOTIFICATIONS("pushNotifications"),
        UNINSTALL_TS("uninstallTimestamp"),
        PUSH_NOTIFICATION_VIEWED("notificationViewed");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f11127f;

        Table(String str) {
            this.f11127f = str;
        }

        public String a() {
            return this.f11127f;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        Table table = Table.EVENTS;
        sb.append(table.a());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("data");
        sb.append(" STRING NOT NULL, ");
        sb.append("created_at");
        sb.append(" INTEGER NOT NULL);");
        f11098d = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE ");
        Table table2 = Table.PROFILE_EVENTS;
        sb2.append(table2.a());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb2.append("data");
        sb2.append(" STRING NOT NULL, ");
        sb2.append("created_at");
        sb2.append(" INTEGER NOT NULL);");
        f11099e = sb2.toString();
        f11100f = "CREATE TABLE " + Table.USER_PROFILES.a() + " (_id STRING UNIQUE PRIMARY KEY, data STRING NOT NULL);";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("CREATE TABLE ");
        Table table3 = Table.INBOX_MESSAGES;
        sb3.append(table3.a());
        sb3.append(" (_id STRING NOT NULL, ");
        sb3.append("data");
        sb3.append(" TEXT NOT NULL, ");
        sb3.append("wzrkParams");
        sb3.append(" TEXT NOT NULL, ");
        sb3.append("campaignId");
        sb3.append(" STRING NOT NULL, ");
        sb3.append("tags");
        sb3.append(" TEXT NOT NULL, ");
        sb3.append("isRead");
        sb3.append(" INTEGER NOT NULL DEFAULT 0, ");
        sb3.append("expires");
        sb3.append(" INTEGER NOT NULL, ");
        sb3.append("created_at");
        sb3.append(" INTEGER NOT NULL, ");
        sb3.append("messageUser");
        sb3.append(" STRING NOT NULL);");
        f11101g = sb3.toString();
        f11102h = "CREATE UNIQUE INDEX IF NOT EXISTS userid_id_idx ON " + table3.a() + " (messageUser,_id);";
        StringBuilder sb4 = new StringBuilder();
        sb4.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb4.append(table.a());
        sb4.append(" (");
        sb4.append("created_at");
        sb4.append(");");
        f11103i = sb4.toString();
        f11104j = "CREATE INDEX IF NOT EXISTS time_idx ON " + table2.a() + " (created_at);";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CREATE TABLE ");
        Table table4 = Table.PUSH_NOTIFICATIONS;
        sb5.append(table4.a());
        sb5.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb5.append("data");
        sb5.append(" STRING NOT NULL, ");
        sb5.append("created_at");
        sb5.append(" INTEGER NOT NULL,");
        sb5.append("isRead");
        sb5.append(" INTEGER NOT NULL);");
        f11105k = sb5.toString();
        f11106l = "CREATE INDEX IF NOT EXISTS time_idx ON " + table4.a() + " (created_at);";
        StringBuilder sb6 = new StringBuilder();
        sb6.append("CREATE TABLE ");
        Table table5 = Table.UNINSTALL_TS;
        sb6.append(table5.a());
        sb6.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb6.append("created_at");
        sb6.append(" INTEGER NOT NULL);");
        f11107m = sb6.toString();
        f11108n = "CREATE INDEX IF NOT EXISTS time_idx ON " + table5.a() + " (created_at);";
        StringBuilder sb7 = new StringBuilder();
        sb7.append("CREATE TABLE ");
        Table table6 = Table.PUSH_NOTIFICATION_VIEWED;
        sb7.append(table6.a());
        sb7.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb7.append("data");
        sb7.append(" STRING NOT NULL, ");
        sb7.append("created_at");
        sb7.append(" INTEGER NOT NULL);");
        f11109o = sb7.toString();
        f11110p = "CREATE INDEX IF NOT EXISTS time_idx ON " + table6.a() + " (created_at);";
        StringBuilder sb8 = new StringBuilder();
        sb8.append("DROP TABLE IF EXISTS ");
        sb8.append(table5.a());
        f11111q = sb8.toString();
        f11112r = "DROP TABLE IF EXISTS " + table3.a();
        f11113s = "DROP TABLE IF EXISTS " + table6.a();
    }

    public DBAdapter(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this(context, D(cleverTapInstanceConfig));
        this.f11114a = cleverTapInstanceConfig;
    }

    private Logger C() {
        return this.f11114a.n();
    }

    private static String D(CleverTapInstanceConfig cleverTapInstanceConfig) {
        if (cleverTapInstanceConfig.t()) {
            return "clevertap";
        }
        return "clevertap_" + cleverTapInstanceConfig.c();
    }

    private boolean q() {
        return this.f11115b.a();
    }

    private void r(Table table, long j8) {
        long currentTimeMillis = (System.currentTimeMillis() - j8) / 1000;
        String a8 = table.a();
        try {
            try {
                SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
                writableDatabase.delete(a8, "created_at <= " + currentTimeMillis, null);
            } catch (SQLiteException e8) {
                Logger C = C();
                C.u("Error removing stale event records from " + a8 + ". Recreating DB.", e8);
                v();
            }
        } finally {
            this.f11115b.close();
        }
    }

    private void v() {
        this.f11115b.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
        if (r9 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004e, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        if (r9 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.lang.String z(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch: java.lang.Throwable -> L87
            java.lang.String r0 = r0.a()     // Catch: java.lang.Throwable -> L87
            r9 = 0
            java.lang.String r10 = ""
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r11.f11115b     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            r3 = 0
            java.lang.String r4 = "data =?"
            r2 = 1
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            r2 = 0
            r5[r2] = r12     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            if (r9 == 0) goto L33
            boolean r12 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            if (r12 == 0) goto L33
            java.lang.String r12 = "data"
            int r12 = r9.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            java.lang.String r10 = r9.getString(r12)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
        L33:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            r12.<init>()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            java.lang.String r1 = "Fetching PID for check - "
            r12.append(r1)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            r12.append(r10)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            com.clevertap.android.sdk.Logger.n(r12)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r12 = r11.f11115b     // Catch: java.lang.Throwable -> L87
            r12.close()     // Catch: java.lang.Throwable -> L87
            if (r9 == 0) goto L7a
        L4e:
            r9.close()     // Catch: java.lang.Throwable -> L87
            goto L7a
        L52:
            r12 = move-exception
            goto L7c
        L54:
            r12 = move-exception
            com.clevertap.android.sdk.Logger r1 = r11.C()     // Catch: java.lang.Throwable -> L52
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r2.<init>()     // Catch: java.lang.Throwable -> L52
            java.lang.String r3 = "Could not fetch records out of database "
            r2.append(r3)     // Catch: java.lang.Throwable -> L52
            r2.append(r0)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = "."
            r2.append(r0)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L52
            r1.u(r0, r12)     // Catch: java.lang.Throwable -> L52
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r12 = r11.f11115b     // Catch: java.lang.Throwable -> L87
            r12.close()     // Catch: java.lang.Throwable -> L87
            if (r9 == 0) goto L7a
            goto L4e
        L7a:
            monitor-exit(r11)
            return r10
        L7c:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r11.f11115b     // Catch: java.lang.Throwable -> L87
            r0.close()     // Catch: java.lang.Throwable -> L87
            if (r9 == 0) goto L86
            r9.close()     // Catch: java.lang.Throwable -> L87
        L86:
            throw r12     // Catch: java.lang.Throwable -> L87
        L87:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.z(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
        if (r10 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String[] A() {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.f11116c     // Catch: java.lang.Throwable -> Lac
            r1 = 0
            if (r0 != 0) goto La
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> Lac
            monitor-exit(r12)
            return r0
        La:
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch: java.lang.Throwable -> Lac
            java.lang.String r0 = r0.a()     // Catch: java.lang.Throwable -> Lac
            r10 = 0
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lac
            r11.<init>()     // Catch: java.lang.Throwable -> Lac
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r12.f11115b     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            r4 = 0
            java.lang.String r5 = "isRead =?"
            java.lang.String r3 = "0"
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            r7 = 0
            r8 = 0
            r9 = 0
            r3 = r0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            if (r10 == 0) goto L64
        L2f:
            boolean r2 = r10.moveToNext()     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            if (r2 == 0) goto L61
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            r2.<init>()     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            java.lang.String r3 = "Fetching PID - "
            r2.append(r3)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            java.lang.String r3 = "data"
            int r3 = r10.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            java.lang.String r3 = r10.getString(r3)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            r2.append(r3)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            com.clevertap.android.sdk.Logger.n(r2)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            java.lang.String r2 = "data"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            r11.add(r2)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
            goto L2f
        L61:
            r10.close()     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L71
        L64:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r12.f11115b     // Catch: java.lang.Throwable -> Lac
            r0.close()     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto L97
        L6b:
            r10.close()     // Catch: java.lang.Throwable -> Lac
            goto L97
        L6f:
            r0 = move-exception
            goto La1
        L71:
            r2 = move-exception
            com.clevertap.android.sdk.Logger r3 = r12.C()     // Catch: java.lang.Throwable -> L6f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r4.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r5 = "Could not fetch records out of database "
            r4.append(r5)     // Catch: java.lang.Throwable -> L6f
            r4.append(r0)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = "."
            r4.append(r0)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L6f
            r3.u(r0, r2)     // Catch: java.lang.Throwable -> L6f
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r12.f11115b     // Catch: java.lang.Throwable -> Lac
            r0.close()     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto L97
            goto L6b
        L97:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> Lac
            java.lang.Object[] r0 = r11.toArray(r0)     // Catch: java.lang.Throwable -> Lac
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch: java.lang.Throwable -> Lac
            monitor-exit(r12)
            return r0
        La1:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r12.f11115b     // Catch: java.lang.Throwable -> Lac
            r1.close()     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto Lab
            r10.close()     // Catch: java.lang.Throwable -> Lac
        Lab:
            throw r0     // Catch: java.lang.Throwable -> Lac
        Lac:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.A():java.lang.String[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r12 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
        if (r12 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized org.json.JSONObject B(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            if (r12 != 0) goto L6
            monitor-exit(r11)
            return r0
        L6:
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.USER_PROFILES     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = r1.a()     // Catch: java.lang.Throwable -> L83
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r11.f11115b     // Catch: java.lang.Throwable -> L49 android.database.sqlite.SQLiteException -> L4e
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L49 android.database.sqlite.SQLiteException -> L4e
            r4 = 0
            java.lang.String r5 = "_id =?"
            r3 = 1
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L49 android.database.sqlite.SQLiteException -> L4e
            r3 = 0
            r6[r3] = r12     // Catch: java.lang.Throwable -> L49 android.database.sqlite.SQLiteException -> L4e
            r7 = 0
            r8 = 0
            r9 = 0
            r3 = r1
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L49 android.database.sqlite.SQLiteException -> L4e
            if (r12 == 0) goto L3e
            boolean r2 = r12.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3c java.lang.Throwable -> L77
            if (r2 == 0) goto L3e
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: android.database.sqlite.SQLiteException -> L3c org.json.JSONException -> L3e java.lang.Throwable -> L77
            java.lang.String r3 = "data"
            int r3 = r12.getColumnIndex(r3)     // Catch: android.database.sqlite.SQLiteException -> L3c org.json.JSONException -> L3e java.lang.Throwable -> L77
            java.lang.String r3 = r12.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L3c org.json.JSONException -> L3e java.lang.Throwable -> L77
            r2.<init>(r3)     // Catch: android.database.sqlite.SQLiteException -> L3c org.json.JSONException -> L3e java.lang.Throwable -> L77
            r0 = r2
            goto L3e
        L3c:
            r2 = move-exception
            goto L50
        L3e:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r11.f11115b     // Catch: java.lang.Throwable -> L83
            r1.close()     // Catch: java.lang.Throwable -> L83
            if (r12 == 0) goto L75
        L45:
            r12.close()     // Catch: java.lang.Throwable -> L83
            goto L75
        L49:
            r12 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L78
        L4e:
            r2 = move-exception
            r12 = r0
        L50:
            com.clevertap.android.sdk.Logger r3 = r11.C()     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r4.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r5 = "Could not fetch records out of database "
            r4.append(r5)     // Catch: java.lang.Throwable -> L77
            r4.append(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "."
            r4.append(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L77
            r3.u(r1, r2)     // Catch: java.lang.Throwable -> L77
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r11.f11115b     // Catch: java.lang.Throwable -> L83
            r1.close()     // Catch: java.lang.Throwable -> L83
            if (r12 == 0) goto L75
            goto L45
        L75:
            monitor-exit(r11)
            return r0
        L77:
            r0 = move-exception
        L78:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r11.f11115b     // Catch: java.lang.Throwable -> L83
            r1.close()     // Catch: java.lang.Throwable -> L83
            if (r12 == 0) goto L82
            r12.close()     // Catch: java.lang.Throwable -> L83
        L82:
            throw r0     // Catch: java.lang.Throwable -> L83
        L83:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.B(java.lang.String):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r10 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r10 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized long E() {
        /*
            r13 = this;
            monitor-enter(r13)
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.UNINSTALL_TS     // Catch: java.lang.Throwable -> L70
            java.lang.String r0 = r0.a()     // Catch: java.lang.Throwable -> L70
            r10 = 0
            r11 = 0
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r13.f11115b     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3d
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "created_at DESC"
            java.lang.String r9 = "1"
            r2 = r0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3d
            if (r10 == 0) goto L30
            boolean r1 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3d
            if (r1 == 0) goto L30
            java.lang.String r1 = "created_at"
            int r1 = r10.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3d
            long r11 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3d
        L30:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r13.f11115b     // Catch: java.lang.Throwable -> L70
            r0.close()     // Catch: java.lang.Throwable -> L70
            if (r10 == 0) goto L63
        L37:
            r10.close()     // Catch: java.lang.Throwable -> L70
            goto L63
        L3b:
            r0 = move-exception
            goto L65
        L3d:
            r1 = move-exception
            com.clevertap.android.sdk.Logger r2 = r13.C()     // Catch: java.lang.Throwable -> L3b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r3.<init>()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "Could not fetch records out of database "
            r3.append(r4)     // Catch: java.lang.Throwable -> L3b
            r3.append(r0)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = "."
            r3.append(r0)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            r2.u(r0, r1)     // Catch: java.lang.Throwable -> L3b
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r13.f11115b     // Catch: java.lang.Throwable -> L70
            r0.close()     // Catch: java.lang.Throwable -> L70
            if (r10 == 0) goto L63
            goto L37
        L63:
            monitor-exit(r13)
            return r11
        L65:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r13.f11115b     // Catch: java.lang.Throwable -> L70
            r1.close()     // Catch: java.lang.Throwable -> L70
            if (r10 == 0) goto L6f
            r10.close()     // Catch: java.lang.Throwable -> L70
        L6f:
            throw r0     // Catch: java.lang.Throwable -> L70
        L70:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.E():long");
    }

    public synchronized ArrayList<CTMessageDAO> F(String str) {
        ArrayList<CTMessageDAO> arrayList;
        String a8 = Table.INBOX_MESSAGES.a();
        arrayList = new ArrayList<>();
        try {
            try {
                Cursor query = this.f11115b.getWritableDatabase().query(a8, null, "messageUser =?", new String[]{str}, null, null, "created_at DESC");
                if (query != null) {
                    while (query.moveToNext()) {
                        CTMessageDAO cTMessageDAO = new CTMessageDAO();
                        cTMessageDAO.p(query.getString(query.getColumnIndex("_id")));
                        cTMessageDAO.q(new JSONObject(query.getString(query.getColumnIndex("data"))));
                        cTMessageDAO.u(new JSONObject(query.getString(query.getColumnIndex("wzrkParams"))));
                        cTMessageDAO.n(query.getLong(query.getColumnIndex("created_at")));
                        cTMessageDAO.o(query.getLong(query.getColumnIndex("expires")));
                        cTMessageDAO.r(query.getInt(query.getColumnIndex("isRead")));
                        cTMessageDAO.t(query.getString(query.getColumnIndex("messageUser")));
                        cTMessageDAO.s(query.getString(query.getColumnIndex("tags")));
                        cTMessageDAO.m(query.getString(query.getColumnIndex("campaignId")));
                        arrayList.add(cTMessageDAO);
                    }
                    query.close();
                }
                this.f11115b.close();
            } catch (SQLiteException e8) {
                Logger C = C();
                C.u("Error retrieving records from " + a8, e8);
                this.f11115b.close();
                return null;
            }
        } catch (JSONException e9) {
            Logger C2 = C();
            C2.s("Error retrieving records from " + a8, e9.getMessage());
            this.f11115b.close();
            return null;
        }
        return arrayList;
    }

    public synchronized boolean G(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        Table table = Table.INBOX_MESSAGES;
        String a8 = table.a();
        try {
            SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("isRead", (Integer) 1);
            writableDatabase.update(table.a(), contentValues, "_id = ? AND messageUser = ?", new String[]{str, str2});
            this.f11115b.close();
            return true;
        } catch (SQLiteException e8) {
            Logger C = C();
            C.u("Error removing stale records from " + a8, e8);
            this.f11115b.close();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void H(Table table) {
        DatabaseHelper databaseHelper;
        String a8 = table.a();
        try {
            this.f11115b.getWritableDatabase().delete(a8, null, null);
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error removing all events from table " + a8 + " Recreating DB");
            v();
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
    }

    public synchronized void I(String str) {
        DatabaseHelper databaseHelper;
        if (str == null) {
            return;
        }
        String a8 = Table.USER_PROFILES.a();
        try {
            this.f11115b.getWritableDatabase().delete(a8, "_id = ?", new String[]{str});
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error removing user profile from " + a8 + " Recreating DB");
            this.f11115b.c();
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int J(JSONObject jSONObject, Table table) {
        DatabaseHelper databaseHelper;
        if (!q()) {
            Logger.n("There is not enough space left on the device to store data, data discarded");
            return -2;
        }
        String a8 = table.a();
        long j8 = -1;
        try {
            SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", jSONObject.toString());
            contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
            writableDatabase.insert(a8, null, contentValues);
            j8 = writableDatabase.compileStatement("SELECT COUNT(*) FROM " + a8).simpleQueryForLong();
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error adding data to table " + a8 + " Recreating DB");
            this.f11115b.c();
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
        return (int) j8;
    }

    public synchronized void K(String str, long j8) {
        DatabaseHelper databaseHelper;
        if (str == null) {
            return;
        }
        if (!q()) {
            C().r("There is not enough space left on the device to store data, data discarded");
            return;
        }
        String a8 = Table.PUSH_NOTIFICATIONS.a();
        if (j8 <= 0) {
            j8 = System.currentTimeMillis() + 345600000;
        }
        try {
            SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", str);
            contentValues.put("created_at", Long.valueOf(j8));
            contentValues.put("isRead", (Integer) 0);
            writableDatabase.insert(a8, null, contentValues);
            this.f11116c = true;
            Logger.n("Stored PN - " + str + " with TTL - " + j8);
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error adding data to table " + a8 + " Recreating DB");
            this.f11115b.c();
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
    }

    public synchronized void L() {
        DatabaseHelper databaseHelper;
        if (!q()) {
            C().r("There is not enough space left on the device to store data, data discarded");
            return;
        }
        String a8 = Table.UNINSTALL_TS.a();
        try {
            SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
            writableDatabase.insert(a8, null, contentValues);
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error adding data to table " + a8 + " Recreating DB");
            this.f11115b.c();
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
    }

    public synchronized long M(String str, JSONObject jSONObject) {
        DatabaseHelper databaseHelper;
        long j8 = -1;
        if (str == null) {
            return -1L;
        }
        if (!q()) {
            C().r("There is not enough space left on the device to store data, data discarded");
            return -2L;
        }
        String a8 = Table.USER_PROFILES.a();
        try {
            SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", jSONObject.toString());
            contentValues.put("_id", str);
            j8 = writableDatabase.insertWithOnConflict(a8, null, contentValues, 5);
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error adding data to table " + a8 + " Recreating DB");
            this.f11115b.c();
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
        return j8;
    }

    public synchronized void N(String[] strArr) {
        DatabaseHelper databaseHelper;
        if (strArr.length == 0) {
            return;
        }
        if (!q()) {
            Logger.n("There is not enough space left on the device to store data, data discarded");
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("isRead", (Integer) 1);
            StringBuilder sb = new StringBuilder();
            sb.append("?");
            for (int i8 = 0; i8 < strArr.length - 1; i8++) {
                sb.append(", ?");
            }
            String a8 = Table.PUSH_NOTIFICATIONS.a();
            writableDatabase.update(a8, contentValues, "data IN ( " + sb.toString() + " )", strArr);
            this.f11116c = false;
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error adding data to table " + Table.PUSH_NOTIFICATIONS.a() + " Recreating DB");
            this.f11115b.c();
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
    }

    public synchronized void O(ArrayList<CTMessageDAO> arrayList) {
        DatabaseHelper databaseHelper;
        if (!q()) {
            Logger.n("There is not enough space left on the device to store data, data discarded");
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
            Iterator<CTMessageDAO> it = arrayList.iterator();
            while (it.hasNext()) {
                CTMessageDAO next = it.next();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", next.e());
                contentValues.put("data", next.f().toString());
                contentValues.put("wzrkParams", next.j().toString());
                contentValues.put("campaignId", next.b());
                contentValues.put("tags", next.g());
                contentValues.put("isRead", Integer.valueOf(next.l()));
                contentValues.put("expires", Long.valueOf(next.d()));
                contentValues.put("created_at", Long.valueOf(next.c()));
                contentValues.put("messageUser", next.h());
                writableDatabase.insertWithOnConflict(Table.INBOX_MESSAGES.a(), null, contentValues, 5);
            }
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error adding data to table " + Table.INBOX_MESSAGES.a());
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void s() {
        r(Table.PUSH_NOTIFICATIONS, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void t(String str, Table table) {
        DatabaseHelper databaseHelper;
        String a8 = table.a();
        try {
            SQLiteDatabase writableDatabase = this.f11115b.getWritableDatabase();
            writableDatabase.delete(a8, "_id <= " + str, null);
            databaseHelper = this.f11115b;
        } catch (SQLiteException unused) {
            Logger C = C();
            C.r("Error removing sent data from table " + a8 + " Recreating DB");
            v();
            databaseHelper = this.f11115b;
        }
        databaseHelper.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void u(Table table) {
        r(table, 432000000L);
    }

    public synchronized boolean w(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        String a8 = Table.INBOX_MESSAGES.a();
        try {
            this.f11115b.getWritableDatabase().delete(a8, "_id = ? AND messageUser = ?", new String[]{str, str2});
            this.f11115b.close();
            return true;
        } catch (SQLiteException e8) {
            Logger C = C();
            C.u("Error removing stale records from " + a8, e8);
            this.f11115b.close();
            return false;
        }
    }

    public synchronized boolean x(String str) {
        return str.equals(z(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099 A[Catch: all -> 0x009d, TryCatch #6 {, blocks: (B:3:0x0001, B:14:0x004b, B:28:0x0084, B:23:0x0077, B:25:0x007e, B:35:0x0092, B:37:0x0099, B:38:0x009c), top: B:51:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized org.json.JSONObject y(com.clevertap.android.sdk.db.DBAdapter.Table r12, int r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r12 = r12.a()     // Catch: java.lang.Throwable -> L9d
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L9d
            r9.<init>()     // Catch: java.lang.Throwable -> L9d
            r10 = 0
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r11.f11115b     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L58
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L58
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "created_at ASC"
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L58
            r1 = r12
            android.database.Cursor r13 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L58
            r0 = r10
        L22:
            boolean r1 = r13.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
            if (r1 == 0) goto L4b
            boolean r1 = r13.isLast()     // Catch: android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
            if (r1 == 0) goto L38
            java.lang.String r0 = "_id"
            int r0 = r13.getColumnIndex(r0)     // Catch: android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
            java.lang.String r0 = r13.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
        L38:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L22 android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
            java.lang.String r2 = "data"
            int r2 = r13.getColumnIndex(r2)     // Catch: org.json.JSONException -> L22 android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
            java.lang.String r2 = r13.getString(r2)     // Catch: org.json.JSONException -> L22 android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
            r1.<init>(r2)     // Catch: org.json.JSONException -> L22 android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
            r9.put(r1)     // Catch: org.json.JSONException -> L22 android.database.sqlite.SQLiteException -> L54 java.lang.Throwable -> L90
            goto L22
        L4b:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r12 = r11.f11115b     // Catch: java.lang.Throwable -> L9d
            r12.close()     // Catch: java.lang.Throwable -> L9d
            r13.close()     // Catch: java.lang.Throwable -> L9d
            goto L82
        L54:
            r0 = move-exception
            goto L5a
        L56:
            r12 = move-exception
            goto L92
        L58:
            r0 = move-exception
            r13 = r10
        L5a:
            com.clevertap.android.sdk.Logger r1 = r11.C()     // Catch: java.lang.Throwable -> L90
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L90
            r2.<init>()     // Catch: java.lang.Throwable -> L90
            java.lang.String r3 = "Could not fetch records out of database "
            r2.append(r3)     // Catch: java.lang.Throwable -> L90
            r2.append(r12)     // Catch: java.lang.Throwable -> L90
            java.lang.String r12 = "."
            r2.append(r12)     // Catch: java.lang.Throwable -> L90
            java.lang.String r12 = r2.toString()     // Catch: java.lang.Throwable -> L90
            r1.u(r12, r0)     // Catch: java.lang.Throwable -> L90
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r12 = r11.f11115b     // Catch: java.lang.Throwable -> L9d
            r12.close()     // Catch: java.lang.Throwable -> L9d
            if (r13 == 0) goto L81
            r13.close()     // Catch: java.lang.Throwable -> L9d
        L81:
            r0 = r10
        L82:
            if (r0 == 0) goto L8e
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch: org.json.JSONException -> L8e java.lang.Throwable -> L9d
            r12.<init>()     // Catch: org.json.JSONException -> L8e java.lang.Throwable -> L9d
            r12.put(r0, r9)     // Catch: org.json.JSONException -> L8e java.lang.Throwable -> L9d
            monitor-exit(r11)
            return r12
        L8e:
            monitor-exit(r11)
            return r10
        L90:
            r12 = move-exception
            r10 = r13
        L92:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r13 = r11.f11115b     // Catch: java.lang.Throwable -> L9d
            r13.close()     // Catch: java.lang.Throwable -> L9d
            if (r10 == 0) goto L9c
            r10.close()     // Catch: java.lang.Throwable -> L9d
        L9c:
            throw r12     // Catch: java.lang.Throwable -> L9d
        L9d:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.y(com.clevertap.android.sdk.db.DBAdapter$Table, int):org.json.JSONObject");
    }

    private DBAdapter(Context context, String str) {
        this.f11116c = true;
        this.f11115b = new DatabaseHelper(context, str);
    }
}
