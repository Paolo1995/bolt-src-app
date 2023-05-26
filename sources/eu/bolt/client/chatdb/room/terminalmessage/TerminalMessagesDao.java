package eu.bolt.client.chatdb.room.terminalmessage;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import java.util.List;

/* compiled from: TerminalMessagesDao.kt */
/* loaded from: classes5.dex */
public abstract class TerminalMessagesDao {
    public abstract void a(List<String> list);

    public abstract Flowable<List<TerminalMessageDBModel>> b(String str);

    public abstract List<TerminalMessageDBModel> c(long j8);

    public abstract Completable d(TerminalMessageDBModel terminalMessageDBModel);

    public abstract void e(TerminalMessageDBModel terminalMessageDBModel);
}
