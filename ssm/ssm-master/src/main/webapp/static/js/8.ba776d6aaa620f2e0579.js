webpackJsonp([8],{"/h/X":function(t,e,i){var d=i("e39d");"string"==typeof d&&(d=[[t.i,d,""]]),d.locals&&(t.exports=d.locals);i("rjj0")("452aefc5",d,!0,null)},KsV5:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var d=i("FWz8"),a=i("oFuF"),r={name:"order-detail",data:function(){return{status:{1:"待付款",2:"待取货",3:"待分拣",4:"清洗中",5:"待收货",6:"待评价",7:"已完成",8:"已取消"},orderObj:{orderId:"",startOrderTime:"",goodsNum:"",orderMonery:"",receiveArea:{receiverName:"",phone:"",receiveArea:""},orderDetailWxVOList:[]}}},created:function(){this._getOrderDetailInfomation(this.$route.query.id)},filters:{_dateFormat:function(t){return Object(a.a)(new Date(t),"yyyy-MM-dd hh:mm:ss")}},methods:{_getOrderDetailInfomation:function(t){var e=this,i={orderId:t};Object(d.b)(i).then(function(t){e.orderObj=t,e.orderObj.receiveArea.receiveArea=t.receiveArea.province+t.receiveArea.city+t.receiveArea.area+t.receiveArea.address,console.log(e.orderObj)})},_del:function(){var t=this;this.$createDialog({type:"confirm",icon:"cubeic-alert",title:"删除订单",content:"是否删除订单",confirmBtn:{text:"确定",active:!0,disabled:!1,href:"javascript:;"},cancelBtn:{text:"取消",active:!1,disabled:!1,href:"javascript:;"},onConfirm:function(){t._deleteOrder()},onCancel:function(){}}).show()},_deleteOrder:function(){var t=this,e={orderId:this.$route.query.id},i=this.$createToast({time:5e3});i.show(),Object(d.a)(e).then(function(e){i.hide(),t.$router.go(-1)})}}},n={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"order-detail"},[i("div",{staticClass:"detail"},[i("cube-scroll",[i("div",{staticClass:"status"},[i("div",{staticClass:"info"},[i("span",{staticClass:"text"},[t._v(t._s(t.status[t.orderObj.orderState]))])])]),t._v(" "),i("div",{staticClass:"card"},[i("div",{staticClass:"item address"},[i("div",{staticClass:"info"},[i("div",{staticClass:"name"},[t._v(t._s(t.orderObj.receiveArea.receiverName))]),t._v(" "),i("div",{staticClass:"phone"},[t._v(t._s(t.orderObj.receiveArea.phone))])]),t._v(" "),i("div",{staticClass:"info area"},[i("div",{staticClass:"name"},[t._v("地址:")]),t._v(" "),i("div",{staticClass:"phone"},[t._v(t._s(t.orderObj.receiveArea.receiveArea))])])])]),t._v(" "),i("div",{staticClass:"card"},[i("div",{staticClass:"item list"},[i("div",{staticClass:"list-title"},[t._v("商品列表")]),t._v(" "),t._l(t.orderObj.orderDetailWxVOList,function(e,d){return i("div",{key:d,staticClass:"product-wrap"},[i("div",{staticClass:"product"},[i("div",{staticClass:"img"},[i("img",{attrs:{src:"/picture/"+e.img,alt:""}})]),t._v(" "),i("div",{staticClass:"desc"},[i("p",{staticClass:"name"},[t._v("商品类型："+t._s(e.goodsName))]),t._v(" "),i("p",{staticClass:"other"},[i("span",[t._v("数量: "+t._s(e.goodsNum))]),t._v(" "),i("span",[t._v("材质: "+t._s(e.goodsTexture))]),t._v(" "),i("span",[t._v("类型: "+t._s(e.goodsType))]),t._v(" "),i("span",[t._v("方式: "+t._s(e.washMethod))])]),t._v(" "),i("p",{staticClass:"price"},[t._v("￥ "+t._s(e.goodsPrice))])])])])})],2)]),t._v(" "),i("div",{staticClass:"card"},[i("div",{staticClass:"item order"},[i("div",{staticClass:"info"},[i("div",{staticClass:"title"},[t._v("订单编号：")]),t._v(" "),i("div",{staticClass:"num"},[t._v(t._s(t.orderObj.orderId))])]),t._v(" "),i("div",{staticClass:"info"},[i("div",{staticClass:"title"},[t._v("下单时间：")]),t._v(" "),i("div",{staticClass:"num"},[t._v(t._s(t._f("_dateFormat")(t.orderObj.startOrderTime)))])]),t._v(" "),i("div",{staticClass:"info"},[i("div",{staticClass:"title"},[t._v("支付时间：")]),t._v(" "),i("div",{staticClass:"num"},[t._v(t._s(t._f("_dateFormat")(t.orderObj.startOrderTime)))])]),t._v(" "),i("div",{staticClass:"info"},[i("div",{staticClass:"title"},[t._v("商品数量：")]),t._v(" "),i("div",{staticClass:"num"},[t._v(t._s(t.orderObj.goodsNum))])]),t._v(" "),i("div",{staticClass:"info"},[i("div",{staticClass:"title"},[t._v("金额总计：")]),t._v(" "),i("div",{staticClass:"num"},[t._v(t._s(t.orderObj.orderMonery))])])])])])],1),t._v(" "),i("div",{staticClass:"btns"},[i("div",{staticClass:"left"},[i("div",{staticClass:"btn",on:{click:t._del}},[t._v("删除订单")])]),t._v(" "),i("div",{staticClass:"right"},[1===t.orderObj.orderState?i("div",{staticClass:"btn m-order-btn"},[t._v("去支付")]):t._e(),t._v(" "),7===t.orderObj.orderState?i("div",{staticClass:"btn m-order-btn"},[t._v("去评价")]):t._e()])])])},staticRenderFns:[]};var o=i("VU/8")(r,n,!1,function(t){i("/h/X")},"data-v-5ddf7eb5",null);e.default=o.exports},e39d:function(t,e,i){(t.exports=i("FZ+f")(!0)).push([t.i,'\n.order-detail[data-v-5ddf7eb5]{height:100vh;font-family:HiraginoSansGB-W3;font-size:3.733vw;content:"viewport-units-buggyfill; height: 100vh; font-size: 3.733vw"\n}\n.order-detail .detail[data-v-5ddf7eb5]{height:calc(100vh - 16vw);content:"viewport-units-buggyfill; height: calc(100vh - 16vw)"\n}\n.order-detail .detail .status[data-v-5ddf7eb5]{text-align:center;height:33.333vw;position:relative;background:-webkit-gradient(linear,left top,left bottom,from(#4a4c59),color-stop(#808b96),to(#d5d8dc));background:linear-gradient(#4a4c59,#808b96,#d5d8dc);content:"viewport-units-buggyfill; height: 33.333vw"\n}\n.order-detail .detail .status .info[data-v-5ddf7eb5]{position:absolute;top:50%;left:50%;-webkit-transform:translate(-50%,-50%);transform:translate(-50%,-50%);color:#fff;font-size:4.267vw;line-height:4.267vw;content:"viewport-units-buggyfill; font-size: 4.267vw; line-height: 4.267vw"\n}\n.order-detail .detail .status .info .icon[data-v-5ddf7eb5],.order-detail .detail .status .info .text[data-v-5ddf7eb5]{font-weight:700\n}\n.order-detail .detail .card[data-v-5ddf7eb5]{background-color:#fff;border-radius:3.2vw;padding:3.2vw;margin:1.6vw;content:"viewport-units-buggyfill; border-radius: 3.2vw; padding: 3.2vw; margin: 1.6vw"\n}\n.order-detail .detail .card .item .info[data-v-5ddf7eb5]{display:-webkit-box;display:-ms-flexbox;display:flex;font-weight:700\n}\n.order-detail .detail .card .address .info .name[data-v-5ddf7eb5]{margin-right:3.2vw;content:"viewport-units-buggyfill; margin-right: 3.2vw"\n}\n.order-detail .detail .card .address .area[data-v-5ddf7eb5]{margin-top:3.2vw;font-weight:400;color:#666;font-size:3.2vw;content:"viewport-units-buggyfill; margin-top: 3.2vw; font-size: 3.2vw"\n}\n.order-detail .detail .card .order .info[data-v-5ddf7eb5]{padding:1.6vw 0;content:"viewport-units-buggyfill; padding: 1.6vw 0"\n}\n.order-detail .detail .card .order .info .title[data-v-5ddf7eb5]{color:#666\n}\n.order-detail .detail .card .list .list-title[data-v-5ddf7eb5]{margin-bottom:1.6vw;content:"viewport-units-buggyfill; margin-bottom: 1.6vw"\n}\n.order-detail .detail .card .list .product-wrap[data-v-5ddf7eb5]{border-bottom:.5px solid #f2f2f2;padding:1.6vw 0;content:"viewport-units-buggyfill; padding: 1.6vw 0"\n}\n.order-detail .detail .card .list .product-wrap .product[data-v-5ddf7eb5]{font-size:3.2vw;display:-webkit-box;display:-ms-flexbox;display:flex;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.order-detail .detail .card .list .product-wrap .product .img[data-v-5ddf7eb5]{width:13.333vw;height:13.333vw;border-radius:1.6vw;margin-right:3.2vw;content:"viewport-units-buggyfill; width: 13.333vw; height: 13.333vw; border-radius: 1.6vw; margin-right: 3.2vw"\n}\n.order-detail .detail .card .list .product-wrap .product .img img[data-v-5ddf7eb5]{width:13.333vw;height:13.333vw;border-radius:1.6vw;content:"viewport-units-buggyfill; width: 13.333vw; height: 13.333vw; border-radius: 1.6vw"\n}\n.order-detail .detail .card .list .product-wrap .product .desc .name[data-v-5ddf7eb5],.order-detail .detail .card .list .product-wrap .product .desc .other[data-v-5ddf7eb5]{line-height:4.8vw;content:"viewport-units-buggyfill; line-height: 4.8vw"\n}\n.order-detail .detail .card .list .product-wrap .product .desc .other[data-v-5ddf7eb5]{color:#666\n}\n.order-detail .detail .card .list .product-wrap .product .desc .other span[data-v-5ddf7eb5]{margin-right:1.6vw;content:"viewport-units-buggyfill; margin-right: 1.6vw"\n}\n.order-detail .detail .card .list .product-wrap .btns[data-v-5ddf7eb5]{height:8vw;border:none;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:end;-ms-flex-pack:end;justify-content:flex-end;content:"viewport-units-buggyfill; height: 8vw"\n}\n.order-detail .detail .card .list .product-wrap .btns .btn[data-v-5ddf7eb5]{margin-left:1.6vw;content:"viewport-units-buggyfill; margin-left: 1.6vw"\n}\n.order-detail .btns[data-v-5ddf7eb5]{border-top:.5px solid #f2f2f2;background-color:#fff;height:16vw;padding:0 3.2vw;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;content:"viewport-units-buggyfill; height: 16vw; padding: 0 3.2vw"\n}\n.order-detail .btns .left[data-v-5ddf7eb5],.order-detail .btns .right[data-v-5ddf7eb5]{-webkit-box-flex:1;-ms-flex:1;flex:1\n}\n.order-detail .btns .left[data-v-5ddf7eb5]{display:-webkit-box;display:-ms-flexbox;display:flex;text-align:left\n}\n.order-detail .btns .right[data-v-5ddf7eb5]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:end;-ms-flex-pack:end;justify-content:flex-end\n}\n.order-detail .btns .right .btn[data-v-5ddf7eb5]{margin-left:1.6vw;content:"viewport-units-buggyfill; margin-left: 1.6vw"\n}',"",{version:3,sources:["G:/project/mall/src/views/order-detail/index.vue"],names:[],mappings:";AACA,+BAA+B,aAAa,8BAA8B,kBAAkB,qEAAqE;CAChK;AACD,uCAAuC,0BAA0B,8DAA8D;CAC9H;AACD,+CAA+C,kBAAkB,gBAAgB,kBAAkB,uGAAuG,oDAAoD,oDAAoD;CACjT;AACD,qDAAqD,kBAAkB,QAAQ,SAAS,uCAAuC,+BAA+B,WAAW,kBAAkB,oBAAoB,4EAA4E;CAC1R;AACD,sHAAsH,eAAe;CACpI;AACD,6CAA6C,sBAAsB,oBAAoB,cAAc,aAAa,uFAAuF;CACxM;AACD,yDAAyD,oBAAoB,oBAAoB,aAAa,eAAe;CAC5H;AACD,kEAAkE,mBAAmB,uDAAuD;CAC3I;AACD,4DAA4D,iBAAiB,gBAAgB,WAAW,gBAAgB,uEAAuE;CAC9L;AACD,0DAA0D,gBAAgB,oDAAoD;CAC7H;AACD,iEAAiE,UAAU;CAC1E;AACD,+DAA+D,oBAAoB,wDAAwD;CAC1I;AACD,iEAAiE,iCAAiC,gBAAgB,oDAAoD;CACrK;AACD,0EAA0E,gBAAgB,oBAAoB,oBAAoB,aAAa,oDAAoD;CAClM;AACD,+EAA+E,eAAe,gBAAgB,oBAAoB,mBAAmB,gHAAgH;CACpQ;AACD,mFAAmF,eAAe,gBAAgB,oBAAoB,2FAA2F;CAChO;AACD,6KAA6K,kBAAkB,sDAAsD;CACpP;AACD,uFAAuF,UAAU;CAChG;AACD,4FAA4F,mBAAmB,uDAAuD;CACrK;AACD,uEAAuE,WAAW,YAAY,oBAAoB,oBAAoB,aAAa,yBAAyB,sBAAsB,mBAAmB,qBAAqB,kBAAkB,yBAAyB,+CAA+C;CACnU;AACD,4EAA4E,kBAAkB,sDAAsD;CACnJ;AACD,qCAAqC,8BAA8B,sBAAsB,YAAY,gBAAgB,oBAAoB,oBAAoB,aAAa,yBAAyB,sBAAsB,mBAAmB,kEAAkE;CAC7S;AACD,uFAAuF,mBAAmB,WAAW,MAAM;CAC1H;AACD,2CAA2C,oBAAoB,oBAAoB,aAAa,eAAe;CAC9G;AACD,4CAA4C,oBAAoB,oBAAoB,aAAa,yBAAyB,sBAAsB,mBAAmB,qBAAqB,kBAAkB,wBAAwB;CACjO;AACD,iDAAiD,kBAAkB,sDAAsD;CACxH",file:"index.vue",sourcesContent:['\n.order-detail[data-v-5ddf7eb5]{height:100vh;font-family:HiraginoSansGB-W3;font-size:3.733vw;content:"viewport-units-buggyfill; height: 100vh; font-size: 3.733vw"\n}\n.order-detail .detail[data-v-5ddf7eb5]{height:calc(100vh - 16vw);content:"viewport-units-buggyfill; height: calc(100vh - 16vw)"\n}\n.order-detail .detail .status[data-v-5ddf7eb5]{text-align:center;height:33.333vw;position:relative;background:-webkit-gradient(linear,left top,left bottom,from(#4a4c59),color-stop(#808b96),to(#d5d8dc));background:linear-gradient(#4a4c59,#808b96,#d5d8dc);content:"viewport-units-buggyfill; height: 33.333vw"\n}\n.order-detail .detail .status .info[data-v-5ddf7eb5]{position:absolute;top:50%;left:50%;-webkit-transform:translate(-50%,-50%);transform:translate(-50%,-50%);color:#fff;font-size:4.267vw;line-height:4.267vw;content:"viewport-units-buggyfill; font-size: 4.267vw; line-height: 4.267vw"\n}\n.order-detail .detail .status .info .icon[data-v-5ddf7eb5],.order-detail .detail .status .info .text[data-v-5ddf7eb5]{font-weight:700\n}\n.order-detail .detail .card[data-v-5ddf7eb5]{background-color:#fff;border-radius:3.2vw;padding:3.2vw;margin:1.6vw;content:"viewport-units-buggyfill; border-radius: 3.2vw; padding: 3.2vw; margin: 1.6vw"\n}\n.order-detail .detail .card .item .info[data-v-5ddf7eb5]{display:-webkit-box;display:-ms-flexbox;display:flex;font-weight:700\n}\n.order-detail .detail .card .address .info .name[data-v-5ddf7eb5]{margin-right:3.2vw;content:"viewport-units-buggyfill; margin-right: 3.2vw"\n}\n.order-detail .detail .card .address .area[data-v-5ddf7eb5]{margin-top:3.2vw;font-weight:400;color:#666;font-size:3.2vw;content:"viewport-units-buggyfill; margin-top: 3.2vw; font-size: 3.2vw"\n}\n.order-detail .detail .card .order .info[data-v-5ddf7eb5]{padding:1.6vw 0;content:"viewport-units-buggyfill; padding: 1.6vw 0"\n}\n.order-detail .detail .card .order .info .title[data-v-5ddf7eb5]{color:#666\n}\n.order-detail .detail .card .list .list-title[data-v-5ddf7eb5]{margin-bottom:1.6vw;content:"viewport-units-buggyfill; margin-bottom: 1.6vw"\n}\n.order-detail .detail .card .list .product-wrap[data-v-5ddf7eb5]{border-bottom:.5px solid #f2f2f2;padding:1.6vw 0;content:"viewport-units-buggyfill; padding: 1.6vw 0"\n}\n.order-detail .detail .card .list .product-wrap .product[data-v-5ddf7eb5]{font-size:3.2vw;display:-webkit-box;display:-ms-flexbox;display:flex;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.order-detail .detail .card .list .product-wrap .product .img[data-v-5ddf7eb5]{width:13.333vw;height:13.333vw;border-radius:1.6vw;margin-right:3.2vw;content:"viewport-units-buggyfill; width: 13.333vw; height: 13.333vw; border-radius: 1.6vw; margin-right: 3.2vw"\n}\n.order-detail .detail .card .list .product-wrap .product .img img[data-v-5ddf7eb5]{width:13.333vw;height:13.333vw;border-radius:1.6vw;content:"viewport-units-buggyfill; width: 13.333vw; height: 13.333vw; border-radius: 1.6vw"\n}\n.order-detail .detail .card .list .product-wrap .product .desc .name[data-v-5ddf7eb5],.order-detail .detail .card .list .product-wrap .product .desc .other[data-v-5ddf7eb5]{line-height:4.8vw;content:"viewport-units-buggyfill; line-height: 4.8vw"\n}\n.order-detail .detail .card .list .product-wrap .product .desc .other[data-v-5ddf7eb5]{color:#666\n}\n.order-detail .detail .card .list .product-wrap .product .desc .other span[data-v-5ddf7eb5]{margin-right:1.6vw;content:"viewport-units-buggyfill; margin-right: 1.6vw"\n}\n.order-detail .detail .card .list .product-wrap .btns[data-v-5ddf7eb5]{height:8vw;border:none;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:end;-ms-flex-pack:end;justify-content:flex-end;content:"viewport-units-buggyfill; height: 8vw"\n}\n.order-detail .detail .card .list .product-wrap .btns .btn[data-v-5ddf7eb5]{margin-left:1.6vw;content:"viewport-units-buggyfill; margin-left: 1.6vw"\n}\n.order-detail .btns[data-v-5ddf7eb5]{border-top:.5px solid #f2f2f2;background-color:#fff;height:16vw;padding:0 3.2vw;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;content:"viewport-units-buggyfill; height: 16vw; padding: 0 3.2vw"\n}\n.order-detail .btns .left[data-v-5ddf7eb5],.order-detail .btns .right[data-v-5ddf7eb5]{-webkit-box-flex:1;-ms-flex:1;flex:1\n}\n.order-detail .btns .left[data-v-5ddf7eb5]{display:-webkit-box;display:-ms-flexbox;display:flex;text-align:left\n}\n.order-detail .btns .right[data-v-5ddf7eb5]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:end;-ms-flex-pack:end;justify-content:flex-end\n}\n.order-detail .btns .right .btn[data-v-5ddf7eb5]{margin-left:1.6vw;content:"viewport-units-buggyfill; margin-left: 1.6vw"\n}'],sourceRoot:""}])},oFuF:function(t,e,i){"use strict";e.a=function(t,e){var i={"M+":t.getMonth()+1,"d+":t.getDate(),"h+":t.getHours(),"m+":t.getMinutes(),"s+":t.getSeconds(),"q+":Math.floor((t.getMonth()+3)/3),"S+":t.getMilliseconds()};/(y+)/i.test(e)&&(e=e.replace(RegExp.$1,(""+t.getFullYear()).substr(4-RegExp.$1.length)));for(var d in i)new RegExp("("+d+")").test(e)&&(e=e.replace(RegExp.$1,1===RegExp.$1.length?i[d]:("00"+i[d]).substr((""+i[d]).length)));return e}}});
//# sourceMappingURL=8.ba776d6aaa620f2e0579.js.map