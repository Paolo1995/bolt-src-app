package eu.bolt.client.chatdb.room.message;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import eu.bolt.client.chatdb.room.converter.ChatMessageConverter;
import eu.bolt.client.chatdb.room.message.translation.TranslationAttributionDBModel;
import eu.bolt.client.chatdb.room.message.translation.TranslationDBModel;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class MessagesDao_Impl extends MessagesDao {

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f39846b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityInsertionAdapter<MessageDBModel> f39847c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatMessageConverter f39848d = new ChatMessageConverter();

    /* renamed from: e  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<MessageDBModel> f39849e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f39850f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f39851g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f39852h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedSQLiteStatement f39853i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedSQLiteStatement f39854j;

    public MessagesDao_Impl(RoomDatabase roomDatabase) {
        this.f39846b = roomDatabase;
        this.f39847c = new EntityInsertionAdapter<MessageDBModel>(roomDatabase) { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR REPLACE INTO `chat_messages` (`id`,`chat_id`,`type`,`attachments_id`,`text`,`sender_id`,`sender_name`,`quick_reply_id`,`date`,`status`,`resend_counter`,`silent`,`translation_text`,`translation_provider_name`,`translation_provider_logo_url`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, MessageDBModel messageDBModel) {
                if (messageDBModel.f() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, messageDBModel.f());
                }
                if (messageDBModel.d() == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, messageDBModel.d());
                }
                supportSQLiteStatement.B0(3, messageDBModel.n());
                if (messageDBModel.c() == null) {
                    supportSQLiteStatement.Q0(4);
                } else {
                    supportSQLiteStatement.q0(4, messageDBModel.c());
                }
                if (messageDBModel.l() == null) {
                    supportSQLiteStatement.Q0(5);
                } else {
                    supportSQLiteStatement.q0(5, messageDBModel.l());
                }
                if (messageDBModel.i() == null) {
                    supportSQLiteStatement.Q0(6);
                } else {
                    supportSQLiteStatement.q0(6, messageDBModel.i());
                }
                if (messageDBModel.j() == null) {
                    supportSQLiteStatement.Q0(7);
                } else {
                    supportSQLiteStatement.q0(7, messageDBModel.j());
                }
                if (messageDBModel.g() == null) {
                    supportSQLiteStatement.Q0(8);
                } else {
                    supportSQLiteStatement.q0(8, messageDBModel.g());
                }
                supportSQLiteStatement.B0(9, messageDBModel.e());
                supportSQLiteStatement.B0(10, MessagesDao_Impl.this.f39848d.a(messageDBModel.k()));
                supportSQLiteStatement.B0(11, messageDBModel.h());
                supportSQLiteStatement.B0(12, messageDBModel.o() ? 1L : 0L);
                TranslationDBModel m8 = messageDBModel.m();
                if (m8 != null) {
                    if (m8.b() == null) {
                        supportSQLiteStatement.Q0(13);
                    } else {
                        supportSQLiteStatement.q0(13, m8.b());
                    }
                    TranslationAttributionDBModel a8 = m8.a();
                    if (a8 != null) {
                        if (a8.b() == null) {
                            supportSQLiteStatement.Q0(14);
                        } else {
                            supportSQLiteStatement.q0(14, a8.b());
                        }
                        if (a8.a() == null) {
                            supportSQLiteStatement.Q0(15);
                            return;
                        } else {
                            supportSQLiteStatement.q0(15, a8.a());
                            return;
                        }
                    }
                    supportSQLiteStatement.Q0(14);
                    supportSQLiteStatement.Q0(15);
                    return;
                }
                supportSQLiteStatement.Q0(13);
                supportSQLiteStatement.Q0(14);
                supportSQLiteStatement.Q0(15);
            }
        };
        this.f39849e = new EntityDeletionOrUpdateAdapter<MessageDBModel>(roomDatabase) { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM `chat_messages` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, MessageDBModel messageDBModel) {
                if (messageDBModel.f() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, messageDBModel.f());
                }
            }
        };
        this.f39850f = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE chat_messages SET status = ? WHERE id =?";
            }
        };
        this.f39851g = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE chat_messages SET date = ? WHERE id =?";
            }
        };
        this.f39852h = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE chat_messages SET resend_counter = ? WHERE id = ?";
            }
        };
        this.f39853i = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM chat_messages WHERE id = ?";
            }
        };
        this.f39854j = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM chat_messages";
            }
        };
    }

    public static List<Class<?>> r() {
        return Collections.emptyList();
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Flowable<List<MessageDBModel>> a() {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT `translation_text`, `translation_provider_name`, `translation_provider_logo_url`, `chat_messages`.`id` AS `id`, `chat_messages`.`chat_id` AS `chat_id`, `chat_messages`.`type` AS `type`, `chat_messages`.`attachments_id` AS `attachments_id`, `chat_messages`.`text` AS `text`, `chat_messages`.`sender_id` AS `sender_id`, `chat_messages`.`sender_name` AS `sender_name`, `chat_messages`.`quick_reply_id` AS `quick_reply_id`, `chat_messages`.`date` AS `date`, `chat_messages`.`status` AS `status`, `chat_messages`.`resend_counter` AS `resend_counter`, `chat_messages`.`silent` AS `silent` FROM chat_messages ORDER BY status > 2 DESC, date", 0);
        return RxRoom.a(this.f39846b, false, new String[]{"chat_messages"}, new Callable<List<MessageDBModel>>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.16
            /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x007f A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x008f A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x00a7 A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00b7 A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x00c6  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x00c8 A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x00d7  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x00d9 A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x00e8  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x00ea A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:64:0x011e  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x011f  */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<eu.bolt.client.chatdb.room.message.MessageDBModel> call() throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 308
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.AnonymousClass16.call():java.util.List");
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public void b(List<String> list) {
        this.f39846b.d();
        StringBuilder b8 = StringUtil.b();
        b8.append("DELETE FROM chat_messages WHERE chat_id IN (");
        StringUtil.a(b8, list.size());
        b8.append(")");
        SupportSQLiteStatement f8 = this.f39846b.f(b8.toString());
        int i8 = 1;
        for (String str : list) {
            if (str == null) {
                f8.Q0(i8);
            } else {
                f8.q0(i8, str);
            }
            i8++;
        }
        this.f39846b.e();
        try {
            f8.x();
            this.f39846b.E();
        } finally {
            this.f39846b.i();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:12:0x007d, B:14:0x0091, B:16:0x0097, B:18:0x009d, B:42:0x00eb, B:46:0x00fc, B:50:0x010b, B:54:0x0121, B:58:0x0130, B:62:0x013f, B:66:0x014e, B:70:0x015d, B:74:0x0188, B:69:0x0159, B:65:0x014a, B:61:0x013b, B:57:0x012c, B:53:0x011d, B:49:0x0107, B:45:0x00f8, B:22:0x00a8, B:26:0x00b4, B:28:0x00ba, B:41:0x00e6, B:32:0x00c5, B:36:0x00d1, B:40:0x00e1, B:39:0x00db, B:35:0x00cd, B:25:0x00b0), top: B:85:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0107 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:12:0x007d, B:14:0x0091, B:16:0x0097, B:18:0x009d, B:42:0x00eb, B:46:0x00fc, B:50:0x010b, B:54:0x0121, B:58:0x0130, B:62:0x013f, B:66:0x014e, B:70:0x015d, B:74:0x0188, B:69:0x0159, B:65:0x014a, B:61:0x013b, B:57:0x012c, B:53:0x011d, B:49:0x0107, B:45:0x00f8, B:22:0x00a8, B:26:0x00b4, B:28:0x00ba, B:41:0x00e6, B:32:0x00c5, B:36:0x00d1, B:40:0x00e1, B:39:0x00db, B:35:0x00cd, B:25:0x00b0), top: B:85:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011d A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:12:0x007d, B:14:0x0091, B:16:0x0097, B:18:0x009d, B:42:0x00eb, B:46:0x00fc, B:50:0x010b, B:54:0x0121, B:58:0x0130, B:62:0x013f, B:66:0x014e, B:70:0x015d, B:74:0x0188, B:69:0x0159, B:65:0x014a, B:61:0x013b, B:57:0x012c, B:53:0x011d, B:49:0x0107, B:45:0x00f8, B:22:0x00a8, B:26:0x00b4, B:28:0x00ba, B:41:0x00e6, B:32:0x00c5, B:36:0x00d1, B:40:0x00e1, B:39:0x00db, B:35:0x00cd, B:25:0x00b0), top: B:85:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012c A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:12:0x007d, B:14:0x0091, B:16:0x0097, B:18:0x009d, B:42:0x00eb, B:46:0x00fc, B:50:0x010b, B:54:0x0121, B:58:0x0130, B:62:0x013f, B:66:0x014e, B:70:0x015d, B:74:0x0188, B:69:0x0159, B:65:0x014a, B:61:0x013b, B:57:0x012c, B:53:0x011d, B:49:0x0107, B:45:0x00f8, B:22:0x00a8, B:26:0x00b4, B:28:0x00ba, B:41:0x00e6, B:32:0x00c5, B:36:0x00d1, B:40:0x00e1, B:39:0x00db, B:35:0x00cd, B:25:0x00b0), top: B:85:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013b A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:12:0x007d, B:14:0x0091, B:16:0x0097, B:18:0x009d, B:42:0x00eb, B:46:0x00fc, B:50:0x010b, B:54:0x0121, B:58:0x0130, B:62:0x013f, B:66:0x014e, B:70:0x015d, B:74:0x0188, B:69:0x0159, B:65:0x014a, B:61:0x013b, B:57:0x012c, B:53:0x011d, B:49:0x0107, B:45:0x00f8, B:22:0x00a8, B:26:0x00b4, B:28:0x00ba, B:41:0x00e6, B:32:0x00c5, B:36:0x00d1, B:40:0x00e1, B:39:0x00db, B:35:0x00cd, B:25:0x00b0), top: B:85:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014a A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:12:0x007d, B:14:0x0091, B:16:0x0097, B:18:0x009d, B:42:0x00eb, B:46:0x00fc, B:50:0x010b, B:54:0x0121, B:58:0x0130, B:62:0x013f, B:66:0x014e, B:70:0x015d, B:74:0x0188, B:69:0x0159, B:65:0x014a, B:61:0x013b, B:57:0x012c, B:53:0x011d, B:49:0x0107, B:45:0x00f8, B:22:0x00a8, B:26:0x00b4, B:28:0x00ba, B:41:0x00e6, B:32:0x00c5, B:36:0x00d1, B:40:0x00e1, B:39:0x00db, B:35:0x00cd, B:25:0x00b0), top: B:85:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0159 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:12:0x007d, B:14:0x0091, B:16:0x0097, B:18:0x009d, B:42:0x00eb, B:46:0x00fc, B:50:0x010b, B:54:0x0121, B:58:0x0130, B:62:0x013f, B:66:0x014e, B:70:0x015d, B:74:0x0188, B:69:0x0159, B:65:0x014a, B:61:0x013b, B:57:0x012c, B:53:0x011d, B:49:0x0107, B:45:0x00f8, B:22:0x00a8, B:26:0x00b4, B:28:0x00ba, B:41:0x00e6, B:32:0x00c5, B:36:0x00d1, B:40:0x00e1, B:39:0x00db, B:35:0x00cd, B:25:0x00b0), top: B:85:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0187  */
    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public eu.bolt.client.chatdb.room.message.MessageDBModel c(java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.c(java.lang.String, java.lang.String):eu.bolt.client.chatdb.room.message.MessageDBModel");
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Flowable<List<MessageDBModel>> d(String str) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM chat_messages WHERE chat_id = ? ORDER BY status > 2 DESC, date", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        return RxRoom.a(this.f39846b, false, new String[]{"chat_messages"}, new Callable<List<MessageDBModel>>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.17
            /* JADX WARN: Removed duplicated region for block: B:37:0x00f6  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00f8 A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0105  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0107 A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:45:0x011b  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x011d A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x012c A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0139  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x013b A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0148  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x014a A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0157  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x0159 A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:67:0x018e  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<eu.bolt.client.chatdb.room.message.MessageDBModel> call() throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 447
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.AnonymousClass17.call():java.util.List");
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Single<List<MessageDBModel>> e() {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT `translation_text`, `translation_provider_name`, `translation_provider_logo_url`, `chat_messages`.`id` AS `id`, `chat_messages`.`chat_id` AS `chat_id`, `chat_messages`.`type` AS `type`, `chat_messages`.`attachments_id` AS `attachments_id`, `chat_messages`.`text` AS `text`, `chat_messages`.`sender_id` AS `sender_id`, `chat_messages`.`sender_name` AS `sender_name`, `chat_messages`.`quick_reply_id` AS `quick_reply_id`, `chat_messages`.`date` AS `date`, `chat_messages`.`status` AS `status`, `chat_messages`.`resend_counter` AS `resend_counter`, `chat_messages`.`silent` AS `silent` FROM chat_messages WHERE status = 5", 0);
        return RxRoom.e(new Callable<List<MessageDBModel>>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.23
            /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x007f A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x008f A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x00a7 A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00b7 A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x00c6  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x00c8 A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x00d7  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x00d9 A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x00e8  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x00ea A[Catch: all -> 0x012f, TryCatch #0 {all -> 0x012f, blocks: (B:3:0x000e, B:4:0x0017, B:6:0x001d, B:8:0x0025, B:10:0x002b, B:34:0x0071, B:38:0x0083, B:42:0x0093, B:46:0x00ab, B:50:0x00bb, B:54:0x00cc, B:58:0x00dd, B:62:0x00ee, B:66:0x0120, B:61:0x00ea, B:57:0x00d9, B:53:0x00c8, B:49:0x00b7, B:45:0x00a7, B:41:0x008f, B:37:0x007f, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:33:0x006c, B:24:0x004f, B:28:0x005b, B:32:0x0067, B:31:0x0063, B:27:0x0057, B:17:0x003c), top: B:73:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:64:0x011e  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x011f  */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<eu.bolt.client.chatdb.room.message.MessageDBModel> call() throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 308
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.AnonymousClass23.call():java.util.List");
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Single<List<MessageDBModel>> f(String str, String str2) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM chat_messages WHERE status < 5 AND sender_id !=? AND chat_id = ?", 2);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        if (str2 == null) {
            e8.Q0(2);
        } else {
            e8.q0(2, str2);
        }
        return RxRoom.e(new Callable<List<MessageDBModel>>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.24
            /* JADX WARN: Removed duplicated region for block: B:37:0x00f6  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00f8 A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0105  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0107 A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:45:0x011b  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x011d A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x012c A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0139  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x013b A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0148  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x014a A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0157  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x0159 A[Catch: all -> 0x01b5, TryCatch #0 {all -> 0x01b5, blocks: (B:4:0x0070, B:5:0x0077, B:7:0x007d, B:9:0x0083, B:11:0x0089, B:35:0x00eb, B:39:0x00fc, B:43:0x010b, B:47:0x0121, B:51:0x0130, B:55:0x013f, B:59:0x014e, B:63:0x015d, B:62:0x0159, B:58:0x014a, B:54:0x013b, B:50:0x012c, B:46:0x011d, B:42:0x0107, B:38:0x00f8, B:15:0x0098, B:19:0x00a4, B:21:0x00aa, B:34:0x00e6, B:25:0x00b9, B:29:0x00cb, B:33:0x00e1, B:32:0x00d7, B:28:0x00c3, B:18:0x00a0), top: B:81:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:67:0x018e  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<eu.bolt.client.chatdb.room.message.MessageDBModel> call() throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 447
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.AnonymousClass24.call():java.util.List");
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public void g(MessageDBModel messageDBModel) {
        this.f39846b.d();
        this.f39846b.e();
        try {
            this.f39847c.i(messageDBModel);
            this.f39846b.E();
        } finally {
            this.f39846b.i();
        }
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public void h(List<MessageDBModel> list) {
        this.f39846b.d();
        this.f39846b.e();
        try {
            this.f39847c.h(list);
            this.f39846b.E();
        } finally {
            this.f39846b.i();
        }
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Flowable<Integer> i(String str, String str2) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("\n            SELECT COUNT(status) FROM chat_messages\n            WHERE status < 5\n            AND sender_id !=?\n            AND chat_id = ?\n            AND silent = 0\n           ", 2);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        if (str2 == null) {
            e8.Q0(2);
        } else {
            e8.q0(2, str2);
        }
        return RxRoom.a(this.f39846b, false, new String[]{"chat_messages"}, new Callable<Integer>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.19
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Integer call() throws Exception {
                Integer num = null;
                Cursor c8 = DBUtil.c(MessagesDao_Impl.this.f39846b, e8, false, null);
                try {
                    if (c8.moveToFirst() && !c8.isNull(0)) {
                        num = Integer.valueOf(c8.getInt(0));
                    }
                    return num;
                } finally {
                    c8.close();
                }
            }

            protected void finalize() {
                e8.release();
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Completable j(final List<String> list) {
        return Completable.v(new Callable<Void>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.26
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                StringBuilder b8 = StringUtil.b();
                b8.append("UPDATE chat_messages SET status = 6 WHERE id IN (");
                StringUtil.a(b8, list.size());
                b8.append(")");
                SupportSQLiteStatement f8 = MessagesDao_Impl.this.f39846b.f(b8.toString());
                int i8 = 1;
                for (String str : list) {
                    if (str == null) {
                        f8.Q0(i8);
                    } else {
                        f8.q0(i8, str);
                    }
                    i8++;
                }
                MessagesDao_Impl.this.f39846b.e();
                try {
                    f8.x();
                    MessagesDao_Impl.this.f39846b.E();
                    return null;
                } finally {
                    MessagesDao_Impl.this.f39846b.i();
                }
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Completable k(final List<String> list) {
        return Completable.v(new Callable<Void>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.25
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                StringBuilder b8 = StringUtil.b();
                b8.append("UPDATE chat_messages SET status = 5 WHERE id IN (");
                StringUtil.a(b8, list.size());
                b8.append(")");
                SupportSQLiteStatement f8 = MessagesDao_Impl.this.f39846b.f(b8.toString());
                int i8 = 1;
                for (String str : list) {
                    if (str == null) {
                        f8.Q0(i8);
                    } else {
                        f8.q0(i8, str);
                    }
                    i8++;
                }
                MessagesDao_Impl.this.f39846b.e();
                try {
                    f8.x();
                    MessagesDao_Impl.this.f39846b.E();
                    return null;
                } finally {
                    MessagesDao_Impl.this.f39846b.i();
                }
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Completable l(final String str, final int i8) {
        return Completable.v(new Callable<Void>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.13
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                SupportSQLiteStatement a8 = MessagesDao_Impl.this.f39852h.a();
                a8.B0(1, i8);
                String str2 = str;
                if (str2 == null) {
                    a8.Q0(2);
                } else {
                    a8.q0(2, str2);
                }
                MessagesDao_Impl.this.f39846b.e();
                try {
                    a8.x();
                    MessagesDao_Impl.this.f39846b.E();
                    return null;
                } finally {
                    MessagesDao_Impl.this.f39846b.i();
                    MessagesDao_Impl.this.f39852h.f(a8);
                }
            }
        });
    }

    @Override // eu.bolt.client.chatdb.room.message.MessagesDao
    public Completable m(final String str, final MessageStatusDBModel messageStatusDBModel) {
        return Completable.v(new Callable<Void>() { // from class: eu.bolt.client.chatdb.room.message.MessagesDao_Impl.11
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                SupportSQLiteStatement a8 = MessagesDao_Impl.this.f39850f.a();
                a8.B0(1, MessagesDao_Impl.this.f39848d.a(messageStatusDBModel));
                String str2 = str;
                if (str2 == null) {
                    a8.Q0(2);
                } else {
                    a8.q0(2, str2);
                }
                MessagesDao_Impl.this.f39846b.e();
                try {
                    a8.x();
                    MessagesDao_Impl.this.f39846b.E();
                    return null;
                } finally {
                    MessagesDao_Impl.this.f39846b.i();
                    MessagesDao_Impl.this.f39850f.f(a8);
                }
            }
        });
    }
}
