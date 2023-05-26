package eu.bolt.client.chatdb.room.chat;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import java.util.List;

/* compiled from: ChatDao.kt */
/* loaded from: classes5.dex */
public abstract class ChatDao {
    public abstract void a(List<String> list);

    public abstract Maybe<List<ChatDBModel>> b();

    public abstract Maybe<ChatDBModel> c(String str);

    public abstract Maybe<ChatDBModel> d();

    public abstract Completable e(ChatDBModel chatDBModel);

    public abstract void f(ChatDBModel chatDBModel);

    public abstract Observable<List<ChatDBModel>> g(long j8, String str, Long l8);
}
