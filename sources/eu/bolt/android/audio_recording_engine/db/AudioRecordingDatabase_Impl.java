package eu.bolt.android.audio_recording_engine.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class AudioRecordingDatabase_Impl extends AudioRecordingDatabase {

    /* renamed from: o  reason: collision with root package name */
    private volatile RecordingDao f36596o;

    @Override // eu.bolt.android.audio_recording_engine.db.AudioRecordingDatabase
    public RecordingDao G() {
        RecordingDao recordingDao;
        if (this.f36596o != null) {
            return this.f36596o;
        }
        synchronized (this) {
            if (this.f36596o == null) {
                this.f36596o = new RecordingDao_Impl(this);
            }
            recordingDao = this.f36596o;
        }
        return recordingDao;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "OrderRecordingsData", "RecordingFileInfo");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper h(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.f7443a.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f7444b).c(databaseConfiguration.f7445c).b(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: eu.bolt.android.audio_recording_engine.db.AudioRecordingDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `OrderRecordingsData` (`orderKey` TEXT NOT NULL, `createdTimeStamp` INTEGER NOT NULL, `fileSize` INTEGER NOT NULL, PRIMARY KEY(`orderKey`))");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `RecordingFileInfo` (`fileIndex` INTEGER NOT NULL, `parentOrderKey` TEXT NOT NULL, `isUploaded` INTEGER NOT NULL DEFAULT false, `durationMilliSecs` INTEGER DEFAULT 0, PRIMARY KEY(`fileIndex`, `parentOrderKey`), FOREIGN KEY(`parentOrderKey`) REFERENCES `OrderRecordingsData`(`orderKey`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '46fafdf2bb7d7862205427ef8c650ea6')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `OrderRecordingsData`");
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `RecordingFileInfo`");
                if (((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h.get(i8)).b(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void c(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h.get(i8)).a(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) AudioRecordingDatabase_Impl.this).f7537a = supportSQLiteDatabase;
                supportSQLiteDatabase.u("PRAGMA foreign_keys = ON");
                AudioRecordingDatabase_Impl.this.w(supportSQLiteDatabase);
                if (((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) AudioRecordingDatabase_Impl.this).f7544h.get(i8)).c(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void e(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.b(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult g(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("orderKey", new TableInfo.Column("orderKey", "TEXT", true, 1, null, 1));
                hashMap.put("createdTimeStamp", new TableInfo.Column("createdTimeStamp", "INTEGER", true, 0, null, 1));
                hashMap.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("OrderRecordingsData", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a8 = TableInfo.a(supportSQLiteDatabase, "OrderRecordingsData");
                if (!tableInfo.equals(a8)) {
                    return new RoomOpenHelper.ValidationResult(false, "OrderRecordingsData(eu.bolt.android.audio_recording_engine.db.OrderRecordingsData).\n Expected:\n" + tableInfo + "\n Found:\n" + a8);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("fileIndex", new TableInfo.Column("fileIndex", "INTEGER", true, 1, null, 1));
                hashMap2.put("parentOrderKey", new TableInfo.Column("parentOrderKey", "TEXT", true, 2, null, 1));
                hashMap2.put("isUploaded", new TableInfo.Column("isUploaded", "INTEGER", true, 0, "false", 1));
                hashMap2.put("durationMilliSecs", new TableInfo.Column("durationMilliSecs", "INTEGER", false, 0, "0", 1));
                HashSet hashSet = new HashSet(1);
                hashSet.add(new TableInfo.ForeignKey("OrderRecordingsData", "CASCADE", "NO ACTION", Arrays.asList("parentOrderKey"), Arrays.asList("orderKey")));
                TableInfo tableInfo2 = new TableInfo("RecordingFileInfo", hashMap2, hashSet, new HashSet(0));
                TableInfo a9 = TableInfo.a(supportSQLiteDatabase, "RecordingFileInfo");
                if (!tableInfo2.equals(a9)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordingFileInfo(eu.bolt.android.audio_recording_engine.db.RecordingFileInfo).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a9);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "46fafdf2bb7d7862205427ef8c650ea6", "c6f78175ab66f9474487f8e777fc0d7b")).a());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> j(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> p() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> q() {
        HashMap hashMap = new HashMap();
        hashMap.put(RecordingDao.class, RecordingDao_Impl.l());
        return hashMap;
    }
}
