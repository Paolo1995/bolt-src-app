package eu.bolt.chat.util;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

/* compiled from: CoroutineRunner.kt */
/* loaded from: classes5.dex */
public interface CoroutineRunner {
    Job a(Function2<? super CoroutineRunner, ? super Continuation<? super Unit>, ? extends Object> function2);
}
