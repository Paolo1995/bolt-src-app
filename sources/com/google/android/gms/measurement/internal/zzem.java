package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzem extends SQLiteOpenHelper {
    final /* synthetic */ zzen zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzem(zzen zzenVar, Context context, String str) {
        super(context, "google_app_measurement_local.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzenVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e8) {
            throw e8;
        } catch (SQLiteException unused) {
            this.zza.zzs.zzay().zzd().zza("Opening the local database failed, dropping and recreating it");
            this.zza.zzs.zzf();
            if (!this.zza.zzs.zzau().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zza.zzs.zzay().zzd().zzb("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e9) {
                this.zza.zzs.zzay().zzd().zzb("Failed to open local database. Events will bypass local storage", e9);
                return null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzan.zzb(this.zza.zzs.zzay(), sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
    }
}
