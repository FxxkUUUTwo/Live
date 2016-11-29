package com.other.project.live.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wanghaixin on 16/11/29.
 */
public class PrivateDingZhi {


    /**
     * code : 10000
     * data : {"id":"1009","name":"私人订制","slogan":"私厨上门烹制高端家宴","head":"http://img.idachu.com/201504/a34c4d7790b102ef3fe19db6d0b4ce28.jpg","description":"1.专业主厨，高端服务，亲自登门下厨；\r\n2.创意菜品，千挑万选，齐备优质食材；\r\n3.美食美器，特制碗碟，观菜如展画卷；\r\n4.多档菜单，灵活调整，满足各种需求。\r\n\r\n请提前三天预订哦，特殊需求可联系客服人员","from":"2015-09-28","to":"2016-12-31","dates":{"2016-12-02":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-03":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-04":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-05":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-06":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-07":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-08":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-09":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-10":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-11":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-12":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-13":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-14":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-15":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-16":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-17":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-18":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-19":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-20":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-21":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-22":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-23":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-24":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-25":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-26":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-27":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-28":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-29":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-30":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-31":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-01":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-02":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-03":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-04":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-05":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-06":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-08":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-09":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-10":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-11":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-12":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-13":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-14":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-15":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-16":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-17":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-18":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-19":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-20":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-21":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-22":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-23":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-24":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-25":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-26":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-27":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-28":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-29":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-30":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-31":[10,11,12,13,14,15,16,17,18,19,20]},"items":[{"id":"10069","name":"春花秋月·宴","slogan":"二凉菜五热菜一汤羹一主食，适用于4-6人","title":"含食材，适宜4-6人享用","price_info":"RMB 1288/套","people_num":"适用于4-6人","price":1288,"bespeak_num":483,"head":"201509/b7358019c5e7cc3dfeb098027f8a0b0e.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201511/3d97b6668e54b0223e32c7dcff757be9_300.jpg","list_img":"http://img.idachu.com/201609/4125a3925bd3b71c9c3ad7f3831718cc.jpg","top_img":"http://img.idachu.com/201609/778346024e3f652488704b1c2864b14c.jpg"},{"id":"10070","name":"稻谷飘香·宴","slogan":"四凉菜八热菜一汤羹一主食，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 1588/套","people_num":"适用于8-10人","price":1588,"bespeak_num":518,"head":"201509/b4f38733d316e628b29abbe2cb2fe9a2.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201609/668b627fd7b1c19c93ff79aff6346355_300.jpg","list_img":"http://img.idachu.com/201604/3b603e927680fdc80e0f49bd8a3f83de.jpg","top_img":"http://img.idachu.com/201604/a5fa02dfa997d77b6984b670d6263f28.jpg"},{"id":"10071","name":"浮郁金酒·宴","slogan":"五凉菜九热菜一汤羹一主食，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 2888/套","people_num":"适用于8-10人","price":2888,"bespeak_num":204,"head":"201509/27ee354650588e30dcc682bdf011b5e4.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201609/31e2b6b8f3ea731ada406c04d6393c0f_300.jpg","list_img":"http://img.idachu.com/201611/81c0c282e46073635d59e9a645a484da.jpg","top_img":"http://img.idachu.com/201611/d221928a9190f9c2ea5456b6d4ad9278.jpg"},{"id":"10074","name":"春诵夏弦·宴","slogan":"五凉菜九热菜一汤羹一甜点，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 3588/套","people_num":"适用于8-10人","price":3588,"bespeak_num":182,"head":"201509/bdb0400cdd6753373bece278fe5cfe02.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201504/81b97f980ff4fa1b80ea4c8ed48a5a6d_300.jpg","list_img":"http://img.idachu.com/201609/cc73434654070ddf9a72e9c5a4997bf9.jpg","top_img":"http://img.idachu.com/201609/eaf345e6ad5db28aebd73759e6618515.jpg"},{"id":"10073","name":"圣郁金澜·宴","slogan":"六凉菜八热菜一汤羹一甜点，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 5288/套","people_num":"适用于8-10人","price":5288,"bespeak_num":159,"head":"201509/c95f165a3d80d6a15612ed65c2db1f3c.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201609/006f58edb015379a2116b4f71a899983_300.jpg","list_img":"http://img.idachu.com/201609/92d5f9a4fb0484f21b39502a783949e1.jpg","top_img":"http://img.idachu.com/201609/87b5c03d815eb93b7eabae88f54a643a.jpg"},{"id":"10072","name":"琼楼圣宴","slogan":"八凉菜六热菜一主食一甜点，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 8888/套","people_num":"适用于8-10人","price":8888,"bespeak_num":196,"head":"201509/2ce93606c6a5fc44e49bd4211b6081fc.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201609/6e2f27fe980f52852c12ce1cd9714daa_300.jpg","list_img":"http://img.idachu.com/201609/2e6db9bf75975b34e10ac684cafbb88f.jpg","top_img":"http://img.idachu.com/201609/f038d68696ba1577a1a20c62bc675604.jpg"}],"selected":"2016-02-07","hotline":{"tel":"13810914829","worktime":"9:30-18:30"},"share_img":"http://img.idachu.com/201511/0e608bce545e603476db1968bd507c70_100.jpg","share_title":"[爱大厨]家宴私人订制，美食星厨随时预约~","share_description":"一场私人家宴，远离纷杂的餐厅，了然无味的菜品~来爱大厨享受不一样的私厨上门服务~","reserve":"http://www.idachu.cn/party/reserve","reserve_img":"http://img.idachu.com/201605/5f526f5dd2b3bc50589c76ec8e23a829.jpg"}
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
         * id : 1009
         * name : 私人订制
         * slogan : 私厨上门烹制高端家宴
         * head : http://img.idachu.com/201504/a34c4d7790b102ef3fe19db6d0b4ce28.jpg
         * description : 1.专业主厨，高端服务，亲自登门下厨；
         2.创意菜品，千挑万选，齐备优质食材；
         3.美食美器，特制碗碟，观菜如展画卷；
         4.多档菜单，灵活调整，满足各种需求。

         请提前三天预订哦，特殊需求可联系客服人员
         * from : 2015-09-28
         * to : 2016-12-31
         * dates : {"2016-12-02":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-03":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-04":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-05":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-06":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-07":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-08":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-09":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-10":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-11":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-12":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-13":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-14":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-15":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-16":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-17":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-18":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-19":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-20":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-21":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-22":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-23":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-24":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-25":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-26":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-27":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-28":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-29":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-30":[10,11,12,13,14,15,16,17,18,19,20],"2016-12-31":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-01":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-02":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-03":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-04":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-05":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-06":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-08":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-09":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-10":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-11":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-12":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-13":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-14":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-15":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-16":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-17":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-18":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-19":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-20":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-21":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-22":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-23":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-24":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-25":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-26":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-27":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-28":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-29":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-30":[10,11,12,13,14,15,16,17,18,19,20],"2017-01-31":[10,11,12,13,14,15,16,17,18,19,20]}
         * items : [{"id":"10069","name":"春花秋月·宴","slogan":"二凉菜五热菜一汤羹一主食，适用于4-6人","title":"含食材，适宜4-6人享用","price_info":"RMB 1288/套","people_num":"适用于4-6人","price":1288,"bespeak_num":483,"head":"201509/b7358019c5e7cc3dfeb098027f8a0b0e.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201511/3d97b6668e54b0223e32c7dcff757be9_300.jpg","list_img":"http://img.idachu.com/201609/4125a3925bd3b71c9c3ad7f3831718cc.jpg","top_img":"http://img.idachu.com/201609/778346024e3f652488704b1c2864b14c.jpg"},{"id":"10070","name":"稻谷飘香·宴","slogan":"四凉菜八热菜一汤羹一主食，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 1588/套","people_num":"适用于8-10人","price":1588,"bespeak_num":518,"head":"201509/b4f38733d316e628b29abbe2cb2fe9a2.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201609/668b627fd7b1c19c93ff79aff6346355_300.jpg","list_img":"http://img.idachu.com/201604/3b603e927680fdc80e0f49bd8a3f83de.jpg","top_img":"http://img.idachu.com/201604/a5fa02dfa997d77b6984b670d6263f28.jpg"},{"id":"10071","name":"浮郁金酒·宴","slogan":"五凉菜九热菜一汤羹一主食，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 2888/套","people_num":"适用于8-10人","price":2888,"bespeak_num":204,"head":"201509/27ee354650588e30dcc682bdf011b5e4.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201609/31e2b6b8f3ea731ada406c04d6393c0f_300.jpg","list_img":"http://img.idachu.com/201611/81c0c282e46073635d59e9a645a484da.jpg","top_img":"http://img.idachu.com/201611/d221928a9190f9c2ea5456b6d4ad9278.jpg"},{"id":"10074","name":"春诵夏弦·宴","slogan":"五凉菜九热菜一汤羹一甜点，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 3588/套","people_num":"适用于8-10人","price":3588,"bespeak_num":182,"head":"201509/bdb0400cdd6753373bece278fe5cfe02.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201504/81b97f980ff4fa1b80ea4c8ed48a5a6d_300.jpg","list_img":"http://img.idachu.com/201609/cc73434654070ddf9a72e9c5a4997bf9.jpg","top_img":"http://img.idachu.com/201609/eaf345e6ad5db28aebd73759e6618515.jpg"},{"id":"10073","name":"圣郁金澜·宴","slogan":"六凉菜八热菜一汤羹一甜点，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 5288/套","people_num":"适用于8-10人","price":5288,"bespeak_num":159,"head":"201509/c95f165a3d80d6a15612ed65c2db1f3c.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201609/006f58edb015379a2116b4f71a899983_300.jpg","list_img":"http://img.idachu.com/201609/92d5f9a4fb0484f21b39502a783949e1.jpg","top_img":"http://img.idachu.com/201609/87b5c03d815eb93b7eabae88f54a643a.jpg"},{"id":"10072","name":"琼楼圣宴","slogan":"八凉菜六热菜一主食一甜点，适用于8-10人","title":"含食材，适宜8-10人享用","price_info":"RMB 8888/套","people_num":"适用于8-10人","price":8888,"bespeak_num":196,"head":"201509/2ce93606c6a5fc44e49bd4211b6081fc.jpg","head2":"","description":"私人订制宴会请至少提前两天预定\r\n费用含食材及厨师服务费\r\n成品以实物为准，图片仅供参考\r\n如有任何疑问，请联系爱大厨菜品研发部","first_img":"http://img.idachu.com/201609/6e2f27fe980f52852c12ce1cd9714daa_300.jpg","list_img":"http://img.idachu.com/201609/2e6db9bf75975b34e10ac684cafbb88f.jpg","top_img":"http://img.idachu.com/201609/f038d68696ba1577a1a20c62bc675604.jpg"}]
         * selected : 2016-02-07
         * hotline : {"tel":"13810914829","worktime":"9:30-18:30"}
         * share_img : http://img.idachu.com/201511/0e608bce545e603476db1968bd507c70_100.jpg
         * share_title : [爱大厨]家宴私人订制，美食星厨随时预约~
         * share_description : 一场私人家宴，远离纷杂的餐厅，了然无味的菜品~来爱大厨享受不一样的私厨上门服务~
         * reserve : http://www.idachu.cn/party/reserve
         * reserve_img : http://img.idachu.com/201605/5f526f5dd2b3bc50589c76ec8e23a829.jpg
         */

        private String id;
        private String name;
        private String slogan;
        private String head;
        private String description;
        private String from;
        private String to;
        private DatesBean dates;
        private String selected;
        private HotlineBean hotline;
        private String share_img;
        private String share_title;
        private String share_description;
        private String reserve;
        private String reserve_img;
        private List<ItemsBean> items;

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

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public DatesBean getDates() {
            return dates;
        }

        public void setDates(DatesBean dates) {
            this.dates = dates;
        }

        public String getSelected() {
            return selected;
        }

        public void setSelected(String selected) {
            this.selected = selected;
        }

        public HotlineBean getHotline() {
            return hotline;
        }

        public void setHotline(HotlineBean hotline) {
            this.hotline = hotline;
        }

        public String getShare_img() {
            return share_img;
        }

        public void setShare_img(String share_img) {
            this.share_img = share_img;
        }

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public String getShare_description() {
            return share_description;
        }

        public void setShare_description(String share_description) {
            this.share_description = share_description;
        }

        public String getReserve() {
            return reserve;
        }

        public void setReserve(String reserve) {
            this.reserve = reserve;
        }

        public String getReserve_img() {
            return reserve_img;
        }

        public void setReserve_img(String reserve_img) {
            this.reserve_img = reserve_img;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class DatesBean {
            @SerializedName("2016-12-02")
            private List<Integer> value1;
            @SerializedName("2016-12-03")
            private List<Integer> value2;
            @SerializedName("2016-12-04")
            private List<Integer> value3;
            @SerializedName("2016-12-05")
            private List<Integer> value4;
            @SerializedName("2016-12-06")
            private List<Integer> value5;
            @SerializedName("2016-12-07")
            private List<Integer> value7;
            @SerializedName("2016-12-08")
            private List<Integer> value8;
            @SerializedName("2016-12-09")
            private List<Integer> value9;
            @SerializedName("2016-12-10")
            private List<Integer> value10;
            @SerializedName("2016-12-11")
            private List<Integer> value11;
            @SerializedName("2016-12-12")
            private List<Integer> value12;
            @SerializedName("2016-12-13")
            private List<Integer> value13;
            @SerializedName("2016-12-14")
            private List<Integer> value14;
            @SerializedName("2016-12-15")
            private List<Integer> value15;
            @SerializedName("2016-12-16")
            private List<Integer> value16;
            @SerializedName("2016-12-17")
            private List<Integer> value17;
            @SerializedName("2016-12-18")
            private List<Integer> value18;
            @SerializedName("2016-12-19")
            private List<Integer> value19;
            @SerializedName("2016-12-20")
            private List<Integer> value20;
            @SerializedName("2016-12-21")
            private List<Integer> value21;
            @SerializedName("2016-12-22")
            private List<Integer> value22;
            @SerializedName("2016-12-23")
            private List<Integer> value23;
            @SerializedName("2016-12-24")
            private List<Integer> value24;
            @SerializedName("2016-12-25")
            private List<Integer> value25;
            @SerializedName("2016-12-26")
            private List<Integer> value26;
            @SerializedName("2016-12-27")
            private List<Integer> value27;
            @SerializedName("2016-12-28")
            private List<Integer> value28;
            @SerializedName("2016-12-29")
            private List<Integer> value29;
            @SerializedName("2016-12-30")
            private List<Integer> value30;
            @SerializedName("2016-12-31")
            private List<Integer> value31;
            @SerializedName("2017-01-01")
            private List<Integer> value201;
            @SerializedName("2017-01-02")
            private List<Integer> value202;
            @SerializedName("2017-01-03")
            private List<Integer> value203;
            @SerializedName("2017-01-04")
            private List<Integer> value204;
            @SerializedName("2017-01-05")
            private List<Integer> value205;
            @SerializedName("2017-01-06")
            private List<Integer> value206;
            @SerializedName("2017-01-08")
            private List<Integer> value208;
            @SerializedName("2017-01-09")
            private List<Integer> value209;
            @SerializedName("2017-01-10")
            private List<Integer> value210;
            @SerializedName("2017-01-11")
            private List<Integer> value211;
            @SerializedName("2017-01-12")
            private List<Integer> value212;
            @SerializedName("2017-01-13")
            private List<Integer> value213;
            @SerializedName("2017-01-14")
            private List<Integer> value214;
            @SerializedName("2017-01-15")
            private List<Integer> value215;
            @SerializedName("2017-01-16")
            private List<Integer> value216;
            @SerializedName("2017-01-17")
            private List<Integer> value217;
            @SerializedName("2017-01-18")
            private List<Integer> value218;
            @SerializedName("2017-01-19")
            private List<Integer> value219;
            @SerializedName("2017-01-20")
            private List<Integer> value220;
            @SerializedName("2017-01-21")
            private List<Integer> value221;
            @SerializedName("2017-01-22")
            private List<Integer> value222;
            @SerializedName("2017-01-23")
            private List<Integer> value223;
            @SerializedName("2017-01-24")
            private List<Integer> value224;
            @SerializedName("2017-01-25")
            private List<Integer> value225;
            @SerializedName("2017-01-26")
            private List<Integer> value226;
            @SerializedName("2017-01-27")
            private List<Integer> value227;
            @SerializedName("2017-01-28")
            private List<Integer> value228;
            @SerializedName("2017-01-29")
            private List<Integer> value229;
            @SerializedName("2017-01-30")
            private List<Integer> value230;
            @SerializedName("2017-01-31")
            private List<Integer> value231;

            public List<Integer> getValue1() {
                return value1;
            }

            public void setValue1(List<Integer> value1) {
                this.value1 = value1;
            }

            public List<Integer> getValue2() {
                return value2;
            }

            public void setValue2(List<Integer> value2) {
                this.value2 = value2;
            }

            public List<Integer> getValue3() {
                return value3;
            }

            public void setValue3(List<Integer> value3) {
                this.value3 = value3;
            }

            public List<Integer> getValue4() {
                return value4;
            }

            public void setValue4(List<Integer> value4) {
                this.value4 = value4;
            }

            public List<Integer> getValue5() {
                return value5;
            }

            public void setValue5(List<Integer> value5) {
                this.value5 = value5;
            }

            public List<Integer> getValue7() {
                return value7;
            }

            public void setValue7(List<Integer> value7) {
                this.value7 = value7;
            }

            public List<Integer> getValue8() {
                return value8;
            }

            public void setValue8(List<Integer> value8) {
                this.value8 = value8;
            }

            public List<Integer> getValue9() {
                return value9;
            }

            public void setValue9(List<Integer> value9) {
                this.value9 = value9;
            }

            public List<Integer> getValue10() {
                return value10;
            }

            public void setValue10(List<Integer> value10) {
                this.value10 = value10;
            }

            public List<Integer> getValue11() {
                return value11;
            }

            public void setValue11(List<Integer> value11) {
                this.value11 = value11;
            }

            public List<Integer> getValue12() {
                return value12;
            }

            public void setValue12(List<Integer> value12) {
                this.value12 = value12;
            }

            public List<Integer> getValue13() {
                return value13;
            }

            public void setValue13(List<Integer> value13) {
                this.value13 = value13;
            }

            public List<Integer> getValue14() {
                return value14;
            }

            public void setValue14(List<Integer> value14) {
                this.value14 = value14;
            }

            public List<Integer> getValue15() {
                return value15;
            }

            public void setValue15(List<Integer> value15) {
                this.value15 = value15;
            }

            public List<Integer> getValue16() {
                return value16;
            }

            public void setValue16(List<Integer> value16) {
                this.value16 = value16;
            }

            public List<Integer> getValue17() {
                return value17;
            }

            public void setValue17(List<Integer> value17) {
                this.value17 = value17;
            }

            public List<Integer> getValue18() {
                return value18;
            }

            public void setValue18(List<Integer> value18) {
                this.value18 = value18;
            }

            public List<Integer> getValue19() {
                return value19;
            }

            public void setValue19(List<Integer> value19) {
                this.value19 = value19;
            }

            public List<Integer> getValue20() {
                return value20;
            }

            public void setValue20(List<Integer> value20) {
                this.value20 = value20;
            }

            public List<Integer> getValue21() {
                return value21;
            }

            public void setValue21(List<Integer> value21) {
                this.value21 = value21;
            }

            public List<Integer> getValue22() {
                return value22;
            }

            public void setValue22(List<Integer> value22) {
                this.value22 = value22;
            }

            public List<Integer> getValue23() {
                return value23;
            }

            public void setValue23(List<Integer> value23) {
                this.value23 = value23;
            }

            public List<Integer> getValue24() {
                return value24;
            }

            public void setValue24(List<Integer> value24) {
                this.value24 = value24;
            }

            public List<Integer> getValue25() {
                return value25;
            }

            public void setValue25(List<Integer> value25) {
                this.value25 = value25;
            }

            public List<Integer> getValue26() {
                return value26;
            }

            public void setValue26(List<Integer> value26) {
                this.value26 = value26;
            }

            public List<Integer> getValue27() {
                return value27;
            }

            public void setValue27(List<Integer> value27) {
                this.value27 = value27;
            }

            public List<Integer> getValue28() {
                return value28;
            }

            public void setValue28(List<Integer> value28) {
                this.value28 = value28;
            }

            public List<Integer> getValue29() {
                return value29;
            }

            public void setValue29(List<Integer> value29) {
                this.value29 = value29;
            }

            public List<Integer> getValue30() {
                return value30;
            }

            public void setValue30(List<Integer> value30) {
                this.value30 = value30;
            }

            public List<Integer> getValue31() {
                return value31;
            }

            public void setValue31(List<Integer> value31) {
                this.value31 = value31;
            }

            public List<Integer> getValue201() {
                return value201;
            }

            public void setValue201(List<Integer> value201) {
                this.value201 = value201;
            }

            public List<Integer> getValue202() {
                return value202;
            }

            public void setValue202(List<Integer> value202) {
                this.value202 = value202;
            }

            public List<Integer> getValue203() {
                return value203;
            }

            public void setValue203(List<Integer> value203) {
                this.value203 = value203;
            }

            public List<Integer> getValue204() {
                return value204;
            }

            public void setValue204(List<Integer> value204) {
                this.value204 = value204;
            }

            public List<Integer> getValue205() {
                return value205;
            }

            public void setValue205(List<Integer> value205) {
                this.value205 = value205;
            }

            public List<Integer> getValue206() {
                return value206;
            }

            public void setValue206(List<Integer> value206) {
                this.value206 = value206;
            }

            public List<Integer> getValue208() {
                return value208;
            }

            public void setValue208(List<Integer> value208) {
                this.value208 = value208;
            }

            public List<Integer> getValue209() {
                return value209;
            }

            public void setValue209(List<Integer> value209) {
                this.value209 = value209;
            }

            public List<Integer> getValue210() {
                return value210;
            }

            public void setValue210(List<Integer> value210) {
                this.value210 = value210;
            }

            public List<Integer> getValue211() {
                return value211;
            }

            public void setValue211(List<Integer> value211) {
                this.value211 = value211;
            }

            public List<Integer> getValue212() {
                return value212;
            }

            public void setValue212(List<Integer> value212) {
                this.value212 = value212;
            }

            public List<Integer> getValue213() {
                return value213;
            }

            public void setValue213(List<Integer> value213) {
                this.value213 = value213;
            }

            public List<Integer> getValue214() {
                return value214;
            }

            public void setValue214(List<Integer> value214) {
                this.value214 = value214;
            }

            public List<Integer> getValue215() {
                return value215;
            }

            public void setValue215(List<Integer> value215) {
                this.value215 = value215;
            }

            public List<Integer> getValue216() {
                return value216;
            }

            public void setValue216(List<Integer> value216) {
                this.value216 = value216;
            }

            public List<Integer> getValue217() {
                return value217;
            }

            public void setValue217(List<Integer> value217) {
                this.value217 = value217;
            }

            public List<Integer> getValue218() {
                return value218;
            }

            public void setValue218(List<Integer> value218) {
                this.value218 = value218;
            }

            public List<Integer> getValue219() {
                return value219;
            }

            public void setValue219(List<Integer> value219) {
                this.value219 = value219;
            }

            public List<Integer> getValue220() {
                return value220;
            }

            public void setValue220(List<Integer> value220) {
                this.value220 = value220;
            }

            public List<Integer> getValue221() {
                return value221;
            }

            public void setValue221(List<Integer> value221) {
                this.value221 = value221;
            }

            public List<Integer> getValue222() {
                return value222;
            }

            public void setValue222(List<Integer> value222) {
                this.value222 = value222;
            }

            public List<Integer> getValue223() {
                return value223;
            }

            public void setValue223(List<Integer> value223) {
                this.value223 = value223;
            }

            public List<Integer> getValue224() {
                return value224;
            }

            public void setValue224(List<Integer> value224) {
                this.value224 = value224;
            }

            public List<Integer> getValue225() {
                return value225;
            }

            public void setValue225(List<Integer> value225) {
                this.value225 = value225;
            }

            public List<Integer> getValue226() {
                return value226;
            }

            public void setValue226(List<Integer> value226) {
                this.value226 = value226;
            }

            public List<Integer> getValue227() {
                return value227;
            }

            public void setValue227(List<Integer> value227) {
                this.value227 = value227;
            }

            public List<Integer> getValue228() {
                return value228;
            }

            public void setValue228(List<Integer> value228) {
                this.value228 = value228;
            }

            public List<Integer> getValue229() {
                return value229;
            }

            public void setValue229(List<Integer> value229) {
                this.value229 = value229;
            }

            public List<Integer> getValue230() {
                return value230;
            }

            public void setValue230(List<Integer> value230) {
                this.value230 = value230;
            }

            public List<Integer> getValue231() {
                return value231;
            }

            public void setValue231(List<Integer> value231) {
                this.value231 = value231;
            }
        }

        public static class HotlineBean {
            /**
             * tel : 13810914829
             * worktime : 9:30-18:30
             */

            private String tel;
            private String worktime;

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getWorktime() {
                return worktime;
            }

            public void setWorktime(String worktime) {
                this.worktime = worktime;
            }
        }

        public static class ItemsBean {
            /**
             * id : 10069
             * name : 春花秋月·宴
             * slogan : 二凉菜五热菜一汤羹一主食，适用于4-6人
             * title : 含食材，适宜4-6人享用
             * price_info : RMB 1288/套
             * people_num : 适用于4-6人
             * price : 1288
             * bespeak_num : 483
             * head : 201509/b7358019c5e7cc3dfeb098027f8a0b0e.jpg
             * head2 :
             * description : 私人订制宴会请至少提前两天预定
             费用含食材及厨师服务费
             成品以实物为准，图片仅供参考
             如有任何疑问，请联系爱大厨菜品研发部
             * first_img : http://img.idachu.com/201511/3d97b6668e54b0223e32c7dcff757be9_300.jpg
             * list_img : http://img.idachu.com/201609/4125a3925bd3b71c9c3ad7f3831718cc.jpg
             * top_img : http://img.idachu.com/201609/778346024e3f652488704b1c2864b14c.jpg
             */

            private String id;
            private String name;
            private String slogan;
            private String title;
            private String price_info;
            private String people_num;
            private int price;
            private int bespeak_num;
            private String head;
            private String head2;
            private String description;
            private String first_img;
            private String list_img;
            private String top_img;

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

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice_info() {
                return price_info;
            }

            public void setPrice_info(String price_info) {
                this.price_info = price_info;
            }

            public String getPeople_num() {
                return people_num;
            }

            public void setPeople_num(String people_num) {
                this.people_num = people_num;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getBespeak_num() {
                return bespeak_num;
            }

            public void setBespeak_num(int bespeak_num) {
                this.bespeak_num = bespeak_num;
            }

            public String getHead() {
                return head;
            }

            public void setHead(String head) {
                this.head = head;
            }

            public String getHead2() {
                return head2;
            }

            public void setHead2(String head2) {
                this.head2 = head2;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getFirst_img() {
                return first_img;
            }

            public void setFirst_img(String first_img) {
                this.first_img = first_img;
            }

            public String getList_img() {
                return list_img;
            }

            public void setList_img(String list_img) {
                this.list_img = list_img;
            }

            public String getTop_img() {
                return top_img;
            }

            public void setTop_img(String top_img) {
                this.top_img = top_img;
            }
        }
    }
}
