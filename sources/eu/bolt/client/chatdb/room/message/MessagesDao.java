package eu.bolt.client.chatdb.room.message;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessagesDao.kt */
/* loaded from: classes5.dex */
public abstract class MessagesDao {

    /* renamed from: a  reason: collision with root package name */
    private static final Companion f39845a = new Companion(null);

    /* compiled from: MessagesDao.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract Flowable<List<MessageDBModel>> a();

    public abstract void b(List<String> list);

    public abstract MessageDBModel c(String str, String str2);

    public abstract Flowable<List<MessageDBModel>> d(String str);

    public abstract Single<List<MessageDBModel>> e();

    public abstract Single<List<MessageDBModel>> f(String str, String str2);

    public abstract void g(MessageDBModel messageDBModel);

    public abstract void h(List<MessageDBModel> list);

    public abstract Flowable<Integer> i(String str, String str2);

    public abstract Completable j(List<String> list);

    public abstract Completable k(List<String> list);

    public abstract Completable l(String str, int i8);

    public abstract Completable m(String str, MessageStatusDBModel messageStatusDBModel);
}
