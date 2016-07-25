package com.android.sugar.appmarket.http.protocol;

import com.android.sugar.appmarket.utils.LogUtils;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HotProtocol
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午10:51
 */
public class HotProtocol extends BaseProtocol<List<String>> {
    
    @Override
    protected String getKey() {
        return "hot";
    }

    @Override
    protected List<String> parseFromJson(String json) {
        try {
            JSONArray array = new JSONArray(json);
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < array.length(); i++) {
                String str = array.optString(i);
                list.add(str);
            }
            return list;
        } catch (Exception e) {
            LogUtils.e(e);
            return null;
        }
    }
}
