package androidx.work.impl.model;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public interface WorkSpecDao {
    int a(WorkInfo.State state, String... strArr);

    void b(String str);

    List<WorkSpec> c(long j8);

    void d(WorkSpec workSpec);

    List<WorkSpec> e();

    List<String> f(@NonNull String str);

    WorkInfo.State g(String str);

    WorkSpec h(String str);

    List<String> i(@NonNull String str);

    List<Data> j(String str);

    List<WorkSpec> k(int i8);

    int l();

    int m(@NonNull String str, long j8);

    List<WorkSpec.IdAndState> n(String str);

    List<WorkSpec> o(int i8);

    void p(String str, Data data);

    List<WorkSpec> q();

    boolean r();

    int s(String str);

    int t(String str);

    void u(String str, long j8);
}
