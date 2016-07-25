package com.android.sugar.appmarket.http.protocol;

import com.android.sugar.appmarket.bean.SubjectInfo;
import com.android.sugar.appmarket.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SubjectProtocol
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午10:52
 */
public class SubjectProtocol extends BaseProtocol<List<SubjectInfo>> {

    @Override
    protected String getKey() {
        return "subject";
    }

    @Override
    protected List<SubjectInfo> parseFromJson(String json) {
        try {
            JSONArray array = new JSONArray(json);
            List<SubjectInfo> list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.optJSONObject(i);
                SubjectInfo info = new SubjectInfo();
                info.setDes(obj.optString("des"));
                info.setUrl(obj.optString("url"));
                list.add(info);
            }
            return list;
        } catch (Exception e) {
            LogUtils.e(e);
            return null;
        }
    }
}
