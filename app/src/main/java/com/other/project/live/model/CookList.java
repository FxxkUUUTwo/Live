package com.other.project.live.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CookList {



    private int code;
    private DataBean data;

    public static CookList objectFromData(String str) {

        return new Gson().fromJson(str, CookList.class);
    }

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


        private int page;
        private int page_size;
        private int total;
        private List<ResultsBean> results;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPage_size() {
            return page_size;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * bespeak_num : 502
             * birth_year : 1975
             * city_id : 1
             * comment : {"content":"厨师态度非常好，做菜也很好吃，谢谢赵师傅！","dateline":"2016-11-26 13:09:58","imgs":[{"url":"http://img.idachu.com/201611/4cf8df3574330ea1d942d552eb3a1cc2.jpg","url_small":"http://img.idachu.com/201611/4cf8df3574330ea1d942d552eb3a1cc2_300.jpg"}],"star":"5","user":{"degree":"0","name":"135****1461"}}
             * comment_num : 194
             * description : 师傅手艺很好，一直在大酒店大饭店工作。经验丰富做菜麻利，做出的菜色香味俱全，希望喜欢的朋友速度预定哦。
             * digg_num : 0
             * favorite_num : 41
             * head : http://img.idachu.com/201504/7a28f3e4823b0cb46f1f54425da9df35.JPG
             * head_small : http://img.idachu.com/201504/7a28f3e4823b0cb46f1f54425da9df35_300.JPG
             * hometown : 河南
             * id : 3339
             * is_digg : 0
             * is_favorite : 0
             * is_full : 0
             * is_in_fence : 0
             * is_valid : 1
             * lat : 39.959322128226
             * lng : 116.378007438
             * location : 116.378007438,39.959322128226
             * name : 赵会钱
             * packages : [{"description":"建议两人用餐","id":"1","name":"四菜","price":"158","recipe_num":"4"},{"description":"建议三人用餐","id":"8","name":"五菜","price":"158","recipe_num":"5"},{"description":"建议四人用餐","id":"2","name":"六菜","price":"158","recipe_num":"6"}]
             * per_recipe_price : 15
             * recipes : [{"id":"42","img":"http://img.idachu.com/201504/27c8498f4c97eaa3dc384c72a87aa302.JPG","img_small":"http://img.idachu.com/201504/27c8498f4c97eaa3dc384c72a87aa302_300.JPG","name":"糯米珍珠丸子"},{"id":"2117","img":"http://img.idachu.com/201504/4fdaba3102b430611d6aa70da2555ed0.JPG","img_small":"http://img.idachu.com/201504/4fdaba3102b430611d6aa70da2555ed0_300.JPG","name":"家常木须肉"}]
             * service_for : 西城区，海淀区，朝阳区，东城
             * sex : 1
             * star : 5
             * status : 1
             * tags : [{"id":"115","name":"家常菜","type":"cuisine"},{"id":"100","name":"川菜","type":"cuisine"},{"id":"103","name":"粤菜","type":"cuisine"},{"id":"101","name":"鲁菜","type":"cuisine"}]
             * weekday : [{"from":"16","to":"19","weekday":"2"},{"from":"16","to":"19","weekday":"3"},{"from":"16","to":"19","weekday":"4"},{"from":"16","to":"19","weekday":"5"},{"from":"10","to":"13","weekday":"6"},{"from":"16","to":"19","weekday":"6"},{"from":"16","to":"19","weekday":"7"}]
             * work_day : {"2016-11-29":["16:00","17:00","17:30","18:00","18:30","19:00","19:30"],"2016-11-30":["16:00","17:00","17:30","18:00","18:30","19:00","19:30"],"2016-12-01":["16:00","17:00","17:30","18:00","18:30","19:00","19:30"],"2016-12-02":["16:00","17:00","17:30","18:00","18:30","19:00","19:30"],"2016-12-03":["10:00","11:00","11:30","12:00","12:30","13:00","16:00","17:00","17:30","18:00","18:30","19:00","19:30"]}
             * work_year : 2004
             */

            private int bespeak_num;
            private String birth_year;
            private String city_id;
            private CommentBean comment;
            private int comment_num;
            private String description;
            private int digg_num;
            private int favorite_num;
            private String head;
            private String head_small;
            private String hometown;
            private String id;
            private int is_digg;
            private int is_favorite;
            private int is_full;
            private int is_in_fence;
            private int is_valid;
            private String lat;
            private String lng;
            private String location;
            private String name;
            private int per_recipe_price;
            private String service_for;
            private String sex;
            private String star;
            private String status;
            //private WorkDayBean work_day;
            private String work_year;
            private List<PackagesBean> packages;
            private List<RecipesBean> recipes;
            private List<TagsBean> tags;
            private List<WeekdayBean> weekday;

            public static ResultsBean objectFromData(String str) {

                return new Gson().fromJson(str, ResultsBean.class);
            }

            public int getBespeak_num() {
                return bespeak_num;
            }

            public void setBespeak_num(int bespeak_num) {
                this.bespeak_num = bespeak_num;
            }

            public String getBirth_year() {
                return birth_year;
            }

            public void setBirth_year(String birth_year) {
                this.birth_year = birth_year;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public CommentBean getComment() {
                return comment;
            }

            public void setComment(CommentBean comment) {
                this.comment = comment;
            }

            public int getComment_num() {
                return comment_num;
            }

            public void setComment_num(int comment_num) {
                this.comment_num = comment_num;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getDigg_num() {
                return digg_num;
            }

            public void setDigg_num(int digg_num) {
                this.digg_num = digg_num;
            }

            public int getFavorite_num() {
                return favorite_num;
            }

            public void setFavorite_num(int favorite_num) {
                this.favorite_num = favorite_num;
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

            public String getHometown() {
                return hometown;
            }

            public void setHometown(String hometown) {
                this.hometown = hometown;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getIs_digg() {
                return is_digg;
            }

            public void setIs_digg(int is_digg) {
                this.is_digg = is_digg;
            }

            public int getIs_favorite() {
                return is_favorite;
            }

            public void setIs_favorite(int is_favorite) {
                this.is_favorite = is_favorite;
            }

            public int getIs_full() {
                return is_full;
            }

            public void setIs_full(int is_full) {
                this.is_full = is_full;
            }

            public int getIs_in_fence() {
                return is_in_fence;
            }

            public void setIs_in_fence(int is_in_fence) {
                this.is_in_fence = is_in_fence;
            }

            public int getIs_valid() {
                return is_valid;
            }

            public void setIs_valid(int is_valid) {
                this.is_valid = is_valid;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPer_recipe_price() {
                return per_recipe_price;
            }

            public void setPer_recipe_price(int per_recipe_price) {
                this.per_recipe_price = per_recipe_price;
            }

            public String getService_for() {
                return service_for;
            }

            public void setService_for(String service_for) {
                this.service_for = service_for;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

          /*  public WorkDayBean getWork_day() {
                return work_day;
            }

            public void setWork_day(WorkDayBean work_day) {
                this.work_day = work_day;
            }*/

            public String getWork_year() {
                return work_year;
            }

            public void setWork_year(String work_year) {
                this.work_year = work_year;
            }

            public List<PackagesBean> getPackages() {
                return packages;
            }

            public void setPackages(List<PackagesBean> packages) {
                this.packages = packages;
            }

            public List<RecipesBean> getRecipes() {
                return recipes;
            }

            public void setRecipes(List<RecipesBean> recipes) {
                this.recipes = recipes;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public List<WeekdayBean> getWeekday() {
                return weekday;
            }

            public void setWeekday(List<WeekdayBean> weekday) {
                this.weekday = weekday;
            }

            public static class CommentBean {
                /**
                 * content : 厨师态度非常好，做菜也很好吃，谢谢赵师傅！
                 * dateline : 2016-11-26 13:09:58
                 * imgs : [{"url":"http://img.idachu.com/201611/4cf8df3574330ea1d942d552eb3a1cc2.jpg","url_small":"http://img.idachu.com/201611/4cf8df3574330ea1d942d552eb3a1cc2_300.jpg"}]
                 * star : 5
                 * user : {"degree":"0","name":"135****1461"}
                 */

                private String content;
                private String dateline;
                private String star;
               // private UserBean user;
                private List<ImgsBean> imgs;

                public static CommentBean objectFromData(String str) {

                    return new Gson().fromJson(str, CommentBean.class);
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getDateline() {
                    return dateline;
                }

                public void setDateline(String dateline) {
                    this.dateline = dateline;
                }

                public String getStar() {
                    return star;
                }

                public void setStar(String star) {
                    this.star = star;
                }

              /*  public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }*/

                public List<ImgsBean> getImgs() {
                    return imgs;
                }

                public void setImgs(List<ImgsBean> imgs) {
                    this.imgs = imgs;
                }

                public static class UserBean {
                    /**
                     * degree : 0
                     * name : 135****1461
                     */

                    private String degree;
                    private String name;

                    public static UserBean objectFromData(String str) {

                        return new Gson().fromJson(str, UserBean.class);
                    }

                    public String getDegree() {
                        return degree;
                    }

                    public void setDegree(String degree) {
                        this.degree = degree;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class ImgsBean {
                    /**
                     * url : http://img.idachu.com/201611/4cf8df3574330ea1d942d552eb3a1cc2.jpg
                     * url_small : http://img.idachu.com/201611/4cf8df3574330ea1d942d552eb3a1cc2_300.jpg
                     */

                    private String url;
                    private String url_small;

                    public static ImgsBean objectFromData(String str) {

                        return new Gson().fromJson(str, ImgsBean.class);
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getUrl_small() {
                        return url_small;
                    }

                    public void setUrl_small(String url_small) {
                        this.url_small = url_small;
                    }
                }
            }

            public static class WorkDayBean {
                @SerializedName("2016-11-29")
                private List<String> value1;
                @SerializedName("2016-11-30")
                private List<String> value2;
                @SerializedName("2016-12-01")
                private List<String> value3;
                @SerializedName("2016-12-02")
                private List<String> value4;
                @SerializedName("2016-12-03")
                private List<String> value5;

                public static WorkDayBean objectFromData(String str) {

                    return new Gson().fromJson(str, WorkDayBean.class);
                }

                public List<String> getValue1() {
                    return value1;
                }

                public void setValue1(List<String> value1) {
                    this.value1 = value1;
                }

                public List<String> getValue2() {
                    return value2;
                }

                public void setValue2(List<String> value2) {
                    this.value2 = value2;
                }

                public List<String> getValue3() {
                    return value3;
                }

                public void setValue3(List<String> value3) {
                    this.value3 = value3;
                }

                public List<String> getValue4() {
                    return value4;
                }

                public void setValue4(List<String> value4) {
                    this.value4 = value4;
                }

                public List<String> getValue5() {
                    return value5;
                }

                public void setValue5(List<String> value5) {
                    this.value5 = value5;
                }
            }

            public static class PackagesBean {
                /**
                 * description : 建议两人用餐
                 * id : 1
                 * name : 四菜
                 * price : 158
                 * recipe_num : 4
                 */

                private String description;
                private String id;
                private String name;
                private String price;
                private String recipe_num;

                public static PackagesBean objectFromData(String str) {

                    return new Gson().fromJson(str, PackagesBean.class);
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

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

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getRecipe_num() {
                    return recipe_num;
                }

                public void setRecipe_num(String recipe_num) {
                    this.recipe_num = recipe_num;
                }
            }

            public static class RecipesBean {
                /**
                 * id : 42
                 * img : http://img.idachu.com/201504/27c8498f4c97eaa3dc384c72a87aa302.JPG
                 * img_small : http://img.idachu.com/201504/27c8498f4c97eaa3dc384c72a87aa302_300.JPG
                 * name : 糯米珍珠丸子
                 */

                private String id;
                private String img;
                private String img_small;
                private String name;

                public static RecipesBean objectFromData(String str) {

                    return new Gson().fromJson(str, RecipesBean.class);
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getImg_small() {
                    return img_small;
                }

                public void setImg_small(String img_small) {
                    this.img_small = img_small;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public static class TagsBean {
                /**
                 * id : 115
                 * name : 家常菜
                 * type : cuisine
                 */

                private String id;
                private String name;
                private String type;

                public static TagsBean objectFromData(String str) {

                    return new Gson().fromJson(str, TagsBean.class);
                }

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

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }

            public static class WeekdayBean {
                /**
                 * from : 16
                 * to : 19
                 * weekday : 2
                 */

                private String from;
                private String to;
                private String weekday;

                public static WeekdayBean objectFromData(String str) {

                    return new Gson().fromJson(str, WeekdayBean.class);
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

                public String getWeekday() {
                    return weekday;
                }

                public void setWeekday(String weekday) {
                    this.weekday = weekday;
                }
            }
        }
    }
}
