package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Record;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IRecordList {
    interface V {
        void showRecordList(@NonNull List<Record> recordList);
    }

    interface P {
        void loadRecordList(int pageNum);
    }
}
