package com.mixpanel.android.mpmetrics;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.mixpanel.android.util.MPLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MPDbAdapter {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Context, MPDbAdapter> f19206b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final String f19207c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f19208d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f19209e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f19210f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f19211g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f19212h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f19213i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f19214j;

    /* renamed from: a  reason: collision with root package name */
    private final MPDatabaseHelper f19215a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MPDatabaseHelper extends SQLiteOpenHelper {

        /* renamed from: f  reason: collision with root package name */
        private final File f19216f;

        /* renamed from: g  reason: collision with root package name */
        private final MPConfig f19217g;

        /* renamed from: h  reason: collision with root package name */
        private final Context f19218h;

        MPDatabaseHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 7);
            this.f19216f = context.getDatabasePath(str);
            this.f19217g = MPConfig.s(context);
            this.f19218h = context;
        }

        private void g(SQLiteDatabase sQLiteDatabase) {
            int i8;
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            Table table = Table.EVENTS;
            sb.append(table.a());
            sb.append(" ADD COLUMN ");
            sb.append("automatic_data");
            sb.append(" INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ALTER TABLE ");
            Table table2 = Table.PEOPLE;
            sb2.append(table2.a());
            sb2.append(" ADD COLUMN ");
            sb2.append("automatic_data");
            sb2.append(" INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL(sb2.toString());
            sQLiteDatabase.execSQL("ALTER TABLE " + table.a() + " ADD COLUMN token STRING NOT NULL DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE " + table2.a() + " ADD COLUMN token STRING NOT NULL DEFAULT ''");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("SELECT * FROM ");
            sb3.append(table.a());
            Cursor rawQuery = sQLiteDatabase.rawQuery(sb3.toString(), null);
            while (true) {
                int i9 = 0;
                if (!rawQuery.moveToNext()) {
                    break;
                }
                try {
                    String string = new JSONObject(rawQuery.getString(rawQuery.getColumnIndex("data"))).getJSONObject("properties").getString("token");
                    i9 = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    sQLiteDatabase.execSQL("UPDATE " + Table.EVENTS.a() + " SET token = '" + string + "' WHERE _id = " + i9);
                } catch (JSONException unused) {
                    String a8 = Table.EVENTS.a();
                    sQLiteDatabase.delete(a8, "_id = " + i9, null);
                }
            }
            Cursor rawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM " + Table.PEOPLE.a(), null);
            while (rawQuery2.moveToNext()) {
                try {
                    String string2 = new JSONObject(rawQuery2.getString(rawQuery2.getColumnIndex("data"))).getString("$token");
                    i8 = rawQuery2.getInt(rawQuery2.getColumnIndex("_id"));
                    try {
                        sQLiteDatabase.execSQL("UPDATE " + Table.PEOPLE.a() + " SET token = '" + string2 + "' WHERE _id = " + i8);
                    } catch (JSONException unused2) {
                        String a9 = Table.PEOPLE.a();
                        sQLiteDatabase.delete(a9, "_id = " + i8, null);
                    }
                } catch (JSONException unused3) {
                    i8 = 0;
                }
            }
        }

        private void h(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(MPDbAdapter.f19209e);
            sQLiteDatabase.execSQL(MPDbAdapter.f19213i);
        }

        private void j(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(MPDbAdapter.f19210f);
            sQLiteDatabase.execSQL(MPDbAdapter.f19214j);
            File file = new File(this.f19218h.getApplicationInfo().dataDir, "shared_prefs");
            if (file.exists() && file.isDirectory()) {
                for (String str : file.list(new FilenameFilter() { // from class: com.mixpanel.android.mpmetrics.MPDbAdapter.MPDatabaseHelper.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str2) {
                        return str2.startsWith("com.mixpanel.android.mpmetrics.MixpanelAPI_");
                    }
                })) {
                    SharedPreferences sharedPreferences = this.f19218h.getSharedPreferences(str.split("\\.xml")[0], 0);
                    String string = sharedPreferences.getString("waiting_array", null);
                    if (string != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(string);
                            sQLiteDatabase.beginTransaction();
                            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                                try {
                                    JSONObject jSONObject = jSONArray.getJSONObject(i8);
                                    String string2 = jSONObject.getString("$token");
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("data", jSONObject.toString());
                                    contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                                    contentValues.put("automatic_data", Boolean.FALSE);
                                    contentValues.put("token", string2);
                                    sQLiteDatabase.insert(Table.ANONYMOUS_PEOPLE.a(), null, contentValues);
                                } catch (JSONException unused) {
                                }
                            }
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                        } catch (JSONException unused2) {
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.remove("waiting_array");
                        edit.apply();
                    }
                }
            }
        }

        public boolean c() {
            if (!this.f19216f.exists() || Math.max(this.f19216f.getUsableSpace(), this.f19217g.t()) >= this.f19216f.length()) {
                return true;
            }
            return false;
        }

        public void e() {
            close();
            this.f19216f.delete();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            MPLog.i("MixpanelAPI.Database", "Creating a new Mixpanel events DB");
            sQLiteDatabase.execSQL(MPDbAdapter.f19207c);
            sQLiteDatabase.execSQL(MPDbAdapter.f19208d);
            sQLiteDatabase.execSQL(MPDbAdapter.f19209e);
            sQLiteDatabase.execSQL(MPDbAdapter.f19210f);
            sQLiteDatabase.execSQL(MPDbAdapter.f19211g);
            sQLiteDatabase.execSQL(MPDbAdapter.f19212h);
            sQLiteDatabase.execSQL(MPDbAdapter.f19213i);
            sQLiteDatabase.execSQL(MPDbAdapter.f19214j);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
            MPLog.i("MixpanelAPI.Database", "Upgrading app, replacing Mixpanel events DB");
            if (i8 >= 4 && i9 <= 7) {
                if (i8 == 4) {
                    g(sQLiteDatabase);
                    h(sQLiteDatabase);
                    j(sQLiteDatabase);
                }
                if (i8 == 5) {
                    h(sQLiteDatabase);
                    j(sQLiteDatabase);
                }
                if (i8 == 6) {
                    j(sQLiteDatabase);
                    return;
                }
                return;
            }
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.a());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.PEOPLE.a());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.GROUPS.a());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.ANONYMOUS_PEOPLE.a());
            sQLiteDatabase.execSQL(MPDbAdapter.f19207c);
            sQLiteDatabase.execSQL(MPDbAdapter.f19208d);
            sQLiteDatabase.execSQL(MPDbAdapter.f19209e);
            sQLiteDatabase.execSQL(MPDbAdapter.f19210f);
            sQLiteDatabase.execSQL(MPDbAdapter.f19211g);
            sQLiteDatabase.execSQL(MPDbAdapter.f19212h);
            sQLiteDatabase.execSQL(MPDbAdapter.f19213i);
            sQLiteDatabase.execSQL(MPDbAdapter.f19214j);
        }
    }

    /* loaded from: classes3.dex */
    public enum Table {
        EVENTS("events"),
        PEOPLE("people"),
        ANONYMOUS_PEOPLE("anonymous_people"),
        GROUPS("groups");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f19225f;

        Table(String str) {
            this.f19225f = str;
        }

        public String a() {
            return this.f19225f;
        }
    }

    static {
        Table table;
        Table table2;
        Table table3;
        Table table4;
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(Table.EVENTS.a());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("data");
        sb.append(" STRING NOT NULL, ");
        sb.append("created_at");
        sb.append(" INTEGER NOT NULL, ");
        sb.append("automatic_data");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("token");
        sb.append(" STRING NOT NULL DEFAULT '')");
        f19207c = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE ");
        sb2.append(Table.PEOPLE.a());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb2.append("data");
        sb2.append(" STRING NOT NULL, ");
        sb2.append("created_at");
        sb2.append(" INTEGER NOT NULL, ");
        sb2.append("automatic_data");
        sb2.append(" INTEGER DEFAULT 0, ");
        sb2.append("token");
        sb2.append(" STRING NOT NULL DEFAULT '')");
        f19208d = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("CREATE TABLE ");
        sb3.append(Table.GROUPS.a());
        sb3.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb3.append("data");
        sb3.append(" STRING NOT NULL, ");
        sb3.append("created_at");
        sb3.append(" INTEGER NOT NULL, ");
        sb3.append("automatic_data");
        sb3.append(" INTEGER DEFAULT 0, ");
        sb3.append("token");
        sb3.append(" STRING NOT NULL DEFAULT '')");
        f19209e = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("CREATE TABLE ");
        sb4.append(Table.ANONYMOUS_PEOPLE.a());
        sb4.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb4.append("data");
        sb4.append(" STRING NOT NULL, ");
        sb4.append("created_at");
        sb4.append(" INTEGER NOT NULL, ");
        sb4.append("automatic_data");
        sb4.append(" INTEGER DEFAULT 0, ");
        sb4.append("token");
        sb4.append(" STRING NOT NULL DEFAULT '')");
        f19210f = sb4.toString();
        f19211g = "CREATE INDEX IF NOT EXISTS time_idx ON " + table.a() + " (created_at);";
        f19212h = "CREATE INDEX IF NOT EXISTS time_idx ON " + table2.a() + " (created_at);";
        f19213i = "CREATE INDEX IF NOT EXISTS time_idx ON " + table3.a() + " (created_at);";
        f19214j = "CREATE INDEX IF NOT EXISTS time_idx ON " + table4.a() + " (created_at);";
    }

    public MPDbAdapter(Context context) {
        this(context, "mixpanel");
    }

    private void l(Table table, String str) {
        String a8 = table.a();
        try {
            try {
                SQLiteDatabase writableDatabase = this.f19215a.getWritableDatabase();
                writableDatabase.delete(a8, "automatic_data = 1 AND token = '" + str + "'", null);
            } catch (SQLiteException e8) {
                MPLog.d("MixpanelAPI.Database", "Could not clean automatic Mixpanel records from " + a8 + ". Re-initializing database.", e8);
                this.f19215a.e();
            }
        } finally {
            this.f19215a.close();
        }
    }

    public static MPDbAdapter s(Context context) {
        MPDbAdapter mPDbAdapter;
        Map<Context, MPDbAdapter> map = f19206b;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (!map.containsKey(applicationContext)) {
                mPDbAdapter = new MPDbAdapter(applicationContext);
                map.put(applicationContext, mPDbAdapter);
            } else {
                mPDbAdapter = map.get(applicationContext);
            }
        }
        return mPDbAdapter;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int i(org.json.JSONObject r8, java.lang.String r9, com.mixpanel.android.mpmetrics.MPDbAdapter.Table r10, boolean r11) {
        /*
            r7 = this;
            boolean r0 = r7.j()
            java.lang.String r1 = "MixpanelAPI.Database"
            if (r0 != 0) goto Lf
            java.lang.String r8 = "There is not enough space left on the device to store Mixpanel data, so data was discarded"
            com.mixpanel.android.util.MPLog.c(r1, r8)
            r8 = -2
            return r8
        Lf:
            java.lang.String r10 = r10.a()
            r0 = -1
            r2 = 0
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r3 = r7.f19215a     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r4.<init>()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r5 = "data"
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r4.put(r5, r8)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r8 = "created_at"
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r4.put(r8, r5)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r8 = "automatic_data"
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r4.put(r8, r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r8 = "token"
            r4.put(r8, r9)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r3.insert(r10, r2, r4)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r8.<init>()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r11 = "SELECT COUNT(*) FROM "
            r8.append(r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r8.append(r10)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r11 = " WHERE token='"
            r8.append(r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r8.append(r9)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r9 = "'"
            r8.append(r9)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            android.database.Cursor r8 = r3.rawQuery(r8, r2)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r8.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> Lab
            r9 = 0
            int r0 = r8.getInt(r9)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> Lab
            r8.close()
            goto La5
        L75:
            r9 = move-exception
            goto L7b
        L77:
            r9 = move-exception
            goto Lad
        L79:
            r9 = move-exception
            r8 = r2
        L7b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab
            r11.<init>()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r3 = "Could not add Mixpanel data to table "
            r11.append(r3)     // Catch: java.lang.Throwable -> Lab
            r11.append(r10)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r10 = ". Re-initializing database."
            r11.append(r10)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> Lab
            com.mixpanel.android.util.MPLog.d(r1, r10, r9)     // Catch: java.lang.Throwable -> Lab
            if (r8 == 0) goto L9a
            r8.close()     // Catch: java.lang.Throwable -> Lab
            goto L9b
        L9a:
            r2 = r8
        L9b:
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r8 = r7.f19215a     // Catch: java.lang.Throwable -> L77
            r8.e()     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto La5
            r2.close()
        La5:
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r8 = r7.f19215a
            r8.close()
            return r0
        Lab:
            r9 = move-exception
            r2 = r8
        Lad:
            if (r2 == 0) goto Lb2
            r2.close()
        Lb2:
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r8 = r7.f19215a
            r8.close()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.i(org.json.JSONObject, java.lang.String, com.mixpanel.android.mpmetrics.MPDbAdapter$Table, boolean):int");
    }

    protected boolean j() {
        return this.f19215a.c();
    }

    public void k(Table table, String str) {
        String a8 = table.a();
        try {
            try {
                SQLiteDatabase writableDatabase = this.f19215a.getWritableDatabase();
                writableDatabase.delete(a8, "token = '" + str + "'", null);
            } catch (SQLiteException e8) {
                MPLog.d("MixpanelAPI.Database", "Could not clean timed-out Mixpanel records from " + a8 + ". Re-initializing database.", e8);
                this.f19215a.e();
            }
        } finally {
            this.f19215a.close();
        }
    }

    public synchronized void m(String str) {
        l(Table.EVENTS, str);
        l(Table.PEOPLE, str);
        l(Table.GROUPS, str);
    }

    public void n(long j8, Table table) {
        String a8 = table.a();
        try {
            try {
                SQLiteDatabase writableDatabase = this.f19215a.getWritableDatabase();
                writableDatabase.delete(a8, "created_at <= " + j8, null);
            } catch (SQLiteException e8) {
                MPLog.d("MixpanelAPI.Database", "Could not clean timed-out Mixpanel records from " + a8 + ". Re-initializing database.", e8);
                this.f19215a.e();
            }
        } finally {
            this.f19215a.close();
        }
    }

    public void o(String str, Table table, String str2, boolean z7) {
        String a8 = table.a();
        try {
            try {
                SQLiteDatabase writableDatabase = this.f19215a.getWritableDatabase();
                StringBuffer stringBuffer = new StringBuffer("_id <= " + str + " AND token = '" + str2 + "'");
                if (!z7) {
                    stringBuffer.append(" AND automatic_data=0");
                }
                writableDatabase.delete(a8, stringBuffer.toString(), null);
            } catch (SQLiteException e8) {
                MPLog.d("MixpanelAPI.Database", "Could not clean sent Mixpanel records from " + a8 + ". Re-initializing database.", e8);
                this.f19215a.e();
            } catch (Exception e9) {
                MPLog.d("MixpanelAPI.Database", "Unknown exception. Could not clean sent Mixpanel records from " + a8 + ".Re-initializing database.", e9);
                this.f19215a.e();
            }
        } finally {
            this.f19215a.close();
        }
    }

    public void p() {
        this.f19215a.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] q(com.mixpanel.android.mpmetrics.MPDbAdapter.Table r13, java.lang.String r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.q(com.mixpanel.android.mpmetrics.MPDbAdapter$Table, java.lang.String, boolean):java.lang.String[]");
    }

    public File r() {
        return this.f19215a.f19216f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0127  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int t(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.t(java.lang.String, java.lang.String):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r7v1, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int u(java.util.Map<java.lang.String, java.lang.String> r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.u(java.util.Map, java.lang.String):int");
    }

    public MPDbAdapter(Context context, String str) {
        this.f19215a = new MPDatabaseHelper(context, str);
    }
}
