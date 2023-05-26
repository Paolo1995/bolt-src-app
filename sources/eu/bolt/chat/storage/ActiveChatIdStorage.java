package eu.bolt.chat.storage;

import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: ActiveChatIdStorage.kt */
/* loaded from: classes5.dex */
public interface ActiveChatIdStorage {
    <T> Object a(Function2<? super Set<String>, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    <T> Object b(Function2<? super Set<String>, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);
}
