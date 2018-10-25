package zhangyanran20181018.bwie.com.myjddemo.bean;

import java.util.List;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class Yean {
    /**
     * msg : 获取子分类成功
     * code : 0
     * data : [{"cid":"5","list":[{"icon":"http://120.27.23.105/images/icon.png","name":"修身休闲裤","pcid":14,"pscid":85},{"icon":"http://120.27.23.105/images/icon.png","name":"免烫休闲裤","pcid":14,"pscid":86},{"icon":"http://120.27.23.105/images/icon.png","name":"小脚休闲裤","pcid":14,"pscid":87},{"icon":"http://120.27.23.105/images/icon.png","name":"商务休闲裤","pcid":14,"pscid":88},{"icon":"http://120.27.23.105/images/icon.png","name":"九分裤","pcid":14,"pscid":89},{"icon":"http://120.27.23.105/images/icon.png","name":"卫裤","pcid":14,"pscid":90},{"icon":"http://120.27.23.105/images/icon.png","name":"哈伦裤","pcid":14,"pscid":91},{"icon":"http://120.27.23.105/images/icon.png","name":"针织裤","pcid":14,"pscid":92}],"name":"休闲裤","pcid":"14"},{"cid":"5","list":[{"icon":"http://120.27.23.105/images/icon.png","name":"加绒牛仔","pcid":15,"pscid":93},{"icon":"http://120.27.23.105/images/icon.png","name":"直筒牛仔","pcid":15,"pscid":94},{"icon":"http://120.27.23.105/images/icon.png","name":"修身牛仔","pcid":15,"pscid":95},{"icon":"http://120.27.23.105/images/icon.png","name":"纯色牛仔","pcid":15,"pscid":96},{"icon":"http://120.27.23.105/images/icon.png","name":"小脚牛仔","pcid":15,"pscid":97},{"icon":"http://120.27.23.105/images/icon.png","name":"弹力牛仔","pcid":15,"pscid":98},{"icon":"http://120.27.23.105/images/icon.png","name":"破洞牛仔","pcid":15,"pscid":99}],"name":"牛仔裤","pcid":"15"},{"cid":"5","list":[{"icon":"http://120.27.23.105/images/icon.png","name":"长袖衬衫","pcid":16,"pscid":100},{"icon":"http://120.27.23.105/images/icon.png","name":"短袖衬衫","pcid":16,"pscid":101},{"icon":"http://120.27.23.105/images/icon.png","name":"POLO衫","pcid":16,"pscid":102},{"icon":"http://120.27.23.105/images/icon.png","name":"卫衣","pcid":16,"pscid":103},{"icon":"http://120.27.23.105/images/icon.png","name":"纯棉衬衫","pcid":16,"pscid":104},{"icon":"http://120.27.23.105/images/icon.png","name":"针织衫","pcid":16,"pscid":105}],"name":"男士内搭","pcid":"16"},{"cid":"5","list":[{"icon":"http://120.27.23.105/images/icon.png","name":"夹克","pcid":17,"pscid":106},{"icon":"http://120.27.23.105/images/icon.png","name":"单西","pcid":17,"pscid":107},{"icon":"http://120.27.23.105/images/icon.png","name":"风衣","pcid":17,"pscid":108},{"icon":"http://120.27.23.105/images/icon.png","name":"真皮外套","pcid":17,"pscid":109},{"icon":"http://120.27.23.105/images/icon.png","name":"西服套装","pcid":17,"pscid":110},{"icon":"http://120.27.23.105/images/icon.png","name":"牛仔外套","pcid":17,"pscid":111}],"name":"男士外套","pcid":"17"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cid : 5
         * list : [{"icon":"http://120.27.23.105/images/icon.png","name":"修身休闲裤","pcid":14,"pscid":85},{"icon":"http://120.27.23.105/images/icon.png","name":"免烫休闲裤","pcid":14,"pscid":86},{"icon":"http://120.27.23.105/images/icon.png","name":"小脚休闲裤","pcid":14,"pscid":87},{"icon":"http://120.27.23.105/images/icon.png","name":"商务休闲裤","pcid":14,"pscid":88},{"icon":"http://120.27.23.105/images/icon.png","name":"九分裤","pcid":14,"pscid":89},{"icon":"http://120.27.23.105/images/icon.png","name":"卫裤","pcid":14,"pscid":90},{"icon":"http://120.27.23.105/images/icon.png","name":"哈伦裤","pcid":14,"pscid":91},{"icon":"http://120.27.23.105/images/icon.png","name":"针织裤","pcid":14,"pscid":92}]
         * name : 休闲裤
         * pcid : 14
         */

        private String cid;
        private String name;
        private String pcid;
        private List<ListBean> list;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPcid() {
            return pcid;
        }

        public void setPcid(String pcid) {
            this.pcid = pcid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * icon : http://120.27.23.105/images/icon.png
             * name : 修身休闲裤
             * pcid : 14
             * pscid : 85
             */

            private String icon;
            private String name;
            private int pcid;
            private int pscid;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPcid() {
                return pcid;
            }

            public void setPcid(int pcid) {
                this.pcid = pcid;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }
        }
    }
}
