package eu.bolt.client.chatdb.room.terminalmessage;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class TerminalMessagesDao_Impl extends TerminalMessagesDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f39907a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<TerminalMessageDBModel> f39908b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<TerminalMessageDBModel> f39909c;

    /* renamed from: d  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<TerminalMessageDBModel> f39910d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f39911e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f39912f;

    public TerminalMessagesDao_Impl(RoomDatabase roomDatabase) {
        this.f39907a = roomDatabase;
        this.f39908b = new EntityInsertionAdapter<TerminalMessageDBModel>(roomDatabase) { // from class: eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR REPLACE INTO `chat_terminal_messages` (`id`,`chat_id`,`message`,`status`,`date`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, TerminalMessageDBModel terminalMessageDBModel) {
                if (terminalMessageDBModel.c() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, terminalMessageDBModel.c());
                }
                if (terminalMessageDBModel.a() == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, terminalMessageDBModel.a());
                }
                if (terminalMessageDBModel.d() == null) {
                    supportSQLiteStatement.Q0(3);
                } else {
                    supportSQLiteStatement.q0(3, terminalMessageDBModel.d());
                }
                if (terminalMessageDBModel.e() == null) {
                    supportSQLiteStatement.Q0(4);
                } else {
                    supportSQLiteStatement.q0(4, terminalMessageDBModel.e());
                }
                supportSQLiteStatement.B0(5, terminalMessageDBModel.b());
            }
        };
        this.f39909c = new EntityDeletionOrUpdateAdapter<TerminalMessageDBModel>(roomDatabase) { // from class: eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM `chat_terminal_messages` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, TerminalMessageDBModel terminalMessageDBModel) {
                if (terminalMessageDBModel.c() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, terminalMessageDBModel.c());
                }
            }
        };
        this.f39910d = new EntityDeletionOrUpdateAdapter<TerminalMessageDBModel>(roomDatabase) { // from class: eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE OR ABORT `chat_terminal_messages` SET `id` = ?,`chat_id` = ?,`message` = ?,`status` = ?,`date` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, TerminalMessageDBModel terminalMessageDBModel) {
                if (terminalMessageDBModel.c() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, terminalMessageDBModel.c());
                }
                if (terminalMessageDBModel.a() == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, terminalMessageDBModel.a());
                }
                if (terminalMessageDBModel.d() == null) {
                    supportSQLiteStatement.Q0(3);
                } else {
                    supportSQLiteStatement.q0(3, terminalMessageDBModel.d());
                }
                if (terminalMessageDBModel.e() == null) {
                    supportSQLiteStatement.Q0(4);
                } else {
                    supportSQLiteStatement.q0(4, terminalMessageDBModel.e());
                }
                supportSQLiteStatement.B0(5, terminalMessageDBModel.b());
                if (terminalMessageDBModel.c() == null) {
                    supportSQLiteStatement.Q0(6);
                } else {
                    supportSQLiteStatement.q0(6, terminalMessageDBModel.c());
                }
            }
        };
        this.f39911e = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM chat_terminal_messages WHERE id = ?";
            }
        };
        this.f39912f = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM chat_terminal_messages";
            }
        };
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao
    public void a(List<String> list) {
        this.f39907a.d();
        StringBuilder b8 = StringUtil.b();
        b8.append("DELETE FROM chat_terminal_messages WHERE id IN (");
        StringUtil.a(b8, list.size());
        b8.append(")");
        SupportSQLiteStatement f8 = this.f39907a.f(b8.toString());
        int i8 = 1;
        for (String str : list) {
            if (str == null) {
                f8.Q0(i8);
            } else {
                f8.q0(i8, str);
            }
            i8++;
        }
        this.f39907a.e();
        try {
            f8.x();
            this.f39907a.E();
        } finally {
            this.f39907a.i();
        }
    }

    @Override // eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao
    public Flowable<List<TerminalMessageDBModel>> b(String str) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM chat_terminal_messages WHERE chat_id = ?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        return RxRoom.a(this.f39907a, false, new String[]{"chat_terminal_messages"}, new Callable<List<TerminalMessageDBModel>>() { // from class: eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao_Impl.11
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public List<TerminalMessageDBModel> call() throws Exception {
                String string;
                String string2;
                String string3;
                String string4;
                Cursor c8 = DBUtil.c(TerminalMessagesDao_Impl.this.f39907a, e8, false, null);
                try {
                    int e9 = CursorUtil.e(c8, Name.MARK);
                    int e10 = CursorUtil.e(c8, "chat_id");
                    int e11 = CursorUtil.e(c8, "message");
                    int e12 = CursorUtil.e(c8, "status");
                    int e13 = CursorUtil.e(c8, "date");
                    ArrayList arrayList = new ArrayList(c8.getCount());
                    while (c8.moveToNext()) {
                        TerminalMessageDBModel terminalMessageDBModel = new TerminalMessageDBModel();
                        if (c8.isNull(e9)) {
                            string = null;
                        } else {
                            string = c8.getString(e9);
                        }
                        terminalMessageDBModel.h(string);
                        if (c8.isNull(e10)) {
                            string2 = null;
                        } else {
                            string2 = c8.getString(e10);
                        }
                        terminalMessageDBModel.f(string2);
                        if (c8.isNull(e11)) {
                            string3 = null;
                        } else {
                            string3 = c8.getString(e11);
                        }
                        terminalMessageDBModel.i(string3);
                        if (c8.isNull(e12)) {
                            string4 = null;
                        } else {
                            string4 = c8.getString(e12);
                        }
                        terminalMessageDBModel.j(string4);
                        terminalMessageDBModel.g(c8.getLong(e13));
                        arrayList.add(terminalMessageDBModel);
                    }
                    return arrayList;
                } finally {
                    c8.close();
                }
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao
    public List<TerminalMessageDBModel> c(long j8) {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM chat_terminal_messages WHERE date < ?", 1);
        e8.B0(1, j8);
        this.f39907a.d();
        Cursor c8 = DBUtil.c(this.f39907a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, Name.MARK);
            int e10 = CursorUtil.e(c8, "chat_id");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "status");
            int e13 = CursorUtil.e(c8, "date");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                TerminalMessageDBModel terminalMessageDBModel = new TerminalMessageDBModel();
                if (c8.isNull(e9)) {
                    string = null;
                } else {
                    string = c8.getString(e9);
                }
                terminalMessageDBModel.h(string);
                if (c8.isNull(e10)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e10);
                }
                terminalMessageDBModel.f(string2);
                if (c8.isNull(e11)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e11);
                }
                terminalMessageDBModel.i(string3);
                if (c8.isNull(e12)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e12);
                }
                terminalMessageDBModel.j(string4);
                terminalMessageDBModel.g(c8.getLong(e13));
                arrayList.add(terminalMessageDBModel);
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao
    public Completable d(final TerminalMessageDBModel terminalMessageDBModel) {
        return Completable.v(new Callable<Void>() { // from class: eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao_Impl.6
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                TerminalMessagesDao_Impl.this.f39907a.e();
                try {
                    TerminalMessagesDao_Impl.this.f39908b.i(terminalMessageDBModel);
                    TerminalMessagesDao_Impl.this.f39907a.E();
                    return null;
                } finally {
                    TerminalMessagesDao_Impl.this.f39907a.i();
                }
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao
    public void e(TerminalMessageDBModel terminalMessageDBModel) {
        this.f39907a.d();
        this.f39907a.e();
        try {
            this.f39908b.i(terminalMessageDBModel);
            this.f39907a.E();
        } finally {
            this.f39907a.i();
        }
    }
}
