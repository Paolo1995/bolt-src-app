package com.clevertap.android.sdk.inbox;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.R$id;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CTSimpleMessageViewHolder extends CTInboxBaseMessageViewHolder {
    private final Button J;
    private final Button K;
    private final Button L;
    private final TextView M;
    private final ImageView N;
    private final TextView O;
    private final TextView P;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTSimpleMessageViewHolder(@NonNull View view) {
        super(view);
        view.setTag(this);
        this.P = (TextView) view.findViewById(R$id.messageTitle);
        this.M = (TextView) view.findViewById(R$id.f11084x0);
        this.O = (TextView) view.findViewById(R$id.timestamp);
        this.N = (ImageView) view.findViewById(R$id.read_circle);
        this.J = (Button) view.findViewById(R$id.cta_button_1);
        this.K = (Button) view.findViewById(R$id.cta_button_2);
        this.L = (Button) view.findViewById(R$id.cta_button_3);
        this.f11508y = (ImageView) view.findViewById(R$id.media_image);
        this.C = (RelativeLayout) view.findViewById(R$id.simple_message_relative_layout);
        this.f11507x = (FrameLayout) view.findViewById(R$id.simple_message_frame_layout);
        this.f11509z = (ImageView) view.findViewById(R$id.square_media_image);
        this.D = (RelativeLayout) view.findViewById(R$id.click_relative_layout);
        this.f11505v = (LinearLayout) view.findViewById(R$id.cta_linear_layout);
        this.f11506w = (LinearLayout) view.findViewById(R$id.body_linear_layout);
        this.B = (FrameLayout) view.findViewById(R$id.simple_progress_frame_layout);
        this.A = (RelativeLayout) view.findViewById(R$id.media_layout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:112:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x04bb A[Catch: NoClassDefFoundError -> 0x067f, TryCatch #1 {NoClassDefFoundError -> 0x067f, blocks: (B:29:0x02a8, B:45:0x02db, B:47:0x02e1, B:48:0x02f2, B:50:0x032a, B:51:0x0346, B:53:0x034c, B:54:0x035d, B:56:0x0399, B:57:0x03b9, B:59:0x03bf, B:61:0x03c9, B:63:0x03d8, B:65:0x03e7, B:67:0x041f, B:64:0x03e0, B:68:0x043b, B:70:0x044a, B:72:0x0459, B:74:0x0461, B:71:0x0452, B:75:0x047a, B:77:0x0480, B:79:0x04a2, B:80:0x04bb, B:82:0x04c1, B:83:0x04d2, B:85:0x050a, B:86:0x0526, B:88:0x052c, B:89:0x053d, B:91:0x0579, B:92:0x0599, B:94:0x059f, B:96:0x05a9, B:97:0x05ba, B:99:0x05f2, B:100:0x060e, B:102:0x0627, B:103:0x063f, B:105:0x0645, B:107:0x0667, B:34:0x02ba, B:37:0x02c4), top: B:123:0x02a8, inners: #0, #3, #4, #5, #6, #7 }] */
    @Override // com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void R(com.clevertap.android.sdk.inbox.CTInboxMessage r18, com.clevertap.android.sdk.inbox.CTInboxListViewFragment r19, final int r20) {
        /*
            Method dump skipped, instructions count: 1769
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.CTSimpleMessageViewHolder.R(com.clevertap.android.sdk.inbox.CTInboxMessage, com.clevertap.android.sdk.inbox.CTInboxListViewFragment, int):void");
    }
}
