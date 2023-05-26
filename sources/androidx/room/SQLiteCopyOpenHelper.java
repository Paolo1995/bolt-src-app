package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Context f7613f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7614g;

    /* renamed from: h  reason: collision with root package name */
    private final File f7615h;

    /* renamed from: i  reason: collision with root package name */
    private final Callable<InputStream> f7616i;

    /* renamed from: j  reason: collision with root package name */
    private final int f7617j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final SupportSQLiteOpenHelper f7618k;

    /* renamed from: l  reason: collision with root package name */
    private DatabaseConfiguration f7619l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7620m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCopyOpenHelper(@NonNull Context context, String str, File file, Callable<InputStream> callable, int i8, @NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.f7613f = context;
        this.f7614g = str;
        this.f7615h = file;
        this.f7616i = callable;
        this.f7617j = i8;
        this.f7618k = supportSQLiteOpenHelper;
    }

    private void a(File file, boolean z7) throws IOException {
        ReadableByteChannel newChannel;
        if (this.f7614g != null) {
            newChannel = Channels.newChannel(this.f7613f.getAssets().open(this.f7614g));
        } else if (this.f7615h != null) {
            newChannel = new FileInputStream(this.f7615h).getChannel();
        } else {
            Callable<InputStream> callable = this.f7616i;
            if (callable != null) {
                try {
                    newChannel = Channels.newChannel(callable.call());
                } catch (Exception e8) {
                    throw new IOException("inputStreamCallable exception on call", e8);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f7613f.getCacheDir());
        createTempFile.deleteOnExit();
        FileUtil.a(newChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        g(createTempFile, z7);
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private SupportSQLiteOpenHelper c(File file) {
        try {
            return new FrameworkSQLiteOpenHelperFactory().a(SupportSQLiteOpenHelper.Configuration.a(this.f7613f).c(file.getAbsolutePath()).b(new SupportSQLiteOpenHelper.Callback(Math.max(DBUtil.d(file), 1)) { // from class: androidx.room.SQLiteCopyOpenHelper.1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void d(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void f(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                    int i8 = this.f7739a;
                    if (i8 < 1) {
                        supportSQLiteDatabase.p0(i8);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void g(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i8, int i9) {
                }
            }).a());
        } catch (IOException e8) {
            throw new RuntimeException("Malformed database file, unable to read version.", e8);
        }
    }

    private void g(File file, boolean z7) {
        SupportSQLiteDatabase E0;
        DatabaseConfiguration databaseConfiguration = this.f7619l;
        if (databaseConfiguration != null && databaseConfiguration.f7448f != null) {
            SupportSQLiteOpenHelper c8 = c(file);
            try {
                if (z7) {
                    E0 = c8.H0();
                } else {
                    E0 = c8.E0();
                }
                this.f7619l.f7448f.a(E0);
            } finally {
                c8.close();
            }
        }
    }

    private void j(boolean z7) {
        boolean z8;
        String databaseName = getDatabaseName();
        File databasePath = this.f7613f.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.f7619l;
        if (databaseConfiguration != null && !databaseConfiguration.f7455m) {
            z8 = false;
        } else {
            z8 = true;
        }
        CopyLock copyLock = new CopyLock(databaseName, this.f7613f.getFilesDir(), z8);
        try {
            copyLock.b();
            if (!databasePath.exists()) {
                try {
                    a(databasePath, z7);
                    copyLock.c();
                    return;
                } catch (IOException e8) {
                    throw new RuntimeException("Unable to copy database file.", e8);
                }
            } else if (this.f7619l == null) {
                copyLock.c();
                return;
            } else {
                try {
                    int d8 = DBUtil.d(databasePath);
                    int i8 = this.f7617j;
                    if (d8 == i8) {
                        copyLock.c();
                        return;
                    } else if (this.f7619l.a(d8, i8)) {
                        copyLock.c();
                        return;
                    } else {
                        if (this.f7613f.deleteDatabase(databaseName)) {
                            try {
                                a(databasePath, z7);
                            } catch (IOException e9) {
                                Log.w("ROOM", "Unable to copy database file.", e9);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        copyLock.c();
                        return;
                    }
                } catch (IOException e10) {
                    Log.w("ROOM", "Unable to read database version.", e10);
                    copyLock.c();
                    return;
                }
            }
        } catch (Throwable th) {
            copyLock.c();
            throw th;
        }
        copyLock.c();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase E0() {
        if (!this.f7620m) {
            j(false);
            this.f7620m = true;
        }
        return this.f7618k.E0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase H0() {
        if (!this.f7620m) {
            j(true);
            this.f7620m = true;
        }
        return this.f7618k.H0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f7618k.close();
        this.f7620m = false;
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper e() {
        return this.f7618k;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f7618k.getDatabaseName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(DatabaseConfiguration databaseConfiguration) {
        this.f7619l = databaseConfiguration;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z7) {
        this.f7618k.setWriteAheadLoggingEnabled(z7);
    }
}
