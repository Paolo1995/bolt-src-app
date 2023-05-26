package eu.bolt.client.chatdb.room;

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
import eu.bolt.client.chatdb.room.chat.ChatDao;
import eu.bolt.client.chatdb.room.chat.ChatDao_Impl;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import eu.bolt.client.chatdb.room.message.MessagesDao_Impl;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class ChatDatabase_Impl extends ChatDatabase {

    /* renamed from: o  reason: collision with root package name */
    private volatile MessagesDao f39787o;

    /* renamed from: p  reason: collision with root package name */
    private volatile ChatDao f39788p;

    /* renamed from: q  reason: collision with root package name */
    private volatile TerminalMessagesDao f39789q;

    @Override // eu.bolt.client.chatdb.room.ChatDatabase
    public ChatDao G() {
        ChatDao chatDao;
        if (this.f39788p != null) {
            return this.f39788p;
        }
        synchronized (this) {
            if (this.f39788p == null) {
                this.f39788p = new ChatDao_Impl(this);
            }
            chatDao = this.f39788p;
        }
        return chatDao;
    }

    @Override // eu.bolt.client.chatdb.room.ChatDatabase
    public MessagesDao H() {
        MessagesDao messagesDao;
        if (this.f39787o != null) {
            return this.f39787o;
        }
        synchronized (this) {
            if (this.f39787o == null) {
                this.f39787o = new MessagesDao_Impl(this);
            }
            messagesDao = this.f39787o;
        }
        return messagesDao;
    }

    @Override // eu.bolt.client.chatdb.room.ChatDatabase
    public TerminalMessagesDao I() {
        TerminalMessagesDao terminalMessagesDao;
        if (this.f39789q != null) {
            return this.f39789q;
        }
        synchronized (this) {
            if (this.f39789q == null) {
                this.f39789q = new TerminalMessagesDao_Impl(this);
            }
            terminalMessagesDao = this.f39789q;
        }
        return terminalMessagesDao;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "chat_messages", "chat_terminal_messages", "chat");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper h(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.f7443a.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f7444b).c(databaseConfiguration.f7445c).b(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(11) { // from class: eu.bolt.client.chatdb.room.ChatDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `chat_messages` (`id` TEXT NOT NULL, `chat_id` TEXT NOT NULL, `type` INTEGER NOT NULL, `attachments_id` TEXT, `text` TEXT, `sender_id` TEXT NOT NULL, `sender_name` TEXT NOT NULL, `quick_reply_id` TEXT NOT NULL, `date` INTEGER NOT NULL, `status` INTEGER NOT NULL, `resend_counter` INTEGER NOT NULL, `silent` INTEGER NOT NULL, `translation_text` TEXT, `translation_provider_name` TEXT, `translation_provider_logo_url` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.u("CREATE INDEX IF NOT EXISTS `index_chat_messages_date` ON `chat_messages` (`date`)");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `chat_terminal_messages` (`id` TEXT NOT NULL, `chat_id` TEXT NOT NULL, `message` TEXT NOT NULL, `status` TEXT NOT NULL, `date` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.u("CREATE INDEX IF NOT EXISTS `index_chat_terminal_messages_chat_id` ON `chat_terminal_messages` (`chat_id`)");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `chat` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT, `thumbnail_url` TEXT, `start_date` INTEGER NOT NULL, `order_handle_order_id` INTEGER NOT NULL, `order_handle_order_system` TEXT, `order_handle_city_id` INTEGER, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ea02c28d07c2f1e3eeeeb3aa803f9ae6')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `chat_messages`");
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `chat_terminal_messages`");
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `chat`");
                if (((RoomDatabase) ChatDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) ChatDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) ChatDatabase_Impl.this).f7544h.get(i8)).b(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void c(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) ChatDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) ChatDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) ChatDatabase_Impl.this).f7544h.get(i8)).a(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) ChatDatabase_Impl.this).f7537a = supportSQLiteDatabase;
                ChatDatabase_Impl.this.w(supportSQLiteDatabase);
                if (((RoomDatabase) ChatDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) ChatDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) ChatDatabase_Impl.this).f7544h.get(i8)).c(supportSQLiteDatabase);
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
                HashMap hashMap = new HashMap(15);
                hashMap.put(Name.MARK, new TableInfo.Column(Name.MARK, "TEXT", true, 1, null, 1));
                hashMap.put("chat_id", new TableInfo.Column("chat_id", "TEXT", true, 0, null, 1));
                hashMap.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                hashMap.put("attachments_id", new TableInfo.Column("attachments_id", "TEXT", false, 0, null, 1));
                hashMap.put("text", new TableInfo.Column("text", "TEXT", false, 0, null, 1));
                hashMap.put("sender_id", new TableInfo.Column("sender_id", "TEXT", true, 0, null, 1));
                hashMap.put("sender_name", new TableInfo.Column("sender_name", "TEXT", true, 0, null, 1));
                hashMap.put("quick_reply_id", new TableInfo.Column("quick_reply_id", "TEXT", true, 0, null, 1));
                hashMap.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, 1));
                hashMap.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                hashMap.put("resend_counter", new TableInfo.Column("resend_counter", "INTEGER", true, 0, null, 1));
                hashMap.put("silent", new TableInfo.Column("silent", "INTEGER", true, 0, null, 1));
                hashMap.put("translation_text", new TableInfo.Column("translation_text", "TEXT", false, 0, null, 1));
                hashMap.put("translation_provider_name", new TableInfo.Column("translation_provider_name", "TEXT", false, 0, null, 1));
                hashMap.put("translation_provider_logo_url", new TableInfo.Column("translation_provider_logo_url", "TEXT", false, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_chat_messages_date", false, Arrays.asList("date"), Arrays.asList("ASC")));
                TableInfo tableInfo = new TableInfo("chat_messages", hashMap, hashSet, hashSet2);
                TableInfo a8 = TableInfo.a(supportSQLiteDatabase, "chat_messages");
                if (!tableInfo.equals(a8)) {
                    return new RoomOpenHelper.ValidationResult(false, "chat_messages(eu.bolt.client.chatdb.room.message.MessageDBModel).\n Expected:\n" + tableInfo + "\n Found:\n" + a8);
                }
                HashMap hashMap2 = new HashMap(5);
                hashMap2.put(Name.MARK, new TableInfo.Column(Name.MARK, "TEXT", true, 1, null, 1));
                hashMap2.put("chat_id", new TableInfo.Column("chat_id", "TEXT", true, 0, null, 1));
                hashMap2.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, 1));
                hashMap2.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, 1));
                hashMap2.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_chat_terminal_messages_chat_id", false, Arrays.asList("chat_id"), Arrays.asList("ASC")));
                TableInfo tableInfo2 = new TableInfo("chat_terminal_messages", hashMap2, hashSet3, hashSet4);
                TableInfo a9 = TableInfo.a(supportSQLiteDatabase, "chat_terminal_messages");
                if (!tableInfo2.equals(a9)) {
                    return new RoomOpenHelper.ValidationResult(false, "chat_terminal_messages(eu.bolt.client.chatdb.room.terminalmessage.TerminalMessageDBModel).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a9);
                }
                HashMap hashMap3 = new HashMap(8);
                hashMap3.put(Name.MARK, new TableInfo.Column(Name.MARK, "TEXT", true, 1, null, 1));
                hashMap3.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                hashMap3.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                hashMap3.put("thumbnail_url", new TableInfo.Column("thumbnail_url", "TEXT", false, 0, null, 1));
                hashMap3.put("start_date", new TableInfo.Column("start_date", "INTEGER", true, 0, null, 1));
                hashMap3.put("order_handle_order_id", new TableInfo.Column("order_handle_order_id", "INTEGER", true, 0, null, 1));
                hashMap3.put("order_handle_order_system", new TableInfo.Column("order_handle_order_system", "TEXT", false, 0, null, 1));
                hashMap3.put("order_handle_city_id", new TableInfo.Column("order_handle_city_id", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("chat", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo a10 = TableInfo.a(supportSQLiteDatabase, "chat");
                if (!tableInfo3.equals(a10)) {
                    return new RoomOpenHelper.ValidationResult(false, "chat(eu.bolt.client.chatdb.room.chat.ChatDBModel).\n Expected:\n" + tableInfo3 + "\n Found:\n" + a10);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "ea02c28d07c2f1e3eeeeb3aa803f9ae6", "a84ec91056c45148ff2877ec0259ee3b")).a());
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
        hashMap.put(MessagesDao.class, MessagesDao_Impl.r());
        hashMap.put(ChatDao.class, ChatDao_Impl.j());
        hashMap.put(TerminalMessagesDao.class, TerminalMessagesDao_Impl.h());
        return hashMap;
    }
}
