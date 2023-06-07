package pers.learn.utils;

import com.alibaba.fastjson2.JSONObject;

import java.util.Map;

public class TestJson {

    public static void main(String[] args) throws InterruptedException {
        String json = "{\"RES_SPEC_ID\":\"JUMP\",\"RES_STATE\":\"0\",\"EXCEPTION\":\"[IM-RIVT-LINK-000022] [Fail to delete, because the link is in use.] \",\"CREATION_DATE\":\"2022-11-17 16:14:39\",\"STATE\":\"Failed\",\"PIPE_INST_ID\":\"221117160903954048\",\"LAST_PROCESS_DATE\":\"2023-01-03 10:13:37\",\"DEFACTO_ID\":\"16939072\",\"RESOURCE_SPECIFICATION\":\"Patch\",\"RES_ACTION\":\"D\",\"IS_REDO\":\"Y\",\"RES_ID\":\"221022191300916527\",\"ID\":\"372\",\"RESOURCE_NAME\":\"1926\"}";
        JSONObject parse = JSONObject.parse(json);
        JSONObject jsonObject = new JSONObject(parse);
        jsonObject.put("test", parse);

//        JSONObject test = (JSONObject) parse.get("test");
        Map<String, Object> test = (Map<String, Object>) jsonObject.get("RES_SPEC_ID");
        System.out.println(test.get("RES_SPEC_ID"));

        Thread.sleep(3000);

    }

}
