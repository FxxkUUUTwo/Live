package com.other.project.live.model;

import java.util.List;

/**
 * Created by wanghaixin on 16/11/28.
 */
public class MainModel  {

    /**
     * code : 10000
     * data : {"events":[{"title":"爱大厨APP：在线支付与家宴预约上线","url":"http://www.idachu.cn/api/document/view/10","ext_url":"","description":"四菜与六菜套餐可实现在线支付，一键支付，厨师速达。家宴可在线预约，人多不怕，天天开趴！\n【活动期间：2014年12月18日--2015年1月30日 新注册用户，立送50元现金券】选择爱大厨，享受厨师上门烹饪星级大餐；选择爱大厨，彻底告别地沟油！","is_multi_media":"1","head":"http://img.idachu.com/201412/004706939e9adce683bd57233b36ec93.png","head_small":"http://img.idachu.com/201412/004706939e9adce683bd57233b36ec93.png"}],"top":[{"title":"有机食材","img":"http://img.idachu.com/201602/186c2872e72246fe0060b1f1517305de.jpg","uri":"http://www.idachu.cn/ingenuity/cat/9"},{"title":"一网通银行卡支付随机立减活动说明","img":"http://img.idachu.com/201610/ed32bb0bef9f2ed5e0d3b47585ee8d72.jpg","uri":"http://www.idachu.cn/document/view/154"},{"title":"爱大厨会员","img":"http://img.idachu.com/201603/8e2c123c9835607e1decaa6552453624.jpg","uri":{"url":"member/list"}}],"weixin10":1,"flash":"","weixin":5,"expands":[],"first":{"title":"预订","description":"专业厨师上门服务","icon":"lucai","price":"158元起"},"tags":[{"title":"川菜","icon":"chuancai","uri":{"url":"kitchener/search","params":{"tag_id":"100"}}},{"title":"家常菜","icon":"jiachangcai","uri":{"url":"kitchener/search","params":{"tag_id":"115"}}},{"title":"鲁菜","icon":"dongbeicai","uri":{"url":"kitchener/search","params":{"tag_id":"101"}}},{"title":"粤菜","icon":"yuecai","uri":{"url":"kitchener/search","params":{"tag_id":"103"}}}],"buttons":[{"title":"家常用餐","icon":"http://img.idachu.com/201605/386d381952b6f98be3f32be34559bf90.png","uri":{"url":"bespeak"}},{"title":"私人订制","icon":"http://img.idachu.com/201605/08251d37acb2640729a061fff45d50a6.png","uri":{"url":"party/info","params":{"id":"1009"}}}],"hot":[{"title":"年夜饭","description":"","img":"http://img.idachu.com/201610/dff6cb5700899d307aff33ecfd72b036.png","uri":{"url":"party/info","params":{"id":"1000"}},"price":"","slogan":""},{"title":"精选家宴","description":"","img":"http://img.idachu.com/201605/e252b2ca3294e51a27de3f0882221687.jpg","uri":{"url":"party/info","params":{"id":"1027"}},"price":"","slogan":""},{"title":"场景宴席","description":"","img":"http://img.idachu.com/201611/4bb682143003aeef6a6a8797ee455b2b.jpg","uri":{"url":"party/info","params":{"id":"1026"}},"price":"","slogan":""},{"title":"单品热卖","description":"","img":"http://img.idachu.com/201610/74a878bcdb3310ac1918aa12812e9caa.jpg","uri":"http://www.idachu.cn/ingenuity/cat/8","price":"","slogan":""}],"version":{"version":"3.0.1","min":"0.5","upgrade":{"Android":["猴年年夜饭火热预订中 年味十足 乐享团圆！","预约更流畅了","服务更贴心了"]},"title":"安卓更新","align":1,"download":{"Android":"http://a.app.qq.com/o/simple.jsp?pkgname=com.example.idachuappone"}},"share":{"url":"http://www.idachu.cn/","title":"推荐一个厨师上门服务应用","content":"刚刚使用了爱大厨，大厨上门服务很给力，快来预约吧，大厨即刻到您家！","img":"http://www.idachu.cn/icon/images/share.png?ver=7f484403"},"packages":[{"id":"1","name":"四菜","description":"建议两人用餐","recipe_num":4,"price":158},{"id":"8","name":"五菜","description":"建议三人用餐","recipe_num":5,"price":158},{"id":"2","name":"六菜","description":"建议四人用餐","recipe_num":6,"price":158}],"awards":{"comment":{"text":"晒图评论","price":0},"friend":{"text":"分享朋友圈","price":0},"weixin":{"text":"推荐安装有微信的用户使用","price":0,"color":"#cccccc","order":1},"alipay":{"text":"推荐安装有支付宝的用户使用","price":0,"color":"#cccccc","order":2},"baidu":{"text":"推荐安装有百度钱包的用户使用","price":0,"color":"#cccccc","order":5,"hidden":1},"apple":{"text":"推荐安装有Apple Pay的用户使用","price":0,"color":"#cccccc","order":4},"cmb":{"text":"首次支付随机立减最高99元","price":0,"color":"#cccccc","order":3},"offline":{"text":"推荐有当面交易需求的用户使用","price":0,"color":"#cccccc"},"balance":{"text":"推荐会员用户使用","price":0,"color":"#cccccc","order":0},"balance_no":{"text":"充值会员尊享更多超值优惠","price":0,"color":"#cccccc"}},"party_id":1009,"max_distance":10,"uid":0}
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
        /**
         * events : [{"title":"爱大厨APP：在线支付与家宴预约上线","url":"http://www.idachu.cn/api/document/view/10","ext_url":"","description":"四菜与六菜套餐可实现在线支付，一键支付，厨师速达。家宴可在线预约，人多不怕，天天开趴！\n【活动期间：2014年12月18日--2015年1月30日 新注册用户，立送50元现金券】选择爱大厨，享受厨师上门烹饪星级大餐；选择爱大厨，彻底告别地沟油！","is_multi_media":"1","head":"http://img.idachu.com/201412/004706939e9adce683bd57233b36ec93.png","head_small":"http://img.idachu.com/201412/004706939e9adce683bd57233b36ec93.png"}]
         * top : [{"title":"有机食材","img":"http://img.idachu.com/201602/186c2872e72246fe0060b1f1517305de.jpg","uri":"http://www.idachu.cn/ingenuity/cat/9"},{"title":"一网通银行卡支付随机立减活动说明","img":"http://img.idachu.com/201610/ed32bb0bef9f2ed5e0d3b47585ee8d72.jpg","uri":"http://www.idachu.cn/document/view/154"},{"title":"爱大厨会员","img":"http://img.idachu.com/201603/8e2c123c9835607e1decaa6552453624.jpg","uri":{"url":"member/list"}}]
         * weixin10 : 1
         * flash :
         * weixin : 5
         * expands : []
         * first : {"title":"预订","description":"专业厨师上门服务","icon":"lucai","price":"158元起"}
         * tags : [{"title":"川菜","icon":"chuancai","uri":{"url":"kitchener/search","params":{"tag_id":"100"}}},{"title":"家常菜","icon":"jiachangcai","uri":{"url":"kitchener/search","params":{"tag_id":"115"}}},{"title":"鲁菜","icon":"dongbeicai","uri":{"url":"kitchener/search","params":{"tag_id":"101"}}},{"title":"粤菜","icon":"yuecai","uri":{"url":"kitchener/search","params":{"tag_id":"103"}}}]
         * buttons : [{"title":"家常用餐","icon":"http://img.idachu.com/201605/386d381952b6f98be3f32be34559bf90.png","uri":{"url":"bespeak"}},{"title":"私人订制","icon":"http://img.idachu.com/201605/08251d37acb2640729a061fff45d50a6.png","uri":{"url":"party/info","params":{"id":"1009"}}}]
         * hot : [{"title":"年夜饭","description":"","img":"http://img.idachu.com/201610/dff6cb5700899d307aff33ecfd72b036.png","uri":{"url":"party/info","params":{"id":"1000"}},"price":"","slogan":""},{"title":"精选家宴","description":"","img":"http://img.idachu.com/201605/e252b2ca3294e51a27de3f0882221687.jpg","uri":{"url":"party/info","params":{"id":"1027"}},"price":"","slogan":""},{"title":"场景宴席","description":"","img":"http://img.idachu.com/201611/4bb682143003aeef6a6a8797ee455b2b.jpg","uri":{"url":"party/info","params":{"id":"1026"}},"price":"","slogan":""},{"title":"单品热卖","description":"","img":"http://img.idachu.com/201610/74a878bcdb3310ac1918aa12812e9caa.jpg","uri":"http://www.idachu.cn/ingenuity/cat/8","price":"","slogan":""}]
         * version : {"version":"3.0.1","min":"0.5","upgrade":{"Android":["猴年年夜饭火热预订中 年味十足 乐享团圆！","预约更流畅了","服务更贴心了"]},"title":"安卓更新","align":1,"download":{"Android":"http://a.app.qq.com/o/simple.jsp?pkgname=com.example.idachuappone"}}
         * share : {"url":"http://www.idachu.cn/","title":"推荐一个厨师上门服务应用","content":"刚刚使用了爱大厨，大厨上门服务很给力，快来预约吧，大厨即刻到您家！","img":"http://www.idachu.cn/icon/images/share.png?ver=7f484403"}
         * packages : [{"id":"1","name":"四菜","description":"建议两人用餐","recipe_num":4,"price":158},{"id":"8","name":"五菜","description":"建议三人用餐","recipe_num":5,"price":158},{"id":"2","name":"六菜","description":"建议四人用餐","recipe_num":6,"price":158}]
         * awards : {"comment":{"text":"晒图评论","price":0},"friend":{"text":"分享朋友圈","price":0},"weixin":{"text":"推荐安装有微信的用户使用","price":0,"color":"#cccccc","order":1},"alipay":{"text":"推荐安装有支付宝的用户使用","price":0,"color":"#cccccc","order":2},"baidu":{"text":"推荐安装有百度钱包的用户使用","price":0,"color":"#cccccc","order":5,"hidden":1},"apple":{"text":"推荐安装有Apple Pay的用户使用","price":0,"color":"#cccccc","order":4},"cmb":{"text":"首次支付随机立减最高99元","price":0,"color":"#cccccc","order":3},"offline":{"text":"推荐有当面交易需求的用户使用","price":0,"color":"#cccccc"},"balance":{"text":"推荐会员用户使用","price":0,"color":"#cccccc","order":0},"balance_no":{"text":"充值会员尊享更多超值优惠","price":0,"color":"#cccccc"}}
         * party_id : 1009
         * max_distance : 10
         * uid : 0
         */

        private int weixin10;
        private String flash;
        private int weixin;
        private FirstBean first;
        private VersionBean version;
        private ShareBean share;
        private AwardsBean awards;
        private int party_id;
        private int max_distance;
        private int uid;
        private List<EventsBean> events;
        //private List<TopBean> top;
        private List<?> expands;
        private List<TagsBean> tags;
        private List<ButtonsBean> buttons;
        //private List<HotBean> hot;
        private List<PackagesBean> packages;

        public int getWeixin10() {
            return weixin10;
        }

        public void setWeixin10(int weixin10) {
            this.weixin10 = weixin10;
        }

        public String getFlash() {
            return flash;
        }

        public void setFlash(String flash) {
            this.flash = flash;
        }

        public int getWeixin() {
            return weixin;
        }

        public void setWeixin(int weixin) {
            this.weixin = weixin;
        }

        public FirstBean getFirst() {
            return first;
        }

        public void setFirst(FirstBean first) {
            this.first = first;
        }

        public VersionBean getVersion() {
            return version;
        }

        public void setVersion(VersionBean version) {
            this.version = version;
        }

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public AwardsBean getAwards() {
            return awards;
        }

        public void setAwards(AwardsBean awards) {
            this.awards = awards;
        }

        public int getParty_id() {
            return party_id;
        }

        public void setParty_id(int party_id) {
            this.party_id = party_id;
        }

        public int getMax_distance() {
            return max_distance;
        }

        public void setMax_distance(int max_distance) {
            this.max_distance = max_distance;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public List<EventsBean> getEvents() {
            return events;
        }

        public void setEvents(List<EventsBean> events) {
            this.events = events;
        }
/*
        public List<TopBean> getTop() {
            return top;
        }

       public void setTop(List<TopBean> top) {
            this.top = top;
        }*/

        public List<?> getExpands() {
            return expands;
        }

        public void setExpands(List<?> expands) {
            this.expands = expands;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<ButtonsBean> getButtons() {
            return buttons;
        }

        public void setButtons(List<ButtonsBean> buttons) {
            this.buttons = buttons;
        }

   /*     public List<HotBean> getHot() {
            return hot;
        }

        public void setHot(List<HotBean> hot) {
            this.hot = hot;
        }
*/
        public List<PackagesBean> getPackages() {
            return packages;
        }

        public void setPackages(List<PackagesBean> packages) {
            this.packages = packages;
        }

        public static class FirstBean {
            /**
             * title : 预订
             * description : 专业厨师上门服务
             * icon : lucai
             * price : 158元起
             */

            private String title;
            private String description;
            private String icon;
            private String price;

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

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }

        public static class VersionBean {
            /**
             * version : 3.0.1
             * min : 0.5
             * upgrade : {"Android":["猴年年夜饭火热预订中 年味十足 乐享团圆！","预约更流畅了","服务更贴心了"]}
             * title : 安卓更新
             * align : 1
             * download : {"Android":"http://a.app.qq.com/o/simple.jsp?pkgname=com.example.idachuappone"}
             */

            private String version;
            private String min;
            private UpgradeBean upgrade;
            private String title;
            private int align;
            private DownloadBean download;

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getMin() {
                return min;
            }

            public void setMin(String min) {
                this.min = min;
            }

            public UpgradeBean getUpgrade() {
                return upgrade;
            }

            public void setUpgrade(UpgradeBean upgrade) {
                this.upgrade = upgrade;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getAlign() {
                return align;
            }

            public void setAlign(int align) {
                this.align = align;
            }

            public DownloadBean getDownload() {
                return download;
            }

            public void setDownload(DownloadBean download) {
                this.download = download;
            }

            public static class UpgradeBean {
                private List<String> Android;

                public List<String> getAndroid() {
                    return Android;
                }

                public void setAndroid(List<String> Android) {
                    this.Android = Android;
                }
            }

            public static class DownloadBean {
                /**
                 * Android : http://a.app.qq.com/o/simple.jsp?pkgname=com.example.idachuappone
                 */

                private String Android;

                public String getAndroid() {
                    return Android;
                }

                public void setAndroid(String Android) {
                    this.Android = Android;
                }
            }
        }

        public static class ShareBean {
            /**
             * url : http://www.idachu.cn/
             * title : 推荐一个厨师上门服务应用
             * content : 刚刚使用了爱大厨，大厨上门服务很给力，快来预约吧，大厨即刻到您家！
             * img : http://www.idachu.cn/icon/images/share.png?ver=7f484403
             */

            private String url;
            private String title;
            private String content;
            private String img;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }

        public static class AwardsBean {
            /**
             * comment : {"text":"晒图评论","price":0}
             * friend : {"text":"分享朋友圈","price":0}
             * weixin : {"text":"推荐安装有微信的用户使用","price":0,"color":"#cccccc","order":1}
             * alipay : {"text":"推荐安装有支付宝的用户使用","price":0,"color":"#cccccc","order":2}
             * baidu : {"text":"推荐安装有百度钱包的用户使用","price":0,"color":"#cccccc","order":5,"hidden":1}
             * apple : {"text":"推荐安装有Apple Pay的用户使用","price":0,"color":"#cccccc","order":4}
             * cmb : {"text":"首次支付随机立减最高99元","price":0,"color":"#cccccc","order":3}
             * offline : {"text":"推荐有当面交易需求的用户使用","price":0,"color":"#cccccc"}
             * balance : {"text":"推荐会员用户使用","price":0,"color":"#cccccc","order":0}
             * balance_no : {"text":"充值会员尊享更多超值优惠","price":0,"color":"#cccccc"}
             */

            private CommentBean comment;
            private FriendBean friend;
            private WeixinBean weixin;
            private AlipayBean alipay;
            private BaiduBean baidu;
            private AppleBean apple;
            private CmbBean cmb;
            private OfflineBean offline;
            private BalanceBean balance;
            private BalanceNoBean balance_no;

            public CommentBean getComment() {
                return comment;
            }

            public void setComment(CommentBean comment) {
                this.comment = comment;
            }

            public FriendBean getFriend() {
                return friend;
            }

            public void setFriend(FriendBean friend) {
                this.friend = friend;
            }

            public WeixinBean getWeixin() {
                return weixin;
            }

            public void setWeixin(WeixinBean weixin) {
                this.weixin = weixin;
            }

            public AlipayBean getAlipay() {
                return alipay;
            }

            public void setAlipay(AlipayBean alipay) {
                this.alipay = alipay;
            }

            public BaiduBean getBaidu() {
                return baidu;
            }

            public void setBaidu(BaiduBean baidu) {
                this.baidu = baidu;
            }

            public AppleBean getApple() {
                return apple;
            }

            public void setApple(AppleBean apple) {
                this.apple = apple;
            }

            public CmbBean getCmb() {
                return cmb;
            }

            public void setCmb(CmbBean cmb) {
                this.cmb = cmb;
            }

            public OfflineBean getOffline() {
                return offline;
            }

            public void setOffline(OfflineBean offline) {
                this.offline = offline;
            }

            public BalanceBean getBalance() {
                return balance;
            }

            public void setBalance(BalanceBean balance) {
                this.balance = balance;
            }

            public BalanceNoBean getBalance_no() {
                return balance_no;
            }

            public void setBalance_no(BalanceNoBean balance_no) {
                this.balance_no = balance_no;
            }

            public static class CommentBean {
                /**
                 * text : 晒图评论
                 * price : 0
                 */

                private String text;
                private int price;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }
            }

            public static class FriendBean {
                /**
                 * text : 分享朋友圈
                 * price : 0
                 */

                private String text;
                private int price;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }
            }

            public static class WeixinBean {
                /**
                 * text : 推荐安装有微信的用户使用
                 * price : 0
                 * color : #cccccc
                 * order : 1
                 */

                private String text;
                private int price;
                private String color;
                private int order;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }
            }

            public static class AlipayBean {
                /**
                 * text : 推荐安装有支付宝的用户使用
                 * price : 0
                 * color : #cccccc
                 * order : 2
                 */

                private String text;
                private int price;
                private String color;
                private int order;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }
            }

            public static class BaiduBean {
                /**
                 * text : 推荐安装有百度钱包的用户使用
                 * price : 0
                 * color : #cccccc
                 * order : 5
                 * hidden : 1
                 */

                private String text;
                private int price;
                private String color;
                private int order;
                private int hidden;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public int getHidden() {
                    return hidden;
                }

                public void setHidden(int hidden) {
                    this.hidden = hidden;
                }
            }

            public static class AppleBean {
                /**
                 * text : 推荐安装有Apple Pay的用户使用
                 * price : 0
                 * color : #cccccc
                 * order : 4
                 */

                private String text;
                private int price;
                private String color;
                private int order;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }
            }

            public static class CmbBean {
                /**
                 * text : 首次支付随机立减最高99元
                 * price : 0
                 * color : #cccccc
                 * order : 3
                 */

                private String text;
                private int price;
                private String color;
                private int order;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }
            }

            public static class OfflineBean {
                /**
                 * text : 推荐有当面交易需求的用户使用
                 * price : 0
                 * color : #ccccccd
                 */

                private String text;
                private int price;
                private String color;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }
            }

            public static class BalanceBean {
                /**
                 * text : 推荐会员用户使用
                 * price : 0
                 * color : #cccccc
                 * order : 0
                 */

                private String text;
                private int price;
                private String color;
                private int order;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }
            }

            public static class BalanceNoBean {
                /**
                 * text : 充值会员尊享更多超值优惠
                 * price : 0
                 * color : #cccccc
                 */

                private String text;
                private int price;
                private String color;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }
            }
        }

        public static class EventsBean {
            /**
             * title : 爱大厨APP：在线支付与家宴预约上线
             * url : http://www.idachu.cn/api/document/view/10
             * ext_url :
             * description : 四菜与六菜套餐可实现在线支付，一键支付，厨师速达。家宴可在线预约，人多不怕，天天开趴！
             【活动期间：2014年12月18日--2015年1月30日 新注册用户，立送50元现金券】选择爱大厨，享受厨师上门烹饪星级大餐；选择爱大厨，彻底告别地沟油！
             * is_multi_media : 1
             * head : http://img.idachu.com/201412/004706939e9adce683bd57233b36ec93.png
             * head_small : http://img.idachu.com/201412/004706939e9adce683bd57233b36ec93.png
             */

            private String title;
            private String url;
            private String ext_url;
            private String description;
            private String is_multi_media;
            private String head;
            private String head_small;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getExt_url() {
                return ext_url;
            }

            public void setExt_url(String ext_url) {
                this.ext_url = ext_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIs_multi_media() {
                return is_multi_media;
            }

            public void setIs_multi_media(String is_multi_media) {
                this.is_multi_media = is_multi_media;
            }

            public String getHead() {
                return head;
            }

            public void setHead(String head) {
                this.head = head;
            }

            public String getHead_small() {
                return head_small;
            }

            public void setHead_small(String head_small) {
                this.head_small = head_small;
            }
        }

        public static class TopBean {
            /**
             * title : 有机食材
             * img : http://img.idachu.com/201602/186c2872e72246fe0060b1f1517305de.jpg
             * uri : http://www.idachu.cn/ingenuity/cat/9
             */

            private String title;
            private String img;
            private String uri;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }
        }

        public static class TagsBean {
            /**
             * title : 川菜
             * icon : chuancai
             * uri : {"url":"kitchener/search","params":{"tag_id":"100"}}
             */

            private String title;
            private String icon;
            private UriBean uri;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public UriBean getUri() {
                return uri;
            }

            public void setUri(UriBean uri) {
                this.uri = uri;
            }

            public static class UriBean {
                /**
                 * url : kitchener/search
                 * params : {"tag_id":"100"}
                 */

                private String url;
                private ParamsBean params;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public ParamsBean getParams() {
                    return params;
                }

                public void setParams(ParamsBean params) {
                    this.params = params;
                }

                public static class ParamsBean {
                    /**
                     * tag_id : 100
                     */

                    private String tag_id;

                    public String getTag_id() {
                        return tag_id;
                    }

                    public void setTag_id(String tag_id) {
                        this.tag_id = tag_id;
                    }
                }
            }
        }

        public static class ButtonsBean {
            /**
             * title : 家常用餐
             * icon : http://img.idachu.com/201605/386d381952b6f98be3f32be34559bf90.png
             * uri : {"url":"bespeak"}
             */

            private String title;
            private String icon;
            private UriBeanX uri;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public UriBeanX getUri() {
                return uri;
            }

            public void setUri(UriBeanX uri) {
                this.uri = uri;
            }

            public static class UriBeanX {
                /**
                 * url : bespeak
                 */

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class HotBean {
            /**
             * title : 年夜饭
             * description :
             * img : http://img.idachu.com/201610/dff6cb5700899d307aff33ecfd72b036.png
             * uri : {"url":"party/info","params":{"id":"1000"}}
             * price :
             * slogan :
             */

            private String title;
            private String description;
            private String img;
            private UriBeanXX uri;
            private String price;
            private String slogan;

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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public UriBeanXX getUri() {
                return uri;
            }

            public void setUri(UriBeanXX uri) {
                this.uri = uri;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public static class UriBeanXX {
                /**
                 * url : party/info
                 * params : {"id":"1000"}
                 */

                private String url;
                private ParamsBeanX params;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public ParamsBeanX getParams() {
                    return params;
                }

                public void setParams(ParamsBeanX params) {
                    this.params = params;
                }

                public static class ParamsBeanX {
                    /**
                     * id : 1000
                     */

                    private String id;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }
                }
            }
        }

        public static class PackagesBean {
            /**
             * id : 1
             * name : 四菜
             * description : 建议两人用餐
             * recipe_num : 4
             * price : 158
             */

            private String id;
            private String name;
            private String description;
            private int recipe_num;
            private int price;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getRecipe_num() {
                return recipe_num;
            }

            public void setRecipe_num(int recipe_num) {
                this.recipe_num = recipe_num;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
}
