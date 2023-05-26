package eu.bolt.client.chatdb.room;

import eu.bolt.client.chatdb.room.ChatDatabaseHelper;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDatabaseHelper.kt */
/* loaded from: classes5.dex */
public final class ChatDatabaseHelper {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDatabase f39785a;

    @Inject
    public ChatDatabaseHelper(ChatDatabase chatDatabase) {
        Intrinsics.f(chatDatabase, "chatDatabase");
        this.f39785a = chatDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ChatDatabaseHelper this$0, final Function0 block) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(block, "$block");
        this$0.f39785a.D(new Runnable() { // from class: o6.b
            @Override // java.lang.Runnable
            public final void run() {
                ChatDatabaseHelper.e(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final Completable c(final Function0<Unit> block) {
        Intrinsics.f(block, "block");
        Completable I = Completable.u(new Action() { // from class: o6.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatDatabaseHelper.d(ChatDatabaseHelper.this, block);
            }
        }).I(Schedulers.b(this.f39785a.r()));
        Intrinsics.e(I, "fromAction {\n        cha…ase.transactionExecutor))");
        return I;
    }
}
