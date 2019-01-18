package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kongzue.dialog.v2.SelectDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.tools.GP;
import com.osmeet.os.app.tools.SDT;
import com.osmeet.os.app.utils.InputSoftUtil;
import com.osmeet.os.app.utils.WidgetUtil;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.UpdateInfoContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.activity.InitActivity;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;

/**
 * Created by yyj on 2018/12/26. email: 2209011667@qq.com
 */

public class UpdateInfoNeScrollPanel extends BaseNeScrollPanel<UpdateInfoContract.IPresenter> {
    public UpdateInfoNeScrollPanel(Context context, UpdateInfoContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_update_info;
    }

    @Override
    protected void update() {

    }


    @BindView(R.id.img_avatar)
    ImageView img_avatar;
    @BindView(R.id.img_u_1)
    ImageView img_u_1;
    @BindView(R.id.img_u_2)
    ImageView img_u_2;
    @BindView(R.id.img_u_3)
    ImageView img_u_3;
    @BindView(R.id.img_u_4)
    ImageView img_u_4;
    @BindView(R.id.img_u_5)
    ImageView img_u_5;
    @BindView(R.id.img_u_6)
    ImageView img_u_6;

    @BindView(R.id.tv_user_score)
    TextView tv_user_score;
    @BindView(R.id.et_signature)
    EditText et_signature;
    @BindView(R.id.tv_signature_num)
    TextView tv_signature_num;
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_birthday)
    EditText et_birthday;
    @BindView(R.id.et_school)
    EditText et_school;
    @BindView(R.id.et_company)
    EditText et_company;
    @BindView(R.id.et_job)
    EditText et_job;

    @OnClick(R.id.et_birthday)
    void birthday() {
        img_avatar.requestFocus();
        String time = et_birthday.getText().toString();
        SDT.create().Listener(new SDT.Listener() {
            @Override
            public void onPositiveButtonClick(Date date) {
                et_birthday.setText(TimeUtil.long2str(date.getTime(), "yyyy-MM-dd"));

            }

            @Override
            public void onNegativeButtonClick(Date date) {

            }
        })
                .setDefaultYear(TimeUtil.getYear() - 17)
                .setDefaultDateTime(TimeUtil.str2long(time, "yyyy-MM-dd"), !TextUtils.isEmpty(time))
                .show(((InitActivity) activity).getSupportFragmentManager(), "dialog_time");

        InputSoftUtil.close(activity);

    }

    private String avatarPath;

    @OnClick(R.id.img_avatar)
    void avatar() {
        GP.create(new GP.CallBack() {
            @Override
            public void onSuccess(List<String> photoList) {
                avatarPath = photoList.get(0);
                G.img(context, photoList.get(0), img_avatar);
            }
        }).openWithPermission(activity);
    }

    @OnClick(R.id.bt_validate)
    void validate() {
        mPresenter.toast("哈哈哈！");
    }

    private List<ImageView> imageViewList = new ArrayList<>();

    @Override
    protected void initView() {
        super.initView();
        mRefreshLayout.setEnablePureScrollMode(true);
        et_signature.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        et_signature.setHorizontallyScrolling(false);
        et_signature.setSingleLine(false);
        imageViewList.add(img_u_1);
        imageViewList.add(img_u_2);
        imageViewList.add(img_u_3);
        imageViewList.add(img_u_4);
        imageViewList.add(img_u_5);
        imageViewList.add(img_u_6);
    }

    @Override
    protected void initListener() {
        super.initListener();
        et_signature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = et_signature.getText().toString().length();
                if (length > 50) {
                    et_signature.setText(et_signature.getText().toString().substring(0, 49));
                    WidgetUtil.setEditSelectionLast(et_signature);
                } else {
                    WidgetUtil.setTextNumber(tv_signature_num, 50 - length);
                }
            }
        });

        for (int i = 0; i < imageViewList.size(); i++) {
            final int p = i;
            imageViewList.get(i).setOnClickListener(v -> GP.create(new GP.CallBack() {
                @Override
                public void onSuccess(List<String> photoList) {
                    mIMGs[p].path = photoList.get(0);
                    setImages();
                }
            }).openWithPermission(activity));
            final int j = i;
            imageViewList.get(i).setOnLongClickListener(v -> {
                if (isNoImage(j)) return false;
                SelectDialog.show(context, "警告", "删除这张照片？",
                        "确定", (dialog, which) -> deleteImage(j),
                        "取消", (dialog, which) -> {});
                return true;
            });
        }


    }

    public void save() {
        int length = et_username.getText().toString().length();
        int length2 = et_birthday.getText().toString().length();
        if (length < 1 || length > 10) {
            mPresenter.toast("昵称长度1~10个字符！");
        } else if (length2 < 8) {
            mPresenter.toast("请完善生日！");
        } else {
            updateInfo();
        }
    }

    private void updateInfo() {
        User user = new User();
        user.setSex(myUser.getSex());
        user.setUsername(myUser.getUsername());
        user.setBirthday(myUser.getBirthday());
        user.setSchool(myUser.getSchool());
        user.setCompany(myUser.getCompany());
        user.setJob(myUser.getJob());
        user.setSignature(myUser.getSignature());

        if (!TextUtils.isEmpty(et_signature.getText().toString())) {
            user.setSignature(et_signature.getText().toString());
        }
        if (!TextUtils.isEmpty(et_username.getText().toString())) {
            user.setUsername(et_username.getText().toString());
        }
        if (!TextUtils.isEmpty(et_birthday.getText().toString())) {
            user.setBirthday(et_birthday.getText().toString().replace("-", ""));
        }
        if (!TextUtils.isEmpty(et_school.getText().toString())) {
            user.setSchool(et_school.getText().toString());
        }
        if (!TextUtils.isEmpty(et_company.getText().toString())) {
            user.setCompany(et_company.getText().toString());
        }
        if (!TextUtils.isEmpty(et_job.getText().toString())) {
            user.setJob(et_job.getText().toString());
        }
        mPresenter.updateMyInfo(user);

        if (!TextUtils.isEmpty(avatarPath)) {
            mPresenter.updateMyAvatar(avatarPath);
        }

        String[] imageIds = new String[6];
        String[] filePaths = new String[6];
        for (int i = 0; i < 6; i++) {
            if (mIMGs[i].info != null)
                imageIds[i] = mIMGs[i].info.getId();
            filePaths[i] = mIMGs[i].path;
        }

        boolean isChange = false;
        for (int i = 0; i < 6; i++) {
            if (filePaths[i] != null) {
                isChange = true;
                break;
            }
            if (oldImageIds[i] != null && !oldImageIds[i].equals(imageIds[i])) {
                isChange = true;
                break;
            }
            if (imageIds[i] != null && !imageIds[i].equals(oldImageIds[i])) {
                isChange = true;
                break;
            }
        }
        if (isChange) {
            mPresenter.updateMyImages(imageIds, filePaths);
        }
    }


    private User myUser;

    public void setUser(@NonNull User user) {
        this.myUser = user;
        if (user.getAvatar() != null) {
            G.img(context, user.getAvatar().getUrl(), img_avatar);
        }
        WidgetUtil.setTextNumber(tv_user_score, user.getCreditScore());
        WidgetUtil.setTextNonNull(et_signature, user.getSignature());
        WidgetUtil.setTextNonNull(et_username, user.getUsername());
        WidgetUtil.setTextNonNull(et_birthday, user.getBirthdayFormat("yyyy-MM-dd"));
        WidgetUtil.setTextNonNull(et_school, user.getSchool());
        WidgetUtil.setTextNonNull(et_company, user.getCompany());
        WidgetUtil.setTextNonNull(et_job, user.getJob());


        List<FileInfo> images = user.getImages();
        if (images != null) {
            for (int i = 0; i < 6 && i < images.size(); i++) {
                FileInfo info = images.get(i);
                mIMGs[i].info = info;
                oldImageIds[i] = info.getId();
            }
        }

        setImages();
    }

    private String[] oldImageIds = new String[6];


    private IMG[] mIMGs = new IMG[]{
            new IMG(),
            new IMG(),
            new IMG(),
            new IMG(),
            new IMG(),
            new IMG()
    };

    private void deleteImage(int j) {
        if (j < 0 || j > 5) return;
        mIMGs[j].info = null;
        mIMGs[j].path = null;
        System.arraycopy(mIMGs, j + 1, mIMGs, j, 5 - j);
        // 等价于
        // for (int i = j; i < 5; i++) {
        //   mIMGs[i] = mIMGs[i + 1];
        //}
        mIMGs[5].info = null;
        mIMGs[5].path = null;
        setImages();
    }

    private boolean isNoImage(int j) {
        return mIMGs[j].info == null && mIMGs[j].path == null;
    }


    private void setImages() {
        for (int i = 0; i < 6; i++) {
            IMG img = mIMGs[i];
            if (img.path != null) {
                G.img(context, img.path, imageViewList.get(i));
                imageViewList.get(i).setVisibility(View.VISIBLE);
            } else if (img.info != null) {
                G.img(context, img.info.getUrl(), imageViewList.get(i));
                imageViewList.get(i).setVisibility(View.VISIBLE);
            } else if (i == 0 || (mIMGs[i - 1].info != null || mIMGs[i - 1].path != null)) {
                G.img(context, R.mipmap.ic_image_add, imageViewList.get(i));
                imageViewList.get(i).setVisibility(View.VISIBLE);
            } else {
                imageViewList.get(i).setVisibility(View.GONE);
            }
        }
    }

    class IMG {
        FileInfo info;
        String path;
    }

}
