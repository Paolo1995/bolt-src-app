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
public class CTIconMessageViewHolder extends CTInboxBaseMessageViewHolder {
    private final RelativeLayout J;
    private final Button K;
    private final Button L;
    private final Button M;
    private final LinearLayout N;
    private final ImageView O;
    private final ImageView P;
    private final TextView Q;
    private final TextView R;
    private final TextView S;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTIconMessageViewHolder(@NonNull View view) {
        super(view);
        view.setTag(this);
        this.Q = (TextView) view.findViewById(R$id.messageTitle);
        this.R = (TextView) view.findViewById(R$id.f11084x0);
        this.f11508y = (ImageView) view.findViewById(R$id.media_image);
        this.P = (ImageView) view.findViewById(R$id.image_icon);
        this.O = (ImageView) view.findViewById(R$id.read_circle);
        this.S = (TextView) view.findViewById(R$id.timestamp);
        this.K = (Button) view.findViewById(R$id.cta_button_1);
        this.L = (Button) view.findViewById(R$id.cta_button_2);
        this.M = (Button) view.findViewById(R$id.cta_button_3);
        this.f11507x = (FrameLayout) view.findViewById(R$id.icon_message_frame_layout);
        this.f11509z = (ImageView) view.findViewById(R$id.square_media_image);
        this.J = (RelativeLayout) view.findViewById(R$id.click_relative_layout);
        this.N = (LinearLayout) view.findViewById(R$id.cta_linear_layout);
        this.B = (FrameLayout) view.findViewById(R$id.icon_progress_frame_layout);
        this.A = (RelativeLayout) view.findViewById(R$id.media_layout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:22|(14:131|26|27|(11:29|(2:57|(3:59|60|61)(2:64|(3:66|67|68)(10:71|(2:73|(5:75|76|(1:78)(1:83)|79|80)(4:84|(1:86)(1:90)|87|(1:89)))(2:91|(2:93|(1:95)))|32|(1:34)(2:53|(1:55)(1:56))|35|36|37|(3:39|40|41)(1:51)|42|(2:44|45)(1:47))))|31|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))(2:96|(11:98|99|100|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))(2:103|(11:105|106|107|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))(10:110|(2:112|(3:114|115|116)(2:119|(1:121)))(2:122|(2:124|(1:126)))|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))))|127|128|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))|25|26|27|(0)(0)|127|128|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(1:3)(1:145)|4|(5:6|7|(1:(3:10|(2:12|(1:14))|17)(2:136|(1:138)))(2:139|(1:141))|15|17)(1:144)|18|(2:19|20)|(16:22|(14:131|26|27|(11:29|(2:57|(3:59|60|61)(2:64|(3:66|67|68)(10:71|(2:73|(5:75|76|(1:78)(1:83)|79|80)(4:84|(1:86)(1:90)|87|(1:89)))(2:91|(2:93|(1:95)))|32|(1:34)(2:53|(1:55)(1:56))|35|36|37|(3:39|40|41)(1:51)|42|(2:44|45)(1:47))))|31|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))(2:96|(11:98|99|100|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))(2:103|(11:105|106|107|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))(10:110|(2:112|(3:114|115|116)(2:119|(1:121)))(2:122|(2:124|(1:126)))|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))))|127|128|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))|25|26|27|(0)(0)|127|128|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))(16:132|(14:134|26|27|(0)(0)|127|128|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))|25|26|27|(0)(0)|127|128|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0))|135|128|32|(0)(0)|35|36|37|(0)(0)|42|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0762, code lost:
        com.clevertap.android.sdk.Logger.a("CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0702 A[Catch: NoClassDefFoundError -> 0x0762, TRY_LEAVE, TryCatch #1 {NoClassDefFoundError -> 0x0762, blocks: (B:121:0x06f8, B:123:0x0702, B:124:0x0708, B:126:0x073f, B:127:0x075a), top: B:136:0x06f8, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x075a A[Catch: NoClassDefFoundError -> 0x0762, TRY_LEAVE, TryCatch #1 {NoClassDefFoundError -> 0x0762, blocks: (B:121:0x06f8, B:123:0x0702, B:124:0x0708, B:126:0x073f, B:127:0x075a), top: B:136:0x06f8, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x04db A[Catch: NoClassDefFoundError -> 0x06a6, TryCatch #10 {NoClassDefFoundError -> 0x06a6, blocks: (B:65:0x03ec, B:67:0x03fb, B:69:0x0436, B:66:0x03f4, B:70:0x044f, B:72:0x045f, B:74:0x046e, B:76:0x047f, B:73:0x0467, B:77:0x0498, B:79:0x049f, B:81:0x04c2, B:82:0x04db, B:84:0x04e2, B:85:0x04f4, B:87:0x052c, B:88:0x0548, B:90:0x054e, B:91:0x0560, B:93:0x059c, B:94:0x05bc, B:96:0x05c2, B:98:0x05d2, B:99:0x05de, B:101:0x0616, B:102:0x0632, B:104:0x064c, B:105:0x0664, B:107:0x066a, B:109:0x068d), top: B:155:0x02e6, inners: #2, #3, #4, #5 }] */
    @Override // com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void R(com.clevertap.android.sdk.inbox.CTInboxMessage r20, com.clevertap.android.sdk.inbox.CTInboxListViewFragment r21, final int r22) {
        /*
            Method dump skipped, instructions count: 1914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.CTIconMessageViewHolder.R(com.clevertap.android.sdk.inbox.CTInboxMessage, com.clevertap.android.sdk.inbox.CTInboxListViewFragment, int):void");
    }
}
