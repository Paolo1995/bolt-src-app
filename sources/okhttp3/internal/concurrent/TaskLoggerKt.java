package okhttp3.internal.concurrent;

import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: TaskLogger.kt */
/* loaded from: classes5.dex */
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task task, TaskQueue taskQueue, String str) {
        log(task, taskQueue, str);
    }

    public static final String formatDuration(long j8) {
        String str;
        if (j8 <= -999500000) {
            str = ((j8 - 500000000) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (j8 <= -999500) {
            str = ((j8 - 500000) / 1000000) + " ms";
        } else if (j8 <= 0) {
            str = ((j8 - ((long) CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION)) / 1000) + " µs";
        } else if (j8 < 999500) {
            str = ((j8 + ((long) CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION)) / 1000) + " µs";
        } else if (j8 < 999500000) {
            str = ((j8 + 500000) / 1000000) + " ms";
        } else {
            str = ((j8 + 500000000) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName$okhttp());
        sb.append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.e(format, "format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final <T> T logElapsed(Task task, TaskQueue queue, Function0<? extends T> block) {
        long j8;
        Intrinsics.f(task, "task");
        Intrinsics.f(queue, "queue");
        Intrinsics.f(block, "block");
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j8 = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, queue, "starting");
        } else {
            j8 = -1;
        }
        try {
            T invoke = block.invoke();
            InlineMarker.b(1);
            if (isLoggable) {
                log(task, queue, Intrinsics.n("finished run in ", formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j8)));
            }
            InlineMarker.a(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.b(1);
            if (isLoggable) {
                log(task, queue, Intrinsics.n("failed a run in ", formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j8)));
            }
            InlineMarker.a(1);
            throw th;
        }
    }

    public static final void taskLog(Task task, TaskQueue queue, Function0<String> messageBlock) {
        Intrinsics.f(task, "task");
        Intrinsics.f(queue, "queue");
        Intrinsics.f(messageBlock, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, queue, messageBlock.invoke());
        }
    }
}
