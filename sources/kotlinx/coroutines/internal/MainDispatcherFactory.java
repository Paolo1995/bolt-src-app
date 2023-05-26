package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: MainDispatcherFactory.kt */
/* loaded from: classes5.dex */
public interface MainDispatcherFactory {
    String a();

    MainCoroutineDispatcher b(List<? extends MainDispatcherFactory> list);

    int c();
}
