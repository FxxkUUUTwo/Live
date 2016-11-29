package com.other.project.live.model;

import java.util.List;

/**
 * Created by wanghaixin on 16/11/29.
 */
public class PhoneChange {


    /**
     * code : 10000
     * data : {"notice":[{"id":"11995","title":"尊敬的用户，客服电话变更为：010-80121586","description":"尊敬的用户，客服电话变更为：010-80121586","uri":""}]}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<NoticeBean> notice;

        public List<NoticeBean> getNotice() {
            return notice;
        }

        public void setNotice(List<NoticeBean> notice) {
            this.notice = notice;
        }

        public static class NoticeBean {
            /**
             * id : 11995
             * title : 尊敬的用户，客服电话变更为：010-80121586
             * description : 尊敬的用户，客服电话变更为：010-80121586
             * uri :
             */

            private String id;
            private String title;
            private String description;
            private String uri;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }
        }
    }
}
