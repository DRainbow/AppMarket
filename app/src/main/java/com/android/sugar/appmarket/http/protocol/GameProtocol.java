package com.android.sugar.appmarket.http.protocol;

import com.android.sugar.appmarket.bean.AppInfo;
import com.android.sugar.appmarket.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GameProtocol
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午10:50
 */
public class GameProtocol extends BaseProtocol<List<AppInfo>> {

    @Override
    protected String getKey() {
        return "game";
    }

    @Override
    protected List<AppInfo> parseFromJson(String json) {
        try {
            List<AppInfo> list = new ArrayList<>();
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                AppInfo info = new AppInfo();
                info.setId(obj.getLong("id"));
                info.setName(obj.getString("name"));
                info.setPackageName(obj.getString("packageName"));
                info.setIconUrl(obj.getString("iconUrl"));
                info.setStars(Float.valueOf(obj.getString("stars")));
                info.setSize(obj.getLong("size"));
                info.setDownloadUrl(obj.getString("downloadUrl"));
                info.setDes(obj.getString("des"));
                list.add(info);
            }
            return list;
        } catch (Exception e) {
            LogUtils.e(e);
            return null;
        }
    }

}
