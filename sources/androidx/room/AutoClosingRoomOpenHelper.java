package androidx.room;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteCompat$Api19Impl;
import androidx.sqlite.db.SupportSQLiteCompat$Api23Impl;
import androidx.sqlite.db.SupportSQLiteCompat$Api29Impl;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final SupportSQLiteOpenHelper f7424f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final AutoClosingSupportSQLiteDatabase f7425g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final AutoCloser f7426h;

    /* loaded from: classes.dex */
    static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private final AutoCloser f7427f;

        AutoClosingSupportSQLiteDatabase(@NonNull AutoCloser autoCloser) {
            this.f7427f = autoCloser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object j(String str, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.u(str);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object k(String str, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.L(str, objArr);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean l(SupportSQLiteDatabase supportSQLiteDatabase) {
            return Boolean.valueOf(supportSQLiteDatabase.d1());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object m(SupportSQLiteDatabase supportSQLiteDatabase) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object q(int i8, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.p0(i8);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor C(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
            try {
                return new KeepAliveCursor(this.f7427f.e().C(supportSQLiteQuery, cancellationSignal), this.f7427f);
            } catch (Throwable th) {
                this.f7427f.b();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor J0(String str) {
            try {
                return new KeepAliveCursor(this.f7427f.e().J0(str), this.f7427f);
            } catch (Throwable th) {
                this.f7427f.b();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void K() {
            SupportSQLiteDatabase d8 = this.f7427f.d();
            if (d8 != null) {
                d8.K();
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void L(final String str, final Object[] objArr) throws SQLException {
            this.f7427f.c(new Function() { // from class: androidx.room.f
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object k8;
                    k8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.k(str, objArr, (SupportSQLiteDatabase) obj);
                    return k8;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void M() {
            try {
                this.f7427f.e().M();
            } catch (Throwable th) {
                this.f7427f.b();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void S() {
            if (this.f7427f.d() != null) {
                try {
                    this.f7427f.d().S();
                    return;
                } finally {
                    this.f7427f.b();
                }
            }
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean T0() {
            if (this.f7427f.d() == null) {
                return false;
            }
            return ((Boolean) this.f7427f.c(new Function() { // from class: androidx.room.a
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).T0());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor a0(SupportSQLiteQuery supportSQLiteQuery) {
            try {
                return new KeepAliveCursor(this.f7427f.e().a0(supportSQLiteQuery), this.f7427f);
            } catch (Throwable th) {
                this.f7427f.b();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f7427f.a();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean d1() {
            return ((Boolean) this.f7427f.c(new Function() { // from class: androidx.room.h
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean l8;
                    l8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.l((SupportSQLiteDatabase) obj);
                    return l8;
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.f7427f.c(new Function() { // from class: androidx.room.g
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getPath();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase d8 = this.f7427f.d();
            if (d8 == null) {
                return false;
            }
            return d8.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void n() {
            try {
                this.f7427f.e().n();
            } catch (Throwable th) {
                this.f7427f.b();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void p0(final int i8) {
            this.f7427f.c(new Function() { // from class: androidx.room.e
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object q8;
                    q8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.q(i8, (SupportSQLiteDatabase) obj);
                    return q8;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List<Pair<String, String>> r() {
            return (List) this.f7427f.c(new Function() { // from class: androidx.room.b
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).r();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement r0(String str) {
            return new AutoClosingSupportSqliteStatement(str, this.f7427f);
        }

        void t() {
            this.f7427f.c(new Function() { // from class: androidx.room.c
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object m8;
                    m8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.m((SupportSQLiteDatabase) obj);
                    return m8;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void u(final String str) throws SQLException {
            this.f7427f.c(new Function() { // from class: androidx.room.d
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object j8;
                    j8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.j(str, (SupportSQLiteDatabase) obj);
                    return j8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {

        /* renamed from: f  reason: collision with root package name */
        private final String f7428f;

        /* renamed from: g  reason: collision with root package name */
        private final ArrayList<Object> f7429g = new ArrayList<>();

        /* renamed from: h  reason: collision with root package name */
        private final AutoCloser f7430h;

        AutoClosingSupportSqliteStatement(String str, AutoCloser autoCloser) {
            this.f7428f = str;
            this.f7430h = autoCloser;
        }

        private void c(SupportSQLiteStatement supportSQLiteStatement) {
            int i8 = 0;
            while (i8 < this.f7429g.size()) {
                int i9 = i8 + 1;
                Object obj = this.f7429g.get(i8);
                if (obj == null) {
                    supportSQLiteStatement.Q0(i9);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.B0(i9, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.z(i9, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.q0(i9, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.F0(i9, (byte[]) obj);
                }
                i8 = i9;
            }
        }

        private <T> T e(final Function<SupportSQLiteStatement, T> function) {
            return (T) this.f7430h.c(new Function() { // from class: androidx.room.k
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object g8;
                    g8 = AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.this.g(function, (SupportSQLiteDatabase) obj);
                    return g8;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object g(Function function, SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteStatement r02 = supportSQLiteDatabase.r0(this.f7428f);
            c(r02);
            return function.apply(r02);
        }

        private void h(int i8, Object obj) {
            int i9 = i8 - 1;
            if (i9 >= this.f7429g.size()) {
                for (int size = this.f7429g.size(); size <= i9; size++) {
                    this.f7429g.add(null);
                }
            }
            this.f7429g.set(i9, obj);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void B0(int i8, long j8) {
            h(i8, Long.valueOf(j8));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void F0(int i8, byte[] bArr) {
            h(i8, bArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void Q0(int i8) {
            h(i8, null);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long m0() {
            return ((Long) e(new Function() { // from class: androidx.room.j
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).m0());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void q0(int i8, String str) {
            h(i8, str);
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int x() {
            return ((Integer) e(new Function() { // from class: androidx.room.i
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteStatement) obj).x());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void z(int i8, double d8) {
            h(i8, Double.valueOf(d8));
        }
    }

    /* loaded from: classes.dex */
    private static final class KeepAliveCursor implements Cursor {

        /* renamed from: f  reason: collision with root package name */
        private final Cursor f7431f;

        /* renamed from: g  reason: collision with root package name */
        private final AutoCloser f7432g;

        KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
            this.f7431f = cursor;
            this.f7432g = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f7431f.close();
            this.f7432g.b();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i8, CharArrayBuffer charArrayBuffer) {
            this.f7431f.copyStringToBuffer(i8, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.f7431f.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i8) {
            return this.f7431f.getBlob(i8);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f7431f.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f7431f.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            return this.f7431f.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i8) {
            return this.f7431f.getColumnName(i8);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f7431f.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f7431f.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i8) {
            return this.f7431f.getDouble(i8);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f7431f.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i8) {
            return this.f7431f.getFloat(i8);
        }

        @Override // android.database.Cursor
        public int getInt(int i8) {
            return this.f7431f.getInt(i8);
        }

        @Override // android.database.Cursor
        public long getLong(int i8) {
            return this.f7431f.getLong(i8);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return SupportSQLiteCompat$Api19Impl.a(this.f7431f);
        }

        @Override // android.database.Cursor
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat$Api29Impl.a(this.f7431f);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f7431f.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i8) {
            return this.f7431f.getShort(i8);
        }

        @Override // android.database.Cursor
        public String getString(int i8) {
            return this.f7431f.getString(i8);
        }

        @Override // android.database.Cursor
        public int getType(int i8) {
            return this.f7431f.getType(i8);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f7431f.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f7431f.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f7431f.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f7431f.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f7431f.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f7431f.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i8) {
            return this.f7431f.isNull(i8);
        }

        @Override // android.database.Cursor
        public boolean move(int i8) {
            return this.f7431f.move(i8);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f7431f.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f7431f.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f7431f.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i8) {
            return this.f7431f.moveToPosition(i8);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f7431f.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f7431f.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f7431f.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.f7431f.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f7431f.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            SupportSQLiteCompat$Api23Impl.a(this.f7431f, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f7431f.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(@NonNull ContentResolver contentResolver, @NonNull List<Uri> list) {
            SupportSQLiteCompat$Api29Impl.b(this.f7431f, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f7431f.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f7431f.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoClosingRoomOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull AutoCloser autoCloser) {
        this.f7424f = supportSQLiteOpenHelper;
        this.f7426h = autoCloser;
        autoCloser.f(supportSQLiteOpenHelper);
        this.f7425g = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    public SupportSQLiteDatabase E0() {
        this.f7425g.t();
        return this.f7425g;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    public SupportSQLiteDatabase H0() {
        this.f7425g.t();
        return this.f7425g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AutoCloser a() {
        return this.f7426h;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f7425g.close();
        } catch (IOException e8) {
            SneakyThrow.a(e8);
        }
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper e() {
        return this.f7424f;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f7424f.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z7) {
        this.f7424f.setWriteAheadLoggingEnabled(z7);
    }
}
