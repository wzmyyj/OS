package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Story;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IStoryList {
    interface V {
        void showStoryList(@NonNull List<Story> storyList);
    }

    interface P {
        void loadStoryList();
    }
}
