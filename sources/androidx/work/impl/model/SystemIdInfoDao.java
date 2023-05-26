package androidx.work.impl.model;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
public interface SystemIdInfoDao {
    SystemIdInfo a(@NonNull String str);

    @NonNull
    List<String> b();

    void c(@NonNull SystemIdInfo systemIdInfo);

    void d(@NonNull String str);
}
