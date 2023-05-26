package eu.bolt.client.chatdb.room;

import androidx.room.RoomDatabase;
import eu.bolt.client.chatdb.room.chat.ChatDao;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;

/* compiled from: ChatDatabase.kt */
/* loaded from: classes5.dex */
public abstract class ChatDatabase extends RoomDatabase {
    public abstract ChatDao G();

    public abstract MessagesDao H();

    public abstract TerminalMessagesDao I();
}
