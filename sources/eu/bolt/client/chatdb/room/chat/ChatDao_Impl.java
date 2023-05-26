package eu.bolt.client.chatdb.room.chat;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ChatDao_Impl extends ChatDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f39798a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<ChatDBModel> f39799b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<ChatDBModel> f39800c;

    /* renamed from: d  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<ChatDBModel> f39801d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f39802e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f39803f;

    public ChatDao_Impl(RoomDatabase roomDatabase) {
        this.f39798a = roomDatabase;
        this.f39799b = new EntityInsertionAdapter<ChatDBModel>(roomDatabase) { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR REPLACE INTO `chat` (`id`,`title`,`description`,`thumbnail_url`,`start_date`,`order_handle_order_id`,`order_handle_order_system`,`order_handle_city_id`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, ChatDBModel chatDBModel) {
                if (chatDBModel.b() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, chatDBModel.b());
                }
                if (chatDBModel.f() == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, chatDBModel.f());
                }
                if (chatDBModel.a() == null) {
                    supportSQLiteStatement.Q0(3);
                } else {
                    supportSQLiteStatement.q0(3, chatDBModel.a());
                }
                if (chatDBModel.e() == null) {
                    supportSQLiteStatement.Q0(4);
                } else {
                    supportSQLiteStatement.q0(4, chatDBModel.e());
                }
                supportSQLiteStatement.B0(5, chatDBModel.d());
                OrderHandleDbModel c8 = chatDBModel.c();
                if (c8 != null) {
                    supportSQLiteStatement.B0(6, c8.b());
                    if (c8.c() == null) {
                        supportSQLiteStatement.Q0(7);
                    } else {
                        supportSQLiteStatement.q0(7, c8.c());
                    }
                    if (c8.a() == null) {
                        supportSQLiteStatement.Q0(8);
                        return;
                    } else {
                        supportSQLiteStatement.B0(8, c8.a().longValue());
                        return;
                    }
                }
                supportSQLiteStatement.Q0(6);
                supportSQLiteStatement.Q0(7);
                supportSQLiteStatement.Q0(8);
            }
        };
        this.f39800c = new EntityDeletionOrUpdateAdapter<ChatDBModel>(roomDatabase) { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM `chat` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, ChatDBModel chatDBModel) {
                if (chatDBModel.b() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, chatDBModel.b());
                }
            }
        };
        this.f39801d = new EntityDeletionOrUpdateAdapter<ChatDBModel>(roomDatabase) { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE OR ABORT `chat` SET `id` = ?,`title` = ?,`description` = ?,`thumbnail_url` = ?,`start_date` = ?,`order_handle_order_id` = ?,`order_handle_order_system` = ?,`order_handle_city_id` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, ChatDBModel chatDBModel) {
                if (chatDBModel.b() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, chatDBModel.b());
                }
                if (chatDBModel.f() == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, chatDBModel.f());
                }
                if (chatDBModel.a() == null) {
                    supportSQLiteStatement.Q0(3);
                } else {
                    supportSQLiteStatement.q0(3, chatDBModel.a());
                }
                if (chatDBModel.e() == null) {
                    supportSQLiteStatement.Q0(4);
                } else {
                    supportSQLiteStatement.q0(4, chatDBModel.e());
                }
                supportSQLiteStatement.B0(5, chatDBModel.d());
                OrderHandleDbModel c8 = chatDBModel.c();
                if (c8 != null) {
                    supportSQLiteStatement.B0(6, c8.b());
                    if (c8.c() == null) {
                        supportSQLiteStatement.Q0(7);
                    } else {
                        supportSQLiteStatement.q0(7, c8.c());
                    }
                    if (c8.a() == null) {
                        supportSQLiteStatement.Q0(8);
                    } else {
                        supportSQLiteStatement.B0(8, c8.a().longValue());
                    }
                } else {
                    supportSQLiteStatement.Q0(6);
                    supportSQLiteStatement.Q0(7);
                    supportSQLiteStatement.Q0(8);
                }
                if (chatDBModel.b() == null) {
                    supportSQLiteStatement.Q0(9);
                } else {
                    supportSQLiteStatement.q0(9, chatDBModel.b());
                }
            }
        };
        this.f39802e = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM chat WHERE id = ?";
            }
        };
        this.f39803f = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM chat";
            }
        };
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    @Override // eu.bolt.client.chatdb.room.chat.ChatDao
    public void a(List<String> list) {
        this.f39798a.d();
        StringBuilder b8 = StringUtil.b();
        b8.append("DELETE FROM chat WHERE id IN (");
        StringUtil.a(b8, list.size());
        b8.append(")");
        SupportSQLiteStatement f8 = this.f39798a.f(b8.toString());
        int i8 = 1;
        for (String str : list) {
            if (str == null) {
                f8.Q0(i8);
            } else {
                f8.q0(i8, str);
            }
            i8++;
        }
        this.f39798a.e();
        try {
            f8.x();
            this.f39798a.E();
        } finally {
            this.f39798a.i();
        }
    }

    @Override // eu.bolt.client.chatdb.room.chat.ChatDao
    public Maybe<List<ChatDBModel>> b() {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT `order_handle_order_id`, `order_handle_order_system`, `order_handle_city_id`, `chat`.`id` AS `id`, `chat`.`title` AS `title`, `chat`.`description` AS `description`, `chat`.`thumbnail_url` AS `thumbnail_url`, `chat`.`start_date` AS `start_date` FROM chat WHERE id NOT IN (SELECT chat_id FROM chat_terminal_messages)", 0);
        return Maybe.e(new Callable<List<ChatDBModel>>() { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.16
            /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0067 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:23:0x0059, B:27:0x006b, B:31:0x007b, B:35:0x008b, B:39:0x009b, B:38:0x0097, B:34:0x0087, B:30:0x0077, B:26:0x0067, B:14:0x0034, B:18:0x0044, B:22:0x0054, B:21:0x004c, B:17:0x0040), top: B:46:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:23:0x0059, B:27:0x006b, B:31:0x007b, B:35:0x008b, B:39:0x009b, B:38:0x0097, B:34:0x0087, B:30:0x0077, B:26:0x0067, B:14:0x0034, B:18:0x0044, B:22:0x0054, B:21:0x004c, B:17:0x0040), top: B:46:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0087 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:23:0x0059, B:27:0x006b, B:31:0x007b, B:35:0x008b, B:39:0x009b, B:38:0x0097, B:34:0x0087, B:30:0x0077, B:26:0x0067, B:14:0x0034, B:18:0x0044, B:22:0x0054, B:21:0x004c, B:17:0x0040), top: B:46:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0097 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:23:0x0059, B:27:0x006b, B:31:0x007b, B:35:0x008b, B:39:0x009b, B:38:0x0097, B:34:0x0087, B:30:0x0077, B:26:0x0067, B:14:0x0034, B:18:0x0044, B:22:0x0054, B:21:0x004c, B:17:0x0040), top: B:46:0x000e }] */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<eu.bolt.client.chatdb.room.chat.ChatDBModel> call() throws java.lang.Exception {
                /*
                    r9 = this;
                    eu.bolt.client.chatdb.room.chat.ChatDao_Impl r0 = eu.bolt.client.chatdb.room.chat.ChatDao_Impl.this
                    androidx.room.RoomDatabase r0 = eu.bolt.client.chatdb.room.chat.ChatDao_Impl.h(r0)
                    androidx.room.RoomSQLiteQuery r1 = r2
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.c(r0, r1, r2, r3)
                    java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb2
                    int r4 = r0.getCount()     // Catch: java.lang.Throwable -> Lb2
                    r1.<init>(r4)     // Catch: java.lang.Throwable -> Lb2
                L17:
                    boolean r4 = r0.moveToNext()     // Catch: java.lang.Throwable -> Lb2
                    if (r4 == 0) goto Lae
                    boolean r4 = r0.isNull(r2)     // Catch: java.lang.Throwable -> Lb2
                    r5 = 2
                    r6 = 1
                    if (r4 == 0) goto L34
                    boolean r4 = r0.isNull(r6)     // Catch: java.lang.Throwable -> Lb2
                    if (r4 == 0) goto L34
                    boolean r4 = r0.isNull(r5)     // Catch: java.lang.Throwable -> Lb2
                    if (r4 != 0) goto L32
                    goto L34
                L32:
                    r6 = r3
                    goto L59
                L34:
                    long r7 = r0.getLong(r2)     // Catch: java.lang.Throwable -> Lb2
                    boolean r4 = r0.isNull(r6)     // Catch: java.lang.Throwable -> Lb2
                    if (r4 == 0) goto L40
                    r4 = r3
                    goto L44
                L40:
                    java.lang.String r4 = r0.getString(r6)     // Catch: java.lang.Throwable -> Lb2
                L44:
                    boolean r6 = r0.isNull(r5)     // Catch: java.lang.Throwable -> Lb2
                    if (r6 == 0) goto L4c
                    r5 = r3
                    goto L54
                L4c:
                    long r5 = r0.getLong(r5)     // Catch: java.lang.Throwable -> Lb2
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lb2
                L54:
                    eu.bolt.client.chatdb.room.chat.OrderHandleDbModel r6 = new eu.bolt.client.chatdb.room.chat.OrderHandleDbModel     // Catch: java.lang.Throwable -> Lb2
                    r6.<init>(r7, r4, r5)     // Catch: java.lang.Throwable -> Lb2
                L59:
                    eu.bolt.client.chatdb.room.chat.ChatDBModel r4 = new eu.bolt.client.chatdb.room.chat.ChatDBModel     // Catch: java.lang.Throwable -> Lb2
                    r4.<init>()     // Catch: java.lang.Throwable -> Lb2
                    r5 = 3
                    boolean r7 = r0.isNull(r5)     // Catch: java.lang.Throwable -> Lb2
                    if (r7 == 0) goto L67
                    r5 = r3
                    goto L6b
                L67:
                    java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Throwable -> Lb2
                L6b:
                    r4.h(r5)     // Catch: java.lang.Throwable -> Lb2
                    r5 = 4
                    boolean r7 = r0.isNull(r5)     // Catch: java.lang.Throwable -> Lb2
                    if (r7 == 0) goto L77
                    r5 = r3
                    goto L7b
                L77:
                    java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Throwable -> Lb2
                L7b:
                    r4.l(r5)     // Catch: java.lang.Throwable -> Lb2
                    r5 = 5
                    boolean r7 = r0.isNull(r5)     // Catch: java.lang.Throwable -> Lb2
                    if (r7 == 0) goto L87
                    r5 = r3
                    goto L8b
                L87:
                    java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Throwable -> Lb2
                L8b:
                    r4.g(r5)     // Catch: java.lang.Throwable -> Lb2
                    r5 = 6
                    boolean r7 = r0.isNull(r5)     // Catch: java.lang.Throwable -> Lb2
                    if (r7 == 0) goto L97
                    r5 = r3
                    goto L9b
                L97:
                    java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Throwable -> Lb2
                L9b:
                    r4.k(r5)     // Catch: java.lang.Throwable -> Lb2
                    r5 = 7
                    long r7 = r0.getLong(r5)     // Catch: java.lang.Throwable -> Lb2
                    r4.j(r7)     // Catch: java.lang.Throwable -> Lb2
                    r4.i(r6)     // Catch: java.lang.Throwable -> Lb2
                    r1.add(r4)     // Catch: java.lang.Throwable -> Lb2
                    goto L17
                Lae:
                    r0.close()
                    return r1
                Lb2:
                    r1 = move-exception
                    r0.close()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.AnonymousClass16.call():java.util.List");
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.chat.ChatDao
    public Maybe<ChatDBModel> c(String str) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM chat WHERE id =?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        return Maybe.e(new Callable<ChatDBModel>() { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.13
            /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x008b A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:3:0x000e, B:5:0x0044, B:7:0x004a, B:9:0x0050, B:22:0x007e, B:26:0x008f, B:30:0x009e, B:34:0x00ad, B:38:0x00bb, B:37:0x00b7, B:33:0x00a9, B:29:0x009a, B:25:0x008b, B:13:0x0059, B:17:0x0069, B:21:0x0079, B:20:0x0071, B:16:0x0065), top: B:45:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x009a A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:3:0x000e, B:5:0x0044, B:7:0x004a, B:9:0x0050, B:22:0x007e, B:26:0x008f, B:30:0x009e, B:34:0x00ad, B:38:0x00bb, B:37:0x00b7, B:33:0x00a9, B:29:0x009a, B:25:0x008b, B:13:0x0059, B:17:0x0069, B:21:0x0079, B:20:0x0071, B:16:0x0065), top: B:45:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00a7  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00a9 A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:3:0x000e, B:5:0x0044, B:7:0x004a, B:9:0x0050, B:22:0x007e, B:26:0x008f, B:30:0x009e, B:34:0x00ad, B:38:0x00bb, B:37:0x00b7, B:33:0x00a9, B:29:0x009a, B:25:0x008b, B:13:0x0059, B:17:0x0069, B:21:0x0079, B:20:0x0071, B:16:0x0065), top: B:45:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00b7 A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:3:0x000e, B:5:0x0044, B:7:0x004a, B:9:0x0050, B:22:0x007e, B:26:0x008f, B:30:0x009e, B:34:0x00ad, B:38:0x00bb, B:37:0x00b7, B:33:0x00a9, B:29:0x009a, B:25:0x008b, B:13:0x0059, B:17:0x0069, B:21:0x0079, B:20:0x0071, B:16:0x0065), top: B:45:0x000e }] */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public eu.bolt.client.chatdb.room.chat.ChatDBModel call() throws java.lang.Exception {
                /*
                    r12 = this;
                    eu.bolt.client.chatdb.room.chat.ChatDao_Impl r0 = eu.bolt.client.chatdb.room.chat.ChatDao_Impl.this
                    androidx.room.RoomDatabase r0 = eu.bolt.client.chatdb.room.chat.ChatDao_Impl.h(r0)
                    androidx.room.RoomSQLiteQuery r1 = r2
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.c(r0, r1, r2, r3)
                    java.lang.String r1 = "id"
                    int r1 = androidx.room.util.CursorUtil.e(r0, r1)     // Catch: java.lang.Throwable -> Lcd
                    java.lang.String r2 = "title"
                    int r2 = androidx.room.util.CursorUtil.e(r0, r2)     // Catch: java.lang.Throwable -> Lcd
                    java.lang.String r4 = "description"
                    int r4 = androidx.room.util.CursorUtil.e(r0, r4)     // Catch: java.lang.Throwable -> Lcd
                    java.lang.String r5 = "thumbnail_url"
                    int r5 = androidx.room.util.CursorUtil.e(r0, r5)     // Catch: java.lang.Throwable -> Lcd
                    java.lang.String r6 = "start_date"
                    int r6 = androidx.room.util.CursorUtil.e(r0, r6)     // Catch: java.lang.Throwable -> Lcd
                    java.lang.String r7 = "order_handle_order_id"
                    int r7 = androidx.room.util.CursorUtil.e(r0, r7)     // Catch: java.lang.Throwable -> Lcd
                    java.lang.String r8 = "order_handle_order_system"
                    int r8 = androidx.room.util.CursorUtil.e(r0, r8)     // Catch: java.lang.Throwable -> Lcd
                    java.lang.String r9 = "order_handle_city_id"
                    int r9 = androidx.room.util.CursorUtil.e(r0, r9)     // Catch: java.lang.Throwable -> Lcd
                    boolean r10 = r0.moveToFirst()     // Catch: java.lang.Throwable -> Lcd
                    if (r10 == 0) goto Lc9
                    boolean r10 = r0.isNull(r7)     // Catch: java.lang.Throwable -> Lcd
                    if (r10 == 0) goto L59
                    boolean r10 = r0.isNull(r8)     // Catch: java.lang.Throwable -> Lcd
                    if (r10 == 0) goto L59
                    boolean r10 = r0.isNull(r9)     // Catch: java.lang.Throwable -> Lcd
                    if (r10 != 0) goto L57
                    goto L59
                L57:
                    r9 = r3
                    goto L7e
                L59:
                    long r10 = r0.getLong(r7)     // Catch: java.lang.Throwable -> Lcd
                    boolean r7 = r0.isNull(r8)     // Catch: java.lang.Throwable -> Lcd
                    if (r7 == 0) goto L65
                    r7 = r3
                    goto L69
                L65:
                    java.lang.String r7 = r0.getString(r8)     // Catch: java.lang.Throwable -> Lcd
                L69:
                    boolean r8 = r0.isNull(r9)     // Catch: java.lang.Throwable -> Lcd
                    if (r8 == 0) goto L71
                    r8 = r3
                    goto L79
                L71:
                    long r8 = r0.getLong(r9)     // Catch: java.lang.Throwable -> Lcd
                    java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> Lcd
                L79:
                    eu.bolt.client.chatdb.room.chat.OrderHandleDbModel r9 = new eu.bolt.client.chatdb.room.chat.OrderHandleDbModel     // Catch: java.lang.Throwable -> Lcd
                    r9.<init>(r10, r7, r8)     // Catch: java.lang.Throwable -> Lcd
                L7e:
                    eu.bolt.client.chatdb.room.chat.ChatDBModel r7 = new eu.bolt.client.chatdb.room.chat.ChatDBModel     // Catch: java.lang.Throwable -> Lcd
                    r7.<init>()     // Catch: java.lang.Throwable -> Lcd
                    boolean r8 = r0.isNull(r1)     // Catch: java.lang.Throwable -> Lcd
                    if (r8 == 0) goto L8b
                    r1 = r3
                    goto L8f
                L8b:
                    java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> Lcd
                L8f:
                    r7.h(r1)     // Catch: java.lang.Throwable -> Lcd
                    boolean r1 = r0.isNull(r2)     // Catch: java.lang.Throwable -> Lcd
                    if (r1 == 0) goto L9a
                    r1 = r3
                    goto L9e
                L9a:
                    java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> Lcd
                L9e:
                    r7.l(r1)     // Catch: java.lang.Throwable -> Lcd
                    boolean r1 = r0.isNull(r4)     // Catch: java.lang.Throwable -> Lcd
                    if (r1 == 0) goto La9
                    r1 = r3
                    goto Lad
                La9:
                    java.lang.String r1 = r0.getString(r4)     // Catch: java.lang.Throwable -> Lcd
                Lad:
                    r7.g(r1)     // Catch: java.lang.Throwable -> Lcd
                    boolean r1 = r0.isNull(r5)     // Catch: java.lang.Throwable -> Lcd
                    if (r1 == 0) goto Lb7
                    goto Lbb
                Lb7:
                    java.lang.String r3 = r0.getString(r5)     // Catch: java.lang.Throwable -> Lcd
                Lbb:
                    r7.k(r3)     // Catch: java.lang.Throwable -> Lcd
                    long r1 = r0.getLong(r6)     // Catch: java.lang.Throwable -> Lcd
                    r7.j(r1)     // Catch: java.lang.Throwable -> Lcd
                    r7.i(r9)     // Catch: java.lang.Throwable -> Lcd
                    r3 = r7
                Lc9:
                    r0.close()
                    return r3
                Lcd:
                    r1 = move-exception
                    r0.close()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.AnonymousClass13.call():eu.bolt.client.chatdb.room.chat.ChatDBModel");
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.chat.ChatDao
    public Maybe<ChatDBModel> d() {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT `order_handle_order_id`, `order_handle_order_system`, `order_handle_city_id`, `chat`.`id` AS `id`, `chat`.`title` AS `title`, `chat`.`description` AS `description`, `chat`.`thumbnail_url` AS `thumbnail_url`, `chat`.`start_date` AS `start_date` FROM chat WHERE id NOT IN (SELECT chat_id FROM chat_terminal_messages) ORDER BY start_date DESC LIMIT 1", 0);
        return Maybe.e(new Callable<ChatDBModel>() { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.15
            /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x005e A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x000e, B:5:0x0014, B:7:0x001c, B:9:0x0022, B:22:0x0050, B:26:0x0062, B:30:0x0072, B:34:0x0082, B:38:0x0091, B:37:0x008d, B:33:0x007e, B:29:0x006e, B:25:0x005e, B:13:0x002b, B:17:0x003b, B:21:0x004b, B:20:0x0043, B:16:0x0037), top: B:45:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x000e, B:5:0x0014, B:7:0x001c, B:9:0x0022, B:22:0x0050, B:26:0x0062, B:30:0x0072, B:34:0x0082, B:38:0x0091, B:37:0x008d, B:33:0x007e, B:29:0x006e, B:25:0x005e, B:13:0x002b, B:17:0x003b, B:21:0x004b, B:20:0x0043, B:16:0x0037), top: B:45:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x007e A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x000e, B:5:0x0014, B:7:0x001c, B:9:0x0022, B:22:0x0050, B:26:0x0062, B:30:0x0072, B:34:0x0082, B:38:0x0091, B:37:0x008d, B:33:0x007e, B:29:0x006e, B:25:0x005e, B:13:0x002b, B:17:0x003b, B:21:0x004b, B:20:0x0043, B:16:0x0037), top: B:45:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x008d A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x000e, B:5:0x0014, B:7:0x001c, B:9:0x0022, B:22:0x0050, B:26:0x0062, B:30:0x0072, B:34:0x0082, B:38:0x0091, B:37:0x008d, B:33:0x007e, B:29:0x006e, B:25:0x005e, B:13:0x002b, B:17:0x003b, B:21:0x004b, B:20:0x0043, B:16:0x0037), top: B:45:0x000e }] */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public eu.bolt.client.chatdb.room.chat.ChatDBModel call() throws java.lang.Exception {
                /*
                    r8 = this;
                    eu.bolt.client.chatdb.room.chat.ChatDao_Impl r0 = eu.bolt.client.chatdb.room.chat.ChatDao_Impl.this
                    androidx.room.RoomDatabase r0 = eu.bolt.client.chatdb.room.chat.ChatDao_Impl.h(r0)
                    androidx.room.RoomSQLiteQuery r1 = r2
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.c(r0, r1, r2, r3)
                    boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> La4
                    if (r1 == 0) goto La0
                    boolean r1 = r0.isNull(r2)     // Catch: java.lang.Throwable -> La4
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L2b
                    boolean r1 = r0.isNull(r5)     // Catch: java.lang.Throwable -> La4
                    if (r1 == 0) goto L2b
                    boolean r1 = r0.isNull(r4)     // Catch: java.lang.Throwable -> La4
                    if (r1 != 0) goto L29
                    goto L2b
                L29:
                    r6 = r3
                    goto L50
                L2b:
                    long r1 = r0.getLong(r2)     // Catch: java.lang.Throwable -> La4
                    boolean r6 = r0.isNull(r5)     // Catch: java.lang.Throwable -> La4
                    if (r6 == 0) goto L37
                    r5 = r3
                    goto L3b
                L37:
                    java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Throwable -> La4
                L3b:
                    boolean r6 = r0.isNull(r4)     // Catch: java.lang.Throwable -> La4
                    if (r6 == 0) goto L43
                    r4 = r3
                    goto L4b
                L43:
                    long r6 = r0.getLong(r4)     // Catch: java.lang.Throwable -> La4
                    java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> La4
                L4b:
                    eu.bolt.client.chatdb.room.chat.OrderHandleDbModel r6 = new eu.bolt.client.chatdb.room.chat.OrderHandleDbModel     // Catch: java.lang.Throwable -> La4
                    r6.<init>(r1, r5, r4)     // Catch: java.lang.Throwable -> La4
                L50:
                    eu.bolt.client.chatdb.room.chat.ChatDBModel r1 = new eu.bolt.client.chatdb.room.chat.ChatDBModel     // Catch: java.lang.Throwable -> La4
                    r1.<init>()     // Catch: java.lang.Throwable -> La4
                    r2 = 3
                    boolean r4 = r0.isNull(r2)     // Catch: java.lang.Throwable -> La4
                    if (r4 == 0) goto L5e
                    r2 = r3
                    goto L62
                L5e:
                    java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> La4
                L62:
                    r1.h(r2)     // Catch: java.lang.Throwable -> La4
                    r2 = 4
                    boolean r4 = r0.isNull(r2)     // Catch: java.lang.Throwable -> La4
                    if (r4 == 0) goto L6e
                    r2 = r3
                    goto L72
                L6e:
                    java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> La4
                L72:
                    r1.l(r2)     // Catch: java.lang.Throwable -> La4
                    r2 = 5
                    boolean r4 = r0.isNull(r2)     // Catch: java.lang.Throwable -> La4
                    if (r4 == 0) goto L7e
                    r2 = r3
                    goto L82
                L7e:
                    java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> La4
                L82:
                    r1.g(r2)     // Catch: java.lang.Throwable -> La4
                    r2 = 6
                    boolean r4 = r0.isNull(r2)     // Catch: java.lang.Throwable -> La4
                    if (r4 == 0) goto L8d
                    goto L91
                L8d:
                    java.lang.String r3 = r0.getString(r2)     // Catch: java.lang.Throwable -> La4
                L91:
                    r1.k(r3)     // Catch: java.lang.Throwable -> La4
                    r2 = 7
                    long r2 = r0.getLong(r2)     // Catch: java.lang.Throwable -> La4
                    r1.j(r2)     // Catch: java.lang.Throwable -> La4
                    r1.i(r6)     // Catch: java.lang.Throwable -> La4
                    r3 = r1
                La0:
                    r0.close()
                    return r3
                La4:
                    r1 = move-exception
                    r0.close()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.AnonymousClass15.call():eu.bolt.client.chatdb.room.chat.ChatDBModel");
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.chat.ChatDao
    public Completable e(final ChatDBModel chatDBModel) {
        return Completable.v(new Callable<Void>() { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.6
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                ChatDao_Impl.this.f39798a.e();
                try {
                    ChatDao_Impl.this.f39799b.i(chatDBModel);
                    ChatDao_Impl.this.f39798a.E();
                    return null;
                } finally {
                    ChatDao_Impl.this.f39798a.i();
                }
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.chat.ChatDao
    public void f(ChatDBModel chatDBModel) {
        this.f39798a.d();
        this.f39798a.e();
        try {
            this.f39799b.i(chatDBModel);
            this.f39798a.E();
        } finally {
            this.f39798a.i();
        }
    }

    @Override // eu.bolt.client.chatdb.room.chat.ChatDao
    public Observable<List<ChatDBModel>> g(long j8, String str, Long l8) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("\n        SELECT * FROM chat \n        WHERE order_handle_order_id = ?  \n        AND (order_handle_order_system = ? OR (order_handle_order_system IS NULL AND ? IS NULL)) \n        AND (order_handle_city_id = ? OR (order_handle_city_id IS NULL AND ? IS NULL))\n        AND id NOT IN (SELECT chat_id FROM chat_terminal_messages GROUP BY chat_id)\n        ORDER BY start_date DESC\n        LIMIT 1\n        ", 5);
        e8.B0(1, j8);
        if (str == null) {
            e8.Q0(2);
        } else {
            e8.q0(2, str);
        }
        if (str == null) {
            e8.Q0(3);
        } else {
            e8.q0(3, str);
        }
        if (l8 == null) {
            e8.Q0(4);
        } else {
            e8.B0(4, l8.longValue());
        }
        if (l8 == null) {
            e8.Q0(5);
        } else {
            e8.B0(5, l8.longValue());
        }
        return RxRoom.c(this.f39798a, false, new String[]{"chat", "chat_terminal_messages"}, new Callable<List<ChatDBModel>>() { // from class: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.14
            /* JADX WARN: Code restructure failed: missing block: B:11:0x005f, code lost:
                if (r2.isNull(r10) == false) goto L30;
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<eu.bolt.client.chatdb.room.chat.ChatDBModel> call() throws java.lang.Exception {
                /*
                    r17 = this;
                    r1 = r17
                    eu.bolt.client.chatdb.room.chat.ChatDao_Impl r0 = eu.bolt.client.chatdb.room.chat.ChatDao_Impl.this
                    androidx.room.RoomDatabase r0 = eu.bolt.client.chatdb.room.chat.ChatDao_Impl.h(r0)
                    androidx.room.RoomSQLiteQuery r2 = r2
                    r3 = 0
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.c(r0, r2, r3, r4)
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.e(r2, r0)     // Catch: java.lang.Throwable -> Ldb
                    java.lang.String r3 = "title"
                    int r3 = androidx.room.util.CursorUtil.e(r2, r3)     // Catch: java.lang.Throwable -> Ldb
                    java.lang.String r5 = "description"
                    int r5 = androidx.room.util.CursorUtil.e(r2, r5)     // Catch: java.lang.Throwable -> Ldb
                    java.lang.String r6 = "thumbnail_url"
                    int r6 = androidx.room.util.CursorUtil.e(r2, r6)     // Catch: java.lang.Throwable -> Ldb
                    java.lang.String r7 = "start_date"
                    int r7 = androidx.room.util.CursorUtil.e(r2, r7)     // Catch: java.lang.Throwable -> Ldb
                    java.lang.String r8 = "order_handle_order_id"
                    int r8 = androidx.room.util.CursorUtil.e(r2, r8)     // Catch: java.lang.Throwable -> Ldb
                    java.lang.String r9 = "order_handle_order_system"
                    int r9 = androidx.room.util.CursorUtil.e(r2, r9)     // Catch: java.lang.Throwable -> Ldb
                    java.lang.String r10 = "order_handle_city_id"
                    int r10 = androidx.room.util.CursorUtil.e(r2, r10)     // Catch: java.lang.Throwable -> Ldb
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ldb
                    int r12 = r2.getCount()     // Catch: java.lang.Throwable -> Ldb
                    r11.<init>(r12)     // Catch: java.lang.Throwable -> Ldb
                L49:
                    boolean r12 = r2.moveToNext()     // Catch: java.lang.Throwable -> Ldb
                    if (r12 == 0) goto Ld7
                    boolean r12 = r2.isNull(r8)     // Catch: java.lang.Throwable -> Ldb
                    if (r12 == 0) goto L61
                    boolean r12 = r2.isNull(r9)     // Catch: java.lang.Throwable -> Ldb
                    if (r12 == 0) goto L61
                    boolean r12 = r2.isNull(r10)     // Catch: java.lang.Throwable -> Ldb
                    if (r12 != 0) goto L86
                L61:
                    long r12 = r2.getLong(r8)     // Catch: java.lang.Throwable -> Ldb
                    boolean r14 = r2.isNull(r9)     // Catch: java.lang.Throwable -> Ldb
                    if (r14 == 0) goto L6d
                    r14 = r4
                    goto L71
                L6d:
                    java.lang.String r14 = r2.getString(r9)     // Catch: java.lang.Throwable -> Ldb
                L71:
                    boolean r15 = r2.isNull(r10)     // Catch: java.lang.Throwable -> Ldb
                    if (r15 == 0) goto L79
                    r15 = r4
                    goto L81
                L79:
                    long r15 = r2.getLong(r10)     // Catch: java.lang.Throwable -> Ldb
                    java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch: java.lang.Throwable -> Ldb
                L81:
                    eu.bolt.client.chatdb.room.chat.OrderHandleDbModel r4 = new eu.bolt.client.chatdb.room.chat.OrderHandleDbModel     // Catch: java.lang.Throwable -> Ldb
                    r4.<init>(r12, r14, r15)     // Catch: java.lang.Throwable -> Ldb
                L86:
                    eu.bolt.client.chatdb.room.chat.ChatDBModel r12 = new eu.bolt.client.chatdb.room.chat.ChatDBModel     // Catch: java.lang.Throwable -> Ldb
                    r12.<init>()     // Catch: java.lang.Throwable -> Ldb
                    boolean r13 = r2.isNull(r0)     // Catch: java.lang.Throwable -> Ldb
                    if (r13 == 0) goto L93
                    r13 = 0
                    goto L97
                L93:
                    java.lang.String r13 = r2.getString(r0)     // Catch: java.lang.Throwable -> Ldb
                L97:
                    r12.h(r13)     // Catch: java.lang.Throwable -> Ldb
                    boolean r13 = r2.isNull(r3)     // Catch: java.lang.Throwable -> Ldb
                    if (r13 == 0) goto La2
                    r13 = 0
                    goto La6
                La2:
                    java.lang.String r13 = r2.getString(r3)     // Catch: java.lang.Throwable -> Ldb
                La6:
                    r12.l(r13)     // Catch: java.lang.Throwable -> Ldb
                    boolean r13 = r2.isNull(r5)     // Catch: java.lang.Throwable -> Ldb
                    if (r13 == 0) goto Lb1
                    r13 = 0
                    goto Lb5
                Lb1:
                    java.lang.String r13 = r2.getString(r5)     // Catch: java.lang.Throwable -> Ldb
                Lb5:
                    r12.g(r13)     // Catch: java.lang.Throwable -> Ldb
                    boolean r13 = r2.isNull(r6)     // Catch: java.lang.Throwable -> Ldb
                    if (r13 == 0) goto Lc0
                    r13 = 0
                    goto Lc4
                Lc0:
                    java.lang.String r13 = r2.getString(r6)     // Catch: java.lang.Throwable -> Ldb
                Lc4:
                    r12.k(r13)     // Catch: java.lang.Throwable -> Ldb
                    long r13 = r2.getLong(r7)     // Catch: java.lang.Throwable -> Ldb
                    r12.j(r13)     // Catch: java.lang.Throwable -> Ldb
                    r12.i(r4)     // Catch: java.lang.Throwable -> Ldb
                    r11.add(r12)     // Catch: java.lang.Throwable -> Ldb
                    r4 = 0
                    goto L49
                Ld7:
                    r2.close()
                    return r11
                Ldb:
                    r0 = move-exception
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.chat.ChatDao_Impl.AnonymousClass14.call():java.util.List");
            }

            protected void finalize() {
                e8.release();
            }
        });
    }
}
